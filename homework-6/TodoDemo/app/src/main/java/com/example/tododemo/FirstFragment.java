package com.example.tododemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {

    List<Task> tasks = new ArrayList<>();
    private MyAdapter adapter;


    @Override
    public View onCreateView(
        LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState
    ) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }


    @Override public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview);
        adapter = new MyAdapter(tasks, new MyAdapter.ClickListener() {
            @Override public void onCheckedChanged(final int position, final boolean isChecked) {
                new Thread(new Runnable() {
                    @Override public void run() {
                        if (isChecked) {
                            MainActivity.db.taskDao().updateTaskCompleted(tasks.get(position).time);
                        } else {
                            MainActivity.db.taskDao().updateTaskActive(tasks.get(position).time);
                        }
                    }
                }).start();
            }


            @Override public void onDeleteClicked(final int position) {
                new Thread(new Runnable() {
                    @Override public void run() {
                        MainActivity.db.taskDao().delete(tasks.get(position));
                    }
                }).start();
            }
        });
        recyclerView.setAdapter(adapter);
        MainActivity.db.taskDao().getAll().observe(getViewLifecycleOwner(), new Observer<List<Task>>() {
            @Override public void onChanged(List<Task> tasks) {
                FirstFragment.this.tasks = tasks;
                adapter.updateData(tasks);
                adapter.notifyDataSetChanged();
            }
        });

        view.findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                    .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }
}

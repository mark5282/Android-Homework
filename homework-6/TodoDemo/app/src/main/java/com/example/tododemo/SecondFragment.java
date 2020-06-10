package com.example.tododemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class SecondFragment extends Fragment {

    @Override
    public View onCreateView(
        LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState
    ) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }


    @Override public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final EditText editText = view.findViewById(R.id.edit);
        Button button = view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                final String content = editText.getText().toString();
                if (!content.isEmpty()) {
                    new Thread(new Runnable() {
                        @Override public void run() {
                            MainActivity.db.taskDao().insert(new Task(System.currentTimeMillis(), content));
                        }
                    }).start();

                }
            }
        });
    }
}

package com.example.tododemo;

import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/**
 * @author jqd
 * @date 2020/5/27
 * @desc
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<Task> mDataset;
    private ClickListener listener;


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public CheckBox checkBox;
        public ImageView delete;


        public MyViewHolder(View v, final ClickListener listener) {
            super(v);
            textView = v.findViewById(R.id.title_text);
            checkBox = v.findViewById(R.id.complete_checkbox);
            delete = v.findViewById(R.id.delete);

            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (listener != null) {
                        listener.onCheckedChanged(getAdapterPosition(), isChecked);
                    }
                }
            });
            delete.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    if (listener != null) {
                        listener.onDeleteClicked(getAdapterPosition());
                    }
                }
            });
        }
    }


    public MyAdapter(List<Task> myDataset, ClickListener listener) {
        mDataset = myDataset;
        this.listener = listener;
    }


    public void updateData(List<Task> myDataset) {
        mDataset = myDataset;
    }


    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_item, parent, false);
        MyViewHolder vh = new MyViewHolder(v, listener);
        return vh;
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textView.setText(mDataset.get(position).content);
        if (mDataset.get(position).isComplete) {
            holder.textView.setPaintFlags(holder.textView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        } else {
            holder.textView.setPaintFlags(holder.textView.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
        }
    }


    @Override
    public int getItemCount() {
        return mDataset.size();
    }


    public interface ClickListener {

        void onCheckedChanged(int position, boolean isChecked);

        void onDeleteClicked(int position);
    }
}


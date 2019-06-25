package com.yunr.pathdemo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DemoAdapter extends RecyclerView.Adapter<DemoAdapter.DemoHolder> {

    private int length;

    public DemoAdapter(int length) {
        this.length = length;
    }

    @NonNull
    @Override
    public DemoHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_demo, viewGroup, false);
        return new DemoHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DemoHolder demoHolder, int i) {
        demoHolder.textView.setText("" + i);
    }

    @Override
    public int getItemCount() {
        return length;
    }

    class DemoHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public DemoHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.item_text);
        }
    }
}

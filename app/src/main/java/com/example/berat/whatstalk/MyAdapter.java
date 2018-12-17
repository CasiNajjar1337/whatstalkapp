package com.example.berat.whatstalk;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    List<ListItem> listItems;
    Context context;

    public MyAdapter(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_items, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ListItem listItem = listItems.get(position);
        holder.nameValue.setText(listItem.getName());
        holder.numberValue.setText(listItem.getNumber());
        holder.onlineDuration.setText(listItem.getDuration());
        holder.startTime.setText(listItem.getStartTime());
        holder.endTime.setText(listItem.getEndTime());

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView nameValue;
        public TextView numberValue;
        public TextView onlineDuration;
        public TextView startTime;
        public TextView endTime;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nameValue = (TextView) itemView.findViewById(R.id.nameValue);
            numberValue = (TextView) itemView.findViewById(R.id.numberValue);
            onlineDuration = (TextView) itemView.findViewById(R.id.onlineDuration);
            startTime = (TextView) itemView.findViewById(R.id.startTime);
            endTime = (TextView) itemView.findViewById(R.id.endTime);
        }
    }

}

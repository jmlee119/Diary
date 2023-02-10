package com.example.diary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private ArrayList<Detailitem> mdetailitems;
    private Context mContext;
    private DBHelper mDBHelper;
    public CustomAdapter(ArrayList<Detailitem> mdetailitems, Context mContext) {
        this.mdetailitems = mdetailitems;
        this.mContext = mContext;
        mDBHelper = new DBHelper(mContext);
    }

    @NonNull
    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View holder = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        return new ViewHolder(holder);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.ViewHolder holder, int position) {
        holder.title.setText(mdetailitems.get(position).getTitle());
        holder.content.setText(mdetailitems.get(position).getContent());
        holder.writeDate.setText(mdetailitems.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return mdetailitems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView content;
        private TextView writeDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            content = itemView.findViewById(R.id.content);
            writeDate = itemView.findViewById(R.id.date);
        }
    }
}

package com.example.socialnetwork;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class postAdapter extends RecyclerView.Adapter<postAdapter.ViewHolder> {
    ArrayList<dataPost>dataPosts;
    Context context;

    public postAdapter(ArrayList<dataPost> dataPosts, Context context) {
        this.dataPosts = dataPosts;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_row,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvFullNamepost.setText(dataPosts.get(position).getName());
        holder.detailPost.setText(dataPosts.get(position).getDetail());
        holder.timePost.setText(dataPosts.get(position).getTime());
        holder.imagepost.setImageResource(dataPosts.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return dataPosts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvFullNamepost,timePost,detailPost;
        ImageView imagepost;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvFullNamepost = itemView.findViewById(R.id.tvFullNamepost);
            timePost = itemView.findViewById(R.id.timePost);
            detailPost = itemView.findViewById(R.id.detailPost);
            imagepost = itemView.findViewById(R.id.imagepost);
        }
    }
}

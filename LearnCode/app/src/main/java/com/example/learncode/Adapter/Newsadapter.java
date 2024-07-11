package com.example.learncode.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.learncode.Common.Readnews;
import com.example.learncode.Model.NewsModel;
import com.example.learncode.R;

import java.util.ArrayList;

public class Newsadapter extends RecyclerView.Adapter<Newsadapter.ViewHolder> {

    Context context;
    ArrayList<NewsModel> modelArrayList;
    private int lastPosition = -1;

    public Newsadapter(Context context, ArrayList<NewsModel> modelArrayList) {
        this.context = context;
        this.modelArrayList = modelArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.news_items, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.newshead.setText(modelArrayList.get(position).getTitle());
        //holder.newspublish.setText(modelArrayList.get(position).getPublishedAt());
        setAnimation(holder.itemView, position);

        Glide.with(context).load(modelArrayList.get(position).getUrlToImage()).into(holder.newsiv);

        holder.newsan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Readnews.class);
                intent.putExtra("URL", modelArrayList.get(position).getUrl());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    private void setAnimation(View viewToAnimate, int position) {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(context, R.anim.slide_in);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView newshead, newspublish;
        ImageView newsiv;
        CardView newsan;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            newshead = itemView.findViewById(R.id.newshead);
            newspublish = itemView.findViewById(R.id.newspublish);
            newsiv = itemView.findViewById(R.id.newsiv);
            newsan = itemView.findViewById(R.id.newsan);
        }
    }
}

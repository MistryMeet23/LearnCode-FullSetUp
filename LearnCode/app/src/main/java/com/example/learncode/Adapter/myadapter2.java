package com.example.learncode.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learncode.Common.Web;
import com.example.learncode.Model.LanModel2;
import com.example.learncode.R;

import java.util.List;

public class myadapter2 extends RecyclerView.Adapter<myadapter2.Holder>{

    List<LanModel2> link;
    Context context;
    private int lastPosition = -1;

    public myadapter2(List<LanModel2> link, Context context) {
        this.link = link;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.lan_link, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, @SuppressLint("RecyclerView") int position) {

        holder.title.setText(link.get(position).getTitle());
        setAnimation(holder.itemView, position);

        holder.btnvdo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(context, Web.class);

                i.putExtra("link", link.get(position).getLink());

                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);

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
        return link.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        TextView title;
        Button btnvdo;

        public Holder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            btnvdo = itemView.findViewById(R.id.btnvdo);

        }
    }

}

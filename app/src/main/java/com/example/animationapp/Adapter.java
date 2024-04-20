package com.example.animationapp;
import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    Context context;
    ArrayList<Items> itemsArrayList;
    public Adapter(Context context, ArrayList<Items> itemsArrayList) {
        this.context = context;
        this.itemsArrayList = itemsArrayList;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.items, parent,false);
        Button buttonMore = view.findViewById(R.id.buttonMore) ;

                buttonMore.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(view.getContext(), WorkerDetails.class);
                        context.startActivity(intent);
                    }
                });

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.cardView.startAnimation(AnimationUtils.loadAnimation(context,R.anim.recycler_animation));


        Items items = itemsArrayList.get(position);

        holder.textName.setText(items.getName());
        holder.textEmail.setText(items.getEmail());

    }


    @Override
    public int getItemCount() {
        return itemsArrayList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView textName;
        TextView textEmail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.cardView);
            textName = itemView.findViewById(R.id.textName);
            textEmail = itemView.findViewById(R.id.textEmail);



        }
    }
}

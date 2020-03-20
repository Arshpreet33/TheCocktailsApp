package com.example.thecocktailsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    private ArrayList<Drink_> drinksList;
    private OnItemClickListener listenerAdapter;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        listenerAdapter = listener;
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {

        public ImageView image;
        public TextView txtTitle, txtBody;

        public RecyclerViewHolder(@NonNull View itemView, final OnItemClickListener listenerView) {
            super(itemView);
            image = itemView.findViewById(R.id.card_image);
            txtTitle = itemView.findViewById(R.id.card_title);
            txtBody = itemView.findViewById(R.id.card_body);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listenerView != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listenerView.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public RecyclerAdapter(ArrayList<Drink_> drinksList) {
        this.drinksList = drinksList;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item, parent, false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view, listenerAdapter);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {

        Drink_ currentDrink = drinksList.get(position);

        String body = "Category: " + currentDrink.getCategory() + "\n" +
                "Alcoholic: " + currentDrink.getAlcoholic();

        holder.txtBody.setText(body);
        holder.txtTitle.setText(currentDrink.getName());

        Picasso.get().load(currentDrink.getImageUrl()).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return drinksList.size();
    }

}

package com.kyad.deal.top;

import android.annotation.SuppressLint;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;
import com.kyad.deal.R;
import com.kyad.deal.admin.AddproductActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.ViewHolder> {


    private final int[] logo;

    public StoreAdapter(int[] modelList) {
        this.logo = modelList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView logo;

        public ViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            logo = (ImageView) view.findViewById(R.id.logo);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.store, viewGroup, false);
        return new ViewHolder(view);
    }

    // Replace the contents of a view
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        viewHolder.logo.setImageResource(AddproductActivity.logo[position]);
        viewHolder.name.setText(AddproductActivity.storeName[position]);
    }


    // Return the size of your arraylist
    @Override
    public int getItemCount() {
        return logo.length;
    }
}

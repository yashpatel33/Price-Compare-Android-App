package com.kyad.deal.top;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;
import com.kyad.deal.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Random;

import static com.kyad.deal.Util.Util.images;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private final ArrayList<Model> modelList;
    private final int i;

    public MyAdapter(ArrayList<Model> modelList, int i) {
        this.modelList = modelList;
        this.i=i;

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView productName, discount, storeName, date;
        ShapeableImageView logo;
        ImageView imagemain;
        LinearLayout linearLayout;
        public ViewHolder(View view) {
            super(view);
            productName = (TextView) view.findViewById(R.id.productName);
            discount = (TextView) view.findViewById(R.id.discount);
            date = (TextView) view.findViewById(R.id.date);
            storeName = (TextView) view.findViewById(R.id.storeName);
            logo = (ShapeableImageView) view.findViewById(R.id.image);
            linearLayout = view.findViewById(R.id.fav);
            imagemain = (ImageView) view.findViewById(R.id.imagemain);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card, viewGroup, false);
        return new ViewHolder(view);
    }

    // Replace the contents of a view
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        Model m = modelList.get(position);
        viewHolder.productName.setText(String.valueOf(m.getProduct_Name()));
        viewHolder.discount.setText(String.valueOf(String.valueOf(m.getDiscount())));
        viewHolder.date.setText(String.valueOf(m.getStart_Date() + " to " + m.getRnd_Date()));
        viewHolder.storeName.setText(String.valueOf(m.getSTORE_NAME()));
        viewHolder.logo.setImageResource(m.getLogo());
        Random r = new Random();
        viewHolder.imagemain.setImageResource(images[r.nextInt(12)]);
        if(i==0)
        {
            viewHolder.linearLayout.setVisibility(View.VISIBLE);
        }
    }


    // Return the size of your arraylist
    @Override
    public int getItemCount() {
        return modelList.size();
    }
}

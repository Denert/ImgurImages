package com.example.varia.imgurimages.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.varia.imgurimages.R;

public class ImageViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;


    public ImageViewHolder(View itemView) {
        super(itemView);
        imageView = (ImageView) itemView.findViewById(R.id.image);
    }
}

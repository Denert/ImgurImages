package com.example.varia.imgurimages.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.varia.imgurimages.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImageViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.image) ImageView imageView;


    public ImageViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}

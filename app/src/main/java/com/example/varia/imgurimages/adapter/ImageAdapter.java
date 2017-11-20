package com.example.varia.imgurimages.adapter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.varia.imgurimages.MainActivity;
import com.example.varia.imgurimages.R;
import com.example.varia.imgurimages.fragment.ImageFragment;
import com.example.varia.imgurimages.model.ImgurItem;
import com.squareup.picasso.Picasso;

public class ImageAdapter extends RecyclerView.Adapter<ImageViewHolder> {

    private ImgurItem imgurItem;
    private Context context;
    private RecyclerView recyclerView;

    public ImageAdapter(Context context, ImgurItem imgurItem, RecyclerView recyclerView) {
        this.imgurItem = imgurItem;
        this.context = context;
        this.recyclerView = recyclerView;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(context).inflate(R.layout.image_item, null);
        ImageViewHolder holder = new ImageViewHolder(layoutView);



        return holder;
    }

    @Override
    public void onBindViewHolder(final ImageViewHolder holder, final int position) {
        if (imgurItem.getData().get(position).getImages() != null &&!imgurItem.getData().get(position).getImages().get(0).getAnimated()) {
            Picasso.with(context)
                    .load(imgurItem.getData().get(position).getImages().get(0).getLink())
                    .placeholder(R.drawable.image_not_available)
                    .into(holder.imageView);
            holder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MainActivity activity = (MainActivity) context;
                    Bundle args = new Bundle();
                    args.putSerializable("imageData", imgurItem.getData().get(position));
                    Fragment imageFragment = new ImageFragment();
                    imageFragment.setArguments(args);
                    FragmentManager fragmentManager = activity.getSupportFragmentManager();
                    fragmentManager.beginTransaction().add(R.id.container, imageFragment)
                            .addToBackStack(imageFragment.getTag()).commit();
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return imgurItem.getData().size();
    }

    public void updateData(ImgurItem images){
        final int positionStart = imgurItem.getData().size();
        final int size = images.getData().size();
        imgurItem.getData().addAll(images.getData());
        recyclerView.post(new Runnable() {
            @Override
            public void run() {
                notifyItemRangeInserted(positionStart, size);
            }
        });

    }
}

package com.example.varia.imgurimages.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.varia.imgurimages.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class CommentsViewHolder extends RecyclerView.ViewHolder{

    @BindView(R.id.textView2) TextView authorName;
    @BindView(R.id.textView3) TextView comment;


    public CommentsViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

}

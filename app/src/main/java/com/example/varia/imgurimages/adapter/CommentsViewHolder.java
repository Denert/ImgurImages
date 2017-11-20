package com.example.varia.imgurimages.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.varia.imgurimages.R;


public class CommentsViewHolder extends RecyclerView.ViewHolder{

    TextView authorName;
    TextView comment;


    public CommentsViewHolder(View itemView) {
        super(itemView);
        authorName = (TextView) itemView.findViewById(R.id.textView2);
        comment = (TextView) itemView.findViewById(R.id.textView3);
    }

}

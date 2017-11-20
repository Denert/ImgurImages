package com.example.varia.imgurimages.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.varia.imgurimages.R;
import com.example.varia.imgurimages.model.CommentsDatum;

import java.util.List;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsViewHolder> {

    private List<CommentsDatum> comments;

    public CommentsAdapter(List<CommentsDatum> comments) {
        this.comments = comments;
    }

    @Override
    public CommentsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.comments_item, null);
        CommentsViewHolder holder = new CommentsViewHolder(layoutView);

        return holder;
    }

    @Override
    public void onBindViewHolder(CommentsViewHolder holder, int position) {
        holder.authorName.setText(comments.get(position).getAuthor());
        holder.comment.setText(comments.get(position).getComment());
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }
}

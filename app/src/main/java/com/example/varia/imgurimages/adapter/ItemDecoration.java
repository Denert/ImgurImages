package com.example.varia.imgurimages.adapter;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class ItemDecoration extends RecyclerView.ItemDecoration {

    private final int mSpace;

    public ItemDecoration(int mSpace) {
        this.mSpace = mSpace;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.bottom = mSpace;
        outRect.right = mSpace;
        outRect.left = mSpace;
        if (parent.getChildAdapterPosition(view) == 0)
            outRect.top = mSpace;
    }
}

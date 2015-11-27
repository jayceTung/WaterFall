package com.joker.mydemo.base;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Joker on 2015/11/27.
 */
public class SpaceItem extends RecyclerView.ItemDecoration {

    private int mSpace;

    public SpaceItem(int space) {
        this.mSpace = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.bottom = mSpace;
        outRect.left = mSpace;
        outRect.right = mSpace;
        if (parent.getChildPosition(view) == 0) {
            outRect.top = mSpace;
        }
    }
}

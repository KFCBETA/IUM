package com.agroup.ium;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class GridItemDecoration extends RecyclerView.ItemDecoration {

    //Column Number
    private int mColumnCount;
    //Vertical Spacing between item
    private int mVerticalSpacing;
    //Horizon Spacing between item
    private int mHorizonSpacing;
    //Do spacing between item or not (vertical)
    private boolean isSpacing;

    public GridItemDecoration(int spanCount, int verticalSpacing, int horizonSpacing, boolean includeEdge) {
        this.mColumnCount = spanCount;
        this.mVerticalSpacing = verticalSpacing;
        this.mHorizonSpacing = horizonSpacing;
        this.isSpacing = includeEdge;
    }


    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view,
                               @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        //Get item position
        int position = parent.getChildAdapterPosition(view);
        //Get Column of item
        int column = position % mColumnCount;

        if(isSpacing){
            //Add left spacing
            outRect.left = mHorizonSpacing - column*mHorizonSpacing/mColumnCount;
            //Add right spacing
            outRect.right = (column+1)*mHorizonSpacing/mColumnCount;

            //If item is in the first row
            if(position < mColumnCount){
                outRect.top = mVerticalSpacing;
            }
            //Do spacing between item
            outRect.bottom = mVerticalSpacing;
        }
        else {
            //Add left spacing
            outRect.left = column*mHorizonSpacing/mColumnCount;
            //Add right spacing
            outRect.right = mHorizonSpacing - (column+1)*mHorizonSpacing/mColumnCount;

            //If item is in the first row
            if(position < mColumnCount){
                outRect.top = mVerticalSpacing;
            }
        }

    }
}

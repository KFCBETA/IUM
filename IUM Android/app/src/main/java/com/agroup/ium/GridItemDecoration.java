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
    //Left Spacing between item
    private int mLeftSpacing;
    //Right Spacing between item
    private int mRightSpacing;
    //Do spacing between item or not (vertical)
    private boolean isSpacing;

    public GridItemDecoration(int spanCount, int verticalSpacing
            , int leftSpacing, int rightSpacing, boolean includeEdge) {
        this.mColumnCount = spanCount;
        this.mVerticalSpacing = verticalSpacing;
        this.mLeftSpacing = leftSpacing;
        this.mRightSpacing = rightSpacing;
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
            outRect.left = mLeftSpacing - column*mLeftSpacing/mColumnCount;
            //Add right spacing
            outRect.right = (column+1)*mRightSpacing/mColumnCount;

            //If item is in the first row
            if(position < mColumnCount){
                outRect.top = mVerticalSpacing;
            }
            //Do spacing between item
            outRect.bottom = mVerticalSpacing;
        }
        else {
            //Add left spacing
            outRect.left = column*mLeftSpacing/mColumnCount;
            //Add right spacing
            outRect.right = mRightSpacing - (column+1)*mRightSpacing/mColumnCount;

            //If item is in the first row
            if(position < mColumnCount){
                outRect.top = mVerticalSpacing;
            }
        }

    }
}

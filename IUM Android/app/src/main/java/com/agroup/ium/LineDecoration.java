package com.agroup.ium;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class LineDecoration extends RecyclerView.ItemDecoration {

    //line height
    private int lineHeight;
    //
    private Context mContext;

    private Paint paint;

    public LineDecoration(Context context, int height) {
        this.mContext = context;
        this.lineHeight = height;
        this.paint = new Paint();
        paint.setAntiAlias(true);
    }


    @Override
    public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {

        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();

        int childCount = parent.getChildCount();
        for(int i=0; i < childCount; i++){
            View child = parent.getChildAt(i);

            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams)child.getLayoutParams();

            int top = child.getBottom() + params.bottomMargin;
            int bottom = top + lineHeight;

            paint.setColor(mContext.getColor(R.color.colorShadowLight));
            c.drawRect(left, top, right, bottom, paint);
        }
    }
}

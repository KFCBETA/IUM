package com.agroup.ium.Util;

import android.content.Context;

public class ScreenUtil {

    public static float dpToPixels(int dp, Context context) {
        return dp * (context.getResources().getDisplayMetrics().density);
    }
}

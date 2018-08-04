package com.ujia.utils;

import android.content.Context;
import android.util.DisplayMetrics;

public class DisplayUtil {

    private DisplayUtil() {
    }

    private static float scale = 0.0f;
    private static float spScale = 0.0f;

    public static int dpToPx(Context context, float dipValue) {
        if (scale == 0.0f) {
            scale = context.getResources().getDisplayMetrics().density;
        }
        return (int) (dipValue * scale + 0.5);
    }

    public static float pxToDp(Context context, float pxValue) {
        if (scale == 0.0f) {
            scale = context.getResources().getDisplayMetrics().density;
        }
        return pxValue / scale;
    }

    public static int spToPx(Context context, float spValue) {
        if (spScale == 0.0f) {
            spScale = context.getResources().getDisplayMetrics().scaledDensity;
        }
        return (int) (spValue * spScale + 0.5);
    }

    public static float pxToSp(Context context, float pxValue) {
        if (spScale == 0.0f) {
            spScale = context.getResources().getDisplayMetrics().scaledDensity;
        }
        return pxValue / spScale;
    }

    public static int[] screenWH(Context context) {
        int[] swh = new int[2];
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        swh[0] = dm.widthPixels;
        swh[1] = dm.heightPixels;
        return swh;
    }
}  
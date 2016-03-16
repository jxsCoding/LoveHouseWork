package com.joy.demo.lovehousework.utils;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;

/**
 * Created by joy on 16/3/16.
 */
public class AppUtils {
    /**
     * dp转换为px
     * @param context
     * @param dp
     * @return
     */
    public static int dp2Px(Context context,float dp){
        final float scale=context.getResources().getDisplayMetrics().density;
        return (int)(dp*scale+0.5f);
    }

    /**
     * px转换为dp
     * @param context
     * @param px
     * @return
     */
    public static int px2Dp(Context context,float px){
        final float scale=context.getResources().getDisplayMetrics().density;
        return (int)(px/scale+0.5f);
    }

    /**
     * 获取状态栏高度
     * @param view
     * @return
     */
    public static int statusBarHeight(View view){
        Rect outRect=new Rect();
        view.getWindowVisibleDisplayFrame(outRect);
        return outRect.top;
    }
}

package com.joy.demo.lovehousework.controller;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by joy on 16/3/15.
 */
public class HouseViewPager extends ViewPager{
    private boolean isCanScroll=true;
    public boolean isCanScroll() {
        return isCanScroll;
    }

    public void setCanScroll(boolean isCanScroll) {
        this.isCanScroll = isCanScroll;
    }



    public HouseViewPager(Context context) {
        super(context);
    }

    public HouseViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 如果返回值是true,那么说明本次触摸时间被消费了，会传进来一个新的触摸事件。
     * 如果是false，那么说明没有被消费掉，就不会传入一个新的事件
     * @param ev
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (isCanScroll){
            try {
                return super.onTouchEvent(ev);
            }catch (Exception e){
                return true;
            }
        }else{
            return true;
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (isCanScroll){
            try {
                return super.onInterceptTouchEvent(ev);
            }catch (Exception e){
                return true;
            }
        }else{
            return true;

        }

    }
}

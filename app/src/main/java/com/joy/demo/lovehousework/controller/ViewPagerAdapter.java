package com.joy.demo.lovehousework.controller;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by joy on 16/3/16.
 * ViewPager适配器，用来绑定数据和view
 */
public class ViewPagerAdapter extends PagerAdapter {
    //界面列表
    private ArrayList<View> mViews;
    public ViewPagerAdapter(ArrayList<View> views){
        super();
        this.mViews=views;
    }
    //获取当前界面数
    @Override
    public int getCount() {
        if (mViews!=null){
            return mViews.size();
        }
        return 0;
    }

    //初始化position位置的界面
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ((ViewPager)container).addView(mViews.get(position),0);
        return mViews.get(position);
    }

    //判断是否由对象生成界面
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager)container).removeView(mViews.get(position));
    }
}

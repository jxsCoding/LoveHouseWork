package com.joy.demo.lovehousework.ui;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.joy.demo.lovehousework.R;
import com.joy.demo.lovehousework.controller.HouseViewPager;
import com.joy.demo.lovehousework.controller.ViewPagerAdapter;
import com.joy.demo.lovehousework.model.HouseWorkService;

import java.util.ArrayList;

/**
 * Created by joy on 16/3/15.
 */
public class MainActivity extends Activity {

    //定义ViewPager对象
    private HouseViewPager mViewPager;
    //ViewPage适配器
    private ViewPagerAdapter mAdapter;
    //存放View
    private ArrayList<View> mViews;
    //引导view布局资源
    private static  int[] mLayouts={R.layout.pager_shake,R.layout.pager_gridview};
    //底部point图片
    private ImageView[] mViewPoints;

    private int currentIndex=1;

    private LayoutInflater mInflater;
    //底部导航开始
    private RelativeLayout mRlStart;
    //底部导航添加
    private RelativeLayout mRlAdd;

    private HouseWorkService mService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mInflater=LayoutInflater.from(this);
        initView();
    }

    private void initView(){

    }
}

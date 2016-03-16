package com.joy.demo.lovehousework.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.joy.demo.lovehousework.R;

/**
 * Created by joy on 16/3/15.
 */
public class SplashActivity extends Activity{
    //splash 显示时间
    private final int SPLASH_DISPLAY_LENGTH=2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SplashActivity.this,MainActivity.class);
                SplashActivity.this.startActivity(intent);
                SplashActivity.this.finish();

            }
        },SPLASH_DISPLAY_LENGTH);
    }
}

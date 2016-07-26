package com.example.viewpager;

import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);
        final Handler myhander=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                if(msg.what==0x000){
                    //修改图片；
                    viewPager.setCurrentItem(viewPager.getCurrentItem()+1,true);
                }
            }
        };
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                myhander.sendEmptyMessage(0x000);
            }
        },0,1000);


    }

    public void init(){
        viewPager = (ViewPager) findViewById(R.id.id_main_vp);
    }

    public void next(View view ){
        viewPager.setCurrentItem(viewPager.getCurrentItem()+1,true);
    }
}

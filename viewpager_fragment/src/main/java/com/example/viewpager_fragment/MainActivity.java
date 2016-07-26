package com.example.viewpager_fragment;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.id_main_vp);
        MyFragmentAdapter myFragmentAdapter = new MyFragmentAdapter(this.getSupportFragmentManager());
        viewPager.setAdapter(myFragmentAdapter);
    }
}

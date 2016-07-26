package com.example.custom_xml;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    MyView first,second,third;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        first.setTitle("First");
        second.setTitle("Second");
        third.setTitle("Third");
    }

    public void initView(){
        first = (MyView) findViewById(R.id.id_main_myview_first);
        second = (MyView) findViewById(R.id.id_main_myview_second);
        third = (MyView) findViewById(R.id.id_main_myview_third);
    }
}

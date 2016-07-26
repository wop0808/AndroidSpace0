package com.example.fragment;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{
    Button btn1,btn2,btn3;
    FragmentOne fragmentOne;
    FragmentTwo fragmentTwo;
    android.app.FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);

    }

    public void init(){
        btn1 = (Button) findViewById(R.id.id_main_button1);
        btn2 = (Button) findViewById(R.id.id_main_button2);
        btn3 = (Button) findViewById(R.id.id_main_button3);
        fm = this.getFragmentManager() ;
    }

    @Override
    public void onClick(View v) {
        int viewID = v.getId();
        switch (viewID){
            case R.id.id_main_button1:
                if(fragmentOne == null){
                    fragmentOne = new FragmentOne();
//                    fm = this.getFragmentManager();
                    fm.beginTransaction().replace(R.id.id_main_linear_fragment,fragmentOne).commit();
                }else {
                    fm.beginTransaction().replace(R.id.id_main_linear_fragment,fragmentOne).commit();
                }
                break;
            case R.id.id_main_button2:
                if(fragmentTwo == null){
                    fragmentTwo = new FragmentTwo();
                    fm.beginTransaction().replace(R.id.id_main_linear_fragment,fragmentTwo).commit();
                }else {
                    fm.beginTransaction().replace(R.id.id_main_linear_fragment,fragmentTwo).commit();
                }
        }
    }
}

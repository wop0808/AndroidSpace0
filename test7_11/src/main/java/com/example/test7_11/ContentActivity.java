package com.example.test7_11;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ContentActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView tv_shouye,tv_wenzi,tv_tupian;
    private FragmentManager fragmentManager;
    private Fragment_shouye fragment_shouye;
    private Fragment_wenzi fragment_wenzi;
    private Fragment_tupian fragment_tupian;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        fragmentManager = this.getFragmentManager();

        tv_shouye = (TextView) findViewById(R.id.id_shouye);
        tv_tupian = (TextView) findViewById(R.id.id_tupian);
        tv_wenzi = (TextView) findViewById(R.id.id_wenzi);

        tv_shouye.setOnClickListener(this);
        tv_tupian.setOnClickListener(this);
        tv_wenzi.setOnClickListener(this);

        initFrag_shouye();

    }

    public void initFrag_shouye(){
        if(fragment_shouye == null){
            fragment_shouye = new Fragment_shouye();
            fragmentManager.beginTransaction().replace(R.id.id_main_fragment,fragment_shouye).commit();
            tv_shouye.setSelected(true);
            tv_wenzi.setSelected(false);
            tv_tupian.setSelected(false);
        }else {
            fragmentManager.beginTransaction().replace(R.id.id_main_fragment,fragment_shouye).commit();
            tv_shouye.setSelected(true);
            tv_wenzi.setSelected(false);
            tv_tupian.setSelected(false);
        }
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.id_shouye:
                if(fragment_shouye == null){
                    fragment_shouye = new Fragment_shouye();
                    fragmentManager.beginTransaction().replace(R.id.id_main_fragment,fragment_shouye).commit();
                    tv_shouye.setSelected(true);
                    tv_wenzi.setSelected(false);
                    tv_tupian.setSelected(false);
                }else {
                    fragmentManager.beginTransaction().replace(R.id.id_main_fragment,fragment_shouye).commit();
                    tv_shouye.setSelected(true);
                    tv_wenzi.setSelected(false);
                    tv_tupian.setSelected(false);
                }
                break;
            case R.id.id_wenzi:
                if(fragment_wenzi == null){
                    fragment_wenzi = new Fragment_wenzi();
                    fragmentManager.beginTransaction().replace(R.id.id_main_fragment,fragment_wenzi).commit();
                    tv_shouye.setSelected(false);
                    tv_wenzi.setSelected(true);
                    tv_tupian.setSelected(false);
                }else {
                    fragmentManager.beginTransaction().replace(R.id.id_main_fragment,fragment_wenzi).commit();
                    tv_shouye.setSelected(false);
                    tv_wenzi.setSelected(true);
                    tv_tupian.setSelected(false);
                }
                break;
            case R.id.id_tupian:
                if(fragment_tupian == null){
                    fragment_tupian = new Fragment_tupian();
                    fragmentManager.beginTransaction().replace(R.id.id_main_fragment,fragment_tupian).commit();
                    tv_shouye.setSelected(false);
                    tv_wenzi.setSelected(false);
                    tv_tupian.setSelected(true);
                }else {
                    fragmentManager.beginTransaction().replace(R.id.id_main_fragment,fragment_tupian).commit();
                    tv_shouye.setSelected(false);
                    tv_wenzi.setSelected(false);
                    tv_tupian.setSelected(true);
                }
                break;
        }
    }
}

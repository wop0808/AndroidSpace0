package com.example.fragment_viewpager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    android.app.FragmentManager fm;
    Fragment_One fragmentOne;
    //    ViewPager viewPager;
    Button btn1, btn2, btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

//        ViewPager_Adapter viewPager_adapter = new ViewPager_Adapter(this);
//        viewPager.setAdapter(viewPager_adapter);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);

//        auto_play();

    }

    public void init() {
        btn1 = (Button) findViewById(R.id.id_main_btn1);
        btn2 = (Button) findViewById(R.id.id_main_btn2);
        btn3 = (Button) findViewById(R.id.id_main_btn3);
        fragmentOne = new Fragment_One();
//        viewPager = fragmentOne.vp;
//        btn_frag = fragmentOne.btn_frag;
        fm = this.getFragmentManager();
    }

    @Override
    public void onClick(View v) {
        int viewID = v.getId();
        switch (viewID) {
//            case R.id.id_main_fragment_btn:
//                viewPager.setCurrentItem(viewPager.getCurrentItem()+1,true);
//                break;
            case R.id.id_main_btn1:
                fm.beginTransaction().replace(R.id.id_main_linear_fragment, fragmentOne).commit();
//                    ViewPager_Adapter viewPager_adapter = new ViewPager_Adapter(this);
//                    viewPager.setAdapter(viewPager_adapter);
//                    auto_play();
                break;
        }
    }


//    public void auto_play(){
//        final Handler handler = new Handler(){
//            @Override
//            public void handleMessage(Message msg) {
//                if(msg.what==000000){
//                    viewPager.setCurrentItem(viewPager.getCurrentItem()+1,true);
//                }
//            }
//        };
//        new Timer().schedule(new TimerTask() {
//            @Override
//            public void run() {
//                handler.sendEmptyMessage(000000);
//            }
//        },0,1500);
//    }
}

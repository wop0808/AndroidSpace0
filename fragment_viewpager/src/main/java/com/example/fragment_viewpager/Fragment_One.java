package com.example.fragment_viewpager;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2016/7/1.
 */
public class Fragment_One extends Fragment  {
    View frag_view;
    ViewPager vp;
    Button btn_frag;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        frag_view = inflater.inflate(R.layout.fragment_one, container, false);
        vp = (ViewPager) frag_view.findViewById(R.id.id_main_fragment_vp);


        ViewPager_Adapter viewPager_adapter = new ViewPager_Adapter(getActivity());
        vp.setAdapter(viewPager_adapter);

        auto_play();

        return frag_view;
    }


    //按钮的监听事件应写在此方法中
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        btn_frag = (Button) frag_view.findViewById(R.id.id_main_fragment_btn);
        btn_frag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vp.setCurrentItem(vp.getCurrentItem() + 1, true);
            }
        });
    }

    //    @Override
//    public void onClick(View v) {
//        int viewID = v.getId();
//        switch (viewID) {
//            case R.id.id_main_fragment_btn:
//                vp.setCurrentItem(vp.getCurrentItem() + 1, true);
//
//        }
//    }

    public void auto_play(){
        final Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                if(msg.what==000000){
                    vp.setCurrentItem(vp.getCurrentItem()+1,true);
                }
            }
        };
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(000000);
            }
        },0,1500);
    }
}

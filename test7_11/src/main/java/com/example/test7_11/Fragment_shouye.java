package com.example.test7_11;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2016/7/11.
 */
public class Fragment_shouye extends Fragment implements RadioGroup.OnCheckedChangeListener, ViewPager.OnPageChangeListener {
    private ViewPager vp;
    private RadioGroup radioGroup;
    private int dotsSize = 0;
    Vp_shouyeAdapter vp_shouyeAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v_shouye = inflater.inflate(R.layout.fragement_shouye,container,false);

        vp = (ViewPager) v_shouye.findViewById(R.id.id_shouye_vp);
        radioGroup = (RadioGroup) v_shouye.findViewById(R.id.id_shouye_rg);
        radioGroup.setOnCheckedChangeListener(this);

        vp_shouyeAdapter = new Vp_shouyeAdapter(this.getActivity());
        dotsSize = vp_shouyeAdapter.getImgsSize();
        vp.addOnPageChangeListener(this);
        vp.setAdapter(vp_shouyeAdapter);
        initDots();


        auto_play();

        return v_shouye;
    }

    public void auto_play(){
        final Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                if(msg.what==000000){
//                    int topisition = -1;
//                    int currentitemIndex = vp.getCurrentItem();
//
//                    if(currentitemIndex == vp_shouyeAdapter.getImgsSize()-1){
//                        topisition = 0;
//                    }else{
//                        topisition = currentitemIndex+1;
//                    }


                    int topisition = (vp.getCurrentItem()==vp_shouyeAdapter.getImgsSize()-1) ? 0 : (vp.getCurrentItem()+1);
                    vp.setCurrentItem(topisition,true);
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


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        int index = group.indexOfChild(group.findViewById(checkedId));
        vp.setCurrentItem(index,true);
    }

    public void initDots(){
        for(int i = 0 ; i<dotsSize;i++ ){
            RadioButton rd = new RadioButton(getActivity());
            radioGroup.addView(rd);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        RadioButton rd = (RadioButton) radioGroup.getChildAt(position);
        rd.setChecked(true);
}

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}

package com.example.viewpager;

import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/30.
 */
public class ViewPagerAdapter extends PagerAdapter {

    MainActivity mainActivity;

    int[] imgID = new int[]{
            R.mipmap.text1,R.mipmap.text2,R.mipmap.text3,R.mipmap.text4,
            R.mipmap.text5,R.mipmap.text6,R.mipmap.text7,R.mipmap.text8,
            R.mipmap.text9,R.mipmap.text10,R.mipmap.text11,R.mipmap.text12,
    };

    List<ImageView> imageViews = new ArrayList<>();

    public void initImgV(){
        for (int i = 0 ; i<imgID.length; i++){
            ImageView imageItem = new ImageView(this.mainActivity);
            imageItem.setImageResource(imgID[i]);
            imageViews.add(imageItem);
        }
    }

    public ViewPagerAdapter(MainActivity mainActivity){
        this.mainActivity = mainActivity;
        initImgV();
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(imageViews.get(position % imageViews.size()));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(imageViews.get( position % imageViews.size()));
        return imageViews.get( position % imageViews.size());

    }




}

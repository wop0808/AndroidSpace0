package com.example.test7_11;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/11.
 */
public class Vp_shouyeAdapter extends PagerAdapter {
    private Context context;

    private int[] imgID = new int[]{
            R.mipmap.text9,R.mipmap.text10,R.mipmap.text11,R.mipmap.text12,
    };

    List<ImageView> imageViews = new ArrayList<>();

    public void initImgV(){
        for (int i = 0 ; i<imgID.length; i++){
            ImageView imageItem = new ImageView(context);
            imageItem.setImageResource(imgID[i]);
            imageViews.add(imageItem);
        }
    }

    public Vp_shouyeAdapter(Context context){
        this.context = context;
        initImgV();
    }

    public int getImgsSize(){
        return imageViews.size();
    }


    @Override
    public int getCount() {
        return imageViews.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(imageViews.get(position));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(imageViews.get( position));
        return imageViews.get( position);

    }
}

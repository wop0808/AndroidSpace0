package com.example.fragment_viewpager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/1.
 */
public class ViewPager_Adapter extends PagerAdapter {
    private Context context;

    int[] imgID = new int[]{R.mipmap.text1,R.mipmap.text2,R.mipmap.text11,};
//    Fragment_One fragment_one;
    ImageView imageView;
    List<ImageView> imgItem = new ArrayList<>();

    public ViewPager_Adapter(Context context){
//        this.fragment_one = fragment_one;
        this.context = context;
        initImg();
    }

    public void initImg() {
        for(int i = 0 ; i<imgID.length ; i++){
            imageView = new ImageView(context);
            imageView.setImageResource(imgID[i]);
            imgItem.add(imageView);
        }
    }
    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(imgItem.get(position%imgItem.size()));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(imgItem.get(position%imgItem.size()));
        return  imgItem.get(position%imgItem.size());
    }
}

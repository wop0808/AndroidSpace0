package com.example.viewpager_fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/2.
 */
public class MyFragmentAdapter extends FragmentPagerAdapter {
    List<Fragment> fragmentList = new ArrayList<>();

    Fragment[] fragments = new Fragment[]{new Fragment_One(),new Fragment_Two(),new Fragment_Three()};


    public MyFragmentAdapter(FragmentManager fm) {
        super(fm);
        for (int i = 0 ; i < fragments.length ; i++){
            fragmentList.add(fragments[i]);
        }
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}

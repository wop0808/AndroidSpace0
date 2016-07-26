package com.example.viewpager_fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Administrator on 2016/7/2.
 */
public class Fragment_One extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view_frag_one = inflater.inflate(R.layout.fragment_one,container,false);
        ImageView imageView = (ImageView) view_frag_one.findViewById(R.id.id_main_vp_frag1_iv);
        imageView.setImageResource(R.mipmap.text1);
        return view_frag_one;
    }
}

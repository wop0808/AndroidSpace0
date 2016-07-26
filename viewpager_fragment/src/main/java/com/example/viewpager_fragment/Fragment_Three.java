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
public class Fragment_Three extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view_frag_three = inflater.inflate(R.layout.fragment_three,container,false);
        ImageView imageView1 = (ImageView) view_frag_three.findViewById(R.id.id_main_vp_frag3);
        imageView1.setImageResource(R.mipmap.text3);
        ImageView imageView2 = (ImageView) view_frag_three.findViewById(R.id.id_main_vp_frag4);
        imageView2.setImageResource(R.mipmap.text4);
        return view_frag_three;
    }
}

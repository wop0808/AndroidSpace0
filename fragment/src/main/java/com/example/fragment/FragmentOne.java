package com.example.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Administrator on 2016/6/30.
 */
public class FragmentOne extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View frag_one_view = inflater.inflate(R.layout.fragment_one,container,false);
        ImageView imgV = (ImageView) frag_one_view.findViewById(R.id.id_main_fragone_iv);
        imgV.setImageResource(R.mipmap.text1);
        return frag_one_view;
    }
}

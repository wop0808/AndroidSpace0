package com.example.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/6/30.
 */
public class FragmentTwo extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View frag_two_view = inflater.inflate(R.layout.fragment_two,container,false);
        TextView tv = (TextView) frag_two_view.findViewById(R.id.id_main_fragtwo_tv);
        tv.setText("我改变了");
        return frag_two_view;
    }
}

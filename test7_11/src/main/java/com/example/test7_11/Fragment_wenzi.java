package com.example.test7_11;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2016/7/11.
 */
public class Fragment_wenzi extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v_wenzi = inflater.inflate(R.layout.fragment_wenzi,container,false);
        return v_wenzi;
    }
}

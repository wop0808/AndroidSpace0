package com.example.custom_xml;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/6/30.
 */

public class MyView extends LinearLayout {

    ImageView icon,jiewei;
    TextView title;



    public MyView(Context context) {
        super(context);
        initView(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public void initView(Context context){
        View v_item = View.inflate(context,R.layout.main_custom_view_item,this);
        icon = (ImageView) v_item.findViewById(R.id.id_main_layout_iv_icon);
        title = (TextView) v_item.findViewById(R.id.id_main_layout_tv);
        jiewei = (ImageView) v_item.findViewById(R.id.id_main_layout_iv_jiewei);
    }

    public void setTitle(String string){
        title.setText(string);
    }
}

package com.example.interdownload_gson;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements CompJson.OnCompGsonEnd {
    private ListView listView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.id_main_lv);
        textView = (TextView) findViewById(R.id.id_main_emptyview);
        listView.setEmptyView(textView);

        new CompJson(this).start();


    }


    @Override
    public void getFriends(Friends friends) {
        List<Friends.FrendsBean> listfrends = friends.frends;
        MyAdapter myAdapter = new MyAdapter(listfrends,this);
        listView.setAdapter(myAdapter);
    }
}

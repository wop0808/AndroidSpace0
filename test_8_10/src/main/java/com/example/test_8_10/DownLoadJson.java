package com.example.test_8_10;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.google.gson.Gson;

/**
 * Created by Administrator on 2016/8/10.
 */
public class DownLoadJson extends Thread {
    public static final String TAG = "crazyK";
    private Person person;
    private String murl;
    private String charSet;
    private MyHandler myHandler;
    private OnGetJsonEndListener ongetJsonEndListener;

    public DownLoadJson(String murl , String charSet, Context context){
        this.murl = murl;
        this.charSet = charSet;
        myHandler = new MyHandler();
        this.ongetJsonEndListener = (OnGetJsonEndListener) context;
    }

    @Override
    public void run() {
        super.run();

        String json = DownLoadTool.getStringFromURL(murl, charSet);
        Log.i(TAG,"返回数据："+json);
        Gson gson = new Gson();

        person = gson.fromJson(json, Person.class);
//        Log.i(TAG, person.getErrorcode());
        myHandler.sendEmptyMessage(666);


    }

    private class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 666){
                ongetJsonEndListener.startUI(person);
            }
        }
    }

    public interface OnGetJsonEndListener{
        void startUI(Person person);
    }
}

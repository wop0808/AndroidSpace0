package com.example.interdownload_gson;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2016/8/2.
 */
public class CompJson extends Thread {
    public static final String TAG = "crazyK";

    private Friends friends;
    private Myhandler myhandler;
    private Context context;
    private OnCompGsonEnd onCompGsonEnd;

    public CompJson(Context context ){
        this.onCompGsonEnd = (OnCompGsonEnd) context;
        myhandler = new Myhandler();
    }

    @Override
    public void run() {
        super.run();
//        Log.i(TAG, "开始读取数据 ");
        String json = DownLoadTool.getStringFromURL("http://172.18.4.3:8080/kaoshi/friends.txt","gbk");
        if(json == null){
            Log.i(TAG, "数据未能成功读取 ");
            return;
        }else {
//            Log.i(TAG, json);
            Gson gson = new Gson();
            friends = gson.fromJson(json,Friends.class);
//            Log.i(TAG, "gson转换成功");
//            String errorcode = friends.errorcode;
//            Log.i(TAG,  errorcode);
//            Message msg = myhandler.obtainMessage();
//            msg.obj = friends;
//            if (msg != null){
//                Log.i(TAG, "msg接收成功");
//            }
//            myhandler.sendMessage(msg);
            myhandler.sendEmptyMessage(666);

        }

    }

    //在主线程中自定义handler类，用于接收线程传过来的数据，
    //同时在线程类的构造函数中 实例化自定义handler类
    class Myhandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 666){
                onCompGsonEnd.getFriends(friends);
//                Log.i(TAG, "调用接口成功");
            }
//            Friends friends = (Friends) msg.obj;
        }
    }

    public interface OnCompGsonEnd{
        void getFriends(Friends friends);
    }
}

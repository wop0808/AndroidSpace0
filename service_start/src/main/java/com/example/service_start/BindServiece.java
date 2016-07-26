package com.example.service_start;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Administrator on 2016/7/20.
 */
public class BindServiece extends Service {
    private final String TAG = "Bind启动";
    int count = 0;
    MyIBinder myIBinder = new MyIBinder();

    class MyIBinder extends Binder{
        public int getCount(){
            return  count;
        }

        public BindServiece getService(){
            return BindServiece.this;
        }
    }

    public void error(){
       obj = null;
    }
    Object obj = new Object();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate() called with: " + "");

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind() called with: " + "intent = [" + intent + "]");
        return myIBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "onUnbind() called with: " + "intent = [" + intent + "]");
        return super.onUnbind(intent);
//        return true;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called with: " + "");
    }
}

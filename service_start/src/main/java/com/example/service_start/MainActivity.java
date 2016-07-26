package com.example.service_start;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";
    Intent intent;
    Intent intent_Bind;
    BindServiece.MyIBinder myIBinder;
    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myIBinder = (BindServiece.MyIBinder) service;
            Log.d(TAG, "onServiceConnected() called with: " + "name = [" + name + "], service = [" + service + "]");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d(TAG, "onServiceDisconnected() called with: " + "name = [" + name + "]");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intent = new Intent(this, MyService.class);
        intent_Bind = new Intent(this, BindServiece.class);
    }

    //启动流程：onCreat() --> onStartCommand()
    public void startService(View view) {
        startService(intent);
    }

    //onDestroy()
    public void stopService(View view) {
        stopService(intent);
    }

    //onCreat() --> onBind() --> onServiceConnected()
    public void startServiceByBind(View view) {
        this.bindService(intent_Bind, serviceConnection, BIND_AUTO_CREATE);
    }

    //onUnbind() --> onDestroy()
    //执行onDestroy()是由于此服务是由BIND_AUTO_CREAT自动生成，若是由startService（）启动 则不会执行onDestroy()
    public void stopServiceByBind(View view) {

        this.unbindService(serviceConnection);

    }

    //用来测试onServiceDisconnected(),并未调用此方法
    public void error(View v) {
        myIBinder.getService().error();
    }
}

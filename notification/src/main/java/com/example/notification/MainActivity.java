package com.example.notification;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    static  final int NOTIFICATION_ID = 000;
    NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
    }

    public void send(View view){
        //返回的是Builder对象
        Notification.Builder builder = new Notification.Builder(this);
        //玉面跳转设置
        Intent intent = new Intent(this,OtherActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,0);
        //设置builder
        builder.setAutoCancel(true)
                .setTicker("有新消息")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("一条新通知")
                .setContentText("新消息新消息新消息新消息")
//                .setSound(Uri.parse())
                .setWhen(System.currentTimeMillis())
                .setContentIntent(pendingIntent);
                //调用build（）返回Notification
        Notification notification = builder.build();

        notificationManager.notify(NOTIFICATION_ID, notification);

    }
}

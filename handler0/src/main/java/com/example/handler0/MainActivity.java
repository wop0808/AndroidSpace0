package com.example.handler0;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.id_main_progressbar);

        final Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                int i = (int) msg.obj;
                progressBar.setProgress(i);
            }
        };



        Thread thread = new Thread(){
            @Override
            public void run() {
                for(int i = 0 ;i<100;i++){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Message message = handler.obtainMessage(0,i);
                    handler.sendMessage(message);
                }
            }
        };
        thread.start();
    }
}

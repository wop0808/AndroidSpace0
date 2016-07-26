package com.example.test_7_19;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MyThread.GetSeekBarListener{

    private LinearLayout ll;
    private TextView tv;
    private final int SIZE = 8;
    private SeekBar[] seekBars;
    private MyThread[] myThreads ;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ll = (LinearLayout) findViewById(R.id.ll);
        tv = (TextView) findViewById(R.id.info);

    }

    //初始化SeekBar
    public void initSeekBar(){
        seekBars = new SeekBar[SIZE];
        for(int i = 0 ; i < seekBars.length ; i ++){
            seekBars[i] = new SeekBar(this);
            seekBars[i].setContentDescription( (i + 1) + "号马");
            ll.addView(seekBars[i]);
        }
    }

    public void initThread(){
        myThreads = new MyThread[SIZE];
        for (int i = 0 ; i < myThreads.length ; i++){
            myThreads[i] = new MyThread(seekBars[i]);
            myThreads[i].setGetSeekBarListener(this);
        }
    }

    public void start(){
        for(int i = 0 ; i < myThreads.length ; i++ ){
            myThreads[i].start();
        }
    }

    public void startRun(View view){
        initSeekBar();
        initThread();
        start();
    }

    @Override
    public void getSeekBar(SeekBar seekBar) {
        final String str = (String) seekBar.getContentDescription();
        tv.post(new Runnable() {
            @Override
            public void run() {
                tv.append("第"+ (count + 1) + "名："+ str + "\n" );
                count ++;
            }
        });
    }
}

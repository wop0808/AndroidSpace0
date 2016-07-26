package com.example.interface_trasdata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MyThread.SeekBarListerner{
    private SeekBar[] seekBars;
    private LinearLayout ll;
    private TextView tv;
    private final int SIZE = 8;
    private MyThread[] myThreads;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ll = (LinearLayout) findViewById(R.id.id_main_ll_seekbars);
        tv = (TextView) findViewById(R.id.id_main_result);

        initSeekBar();
    }

    public void initSeekBar(){
        seekBars = new SeekBar[SIZE];
        for(int i = 0 ; i < seekBars.length ; i++){
            seekBars[i] = new SeekBar(this);
            seekBars[i].setMax(200);
            seekBars[i].setContentDescription((i+1) + "号马");
            ll.addView(seekBars[i]);
        }
    }

    public void initThread(){
        myThreads = new MyThread[SIZE];
        for(int i = 0 ; i < myThreads.length ; i ++){
            myThreads[i] = new MyThread(seekBars[i]);
            myThreads[i].setSeekBarListerner(this);
        }
    }

    public void startGame(View view){
        initThread();
        for(int i = 0 ; i < myThreads.length ; i++){
            myThreads[i].start();
        }
    }

    @Override
    public void initResult(SeekBar seekBar) {
        final String str = (String) seekBar.getContentDescription();
        tv.post(new Runnable() {
            @Override
            public void run() {
                tv.append("第" + ++count + "名：" + str + "\n" );
            }
        });
    }
}

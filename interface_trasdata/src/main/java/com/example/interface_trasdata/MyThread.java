package com.example.interface_trasdata;

import android.widget.SeekBar;

import java.util.Random;

/**
 * Created by Administrator on 2016/7/20.
 */
public class MyThread extends Thread {
    private SeekBar seekBar;
    private Random random;
    private SeekBarListerner seekBarListerner;


    public MyThread(SeekBar seekBar){
        this.seekBar = seekBar;
    }

    @Override
    public void run() {
        random = new Random();
        while (seekBar.getProgress() < 200){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            seekBar.setProgress(seekBar.getProgress() + random.nextInt(5) + 1);
        }
        if(seekBar.getProgress() >= 200){
            seekBar.setProgress(200);
            seekBarListerner.initResult(seekBar);
        }
    }

    interface SeekBarListerner{
        public void initResult(SeekBar seekBar);
    }

    public SeekBarListerner getSeekBarListerner() {
        return seekBarListerner;
    }

    public void setSeekBarListerner(SeekBarListerner seekBarListerner) {
        this.seekBarListerner = seekBarListerner;
    }
}

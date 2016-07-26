package com.example.test_7_19;

import android.widget.SeekBar;

import java.util.Random;

/**
 * Created by Administrator on 2016/7/20.
 */
public class MyThread extends Thread {
    private SeekBar seekBar;
    private Random random;
    private GetSeekBarListener getSeekBarListener;

    public MyThread(SeekBar seekBar) {
        this.seekBar = seekBar;
        seekBar.setMax(200);
        random = new Random();
    }

    //赛马 耗时操作
    @Override
    public void run() {
        while (seekBar.getProgress() < 200) {
            seekBar.setProgress(seekBar.getProgress() + random.nextInt(5));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (seekBar.getProgress() >= 200) {
            seekBar.setProgress(200);
            getSeekBarListener.getSeekBar(seekBar);
        }
    }
    /**
     * public 为何是多余的？
     * */

    public interface GetSeekBarListener {
        public void getSeekBar(SeekBar seekBar);
    }

    public GetSeekBarListener getGetSeekBarListener() {
        return getSeekBarListener;
    }

    public void setGetSeekBarListener(GetSeekBarListener getSeekBarListener) {
        this.getSeekBarListener = getSeekBarListener;
    }
}

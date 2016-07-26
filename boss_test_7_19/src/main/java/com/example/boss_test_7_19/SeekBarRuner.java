package com.example.boss_test_7_19;

import android.os.SystemClock;
import android.widget.SeekBar;

import java.util.Random;

/**
 * Created by Administrator on 2016/7/20.
 */
public class SeekBarRuner extends Thread {
    private SeekBar seekbar;
    private Random random;
    private OnSeekBarRunEndListener onSeekBarRunEndListener;
    private boolean isRunning = false;

    public SeekBarRuner(SeekBar seekbar) {
        this.seekbar = seekbar;
        random = new Random();
    }

    @Override
    public void run() {
        while (seekbar.getProgress() < MainActivity.MAX_SEEKBAR_VALUE) {
            isRunning = true;
            setProgress(seekbar.getProgress() + (random.nextInt(5) + 1));// 每秒随机增加1~5
            SystemClock.sleep(100);
        }
        if (onSeekBarRunEndListener != null) {
            onSeekBarRunEndListener.onEnd(seekbar);// 回调SeekBar跑完事件
        }
        isRunning = false;
    }

    public void setProgress(int progress) {
        seekbar.setProgress(progress);
    }

    public SeekBar getSeekbar() {
        return seekbar;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public OnSeekBarRunEndListener getOnSeekBarRunEndListener() {
        return onSeekBarRunEndListener;
    }

    /**
     * 设置SeekBar跑完的监听器
     *
     * @param onSeekBarRunEndListener
     */
    public void setOnSeekBarRunEndListener(OnSeekBarRunEndListener onSeekBarRunEndListener) {
        this.onSeekBarRunEndListener = onSeekBarRunEndListener;
    }

    /**
     * SeekBar跑完的监听器
     *
     * @author MicroAnswer
     *
     */
    interface OnSeekBarRunEndListener {
        void onEnd(SeekBar seekbar);
    }

}
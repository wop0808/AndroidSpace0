package com.example.boss_test_7_19;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener ,SeekBarRuner.OnSeekBarRunEndListener{
    public static final int MAX_SEEKBAR_VALUE = 200;// seekBar最大值
    public static final int SEEKBAR_COUNT = 8;// 参与竞跑的SeekBar个数

    private Object locker = new Object();

    private SeekBar seekbars[];
    private SeekBarRuner seekBarRuners[];

    private LinearLayout seekbar_linearlayout;
    private Button button_start;
    private TextView textview_result;

    private int index;// 记录seekbar跑完的顺序

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekbar_linearlayout = (LinearLayout) findViewById(R.id.activity_main_seekbars);
        textview_result = (TextView) findViewById(R.id.activity_main_textview_result);
        button_start = (Button) findViewById(R.id.activity_main_button_start);
        button_start.setOnClickListener(this);

        seekbars = new SeekBar[SEEKBAR_COUNT];
        seekBarRuners = new SeekBarRuner[seekbars.length];

        for (int i = 0; i < seekbars.length; i++) {
            seekbars[i] = new SeekBar(this);
            seekbars[i].setContentDescription((i + 1) + "号赛马");
            seekbars[i].setMax(MAX_SEEKBAR_VALUE);
            seekbar_linearlayout.addView(seekbars[i]);
            seekBarRuners[i] = new SeekBarRuner(seekbars[i]);
            seekBarRuners[i].setOnSeekBarRunEndListener(this);
        }

    }

    @Override
    public void onClick(View v) {
        if (isRunning()) {
            Toast.makeText(this, "请等待所有参赛者完成再开始", Toast.LENGTH_SHORT).show();
            return;
        }
        textview_result.setText("");
        index = 0;
        for (int i = 0; i < seekBarRuners.length; i++) {
            try {
                seekBarRuners[i].start();// 开启每一个竞跑的线程
            } catch (Exception e) {// 同一个线程不能执行多次，所以，阅卷者若果多次点击开始，将会导致此异常，这里将其try住，并new新的线程同时开启即可
                seekBarRuners[i] = new SeekBarRuner(seekBarRuners[i].getSeekbar());
                seekBarRuners[i].setOnSeekBarRunEndListener(this);
                seekBarRuners[i].setProgress(0);
                seekBarRuners[i].start();
            }
        }
    }

    /**
     * 判断是否有SeekBar还在跑
     *
     * @return
     */
    private boolean isRunning() {
        for (SeekBarRuner seekBarRuner : seekBarRuners) {
            if (seekBarRuner.isRunning()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void onEnd(final SeekBar seekbar) {
        synchronized (locker) {// 多个线程，操作一个TextView，避免出错，加个同步
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    textview_result.append("第" + (++index) + "名：" + seekbar.getContentDescription() + "\n");
                }
            });
        }
    }
}

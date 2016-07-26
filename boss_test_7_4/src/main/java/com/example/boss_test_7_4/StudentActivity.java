package com.example.boss_test_7_4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Calendar;

public class StudentActivity extends Activity {
    private Student student;
    private TextView tv_name,tv_detail,tv_time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        student = (Student) getIntent().getSerializableExtra("data");

        tv_name = (TextView) findViewById(R.id.id_activity_student_name);
        tv_detail = (TextView) findViewById(R.id.id_activity_student_detail);
        tv_time = (TextView) findViewById(R.id.id_activity_student_time);

        getActionBar().setTitle(student.getName());

        tv_name.setText(student.getName());
        tv_detail.setText(student.getDetail());
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        tv_time.setText(year + "-" + month + "-" +day);

    }

    public void comeback(View view){
        this.finish();
    }
}

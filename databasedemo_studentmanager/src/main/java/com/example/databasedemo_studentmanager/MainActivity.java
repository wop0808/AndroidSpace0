package com.example.databasedemo_studentmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText name, number;
    private Button save, read;
    private DataManager dataManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataManager = new DataManager(this);
        save = (Button) findViewById(R.id.save);
        save.setOnClickListener(this);
        read = (Button) findViewById(R.id.read);
        read.setOnClickListener(this);
        name = (EditText) findViewById(R.id.name);
        number = (EditText) findViewById(R.id.number);
    }

    @Override
    public void onClick(View v) {
        if (v == read) {
            Student student = dataManager.get(Integer.parseInt(number.getText().toString()));
            Toast.makeText(this, "学生：" + student.toString(), Toast.LENGTH_LONG).show();
        } else if (v == save) {
            String namee = name.getText().toString();
            int numberr = Integer.parseInt(number.getText().toString());
            Student student = new Student(namee,numberr);
            long l = dataManager.put(student);
            Toast.makeText(this,""+l,Toast.LENGTH_SHORT).show();
        }
    }



    public void changetobyte(View a) throws Exception {
        Student student = new Student("Tom",20);

        byte[] bytes = Student.Object2Bytes(student);

        Toast.makeText(this, Arrays.toString(bytes),Toast.LENGTH_SHORT).show();

        Student student1 = Student.Bytes2Object(Student.class, bytes);

        Toast.makeText(this, student1.toString(),Toast.LENGTH_SHORT).show();
    }
}

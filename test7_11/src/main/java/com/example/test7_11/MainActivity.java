package com.example.test7_11;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button button_main;
    private EditText et_username,et_pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_main = (Button) findViewById(R.id.id_main_login);

        button_main.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.id_main_login:
                creatDialog();
                break;
        }
    }

    public void creatDialog(){
        View dialog_view = getLayoutInflater().inflate(R.layout.dialog_item,null);
        et_username = (EditText) dialog_view.findViewById(R.id.id_dialog_username);
        et_pwd = (EditText) dialog_view.findViewById(R.id.id_dialog_pwd);


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("登录")
                .setCancelable(false)
                .setView(dialog_view)
                .setPositiveButton("登录", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String username = et_username.getText().toString().trim();
                        String pwd = et_pwd.getText().toString().trim();
                        if(TextUtils.isEmpty(username) || TextUtils.isEmpty(pwd)){
                            Toast.makeText(MainActivity.this, "账户密码不能为空", Toast.LENGTH_SHORT).show();
                        }
                        if(TextUtils.equals("asd",username) && TextUtils.equals("123",pwd)){
                            startActivity(new Intent(MainActivity.this,ContentActivity.class));
                        }
                        else {
                            Toast.makeText(MainActivity.this, "账户密码错误", Toast.LENGTH_SHORT).show();
                        }
//                        if("asd".equals(username) && "123".equals(pwd)){
//                            startActivity(new Intent(MainActivity.this,ContentActivity.class));
//                        }else{
//                            Toast.makeText(MainActivity.this,"账户密码错误",Toast.LENGTH_SHORT).show();
//                        }
//                        startActivity(new Intent(MainActivity.this,ContentActivity.class));
                    }
                })
                .setNegativeButton("取消",null)
                .create().show();
    }
}

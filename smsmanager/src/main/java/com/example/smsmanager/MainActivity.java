package com.example.smsmanager;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {
    private EditText et_numbers,et_contends;
    private Button btn_select,btn_send;
    private ArrayList<String> sendList = new ArrayList<>();
    private SmsManager smsManager;
    private final int REQUEST_CODE = 1;
//    private Context context;


    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        //申请权限，详情见telephonyManager
        if(Integer.parseInt(Build.VERSION.SDK)<23){
            btn_select.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //xml-->view 对话框的view
                    View view_ald = View.inflate(MainActivity.this, R.layout.listview, null);
                    //查找view_ald中的listview
                    final ListView listView = (ListView) view_ald.findViewById(R.id.id_listview_lv);
                    MyAdapter myAdapter = new MyAdapter(MainActivity.this,sendList);
                    listView.setAdapter(myAdapter);
                    AlertDialog.Builder ald_Builder = new AlertDialog.Builder(MainActivity.this);
                    ald_Builder.setView(view_ald)
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    sendList.clear();
                                    for(int x = 0 ;x<listView.getCount() ;x++ ){
                                        CheckBox checkBox = (CheckBox) listView.getChildAt(i);
                                        if(checkBox.isChecked()){
                                            sendList.add(checkBox.getText().toString());
                                        }
                                    }
                                    et_numbers.setText(sendList.toString());
                                }
                            })
                            .create().show();
                }
            });

            btn_send.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    for(String number : sendList ){
                        PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this,0,new Intent(),0);
                        smsManager.sendTextMessage(number,null,et_contends.getText().toString(),pendingIntent ,null);
                    }
                }
            });
        }else {
            requestPermissions(new String[]{"android.permission.SEND_SMS","android.permission.READ_CONTACTS","android.permission.WRITE_CONTACTS"},REQUEST_CODE);
        }
//        initOnClick();


    }

    public void initView(){
        et_contends = (EditText) findViewById(R.id.id_main_et_contends);
        et_numbers = (EditText) findViewById(R.id.id_main_et_numbers);
        btn_select = (Button) findViewById(R.id.id_main_btn_select);
        btn_send = (Button) findViewById(R.id.id_main_btn_send);
        smsManager = SmsManager.getDefault();
    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1:
                boolean isSuccess = (grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED && grantResults[2] == PackageManager.PERMISSION_GRANTED );

                if(isSuccess){
                    btn_select.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            //xml-->view 对话框的view
                            View view_ald = View.inflate(MainActivity.this, R.layout.listview, null);
                            //查找view_ald中的listview
                            final ListView listView = (ListView) view_ald.findViewById(R.id.id_listview_lv);
                            MyAdapter myAdapter = new MyAdapter(MainActivity.this,sendList);
                            listView.setAdapter(myAdapter);
                            AlertDialog.Builder ald_Builder = new AlertDialog.Builder(MainActivity.this);
                            ald_Builder.setView(view_ald)
                                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            sendList.clear();
                                            for(int x = 0 ;x<listView.getCount() ;x++ ){
                                                CheckBox checkBox = (CheckBox) listView.getChildAt(i);
                                                if(checkBox.isChecked()){
                                                    sendList.add(checkBox.getText().toString());
                                                }
                                            }
                                            et_numbers.setText(sendList.toString());
                                        }
                                    })
                                    .create().show();
                        }
                    });

                    btn_send.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            for(String number : sendList ){
                                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this,0,new Intent(),0);
                                smsManager.sendTextMessage(number,null,et_contends.getText().toString(),pendingIntent ,null);
                            }
                        }
                    });
                }
        }
    }
}

package com.example.telephonymanager;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * Dangerous Permissions:
 group:android.permission-group.CONTACTS
 permission:android.permission.WRITE_CONTACTS
 permission:android.permission.GET_ACCOUNTS
 permission:android.permission.READ_CONTACTS

 group:android.permission-group.PHONE
 permission:android.permission.READ_CALL_LOG
 permission:android.permission.READ_PHONE_STATE
 permission:android.permission.CALL_PHONE
 permission:android.permission.WRITE_CALL_LOG
 permission:android.permission.USE_SIP
 permission:android.permission.PROCESS_OUTGOING_CALLS
 permission:com.android.voicemail.permission.ADD_VOICEMAIL

 group:android.permission-group.CALENDAR
 permission:android.permission.READ_CALENDAR
 permission:android.permission.WRITE_CALENDAR

 group:android.permission-group.CAMERA
 permission:android.permission.CAMERA

 group:android.permission-group.SENSORS
 permission:android.permission.BODY_SENSORS

 group:android.permission-group.LOCATION
 permission:android.permission.ACCESS_FINE_LOCATION
 permission:android.permission.ACCESS_COARSE_LOCATION

 group:android.permission-group.STORAGE
 permission:android.permission.READ_EXTERNAL_STORAGE
 permission:android.permission.WRITE_EXTERNAL_STORAGE

 group:android.permission-group.MICROPHONE
 permission:android.permission.RECORD_AUDIO

 group:android.permission-group.SMS
 permission:android.permission.READ_SMS
 permission:android.permission.RECEIVE_WAP_PUSH
 permission:android.permission.RECEIVE_MMS
 permission:android.permission.RECEIVE_SMS
 permission:android.permission.SEND_SMS
 permission:android.permission.READ_CELL_BROADCASTS
 *
 * */

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private String[] arrayDatas;
    private ArrayList<String> listDatas;
    private final int REQUEST_CODE = 1;
    private String TAG = "crazyK";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.id_main_lv);

        //当api等级大于等于23，即sdk>=6.0时，需要调用 requestPermissions（）申请权限
        //判断sdk版本号是由Integer.parseInt(Build.VERSION.SDK)
        if(Integer.parseInt(Build.VERSION.SDK) < 23){

        }else {
            requestPermissions(new String[]{"android.permission.ACCESS_COARSE_LOCATION" ,"android.permission.READ_PHONE_STATE"},REQUEST_CODE);
        }


    }

    public void getArrayDatas(){
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        arrayDatas = new String[]{
                "SIM卡状态："+ telephonyManager.getSimState(),
                "SIM卡序列号："+ telephonyManager.getSimSerialNumber(),
                "SIM卡的国别："+ telephonyManager.getSimCountryIso(),
                "设备所在位置："+ (telephonyManager.getCellLocation() != null? telephonyManager.getCellLocation().toString():"未知未知"),
                "手机网络类型："+ telephonyManager.getPhoneType(),
                "网络运营商名："+ telephonyManager.getNetworkOperatorName(),
                "网络运营商代号："+ telephonyManager.getNetworkOperator()
        };
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1:
                //int[] grantResults，指两个申请权限后 分别返回的值 所组成的数组
                boolean isSuccess = (grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED);
                if(isSuccess){
                    getArrayDatas();
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,arrayDatas);
                    listView.setAdapter(arrayAdapter);
                }else {
                    Toast.makeText(MainActivity.this, "申请权限不成功", Toast.LENGTH_SHORT).show();
                }


        }
    }
}

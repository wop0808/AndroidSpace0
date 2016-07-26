package com.example.serviceclient;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.serviceport.AAA;
import com.example.serviceport.IMyAidlInterface;

public class MainActivity extends AppCompatActivity {
    private EditText id,pwd;

    private IMyAidlInterface iMyAidlInterface;
    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (iMyAidlInterface == null) {
                iMyAidlInterface = IMyAidlInterface.Stub.asInterface(iBinder);
                Toast.makeText(MainActivity.this, "连接成功", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "连接失败", Toast.LENGTH_SHORT).show();
            }

        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        bindService(new Intent("com.example.serviceport.IMyAidlInterface"),serviceConnection ,BIND_AUTO_CREATE );

        id = (EditText) findViewById(R.id.id_main_id);
        pwd = (EditText) findViewById(R.id.id_main_pwd);

        Intent intent = new Intent();
        intent.setAction("com.example.serviceport.IMyAidlInterface");
//        intent.setPackage("com.example.serviceport");
        bindService(intent,serviceConnection ,BIND_AUTO_CREATE );
    }

    public void startSS(View view) throws RemoteException {

        String username = id.getText().toString().trim();
        String userPwd = pwd.getText().toString().trim();

        if ( iMyAidlInterface.getUser(username,userPwd)){
            Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
        }
    }


}

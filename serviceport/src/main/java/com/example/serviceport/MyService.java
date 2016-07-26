package com.example.serviceport;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class MyService extends Service {

    public MyService() {
    }

    public  class  MyServiceImpl extends IMyAidlInterface.Stub{

        @Override
        public boolean getUser(String id, String pwd) throws RemoteException {
            if(id.equals("abc") && pwd.equals("123")){
                return true;
            }
            return false;
        }
    }


    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("MyService","onCreate");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("MyService","onDestroy");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onRebind(Intent intent) {
        Log.i("MyService","onRebind");
        super.onRebind(intent);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i("MyService","onUnbind");
        return true;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return new MyServiceImpl();
    }
}

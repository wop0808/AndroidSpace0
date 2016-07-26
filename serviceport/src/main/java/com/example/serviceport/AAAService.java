package com.example.serviceport;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class AAAService extends Service {
    public class AAABinder extends AAA.Stub{

        @Override
        public String getStr() throws RemoteException {
            return "abcdefg";
        }
    }
    public AAAService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return new AAABinder();
    }
}

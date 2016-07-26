package share.serviceclient_obj;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import share.serviceport_obj.IMyAidlInterface;
import share.serviceport_obj.Person;

public class MainActivity extends AppCompatActivity {

    private Person person;
    private IMyAidlInterface iMyAidlInterface;
    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            iMyAidlInterface = IMyAidlInterface.Stub.asInterface(iBinder);
            try {
                person = iMyAidlInterface.getPerson();
                Toast.makeText(MainActivity.this, "姓名："+ person.getName() +" 年龄："+ person.getAge(), Toast.LENGTH_SHORT).show();
            } catch (RemoteException e) {
                e.printStackTrace();
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
    }

    public void start(View view){
        Intent intent = new Intent();
        intent.setAction("share.serviceport_obj.PersonService");
        intent.setPackage("share.serviceport_obj");

        bindService(intent,serviceConnection,BIND_AUTO_CREATE);
    }

    public void stop(View view){
        unbindService(serviceConnection);
    }
}

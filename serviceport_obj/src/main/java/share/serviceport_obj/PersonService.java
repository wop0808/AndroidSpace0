package share.serviceport_obj;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;


public class PersonService extends Service {
    private Person person;

    public class Person_Obj extends IMyAidlInterface.Stub{

        @Override
        public Person getPerson() throws RemoteException {
            return person;
        }
    }

    public PersonService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        person = new Person();
        person.setAge(25);
        person.setName("aaa");

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return new Person_Obj();
    }
}

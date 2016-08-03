package share.broadcastreciver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class FreshUI_Service extends Service {
    public FreshUI_Service() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Intent intent = new Intent();
        intent.putExtra("actions", "打代码");
        intent.setAction("com.hkc.inner_receiver");
        sendBroadcast(intent);
    }

    @Override
    public IBinder onBind(Intent intent) {
      return null;
    }
}

package share.post0;

import android.os.Handler;
import android.os.Looper;

/**
 * Created by Administrator on 2016/7/26.
 */

class LoadThread extends Thread{
    Handler loadHandler;
    @Override
    public void run() {
        super.run();
        Looper.prepare();
        loadHandler = new Handler();
        Looper.loop();
    }
}
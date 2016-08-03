package share.broadcastreciver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    static EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = (EditText) findViewById(R.id.id_main_et);
    }

    public void sendBroad(View view){
        Intent intent = new Intent();
        intent.setAction("com.hkc.firstreceiver");
        Bundle bundle = new Bundle();
        bundle.putInt("age",25);
        bundle.putString("name","HKC");
        intent.putExtras(bundle);
        sendBroadcast(intent);
    }

    public void freshUI(View view){
        Intent intent = new Intent(this,FreshUI_Service.class);
        startService(intent);
    }

    public static class FreshUI_Receiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            String str = intent.getStringExtra("actions");
            et.setText(str);
        }
    }

    public void sendoOne(View view){
        Intent intent = new Intent();
        intent.setAction("com.hkc.firstreceiver");
        Bundle bundle = new Bundle();
        bundle.putInt("age", 32);
        bundle.putString("name", "小陶");
        intent.putExtras(bundle);
        //sendBroadcast()：发送广播
        sendBroadcast(intent);
    }
    public void sendTwo(View view){
        Intent intent = new Intent();
        intent.setAction("com.hkc.firstreceiver");
        Bundle bundle = new Bundle();
        bundle.putInt("age", 30);
        bundle.putString("name", "小杨");
        intent.putExtras(bundle);
        //sendBroadcast()：发送广播
        sendBroadcast(intent);
    }

    public void sendOrderBroad(View view){
        Intent intent = new Intent();
        intent.setAction("com.hkc.firstreceiver");
        Bundle bundle = new Bundle();
        bundle.putInt("age", 30);
        bundle.putString("name", "小杨");
        intent.putExtras(bundle);
        //sendOrderedBroadcast()：发送有序广播
        //sendOrderedBroadcast(intent, null);

        //发送有权限的广播
        sendOrderedBroadcast(intent, "share.permission");
    }

    public void registReceiver(View view){
        RegistReceiver registReceiver = new RegistReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.hkc.registReceiver");
        registerReceiver(registReceiver,intentFilter);
    }
}

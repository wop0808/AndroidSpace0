package share.broadcastreciver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class FirstReceiver extends BroadcastReceiver {
    public FirstReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        String name = bundle.getString("name");
        int age = bundle.getInt("age");
        Toast.makeText(context, name + "  "+age , Toast.LENGTH_SHORT).show();
    }
}

package share.broadcastreciver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class RegistReceiver extends BroadcastReceiver {
    public RegistReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        String name = bundle.getString("name");
        Toast.makeText(context, name  , Toast.LENGTH_SHORT).show();
    }
}

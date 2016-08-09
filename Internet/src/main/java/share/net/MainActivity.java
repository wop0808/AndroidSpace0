package share.net;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getURLInfo(View view){
        new URLThread().start();
    }

    public void uRLConn_Get(View view){
        new URLConnection_Get().start();
    }

    public void uRLConn_Post(View view){
        new URLConnection_Post().start();
    }

    public void httpURLConn_Get(View view){
        new HttpURLConnection_Get().start();
    }

    public void httpURLConn_Post(View view){
        new HttpURLConn_Post().start();
    }
}

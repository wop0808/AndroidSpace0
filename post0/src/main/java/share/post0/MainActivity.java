package share.post0;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * post()详解：
 * 1.在调用post（）时，会将Runnable放入消息队列中。而消息队列为loop模式运行，一个个处理消息，这样就能够做到将许多线程放到一个线程中处理，从而避免了过多线程造成内存消耗过大。试用于listview刷新
 * 2.post（）的Runnable将会运行在其handler实例所在的线程。及handler实例化在哪个线程 则Runnable就会在哪个线程运行
 * */

public class MainActivity extends AppCompatActivity {
    private TextView tv;
    private Button btn;
    private Handler mainHandler;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.id_main_tv);
        btn = (Button) findViewById(R.id.id_main_btn);

        mainHandler = new Handler();
        final LoadThread  loadThread = new LoadThread();
        loadThread.start();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadThread.loadHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        BufferedReader br = null;
                        try {
                            URL url = new URL("http://172.18.4.18:8080/my/aaa.txt");
                            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                            httpURLConnection.setRequestMethod("POST");
                            httpURLConnection.setDoInput(true);
                            httpURLConnection.setDoOutput(true);
                            httpURLConnection.connect();

                            InputStream is = httpURLConnection.getInputStream();
                            InputStreamReader isr = new InputStreamReader(is);
                            br = new BufferedReader(isr);
                            String content = "";
                            while ((content = br.readLine()) != null){
                                final String dataa = content;
                                mainHandler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        tv.append(dataa);
                                    }
                                });
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }finally {
                            try {
                                br.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
            }
        });


    }



}
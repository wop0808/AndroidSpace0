package share.net;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Administrator on 2016/7/26.
 */

public class HttpURLConnection_Get extends Thread {
    private URL url;
    private BufferedReader br;

    @Override
    public void run() {
        super.run();
        try {
            url = new URL("http://172.18.4.18:8080/my/aaa.txt");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            //设置访问服务端的方式为GET
            httpURLConnection.setRequestMethod("GET");

            httpURLConnection.connect();

            InputStream is = httpURLConnection.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            br = new BufferedReader(isr);

            String content = "";
            while ((content = br.readLine()) != null){
                Log.e("content",content);
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
}

package share.net;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrator on 2016/7/26.
 */

public class HttpURLConn_Post extends Thread {
    private URL url;
    private BufferedReader br;

    @Override
    public void run() {
        super.run();
        try {
            url = new URL("http://172.18.4.18:8080/my/aaa.txt");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestProperty("accept", "*/*");
            httpURLConnection.connect();

            OutputStream os = httpURLConnection.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            pw.write("输出流");
            pw.flush();

            InputStream is = httpURLConnection.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            String content ="";
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

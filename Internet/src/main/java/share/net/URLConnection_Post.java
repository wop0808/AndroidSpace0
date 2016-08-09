package share.net;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Administrator on 2016/7/26.
 */

public class URLConnection_Post extends Thread {
    private URL url;
    private URLConnection urlConnection;
    private BufferedReader bufferedReader;

    @Override
    public void run() {
        super.run();
        try {
            url = new URL("http://172.18.4.18:8080/my/aaa.txt");
            urlConnection = url.openConnection();

            //设置请求头，报头
            urlConnection.setRequestProperty("accept", "*/*");

            //设置post方式访问服务器
            urlConnection.setDoInput(true);
            urlConnection.setDoOutput(true);

            //获取输出流
            OutputStream outputStream = urlConnection.getOutputStream();

            //客户端通过“输出流”的形式，向服务器发送数据
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.write("输出流:prentWriter");
            printWriter.flush();

            //客户端以“输入流”的形式，接收从服务器返回的数据
            InputStream inputStream = urlConnection.getInputStream();
            InputStreamReader isr = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(isr);
            String content = "";
            while ((content = bufferedReader.readLine()) != null){
                Log.e("content",content);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

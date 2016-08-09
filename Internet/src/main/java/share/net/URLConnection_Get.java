package share.net;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Administrator on 2016/7/26.
 */

public class URLConnection_Get extends Thread {
    private URL url;
    private URLConnection conn;
    private BufferedReader br;

    @Override
    public void run() {
        super.run();
        try {
            url = new URL("http://172.18.4.18:8080/my/aaa.txt");
            //获取URLConnection对象
            //默认以Get方式连接，没有setRequestMethod("GET")
            conn = url.openConnection();

            //报文信息(请求头, 请求体)
            //设置“请求头”“报头”
            conn.setRequestProperty("accept", "*/*");

            //建立与服务端连接
            conn.connect();

            //获取字节流
            InputStream is = conn.getInputStream();
            //将字节流转换为字符流 并转换为utf-8格式
            InputStreamReader isr = new InputStreamReader(is,"utf-8");
            //将字节流放入缓冲
            br = new BufferedReader(isr);
            //读取操作
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

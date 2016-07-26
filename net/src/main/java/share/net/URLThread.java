package share.net;

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import static android.content.ContentValues.TAG;

/**
 * Created by Administrator on 2016/7/26.
 */

public class URLThread extends Thread {
    private URL url;

    @Override
    public void run() {
        super.run();
        try {
            url = new URL("http://172.18.4.18:8080/my/aaa.txt");

            String file = url.getFile();//获取网络文件在服务器上的地址及文件名
            Log.e("file",file);

            String host = url.getHost();//获取服务器主机
            Log.e("host",host);

            String path = url.getPath();//获取文件路径
            Log.e("path",path);

            int port = url.getPort();     //获取端口号
            Log.e("port", port+"");

            String protocol = url.getProtocol();   //获取协议头
            Log.e("protocol", protocol);

            String query = url.getQuery();  //获取请求参数
            Log.e("query", query+"");

            InputStream is = url.openConnection().getInputStream();
//            完整写法如下:URLConnection urlConnection = url.openConnection();
//            urlConnection.connect();
//            InputStream inputStream = urlConnection.getInputStream();


//             InputStream is = url.openStream();
//            在oprenStream()方法中已封装好了openConnection()

            InputStreamReader isr = new InputStreamReader(is,"utf-8");
            BufferedReader br = new BufferedReader(isr);
            String content = "";
            while ((content = br.readLine()) != null){
                Log.e("content",content);
            }
            br.close();//关闭流 应关闭最外面一层

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package com.example.test_8_1;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Administrator on 2016/8/1.
 */
public class DownLoad extends Thread {
    URL url;
    Interface_DownLoad interface_downLoad;
    HttpURLConnection connection;
    MHandler mHandler;

    public DownLoad(String address, Interface_DownLoad interface_downLoad) {
        this.interface_downLoad = interface_downLoad;
        try {
            url = new URL(address);
            connection = (HttpURLConnection) url.openConnection();
            mHandler = new MHandler();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        super.run();
        try {
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.connect();
            PrintWriter printWriter = new PrintWriter(connection.getOutputStream());
            printWriter.write("");
            printWriter.flush();
            String temp = null;
            StringBuilder stringBuilder = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "GBK"));
            while ((temp = bufferedReader.readLine()) != null) {
                stringBuilder.append(temp);
            }
//            Log.i("crazyK", stringBuilder.toString());
            Message message = new Message();
            message.obj = stringBuilder.toString();
            mHandler.sendMessage(message);
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class MHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            String result = (String) msg.obj;
//            Log.i("crazyK", result);
            Gson gson = new Gson();
            MyGson myGson = gson.fromJson(result, MyGson.class);
            interface_downLoad.getData(myGson);
        }
    }


}

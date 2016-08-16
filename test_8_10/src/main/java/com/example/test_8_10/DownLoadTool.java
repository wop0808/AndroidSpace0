package com.example.test_8_10;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Administrator on 2016/8/10.
 */
public class DownLoadTool {

    public static String getStringFromURL(String murl,String charSet){
        BufferedReader bufferedReader = null;
        HttpURLConnection httpURLConnection = null;
        String result = "";
        try {
            URL url = new URL(murl);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.connect();
            InputStream inputStream = httpURLConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream,charSet);
            bufferedReader = new BufferedReader(inputStreamReader);
            String temp = "";
            while ((temp = bufferedReader.readLine()) != null){
                result += (temp + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            httpURLConnection.disconnect();
        }
        return result;
    }


    public static Bitmap getBitmapFromURL(String murl ){
        HttpURLConnection httpURLConnection = null;
        InputStream inputStream = null;
        Bitmap bitmap = null;
        try {
            URL url = new URL(murl);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.connect();
            inputStream = httpURLConnection.getInputStream();
            bitmap = BitmapFactory.decodeStream(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            httpURLConnection.disconnect();
        }
        return bitmap;
    }

    public static void getImgFromURL_InSD(String murl ,File file){
        HttpURLConnection httpURLConnection = null;
        InputStream inputStream = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            if (Environment.getExternalStorageState().equals(
                    Environment.MEDIA_MOUNTED)) {
                file.createNewFile();
                URL url = new URL(murl);
                httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.connect();
                inputStream = httpURLConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                bufferedReader = new BufferedReader(inputStreamReader);
                bufferedWriter = new BufferedWriter(new FileWriter(file));
                String str = "";
                while ((str = bufferedReader.readLine()) != null) {
                    bufferedWriter.write(str);
                    bufferedWriter.newLine();
                }

                bufferedWriter.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(inputStream != null){
                try {
                    inputStream.close();
                    bufferedReader.close();
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
//            httpURLConnection.disconnect();
        }
    }
}

package com.example.test_8_10;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements DownLoadJson.OnGetJsonEndListener {
    private ImageView imageView;
    private TextView textView;
    private String[][] datas;
    private String TAG = "crazyK";
    private final String FILE_NAME = "/touxiang.png";
    private File file;
    private String result_Bitmap = "";
    private Person.InfoBean info;
    private String url_bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            file = new File(Environment.getExternalStorageDirectory().getCanonicalPath() + FILE_NAME);
            if(file.getParentFile().exists()&&file.getParentFile().isDirectory()){
                if(!file.exists()){
                    file.createNewFile();
                }
            }else{
                file.getParentFile().mkdirs();
                file.createNewFile();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        Log.i(TAG, file.getAbsolutePath());

        initView();

        startLogi();

    }

    public void initView() {
        imageView = (ImageView) findViewById(R.id.id_main_iv);
        textView = (TextView) findViewById(R.id.id_main_tv);
    }


    @Override
    public void startUI(Person person) {

        info = person.getInfo();
        String user_name = info.getUser_name();
        String user_pwd = info.getUser_pwd();

        url_bitmap = info.getUser_head();

        inSdCard();

        //设置用户名
        textView.setText(user_name);

        //将数据写入数据库
        RegistDao registDao_Write = new RegistDao(this, user_name, user_pwd);
        registDao_Write.startWrite(registDao_Write);
    }

    public boolean isContentEmpty() {
        RegistDao registDao_Read = new RegistDao(this);
        datas = registDao_Read.startRead(registDao_Read);
        return isArrayEmpty(datas);
    }

    //这个才是判断二维数组是否为空的方法
    public static boolean isArrayEmpty(Object[][] array) {
        if (array[0].equals("null") || array[0].length == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void startLogi() {
        if (isContentEmpty()) {
            Log.i(TAG, "数据库没有信息");
            new DownLoadJson("http://172.18.4.3:8080/user/user_info.txt", "UTF-8", this).start();
        } else {
            Log.i(TAG, "数据库有信息 ");
//            FileInputStream fis = null;
//            try {
//                fis = new FileInputStream(file);
//                Log.i(TAG, "读取流成功");
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            }
            Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
            Log.i(TAG, "获得bitmap");
            imageView.setImageBitmap(bitmap);
            textView.setText(datas[0][0]);
        }
    }

    public boolean isExist() {
        if (file.exists()) {
            return true;
        }
        return false;
    }

    public void inSdCard() {
        //开始下载图片并且设置头像
        DownLoadImage downLoadImage = new DownLoadImage(this.imageView);
        downLoadImage.execute(info.getUser_head());
        //将图片存入sd卡
        DownLoadTool.getImgFromURL_InSD(url_bitmap, file);
    }
}



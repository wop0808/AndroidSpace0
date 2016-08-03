package com.example.test_8_1;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Interface_DownLoad{
    TextView tv1,tv2,tv3;
    ImageView iv1,iv2,iv3;
    ListView listView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = (TextView) findViewById(R.id.id_main_tv1);
        tv2 = (TextView) findViewById(R.id.id_main_tv2);
        tv3 = (TextView) findViewById(R.id.id_main_tv3);
        iv1 = (ImageView) findViewById(R.id.id_main_iv1);
        iv2 = (ImageView) findViewById(R.id.id_main_iv2);
        iv3 = (ImageView) findViewById(R.id.id_main_iv3);
        listView = (ListView) findViewById(R.id.id_main_lv);

        new DownLoad("http://172.18.4.3:8080/kaoshi/friends.txt",this).start();
    }

    @Override
    public void getData(MyGson myGson) {
        int errorcode = myGson.errorcode;
        String reason = myGson.reason;
        List<MyGson.FrendsBean> frends = myGson.frends;
        String jiangzeming = frends.get(0).frend_name;
        String hujintao = frends.get(1).frend_name;
        String xijinping = frends.get(2).frend_name;

        tv1.setText(jiangzeming);
        tv2.setText(hujintao);
        tv3.setText(xijinping);
        ImageLoader.getInstance().displayImage(frends.get(0).frend_icon,iv1);
        ImageLoader.getInstance().displayImage(frends.get(1).frend_icon,iv2);
        ImageLoader.getInstance().displayImage(frends.get(2).frend_icon,iv3);
//        Log.i("crazyK", reason);
//        List<MyGson.ListContent> listContentList = myGson.listContentList;
//        MyGson.ListContent listContent1 = listContentList.get(0);
//        String jiangzemin = listContent1.frend_name;
//
//        tv1.setText(jiangzemin);
    }
}

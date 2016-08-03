package com.example.interfacedownload_gson_boss;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements DownLoadJson.OnGetJsonEndListener, AdapterView.OnItemClickListener {
    private MyAdapter myAdapter;
    private ListView lv;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.id_main_lv);
        tv = (TextView) findViewById(R.id.id_main_emptyview);
        lv.setOnItemClickListener(this);

        lv.setEmptyView(tv);

        //将listview绑定适配器写在onCreat方法中：这样在其他逻辑中就不会再次new Adapter，如果重新new Adapter会出现肉眼可见的整个listview的刷新
        myAdapter = new MyAdapter(this);
        lv.setAdapter(myAdapter);

        new DownLoadJson("http://172.18.4.3:8080/kaoshi/friends.txt","GBK",this).start();
    }

    @Override
    public void startUI(Person person) {
        List<Person.FrendsBean> frends = person.getFrends();
        myAdapter.setPerson(frends);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Person.FrendsBean friends = (Person.FrendsBean) parent.getItemAtPosition(position);
        AlertDialog.Builder bd = new AlertDialog.Builder(this);
        bd.setTitle(friends.getFrend_name())
                .setMessage("我是" + friends.getFrend_name())
                .setPositiveButton("确定",null)
                .create().show();
    }
}

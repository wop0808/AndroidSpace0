package com.example.boss_test_7_4;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends Activity implements AdapterView.OnItemClickListener {
    private ActionBar actionBar;
    private ListView listView;
    private Student_Adapter student_adapter;
    static final int menu_delete = 998;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionBar = getActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setIcon(android.R.drawable.ic_menu_add);
        actionBar.setTitle("添加");

        listView = (ListView) findViewById(R.id.id_main_lv);
        listView.setEmptyView(findViewById(R.id.id_main_emptyview));
        listView.setOnItemClickListener(this);
        student_adapter = new Student_Adapter(this);
        listView.setAdapter(student_adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem item = menu.add(Menu.NONE,menu_delete,0,"删除")
                .setIcon(android.R.drawable.ic_menu_delete);
        item.setShowAsActionFlags(MenuItem.SHOW_AS_ACTION_ALWAYS | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
        return super.onCreateOptionsMenu(menu);
//        return true;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this,StudentActivity.class);
        intent.putExtra("data",(Student)parent.getItemAtPosition(position));
        startActivity(intent);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            this.student_adapter.addStudent();
        }else if(item.getItemId() == menu_delete ){
            this.student_adapter.deleteStudent();
        }
        return super.onOptionsItemSelected(item);
    }
}

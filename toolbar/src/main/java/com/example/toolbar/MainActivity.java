package com.example.toolbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // setTitle();设置标题
        toolbar.setTitle("My Title");
        //setLogo()设置图标
        toolbar.setLogo(android.R.drawable.btn_star);
        // Sub Title
        toolbar.setSubtitle("Sub title");
        // Navigation Icon 要设定在 setSupoortActionBar 才有作用

        toolbar.setNavigationIcon(R.mipmap.back);
        setSupportActionBar(toolbar);
    }

    //为菜单添加事件
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int postion = item.getItemId();
        switch (postion){
            //为ToolBar的“返回箭头”添加事件
            case android.R.id.home:
                MainActivity.this.finish();
            case R.id.action_edit:
                Toast.makeText(MainActivity.this, "aaa", Toast.LENGTH_LONG).show();
                break;
            case R.id.action_settings:
                break;
        }
        return false;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}

package com.example.menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final static int MenuGroup_ID = 0;
    private final static int MenuItem_1 = 1;
    private final static int MenuItem_2 = 2;
    private final static int MenuItem_3 = 3;
    private final static int MenuItem_4 = 4;
    private final static int MenuItem_5 = 5;
    private final static int Sub_MenuItem_5_1 = 6;
    private final static int Sub_MenuItem_5_2 = 7;
    private final static int Sub_MenuItem_5_3 = 8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button show_btn = (Button) this.findViewById(R.id.show_btn);
        //给View对象注册上下文菜单registerForContextMenu()
        //"长按View对象"有效
        registerForContextMenu(show_btn);
    }

    //在Activity中重写onCreateContextMenu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        //add()参数说明:
        //第一个参数：菜单组的ID，如果ID相同，则这属于同一组菜单
        //第二个参数：菜单项的id。
        //第三个参数：菜单的排序。
        //第四个参数：菜单内容
        menu.add(MenuGroup_ID, MenuItem_1, Menu.NONE, "蓝牙发送");
        menu.add(MenuGroup_ID, MenuItem_2, Menu.NONE, "重命名");
        menu.add(MenuGroup_ID, MenuItem_3, Menu.NONE, "删除");
        menu.add(MenuGroup_ID, MenuItem_4, Menu.NONE, "Wifi");

        //SubMenu：子菜单
        //addSubMenu()：添加子菜单
        SubMenu subMenu = menu.addSubMenu(MenuGroup_ID, MenuItem_5, Menu.NONE, "重要程度>>");
        //添加子菜单项
        //第一参数：菜单组的ID
        //第二参数: 菜单的ID
        //第三参数：菜单的排序，数字越小，越靠前
        //第四个参数：菜单的内容
        subMenu.add(2, Sub_MenuItem_5_1, 1, "☆☆☆☆☆");
        subMenu.add(2, Sub_MenuItem_5_2, 2, "☆☆☆");
        subMenu.add(2, Sub_MenuItem_5_3, 3, "☆");
        //MenuInflater inflater = new MenuInflater(this);
    }

    //Menu菜单的监听
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case MenuItem_1:
                Toast.makeText(this, "蓝牙发送", Toast.LENGTH_LONG).show();
                break;
            case MenuItem_2:
                Toast.makeText(this, "重命名", Toast.LENGTH_LONG).show();
                break;
            case MenuItem_3:
                Toast.makeText(this, "删除", Toast.LENGTH_LONG).show();
                break;
            case MenuItem_4:
                Toast.makeText(this, "Wifi", Toast.LENGTH_LONG).show();
                break;
            case Sub_MenuItem_5_1:
                Toast.makeText(this, "子菜单1", Toast.LENGTH_LONG).show();
                break;
            case Sub_MenuItem_5_2:
                Toast.makeText(this, "子菜单2", Toast.LENGTH_LONG).show();
                break;
            case Sub_MenuItem_5_3:
                Toast.makeText(this, "子菜单3", Toast.LENGTH_LONG).show();
                break;
        }
        return super.onContextItemSelected(item);
    }

}

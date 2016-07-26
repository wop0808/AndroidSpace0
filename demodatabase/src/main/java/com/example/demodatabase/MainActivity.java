package com.example.demodatabase;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    /**
     * 操作数据库的推荐/正常/便以管理的方式
     */
    public void useDatabaseInPublicWay(){
        MyDataBaseOpenHelper dataBaseOpenHelper = new MyDataBaseOpenHelper(this);//建立一个数据库打开帮助类


        SQLiteDatabase writableDatabase = dataBaseOpenHelper.getWritableDatabase();//获取可写的数据库


        ContentValues values = new ContentValues();
        values.put("_id","1");
        values.put("age",23);
        values.put("name","Tim");//构造要插入的数据


        writableDatabase.insert("data2","name",values);//insert


        writableDatabase.close();//关闭数据库

        SQLiteDatabase readableDatabase = dataBaseOpenHelper.getReadableDatabase();//获取可读的数据库

        Cursor data2 = readableDatabase.query("data2", null, null, null, null, null, null);//获取整张表的内容

        int id = -1;
        int age = 0;
        String name = "";

        if(data2.moveToFirst()){
            do {
                id  =  data2.getInt(data2.getColumnIndex("_id"));
                age = data2.getInt(data2.getColumnIndex("age"));
                name = data2.getString(data2.getColumnIndex("name"));
            }while (data2.moveToNext());//循环读内容

        }

        data2.close();

        readableDatabase.close();


        Toast.makeText(this,"id="+id+",name = "+name+",age="+age,Toast.LENGTH_LONG).show();
    }


    /**
     * 数据库快捷获取，并操作器内容
     * <li>
     SQLiteDatabase sqLiteDatabase = SQLiteDatabase.openOrCreateDatabase(getFilesDir().getAbsolutePath()+"/demodata.db",null);</li>
     */
    public void useDatabaseInSimpleWay(){


//        Toast.makeText(this,getFilesDir().getAbsolutePath(),Toast.LENGTH_SHORT).show();
        SQLiteDatabase sqLiteDatabase = SQLiteDatabase.openOrCreateDatabase(getFilesDir().getAbsolutePath()+"/demodata.db",null);

//        sqLiteDatabase.execSQL("create table data(_id integer ,name varchar)");
//
//        ContentValues values = new ContentValues();
//        values.put("_id",0);
//        values.put("name","Jack");
//
//        sqLiteDatabase.insert("data", "name", values);


        //============================================================================

        int id=-1;
        String name = "";

        Cursor data = sqLiteDatabase.query("data", null, "_id = ? and name = ?", new String[]{"0", "Jack"}, null, null, null);

        if(data.moveToFirst()){//将cusor里面的游标移动到第一条数据的位置
            do {//此处应该使用数组或集合保存获取到的多条数据
                id = data.getInt(data.getColumnIndex("_id"));
                name = data.getString(data.getColumnIndex("name"));
            }while (data.moveToNext());//可能数据结果是多条，所以循环获取数据，当数据获取完成后，moveToNext会返回false，就自动跳出循环
        }

        data.close();

        sqLiteDatabase.close();

        Toast.makeText(this,"id="+id+",name="+name,Toast.LENGTH_LONG).show();

    }
}

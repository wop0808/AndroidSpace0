package com.example.demodatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2016/7/11.
 */
public class MyDataBaseOpenHelper extends SQLiteOpenHelper{
    public static int vesion = 1;
    public static String dbname = "data.db";

//    public MyDataBaseOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
//        super(context, name, factory, version);
//    }
    public MyDataBaseOpenHelper(Context context){
        super(context,dbname,null,vesion);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //Android中建立的任何表，至少都因该包含字段 _id
        db.execSQL("create table data2(_id integer  ,name varchar , age integer)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

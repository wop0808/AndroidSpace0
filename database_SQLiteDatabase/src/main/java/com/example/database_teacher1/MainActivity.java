package com.example.database_teacher1;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private final String DBNAME = "mydb.db";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView = (ListView) findViewById(R.id.id_main_lv);

        SQLiteDatabase sqLiteDatabase = SQLiteDatabase.openOrCreateDatabase(getFilesDir() + DBNAME, null);
        sqLiteDatabase.execSQL("drop table myTable");
        sqLiteDatabase.execSQL("create table myTable (_id Integer primary key autoincrement , name String)");

        ContentValues valus = new ContentValues();

        valus.put("_id", 0);
        valus.put("name", "小明");
        sqLiteDatabase.insert("myTable", "nullColumn", valus);

        valus.put("_id", 1);
        valus.put("name", "小李");
        sqLiteDatabase.insert("myTable", "nullColumn", valus);

        valus.put("_id", 2);
        valus.put("name", "小红");
        sqLiteDatabase.insert("myTable", "nullColumn", valus);

        Cursor cursor = sqLiteDatabase.query(false, "myTable", null, null, null, null, null, null, null);
        Toast.makeText(this,cursor.getCount()+"",Toast.LENGTH_SHORT).show();
        int[] ids = new int[cursor.getCount()];
        String[] names = new String[cursor.getCount()];
        int i = 0;
        int x = 0;
        if (cursor.moveToFirst()) {
            do {
                ids[i++] = cursor.getInt(cursor.getColumnIndex("_id"));
                names[x++] = cursor.getString(cursor.getColumnIndex("name"));
            } while (cursor.moveToNext());
        }


        new AlertDialog.Builder(this).setMessage(Arrays.toString(ids)+"-------"+Arrays.toString(names)).setPositiveButton("OK", null).show();
        if(sqLiteDatabase.isOpen()){
            sqLiteDatabase.close();
        }
    }

}

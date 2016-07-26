package com.example.databasedemo_studentmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2016/7/12.
 */
public class DataManager {
    private DBOpenhelper dbh;

    public DataManager(Context context) {
        dbh = new DBOpenhelper(context);
    }

    public long put(Student student) {
        SQLiteDatabase writableDatabase = dbh.getWritableDatabase();
        long l = -1L;
        if (writableDatabase.isOpen()) {
            ContentValues values = new ContentValues();
            values.put("name", student.getName());
            values.put("number", student.getNumber());
            l = writableDatabase.insert(DBOpenhelper.TABLE_STUDENT, "name", values);
            writableDatabase.close();
        }
        return l;
    }



    public Student get(int number) {
        SQLiteDatabase readableDatabase = dbh.getReadableDatabase();
        Student student = null;
        if (readableDatabase.isOpen()) {
//            Cursor result = readableDatabase.query(DBOpenhelper.TABLE_STUDENT, null, "number = ?", new String[]{number + ""}, null, null, null, null);
            Cursor result = readableDatabase.rawQuery("select * from " + DBOpenhelper.TABLE_STUDENT + " where number = ?", new String[]{number + ""});
            if (result.moveToFirst()) {
                String name = result.getString(result.getColumnIndex("name"));
                int numberr = result.getInt(result.getColumnIndex("number"));
                student = new Student(name, numberr);
            }
            readableDatabase.close();
        }
        return student;
    }


    class DBOpenhelper extends SQLiteOpenHelper {
        public static final String TABLE_STUDENT = "student";

        public DBOpenhelper(Context context) {
            super(context, "studentdata.db", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table " + TABLE_STUDENT + "(_id integer primary key autoincrement,name varchar,number integer)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }


}

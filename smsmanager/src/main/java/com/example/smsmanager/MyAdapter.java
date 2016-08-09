package com.example.smsmanager;

import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/8/9.
 */
public class MyAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<String> numberList = new ArrayList<>();
    private Cursor cursor;
    private ArrayList<String> sendList;

    public MyAdapter(Context context ,ArrayList<String> sendList){
        this.sendList = sendList;
        this.context = context;
        cursor = context.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null);
        if(cursor != null){
            if(cursor.moveToFirst()){
                do{
                    String number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                    numberList.add(number);
                }while (cursor.moveToNext());
            }
        }

    }

    public void addData(String number){
        numberList.add(number);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return numberList.size();
    }

    @Override
    public Object getItem(int i) {
        return numberList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        CheckBox checkBox = new CheckBox(context);
        checkBox.setText(numberList.get(i));
        if(isChecked(numberList.get(i))){
            checkBox.setChecked(true);
        }
        return checkBox;
    }

    public boolean isChecked(String phonenumber){
        for(String i : sendList){
            if(i.equals(phonenumber)){
                return true;
            }
        }
        return false;
    }
}

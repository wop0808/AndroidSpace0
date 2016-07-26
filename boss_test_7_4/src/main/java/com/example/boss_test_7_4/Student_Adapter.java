package com.example.boss_test_7_4;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Administrator on 2016/7/4.
 */
public class Student_Adapter extends BaseAdapter {
    private Context context;
    private ArrayList<Student> list_student ;


    public Student_Adapter(Context context) {
        this.context = context;
        list_student = new ArrayList<>();
    }

    public void addStudent(){
        Student student = new Student();
        student.setName("学生"+(this.getCount()+1));
        student.setDetail("这是学生"+(this.getCount()+1)+"的详细信息");
        student.setTime(System.currentTimeMillis());
        list_student.add(student);
        this.notifyDataSetChanged();
    }

    public void deleteStudent(){
        list_student.remove(this.getCount()-1);
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list_student.size();
    }

    @Override
    public Object getItem(int position) {
        return list_student.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            convertView = convertView.inflate(context,R.layout.list_item_student,null);
            viewHolder = new ViewHolder();
            viewHolder.tv_Name = (TextView) convertView.findViewById(R.id.id_listitem_name);
            viewHolder.tv_Detail = (TextView) convertView.findViewById(R.id.id_listitem_detail);
            viewHolder.tv_Time = (TextView) convertView.findViewById(R.id.id_listitem_time);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Student student = (Student) getItem(position);
        viewHolder.tv_Name.setText(student.getName());
        viewHolder.tv_Detail.setText(student.getDetail());
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        viewHolder.tv_Time.setText("" + year + "-" + month + "-" + day);
        return convertView;
    }

    class ViewHolder{
        TextView tv_Name,tv_Detail,tv_Time;
    }
}

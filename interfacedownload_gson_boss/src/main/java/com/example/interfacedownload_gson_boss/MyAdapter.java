package com.example.interfacedownload_gson_boss;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/2.
 */
public class MyAdapter extends BaseAdapter{
    private ArrayList<Person.FrendsBean> persons = new ArrayList<>();
    private Context context;

    public MyAdapter(Context context){
        this.context = context;
    }

    public void addPerson(Person.FrendsBean person){
        persons.add(person);
        notifyDataSetChanged();
    }

    public void deletePerson(int position){
        persons.remove(position);
        notifyDataSetChanged();
    }

    public void changePerson(int position,Person.FrendsBean person){
        persons.remove(position);
        persons.add(position,person);
        notifyDataSetChanged();
    }

    public void clearPerson(){
        persons.clear();
        notifyDataSetChanged();
    }

    public void setPerson(List<Person.FrendsBean> frends){
        persons.clear();
        persons.addAll(frends);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return persons.size();
    }

    @Override
    public Object getItem(int i) {
        return persons.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if(view == null){
            view = View.inflate(context,R.layout.list_item,null);
            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView) view.findViewById(R.id.id_listitem_iv);
            viewHolder.textView = (TextView) view.findViewById(R.id.id_listitem_tv);
            view.setTag(viewHolder);
        }
        viewHolder = (ViewHolder) view.getTag();
        viewHolder.textView.setText(persons.get(i).getFrend_name());
        new DownLoadImage(viewHolder.imageView).execute(persons.get(i).getFrend_icon());
        return view;
    }

    private class ViewHolder{
        ImageView imageView;
        TextView textView;
    }
}

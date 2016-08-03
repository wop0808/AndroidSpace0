package com.example.interdownload_gson;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2016/8/2.
 */
public class MyAdapter extends BaseAdapter {
    private List<Friends.FrendsBean> listfrends;
    private Context context;

    public MyAdapter(List<Friends.FrendsBean> listfrends, Context context) {
        this.listfrends = listfrends;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listfrends.size();
    }

    @Override
    public Object getItem(int position) {
        return listfrends.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.list_item, null);
            viewHolder = new ViewHolder();
            viewHolder.textView = (TextView) convertView.findViewById(R.id.id_listitem_tv);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.id_listitem_iv);
            convertView.setTag(viewHolder);
        }
        viewHolder = (ViewHolder) convertView.getTag();
//        viewHolder.imageView.setImageBitmap();
        //设置图片
        new DownLoadImage(viewHolder.imageView).execute(listfrends.get(position).frend_icon);
        viewHolder.textView.setText(listfrends.get(position).frend_name);
        return convertView;
    }

    private class ViewHolder {
        ImageView imageView;
        TextView textView;
    }
}

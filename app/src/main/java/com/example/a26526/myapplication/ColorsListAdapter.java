package com.example.a26526.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by 26526 on 2017/12/30.
 */

public class ColorsListAdapter extends BaseAdapter {

    private int checkItem;
    Context context;
    List<Integer> list;

    public ColorsListAdapter(Context context, List<Integer> list) {
        this.context = context;
        this.list = list;
    }



    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.colors_image_layout, null);
            holder = new Holder();
            holder.imageView1 = (ImageView) convertView.findViewById(R.id.img_1);
            holder.imageView2 = (ImageView) convertView.findViewById(R.id.img_2);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        holder.imageView1.setImageResource(list.get(position));
        if (checkItem == position) {
            holder.imageView2.setImageResource(R.drawable.ic_done_white);
        }
        return convertView;
    }
    public void setCheckItem(int checkItem) {
        this.checkItem = checkItem;
    }
    static class Holder {
        ImageView imageView1;
        ImageView imageView2;
    }
}
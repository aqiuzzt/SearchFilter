package com.demo.SearchFilter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.demo.SearchFilter.R;
import com.demo.SearchFilter.model.FiterBean;

import java.util.ArrayList;


public class FiterAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<FiterBean> list;
    private LayoutInflater layoutInflater;

    public FiterAdapter(Context contexts, ArrayList<FiterBean> lists) {
        this.context = contexts;
        this.list = lists;
        this.layoutInflater = LayoutInflater.from(context);
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
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.one_fiter_fragment_item, null);
            holder.tvFilterName = (TextView) convertView.findViewById(R.id.tvFilterName);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tvFilterName.setText(list.get(position).getFiterName());
        return convertView;
    }


    class ViewHolder {
        private TextView tvFilterName;
    }
}

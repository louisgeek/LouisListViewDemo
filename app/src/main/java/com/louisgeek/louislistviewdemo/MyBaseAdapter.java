package com.louisgeek.louislistviewdemo;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.List;

/**
 * Created by louisgeek on 2016/5/15.
 */
public class MyBaseAdapter extends BaseAdapter {
    public MyBaseAdapter(List<HasCheckedStateBean> hasCheckedStateBeanList, Context context) {
        this.hasCheckedStateBeanList = hasCheckedStateBeanList;
        this.context = context;
    }

    private List<HasCheckedStateBean> hasCheckedStateBeanList;
private Context context;
    @Override
    public int getCount() {
        return hasCheckedStateBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        return hasCheckedStateBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        if (convertView==null){
            viewHolder=new ViewHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.content_item,null);
            viewHolder.id_tv= (TextView) convertView.findViewById(R.id.id_tv);
            viewHolder.id_cb=(CheckBox) convertView.findViewById(R.id.id_cb);
            convertView.setTag(viewHolder);
        }else
        {
            viewHolder= (ViewHolder) convertView.getTag();
        }

        viewHolder.id_tv.setText(hasCheckedStateBeanList.get(position).getTxt());

        //一定需要加在【设置选择状态代码段】之前  解决滑动错位
        viewHolder.id_cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    hasCheckedStateBeanList.get(position).setCheckedbox_isChecked(isChecked);
            }
        });
        //【设置选择状态代码段】
       boolean isCheckedbox_isChecked=hasCheckedStateBeanList.get(position).isCheckedbox_isChecked();
        viewHolder.id_cb.setChecked(isCheckedbox_isChecked);
        return convertView;
    }

    class ViewHolder{
        TextView id_tv;
        CheckBox id_cb;
    }
}

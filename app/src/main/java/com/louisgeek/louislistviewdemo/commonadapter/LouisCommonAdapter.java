package com.louisgeek.louislistviewdemo.commonadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * 抽象类
 * Created by louisgeek on 2016/5/17.
 */
public abstract class LouisCommonAdapter<T> extends BaseAdapter {

    protected static final String TAG = "LouisCommonAdapter";
    protected LayoutInflater layoutInflater;
    protected Context context;
    protected List<T> dataList;
    protected int mItemLayoutId;

    public LouisCommonAdapter(Context context, List<T> dataList, int mItemLayoutId) {
        this.context = context;
        this.dataList = dataList;
        this.mItemLayoutId = mItemLayoutId;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LouisCommonViewHolder myCommonViewHolder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(mItemLayoutId, parent, false);
            myCommonViewHolder = new LouisCommonViewHolder(convertView);
            convertView.setTag(myCommonViewHolder);
        } else {
            myCommonViewHolder = (LouisCommonViewHolder) convertView.getTag();
        }
        getViewInner(position, myCommonViewHolder);

        return convertView;
      /*  //实例化一个viewHolder
        CommonViewHolder commonViewHolder = CommonViewHolder.getViewHolder(convertView,context,parent,
                R.layout.news_item, position);
        //通过getView获取控件
        TextView tv = commonViewHolder.getView(R.id.id_tv_title);
        //使用
        tv.setText(stringList.get(position));
        return commonViewHolder.getmConvertView();*/
    }

    public abstract void getViewInner(int position, LouisCommonViewHolder myCommonViewHolder);

 /*  private void getViewInner(int position, LouisCommonViewHolder myCommonViewHolder) {
        //通过getView获取控件
        TextView tv = myCommonViewHolder.getView(R.id.id_tv_title);
        //使用
        tv.setText((String)dataList.get(position));
    }*/


}

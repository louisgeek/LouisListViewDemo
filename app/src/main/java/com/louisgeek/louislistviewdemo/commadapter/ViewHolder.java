package com.louisgeek.louislistviewdemo.commadapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

/**
 * Created by louisgeek on 2016/5/16.
 */
public   class ViewHolder  {
    private SparseArray<View> mitemViews = new SparseArray<>();   //存储ListView 的 item中的View
    private View itemView;                  //存放convertView
    private Context context;            //Context上下文

    private int position;               //

    public ViewHolder(Context context,int layoutRes) {
        this.context = context;

        View view = LayoutInflater.from(context).inflate(layoutRes, null);
        view.setTag(this);//
        this.itemView = view;
    }


    TextView txt_title;
    TextView txt_content;


}

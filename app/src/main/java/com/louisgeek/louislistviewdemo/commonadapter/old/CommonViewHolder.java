/*
package com.louisgeek.louislistviewdemo.commonadapter.old;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

*/
/**
 * Created by louisgeek on 2016/5/17.
 *//*

public class CommonViewHolder {

    private SparseArray<View> mViewSparseArray;
    private View mConvertView;


    public CommonViewHolder(Context context, ViewGroup parent, int layoutId, int position) {
        this.mConvertView =  LayoutInflater.from(context).inflate(layoutId, parent,
                false);
        mViewSparseArray = new SparseArray<>();

        this.mConvertView.setTag(this);
    }

    public static CommonViewHolder getViewHolder(View convertView, Context context, ViewGroup parent, int layoutId, int position) {
        if (convertView == null) {
            return new CommonViewHolder(context, parent, layoutId, position);
        }
        return (CommonViewHolder) convertView.getTag();
    }
    public <T extends View> T getView(int viewId){

        View view=mViewSparseArray.get(viewId);
        if (view==null){
            view=mConvertView.findViewById(viewId);
            mViewSparseArray.put(viewId,view);
        }
        return (T) view;

    }

    public View getmConvertView() {
        return mConvertView;
    }
}
*/

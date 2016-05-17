package com.louisgeek.louislistviewdemo.commonadapter;

import android.util.SparseArray;
import android.view.View;

/**
 * Created by louisgeek on 2016/5/17.
 */
public class LouisCommonViewHolder {

    private SparseArray<View> mViewSparseArray = new SparseArray<>();
    private View mConvertView;


    public LouisCommonViewHolder(View mConvertView) {
        this.mConvertView = mConvertView;
    }

    public <T extends View> T getView(int viewId) {

        View view = mViewSparseArray.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViewSparseArray.put(viewId, view);
        }
        return (T) view;

    }
}

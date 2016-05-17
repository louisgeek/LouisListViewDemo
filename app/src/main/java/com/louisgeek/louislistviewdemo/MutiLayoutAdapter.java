package com.louisgeek.louislistviewdemo;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.louisgeek.louislistviewdemo.commadapter.NewsBean;

import java.util.List;

/**
 * Created by louisgeek on 2016/5/17.
 */
public class MutiLayoutAdapter extends BaseAdapter {

    private List<NewsBean> newsBeanList;
    private Context context;

    public MutiLayoutAdapter(List<NewsBean> newsBeanList, Context context) {
        this.newsBeanList = newsBeanList;
        this.context = context;
    }

    //定义类别标志
    private static final int TYPE_A = 0;
    private static final int TYPE_B = 1;
    private static final int TYPE_C = 2;

    private int[] types = new int[]{TYPE_A, TYPE_B, TYPE_C};

    @Override
    public int getCount() {
        return newsBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        return newsBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        int viewType = getItemViewType(position);
        ViewHolderA viewHolderA = null;
        ViewHolderB viewHolderB = null;
        ViewHolderC viewHolderC = null;

        if (convertView == null) {
            switch (viewType) {
                case TYPE_A:
                    viewHolderA = new ViewHolderA();
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_a, parent, false);
                    viewHolderA.textView = (TextView) convertView.findViewById(R.id.id_tv_a);
                    convertView.setTag(R.id.tag_A, viewHolderA);
                    break;
                case TYPE_B:
                    viewHolderB = new ViewHolderB();
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_b, parent, false);
                    viewHolderB.imageView = (ImageView) convertView.findViewById(R.id.id_iv_b);
                    convertView.setTag(R.id.tag_B, viewHolderB);
                    break;
                case TYPE_C:
                    viewHolderC = new ViewHolderC();
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_c, parent, false);
                    viewHolderC.editText = (EditText) convertView.findViewById(R.id.id_et_c);
                    convertView.setTag(R.id.tag_C, viewHolderC);
                    break;
            }
        } else {
            switch (viewType) {
                case TYPE_A:
                    viewHolderA = (ViewHolderA) convertView.getTag(R.id.tag_A);
                    break;
                case TYPE_B:
                    viewHolderB = (ViewHolderB) convertView.getTag(R.id.tag_B);
                    break;
                case TYPE_C:
                    viewHolderC = (ViewHolderC) convertView.getTag(R.id.tag_C);
                    break;
            }
        }

        NewsBean newsBean = newsBeanList.get(position);
        //设置下控件的值
        switch (viewType) {
            case TYPE_A:
                if (newsBean != null) {
                    viewHolderA.textView.setText(newsBean.getNewsTitle());
                }
                break;
            case TYPE_B:
                if (newsBean != null) {
                    viewHolderB.imageView.setImageDrawable(ContextCompat.getDrawable(context, R.mipmap.ic_launcher));
                }
                break;
            case TYPE_C:
                if (newsBean != null) {
                    viewHolderC.editText.setText(newsBean.getNewsTitle());
                }
                break;
        }


        return convertView;
    }


    class ViewHolderA {
        TextView textView;
    }

    class ViewHolderB {
        ImageView imageView;
    }

    class ViewHolderC {
        EditText editText;
    }

    @Override
    public int getItemViewType(int position) {
        // return super.getItemViewType(position);
        int layoutType = newsBeanList.get(position).getLayoutType();
        if (layoutType > 0) {
            return layoutType;
        } else {
            return super.getItemViewType(position);
        }
    }

    @Override
    public int getViewTypeCount() {
        // return super.getViewTypeCount();
        return types.length;
    }
}

package com.louisgeek.louislistviewdemo.commadapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


/**
 * Created by louisgeek on 2016/5/16.
 */
public abstract class MyCommBaseAdapter<T> extends BaseAdapter{


    private List<T> listData;

    private int mLayoutRes;           //布局id

    public MyCommBaseAdapter(List<T> listData,int mLayoutRes) {
        this.listData = listData;
        this.mLayoutRes = mLayoutRes;
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public T getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = ViewHolder.bind(parent.getContext(), convertView, parent, mLayoutRes
                , position);
        bindView(holder,getItem(position));
        return holder.getItemView();
    }
    public abstract void bindView(ViewHolder holder, T t);

    public static  class ViewHolder{
       private SparseArray<View> mitemViews = new SparseArray<>();   //存储ListView 的 item中的View
       private View itemView;                  //存放convertView
       private Context context;            //Context上下文

       private int position;               //

       public ViewHolder(Context context,ViewGroup parent,int layoutRes) {
           this.context = context;

           View view = LayoutInflater.from(context).inflate(layoutRes, null);
           view.setTag(this);//
           this.itemView = view;
       }

       TextView textView_title;
       TextView textView_content;

        //绑定ViewHolder与item
        public static  ViewHolder bind(Context context, View convertView, ViewGroup parent,
                                int layoutRes, int position) {
            ViewHolder holder=null;
            if(convertView == null) {
                holder = new ViewHolder(context,parent,layoutRes);
            } else {
                holder = (ViewHolder) convertView.getTag();
                holder.itemView = convertView;
            }
            holder.position = position;
            return holder;
        }

        public <T extends View> T getView(int id) {
            T t = (T) mitemViews.get(id);
            if(t == null) {
                t = (T) itemView.findViewById(id);
                mitemViews.put(id, t);
            }
            return t;
        }

        /**
         * 获取当前条目
         */
        public View getItemView() {
            return itemView;
        }

        /**
         * 获取条目位置
         */
        public int getItemPosition() {
            return position;
        }

        /**
         * 设置文字
         */
        public ViewHolder setText(int id, CharSequence text) {
            View view = getView(id);
            if(view instanceof TextView) {
                ((TextView) view).setText(text);
            }
            return this;
        }

        /**
         * 设置图片
         */
        public ViewHolder setImageResource(int id, int drawableRes) {
            View view = getView(id);
            if(view instanceof ImageView) {
                ((ImageView) view).setImageResource(drawableRes);
            } else {
                view.setBackgroundResource(drawableRes);
            }
            return this;
        }


        /**
         * 设置点击监听
         */
        public ViewHolder setOnClickListener(int id, View.OnClickListener listener) {
            getView(id).setOnClickListener(listener);
            return this;
        }

        /**
         * 设置可见
         */
        public ViewHolder setVisibility(int id, int visible) {
            getView(id).setVisibility(visible);
            return this;
        }

        /**
         * 设置标签
         */
        public ViewHolder setTag(int id, Object obj) {
            getView(id).setTag(obj);
            return this;
        }

        //其他方法可自行扩展


        //

   }


    //
    public void add(T t) {
        listData.add(t);
        this.notifyDataSetChanged();
    }

    //
    public void remove(int position) {
        listData.remove(position);
        this.notifyDataSetChanged();
    }


}

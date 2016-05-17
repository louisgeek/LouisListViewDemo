package com.louisgeek.louislistviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import com.louisgeek.louislistviewdemo.commadapter.GoodsBean;
import com.louisgeek.louislistviewdemo.commadapter.NewsBean;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<HasCheckedStateBean> hasCheckedStateBeanList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView idlv2 = (ListView) findViewById(R.id.id_lv_2);
        TextView idemptytv = (TextView) findViewById(R.id.id_empty_tv);
        ListView idlv = (ListView) findViewById(R.id.id_lv);


        hasCheckedStateBeanList=new ArrayList<>();
        for (int i = 0; i <0 ; i++) {
            HasCheckedStateBean hasCheckedStateBean=new HasCheckedStateBean();
            if (i%2==0) {
                hasCheckedStateBean.setCheckedbox_isChecked(true);
            }else
            {
                hasCheckedStateBean.setCheckedbox_isChecked(false);
            }
            hasCheckedStateBean.setSid("sid");
            hasCheckedStateBean.setTxt("内容" + i);
            hasCheckedStateBean.setImg("img url");
            hasCheckedStateBeanList.add(hasCheckedStateBean);
        }


     /*   MyBaseAdapter myBaseAdapter=new MyBaseAdapter(hasCheckedStateBeanList,this);
        idlv.setAdapter(myBaseAdapter);

        View content_empty= LayoutInflater.from(this).inflate(R.layout.content_empty, null);
        ((ViewGroup)idlv.getParent()).addView(content_empty);//依托listview  要居中是不是得让listview居中？

        idlv.setEmptyView(content_empty);*/


//功能2

        List<NewsBean> newsBeanList=new ArrayList<>();
        for (int i = 0; i <6; i++) {
            NewsBean newsBean=new NewsBean();
            newsBean.setNewsTitle("title_" + i);
            newsBean.setNewsContent("content_" + i);
            newsBean.setLayoutType(i%3);
            newsBeanList.add(newsBean);
        }
        final List<GoodsBean> goodsBeanList=new ArrayList<>();
        for (int i = 0; i <3; i++) {
            GoodsBean goodsBean=new GoodsBean();
            goodsBean.setGoodsTitle("goodstitle_" + i);
            goodsBean.setGoodsImgResId(R.mipmap.ic_launcher);
            goodsBeanList.add(goodsBean);
        }
       /* MyCommBaseAdapter myCommBaseAdapter=new MyCommBaseAdapter<NewsBean>(newsBeanList,R.layout.news_item) {
            @Override
            public void bindView(ViewHolder holder, NewsBean newsBean) {
                holder.setText(R.id.id_tv_title,newsBean.getNewsTitle());
                holder.setText(R.id.id_tv_content,newsBean.getNewsContent());
            }
        };
        idlv.setAdapter(myCommBaseAdapter);
        MyCommBaseAdapter myCommBaseAdapter2=new MyCommBaseAdapter<GoodsBean>(goodsBeanList,R.layout.goods_item){

            @Override
            public void bindView(ViewHolder holder, GoodsBean goodsBean) {
                holder.setImageResource(R.id.id_img,goodsBean.getGoodsImgResId());
                holder.setText(R.id.id_tv_goods_title,goodsBean.getGoodsTitle());
            }
        };
        idlv2.setAdapter(myCommBaseAdapter2);*/

       /* List<String> stringList=new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            stringList.add("文本SS"+i);
        }
        LouisCommonAdapter commonAdapter=new LouisCommonAdapter(this,stringList,R.layout.news_item) {
            @Override
            public void getViewInner(int position, LouisCommonViewHolder myCommonViewHolder) {
                //通过getView获取控件
                TextView tv = myCommonViewHolder.getView(R.id.id_tv_title);
                //使用
                tv.setText(dataList.get(position).toString());
            }
        };

        idlv.setAdapter(commonAdapter);

        LouisCommonAdapter commonAdapter2=new LouisCommonAdapter(this,goodsBeanList,R.layout.goods_item) {
            @Override
            public void getViewInner(int position, LouisCommonViewHolder myCommonViewHolder) {
                //通过getView获取控件
                TextView tv = myCommonViewHolder.getView(R.id.id_tv_goods_title);
                //使用
                tv.setText(goodsBeanList.get(position).getGoodsTitle());
                //通过getView获取控件
                ImageView iv = myCommonViewHolder.getView(R.id.id_img);
                //使用
                iv.setImageDrawable(ContextCompat.getDrawable(context,R.mipmap.ic_launcher));
            }
        };


        idlv2.setAdapter(commonAdapter2);*/

        MutiLayoutAdapter mutiLayoutAdapter=new MutiLayoutAdapter(newsBeanList,this);
        idlv.setAdapter(mutiLayoutAdapter);
    }
}

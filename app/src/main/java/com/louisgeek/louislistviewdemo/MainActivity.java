package com.louisgeek.louislistviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import com.louisgeek.louislistviewdemo.commadapter.MyCommBaseAdapter;
import com.louisgeek.louislistviewdemo.commadapter.NewsBean;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<HasCheckedStateBean> hasCheckedStateBeanList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        for (int i = 0; i <20; i++) {
            NewsBean newsBean=new NewsBean();
            newsBean.setNewsTitle("title_"+i);
            newsBean.setNewsContent("content_"+i);
            newsBeanList.add(newsBean);
        }
        MyCommBaseAdapter myCommBaseAdapter=new MyCommBaseAdapter(newsBeanList,this);
        idlv.setAdapter(myCommBaseAdapter);

    }
}

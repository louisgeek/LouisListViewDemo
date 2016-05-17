package com.louisgeek.louislistviewdemo.commadapter;

/**
 * Created by louisgeek on 2016/5/16.
 */
public class NewsBean {
    private int newsid;

    public int getNewsid() {
        return newsid;
    }

    public void setNewsid(int newsid) {
        this.newsid = newsid;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    private  String newsTitle;
    private  String newsContent;

    public int getLayoutType() {
        return layoutType;
    }

    public void setLayoutType(int layoutType) {
        this.layoutType = layoutType;
    }

    private int layoutType;
}

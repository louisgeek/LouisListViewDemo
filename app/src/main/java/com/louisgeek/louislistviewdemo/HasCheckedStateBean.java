package com.louisgeek.louislistviewdemo;

/**
 * Created by louisgeek on 2016/5/15.
 */
public class HasCheckedStateBean {
    private  String sid;
    private  String txt;
    private  String img;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public String getImg() {
        return img;
    }

    public boolean isCheckedbox_isChecked() {
        return checkedbox_isChecked;
    }

    public void setCheckedbox_isChecked(boolean checkedbox_isChecked) {
        this.checkedbox_isChecked = checkedbox_isChecked;
    }

    public void setImg(String img) {
        this.img = img;
    }



    private  boolean checkedbox_isChecked;
}

package edu.hzuapps.androidlabs.homeworks.net1414080903220.knowdev.bean;

import java.io.Serializable;
import java.util.List;

/**
 * ProjectName: knowdev
 * PackName：edu.hzuapps.androidlabs.homeworks.net1414080903220.knowdev.bean
 * Class describe:
 * Author: cheng
 * Create time: 2017/5/6 15:31
 */
public class NewsBaseBean implements Serializable {
    private int code;
    private String msg;
    private List<News> newslist;
    public void setCode(int code) {
        this.code = code;
    }
    public int getCode() {
        return code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    public String getMsg() {
        return msg;
    }

    public void setNewslist(List<News> newslist) {
        this.newslist = newslist;
    }
    public List<News> getNewslist() {
        return newslist;
    }
}

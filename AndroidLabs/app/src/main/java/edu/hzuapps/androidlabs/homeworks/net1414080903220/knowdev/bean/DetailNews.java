package edu.hzuapps.androidlabs.homeworks.net1414080903220.knowdev.bean;

import java.io.Serializable;
import java.util.List;

/**
 * ProjectName: knowdev
 * PackName：edu.hzuapps.androidlabs.homeworks.net1414080903220.knowdev.bean
 * Class describe:
 * Author: cheng
 * Create time: 2017/5/3 14:57
 */


/**
 * @Variable: type 新闻的类型
 * @Variable: newsList 返回的新闻集合
 */
public class DetailNews implements Serializable {

    String type;
    List<News>newsList;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;

    }

    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }


}

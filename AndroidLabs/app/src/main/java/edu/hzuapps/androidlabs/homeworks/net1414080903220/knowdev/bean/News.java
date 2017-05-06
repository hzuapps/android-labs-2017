package edu.hzuapps.androidlabs.homeworks.net1414080903220.knowdev.bean;

import java.io.Serializable;

/**
 * ProjectName: knowdev
 * PackName：edu.hzuapps.androidlabs.homeworks.net1414080903220.knowdev.bean
 * Class describe:
 * Author: cheng
 * Create time: 2017/5/3 14:43
 */


/**
 * @Variable: ctime 新闻发布时间
 * @Variable: title 新闻标题
 * @Variable: description 新闻来源
 * @Variable: picUrl 新闻图片地址
 * @Variable: url 新闻源地址
 */
public class News implements Serializable{

    String ctime;
    String title;
    String description;
    String picUrl;
    String url;

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}

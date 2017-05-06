package edu.hzuapps.androidlabs.homeworks.net1414080903220.knowdev.bean;

import java.io.Serializable;
import java.util.List;


/**
 * ProjectName: knowdev
 * PackName：edu.hzuapps.androidlabs.homeworks.net1414080903220.knowdev.bean
 * Class describe:
 * Author: cheng
 * Create time: 2017/5/5 13:11
 */

/**
 * _id:文章编号
 * createdAt：创建时间
 * desc：描述
 * images：图片
 * publishedAt：发布时间
 * source：来源
 * type：类型
 * url：地址
 * who：作者
 */
public class DevArticle implements Serializable {
    String _id;
    String createdAt;
    String desc;
    List<String> images;
    String publishedAt;
    String source;
    String type;
    String url;
    String used;
    String who;

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsed() {
        return used;
    }

    public void setUsed(String used) {
        this.used = used;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }



}

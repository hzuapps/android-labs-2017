package edu.hzuapps.androidlabs.homeworks.net1414080903220.knowdev.utils;

import org.litepal.crud.DataSupport;

import java.util.List;

import edu.hzuapps.androidlabs.homeworks.net1414080903220.knowdev.bean.DevArticle;


/**
 * ProjectName: knowdev
 * PackName：edu.hzuapps.androidlabs.homeworks.net1414080903220.knowdev.utils
 * Class describe:对开发类文章数据库进行操作
 * Author: cheng
 * Create time: 2017/6/1 22:16
 */
public class DevItemDao {

    public void addData(List<DevArticle> devArticleList){

        for (DevArticle devs:devArticleList){
            devs.save();
        }
    }

    public void clearAllData(){
        DataSupport.deleteAll(DevArticle.class);
    }

    public void updateData(){

    }

    public List<DevArticle>  getAllData() {
        List<DevArticle>devArticleList=  DataSupport.findAll(DevArticle.class);
        return devArticleList;

    }
}

package edu.hzuapps.androidlabs.homeworks.net1414080903220.knowdev.utils;

import org.litepal.crud.DataSupport;

import java.util.List;

import edu.hzuapps.androidlabs.homeworks.net1414080903220.knowdev.bean.News;

/**
 * ProjectName: knowdev
 * PackName：edu.hzuapps.androidlabs.homeworks.net1414080903220.knowdev.utils
 * Class describe:对新闻数据库进行操作
 * Author: cheng
 * Create time: 2017/6/1 22:12
 */
public class NewsDao extends LitePalHelper {


    public void addData(List<News> newsList){

        for (News news:newsList){
            news.save();
        }
    }

    public void clearAllData(){
        DataSupport.deleteAll(News.class);
    }

    public void updateData(){

    }

    public List<News>  getAllData() {
        List<News>newsList=  DataSupport.findAll(News.class);
        return newsList;

    }



}

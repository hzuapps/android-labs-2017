package edu.hzuapps.androidlabs.homeworks.net1414080903121;

import android.support.annotation.Nullable;
import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 作者：zgw on 2017/6/21 12:51
 * 邮箱：zhanmu123@163.com
 */

public class Net1414080903121NewsInfoService {
    //解析副驱蚊器返回的XML信息，获取所有任务数据实体
    public static List<NewsInfo> getNewsInfos(InputStream is){
        //获取XMLPullParser对象
        XmlPullParser parser = Xml.newPullParser();
        try {
            parser.setInput(is,"utf-8");
            //获取指针
            int type = parser.getEventType();
            List<NewsInfo> newsInfos = null;
            NewsInfo newsInfo = null;
            //type不是文档借宿
            while(type!=XmlPullParser.END_DOCUMENT){
                switch (type){
                    case XmlPullParser.START_TAG:
                        //拿到标签名并判断
                        if ("news".equals(parser.getName())){
                            newsInfos=new ArrayList<NewsInfo>();
                        }else if ("newsInfo".equals(parser.getName())){
                            newsInfo=new NewsInfo();
                        }else if ("icon".equals(parser.getName())){
                            //获取解析器当前指向元素的下一个文本节点的值
                            String icon = parser.nextText();
                            newsInfo.setIconPath(icon);
                        }else if ("title".equals(parser.getName())){
                            String title = parser.nextText();
                            newsInfo.setTitle(title);
                        }else if ("content".equals(parser.getName())){
                            String des = parser.nextText();
                            newsInfo.setDes(des);
                        }else if ("type".equals(parser.getName())){
                            String tasktype = parser.nextText();
                            newsInfo.setType(Integer.parseInt(tasktype));
                        }else if ("salary".equals(parser.getName())){
                            String salary =parser.nextText();
                            newsInfo.setSalary(Long.parseLong(salary));
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        if ("newsInfo".equals(parser.getName())){
                            newsInfos.add(newsInfo);
                            newsInfo=null;
                        }
                        break;
                }
                type=parser.next();
            }
            return newsInfos;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}

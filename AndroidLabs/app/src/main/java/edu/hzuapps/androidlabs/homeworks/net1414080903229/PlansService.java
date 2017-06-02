package edu.hzuapps.androidlabs.homeworks.net1414080903229;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;

import java.io.File;
import java.io.FileInputStream;

/**
 * Created by Administrator on 2017-6-1.
 */

public class PlansService extends AppCompatActivity {
    public static PlanInfo getPlanInfo(String filename) throws Exception{
        XmlPullParser parser = Xml.newPullParser();
        File sdDir = Environment.getExternalStorageDirectory();
        File file = new File(sdDir, filename);
        FileInputStream fis = new FileInputStream(file);
        parser.setInput(fis,"utf-8");
        PlanInfo planinfo =null;
        int type= parser.getEventType();
        while (type!=XmlPullParser.END_DOCUMENT){
            switch (type){
                case XmlPullParser.START_TAG:
                    if("plans".equals(parser.getName())){

                    }else if("plan".equals(parser.getName())){
                        planinfo = new PlanInfo();
                    }else if("event".equals(parser.getName())){
                        String event = parser.nextText();
                        planinfo.setEvent(event);
                    }else if("time".equals(parser.getName())){
                        String time = parser.nextText();
                        planinfo.setTime(time);
                    }else if("content".equals(parser.getName())){
                        String content = parser.nextText();
                        planinfo.setContent(content);
                    }
                    break;
                case XmlPullParser.END_TAG:
                    break;
            }
            type = parser.next();
        }
        return planinfo;
    }

}

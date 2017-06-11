package edu.hzuapps.androidlabs.homeworks.net1414080903231;


import android.util.Log;
import android.util.Xml;


import org.xmlpull.v1.XmlPullParser;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MusicinfoService {
    public static List<MusicInfo> getMusicinfos(InputStream is){
        XmlPullParser parser= Xml.newPullParser();
        try{
            parser.setInput(is,"utf-8");
            int type=parser.getEventType();
            List<MusicInfo> musicInfos=null;
            MusicInfo musicInfo=null;
            while(type!=XmlPullParser.END_DOCUMENT){
                switch(type){
                    case XmlPullParser.START_TAG:
                        Log.i("info",parser.getName());
                        if("music".equals(parser.getName())){
                            musicInfos=new ArrayList<MusicInfo>();
                        }else if("musicInfo".equals(parser.getName())){
                            musicInfo=new MusicInfo();
                        }else if("icon".equals(parser.getName())){
                            String icon=parser.nextText();
                            musicInfo.setIconpath(icon);
                        }else if("title".equals(parser.getName())){
                            String title=parser.nextText();
                            musicInfo.setMusicname(title);
                        }else if("content".equals(parser.getName())){
                            String des=parser.nextText();
                            musicInfo.setDes(des);
                        }else if("type".equals(parser.getName())){
                            String musictype=parser.nextText();
                            musicInfo.setType(Integer.parseInt(musictype));
                        }else if("comment".equals(parser.getName())){
                            String comment=parser.nextText();
                            musicInfo.setComment(Long.parseLong(comment));
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        if("musicInfo".equals(parser.getName())){
                            musicInfos.add(musicInfo);
                            musicInfo=null;
                            Log.i("info","start2");
                        }
                        break;
                }
                type=parser.next();
            }
            return musicInfos;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}

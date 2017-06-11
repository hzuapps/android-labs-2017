package edu.hzuapps.androidlabs.homeworks.net1414080903240;

import android.content.SharedPreferences;
import android.content.pm.ProviderInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.os.Handler;
import android.util.Xml;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.xmlpull.v1.XmlPullParser;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.logging.LogRecord;

public class Net1414080903240_OldAccount extends AppCompatActivity {
    private ListView mListView;
    private String path="https://raw.githubusercontent.com/mokulai/android-labs-2017/master/AndroidLabs/app/src/main/java/edu/hzuapps/androidlabs/homeworks/net1414080903240/detailvalues.xml";
    Handler mHandler=new Handler(){
        public void handleMessage(Message msg) {
            if(msg.what==1){
                try {
                    List<order> info=(List<order>) msg.obj;
                    initData(info);
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }else{
                try {
                    List<order> info=getAccountInfos(getResources().getAssets().open("detailvalues.xml"));
                    initData(info);
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }

     }
    };
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.old_account);
        getXml();
    }
    protected void initData(List<order> info) {
        ListView lv = (ListView) findViewById(R.id.lv);
        try {
            ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String,Object>>();
            for(order infos:info)
            {
                HashMap<String, Object> map = new HashMap<String, Object>();
                map.put("tt_value",infos.getClassname());
                map.put("project_value",infos.getValue());
                listItem.add(map);
            }
            SimpleAdapter mSimpleAdapter = new SimpleAdapter(this,listItem,R.layout.list_item, new String[] {"tt_value", "project_value"},new int[]{R.id.tt_value,R.id.project_value});
            lv.setAdapter(mSimpleAdapter);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static List<order> getAccountInfos( InputStream is) throws Exception {
        XmlPullParser parser = Xml.newPullParser();
        parser.setInput(is, "utf-8");
        List<order> infos = null;
        order info = null;
        int type = parser.getEventType();
        while (type != XmlPullParser.END_DOCUMENT) {
            switch (type) {
                case XmlPullParser.START_TAG:
                    if ("detail".equals(parser.getName())) {
                        infos = new ArrayList<order>();
                    } else if ("account".equals(parser.getName())) {
                        info = new order();
                        String id = parser.getAttributeValue(0);
                        info.setId(Integer.parseInt(id));
                    } else if ("classname".equals(parser.getName())) {
                        String cla = parser.nextText();
                        info.setClassname(cla);
                    } else if ("value".equals(parser.getName())) {
                        String value = parser.nextText();
                        info.setValue(value);
                    }
                    break;
                case XmlPullParser.END_TAG:
                    if ("account".equals(parser.getName())) {
                        infos.add(info);
                        info = null;
                    }
                    break;

            }
            type = parser.next();
        }
        return infos;
    }

    public void getXml(){
            new Thread(new Runnable() {
                private HttpURLConnection conn;
                public void run() {
                    try {
                        URL url=new URL(path);
                        conn = (HttpURLConnection) url.openConnection();
                        conn.setReadTimeout(5000);
                        conn.setRequestMethod("GET");
                        if (conn.getResponseCode()==200) {
                            InputStream inputStream=conn.getInputStream();
                            List<order> listNews=getAccountInfos(inputStream);
                            if(listNews.size()>0) {
                                Message msg = new Message();
                                msg.obj = listNews;
                                msg.what = 1;
                                mHandler.sendMessage(msg);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

}

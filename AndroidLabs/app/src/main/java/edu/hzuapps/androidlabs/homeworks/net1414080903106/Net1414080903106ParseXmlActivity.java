package edu.hzuapps.androidlabs.homeworks.net1414080903106;


import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

import edu.hzuapps.androidlabs.R;

public class Net1414080903106ParseXmlActivity extends AppCompatActivity {
    private TextView CityName,Temperature,Climate;
    Net1414080903106Weather weather=null;


    private Handler mHandler=new Handler(){
        public void handleMessage(android.os.Message message){
            switch(message.what){
                case 1:
                    updateWeather((Net1414080903106Weather) message.obj);
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903106_parse_xml);

        CityName=(TextView) findViewById(R.id.wether_cityName);
        Temperature=(TextView) findViewById(R.id.weather_temperature);
        Climate=(TextView) findViewById(R.id.weather_climate);
        CityName.setText("N/A");
        Temperature.setText("N/A");
        Climate.setText("N/A");

        getWeatherDatafromNet();
    }

    //获取网络上的数据
    private void getWeatherDatafromNet(){
        final String address="https://raw.githubusercontent.com/zida106/android-labs-2017/master/AndroidLabs/app/src/main/res/values/weather.xml";
        Log.d("Address",address);
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection urlConnection=null;
                try{
                    URL url=new URL(address);
                    urlConnection=(HttpURLConnection) url.openConnection();
                    urlConnection.setRequestMethod("GET");
                    urlConnection.setConnectTimeout(8000);
                    urlConnection.setReadTimeout(8000);
                    InputStream in=urlConnection.getInputStream();
                    BufferedReader reader=new BufferedReader(new InputStreamReader(in));
                    StringBuffer sb=new StringBuffer();
                    String str;
                    while((str=reader.readLine())!=null){
                        sb.append(str);
                        Log.d("data from url",str);
                    }
                    String response=sb.toString();
                    Log.d("response",response);

                    //调用parseXML函数
                    weather=parseXML(response);
                    if(weather!=null){
                        Log.d("weatherData",weather.toString());
                        Message message=new Message();
                        message.what=1;
                        message.obj=weather;
                        mHandler.sendMessage(message);
                    }

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

    //通过xmlPullParser解析xml数据
    private Net1414080903106Weather parseXML(String xmlData){
        Net1414080903106Weather weather=null;
        try{
            XmlPullParserFactory factory=XmlPullParserFactory.newInstance();
            XmlPullParser xmlPullParser=factory.newPullParser();
            xmlPullParser.setInput(new StringReader(xmlData));

            int eventType=xmlPullParser.getEventType();
            Log.d("ParseXmlActivity","start parse xml");

            while(eventType!=xmlPullParser.END_DOCUMENT){
                switch(eventType){
                    //文档开始位置
                    case XmlPullParser.START_DOCUMENT:
                        Log.d("ParseXmlActivity","start doc");
                        break;
                    //标签元素开始位置
                    case XmlPullParser.START_TAG:
                        if(xmlPullParser.getName().equals("resources")){
                            weather=new Net1414080903106Weather();
                        }
                        if(weather!=null){
                            if(xmlPullParser.getName().equals("city")){
                                eventType=xmlPullParser.next();
                                Log.d("city",xmlPullParser.getText());
                                weather.setCity(xmlPullParser.getText());
                            }else if(xmlPullParser.getName().equals("wendu")){
                                eventType=xmlPullParser.next();
                                Log.d("wendu",xmlPullParser.getText());
                                weather.setWendu(xmlPullParser.getText());
                            }else if(xmlPullParser.getName().equals("type")){
                                eventType=xmlPullParser.next();
                                Log.d("type",xmlPullParser.getText());
                                weather.setType(xmlPullParser.getText());
                            }
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        break;
                }
                eventType=xmlPullParser.next();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        Log.d("parseXML",weather.toString());
        return weather;
    }

    //更新组件
    void updateWeather(Net1414080903106Weather weather){
        CityName.setText(weather.getCity());
        Temperature.setText(weather.getWendu()+"℃");
        Climate.setText(weather.getType());
        Log.d("XmlActivity","更新成功");
        Toast.makeText(Net1414080903106ParseXmlActivity.this,"更新成功",Toast.LENGTH_SHORT).show();
    }
}


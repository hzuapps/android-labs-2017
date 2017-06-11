package edu.hzuapps.androidlabs.homework.net1414080903234;

import android.app.DownloadManager;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import org.json.JSONObject;

import java.io.InputStream;

public class Net1414080903234AnalyActivity extends AppCompatActivity {
    protected static final int CHANGE_UI = 1;
    protected static final int ERROR = 2;
    private TextView Tview;
    private String money;
    private String income;
    private String outlay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903234_analy);
        Tview = (TextView)findViewById(R.id.jsontext);
        GetJson();
    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.what == CHANGE_UI){
                String string = (String) msg.obj;
                parseJson(string);
                String text = "总 额: " + money + "\n\n" +
                        "收 入: " + income + "\n\n" +
                        "支 出: " + outlay + "\n\n";
                Tview.setText(text);
            }else if(msg.what == ERROR){
                Toast.makeText(Net1414080903234AnalyActivity.this,"网络错误，解析失败",Toast.LENGTH_SHORT);
            }
        }
    };

    private void GetJson(){
       final String path = "https://raw.githubusercontent.com/trjie/android-labs-2017/master/AndroidLabs/app/src/main/java/edu/hzuapps/androidlabs/homeworks/net1414080903234/1414080903234.json";
        new Thread(){
            @Override
            public void run() {
                try{
                    HttpClient client = new DefaultHttpClient();
                    HttpGet httpGet = new HttpGet(path);
                    HttpResponse httpResponse = client.execute(httpGet);
                    if(httpResponse.getStatusLine().getStatusCode() == 200){
                        HttpEntity entity = httpResponse.getEntity();
                        InputStream content = entity.getContent();
                        String scontent = getString(content);
                        Message message = new Message();
                        message.what = CHANGE_UI;
                        message.obj = scontent;
                        handler.sendMessage(message);
                    }else{
                        Message message = new Message();
                        message.what = ERROR;
                        handler.sendMessage(message);
                    }
                }catch(Exception e){
                    e.printStackTrace();
                    Message message = new Message();
                    message.what = ERROR;
                    handler.sendMessage(message);
                }
            }
        }.start();
    }
    public String getString(InputStream content) {
        try {

            byte[] buf = new byte[1024];
            StringBuilder stringBuilder = new StringBuilder();
            String text;
            int len;
            while ((len = content.read(buf)) != -1) {
                text = new String(buf,0,len);
                stringBuilder.append(text);
            }
            return stringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    public void parseJson(String data){
        try {
            JSONObject object = new JSONObject(data);
            money = object.getString("money");
            income = object.getString("income");
            outlay = object.getString("outlay");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


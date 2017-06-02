package edu.hzuapps.androidlabs.net1414080903112;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;
import android.widget.TextView;


import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class result1414080903112 extends AppCompatActivity {
    String what = "";
    String timeid;
    Handler handler;
    TextView view;

    protected void onCreate(Bundle savedInstanceState) {
        /*StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);*/
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result1414080903112);
        view = (TextView) findViewById(R.id.result);

        //新页面接收数据
        Bundle bundle = this.getIntent().getExtras();
        //接收值
        String weekday = bundle.getString("weekday");
        Log.i("获取到的weekday值为", weekday);
        String daytime = bundle.getString("daytime");
        Log.i("获取到的daytime值为", daytime);
        sendRequest(weekday,daytime);
    }
    /*
    这里存储是用访问外部服务器的方式。try.php外部服务器的一个接口，负责到服务器mysql数据库根据传递的参数进行数据的读取，并将结果以JSON格式的数据返回。
     */
    private void sendRequest(final String weekday, final String daytime) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder().url("http://hzubbs.cn/LBS/try.php?week="+weekday+"&daytime="+daytime).build();//目标地址
                    Response response = client.newCall(request).execute();
                    String responseData = response.body().string();
                    AnalysisJson(responseData);
                    view.setText("结果:" + what + "\n" + "\n");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    /*解析json文件*/
    private void AnalysisJson(String jsonData) {
        try {
            JSONArray jsonArray = new JSONArray(jsonData);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                timeid = jsonObject.getString("id");
                what = jsonObject.getString("what");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}


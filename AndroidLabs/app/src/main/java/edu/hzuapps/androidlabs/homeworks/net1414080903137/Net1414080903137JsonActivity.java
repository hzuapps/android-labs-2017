package edu.hzuapps.androidlabs.homworks.net1414080903137;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import edu.hzuapps.androidlabs.R;

public class Net1414080903137JsonActivity extends AppCompatActivity {


    private String banji;
    private String xingming;
    private String xuehao;
    private TextView message;
    private Handler handler = null;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903137_json);
        handler = new Handler();
        message = (TextView) findViewById(R.id.info);
        sendRequest();
    }
    private void sendRequest() {
        new Thread(){
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder().url("https://raw.githubusercontent.com/hizzj/android-labs-2017/master/AndroidLabs/app/src/main/java/edu/hzuapps/androidlabs/homeworks/net1414080903137/info.json").build();//目标地址
                    Response response = client.newCall(request).execute();
                    String responseData = response.body().string();
                    AnalysisJson(responseData);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                handler.post(runnableUi);
            }
        }.start();
    }

    /*解析json文件*/
    private void AnalysisJson(String jsonData) {
        try {
            JSONArray jsonArray = new JSONArray(jsonData);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                banji = jsonObject.getString("banji");
                xuehao = jsonObject.getString("xuehao");
                xingming = jsonObject.getString("xingming");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*更新UI*/
    Runnable runnableUi = new Runnable() {
        public void run() {
            message.setText("班级: " + banji + "\n" + "\n" +"学号: " + xuehao + "\n" + "\n"+ "姓名: " + xingming + "\n" + "\n"  );//显示解析结果
        }
    };
}

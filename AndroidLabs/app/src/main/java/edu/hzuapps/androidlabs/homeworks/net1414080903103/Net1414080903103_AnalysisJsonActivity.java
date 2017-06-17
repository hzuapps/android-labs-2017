package edu.hzuapps.androidlabs.homeworks.net1414080903103;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;



import org.json.JSONArray;
import org.json.JSONObject;


import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/*抓取并解析json文件*/
public class Net1414080903103_AnalysisJsonActivity extends AppCompatActivity {
    private String ip;
    private String port;
    private String password;
    private TextView GithubResponse;
    private Handler handler = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903103__analysis_json);
        handler = new Handler();
        GithubResponse = (TextView) findViewById(R.id.response_info);
        sendRequest();
    }

    private void sendRequest() {
        new Thread(){
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder().url("https://raw.githubusercontent.com/Paynehe/android-labs-2017/master/AndroidLabs/app/src/main/java/edu/hzuapps/androidlabs/homeworks/net1414080903103/vpn_info.json").build();//目标地址
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
                ip = jsonObject.getString("ip");
                port = jsonObject.getString("port");
                password = jsonObject.getString("password");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*更新UI*/
    Runnable runnableUi = new Runnable() {
        public void run() {
            GithubResponse.setText("IP" + ip + "\n" + "\n" + "Port" + port + "\n" + "\n" + "Password" + password + "\n" + "\n");//显示解析结果
        }
    };
}
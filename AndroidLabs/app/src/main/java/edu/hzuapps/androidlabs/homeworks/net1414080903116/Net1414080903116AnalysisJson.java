package edu.hzuapps.androidlabs.homeworks.net1414080903116;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import edu.hzuapps.androidlabs.R;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Net1414080903116AnalysisJson extends AppCompatActivity {
    private String soft_name;
    private String developer;
    private String version;
    private TextView GithubResponse;
    private Handler handler = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903116_analysis_json);
        handler = new Handler();
        GithubResponse = (TextView) findViewById(R.id.analysis_json);
        Request();
    }

    private void Request() {
        new Thread(){
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder().url("https://raw.githubusercontent.com/Qlzr/android-labs-2017/master/AndroidLabs/app/src/main/java/edu/hzuapps/androidlabs/homeworks/net1414080903116/Net141408093116SoftInfo.json").build();//目标地址
                    Response response = client.newCall(request).execute();
                    String responseData = response.body().string();
                    Analysis(responseData);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                handler.post(runnableUi);
            }
        }.start();
    }
    /*解析json文件*/
    private void Analysis(String jsonData) {
        try {
            JSONArray jsonArray = new JSONArray(jsonData);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                soft_name= jsonObject.getString("soft_name");
                developer= jsonObject.getString("developer");
                version = jsonObject.getString("version");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*更新UI*/
    Runnable runnableUi = new Runnable() {
        public void run() {
            GithubResponse.setText("软件名: " + soft_name + "\n" + "\n" + "开发者: " + developer + "\n" + "\n" + "版本号: " + version + "\n" + "\n");//显示解析结果
        }
    };
}
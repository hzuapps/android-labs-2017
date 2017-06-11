package edu.hzuapps.androidlabs.homeworks.net1414080903108;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import com.example.myapplication.R;

import org.json.JSONArray;
import org.json.JSONObject;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
public class Net1414080903108SActivity extends AppCompatActivity {
    private String usename;
    private String name;
    private String number;
    private TextView GithubResponse;
    private Handler handler = null;
       @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903108_s);
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
                    Request request = new Request.Builder().url("https://raw.githubusercontent.com/claixiang/android-labs-2017/master/AndroidLabs/app/src/main/java/edu/hzuapps/androidlabs/homeworks/net1414080903108/shuoming.json").build();//目标地址
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

    private void AnalysisJson(String jsonData) {
        try {
            JSONArray jsonArray = new JSONArray(jsonData);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                name  = jsonObject.getString("name");
                usename = jsonObject.getString("usename");
                number = jsonObject.getString("number");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Runnable runnableUi = new Runnable() {
        public void run() {
            GithubResponse.setText("软件名称: " + name + "\n" + "\n" + "姓名: " + usename + "\n" + "\n" + "学号: " + number + "\n" + "\n");//显示解析结果
        }
    };
}
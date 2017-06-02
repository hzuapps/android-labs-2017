package edu.hzuapps.androidlabs.homeworks.net1414080903117;

import android.app.DownloadManager;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import edu.hzuapps.androidlabs.R;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Net1414080903117ParseJsonActivity extends AppCompatActivity {
    private String floor;
    private String dorm;
    private String water;
    private String electric;
    private String info;
    private TextView GithubResponse;
    private Handler handler = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903117_parse_json);
        handler = new Handler();
        GithubResponse = (TextView) findViewById(R.id.json_info);
        sendRequest();
    }

    private void sendRequest() {
        new Thread(){
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder().url("https://raw.githubusercontent.com/JCLin0318/android-labs-2017/master/AndroidLabs/app/src/main/java/edu/hzuapps/androidlabs/homeworks/net1414080903117/1414080903117.json").build();//目标地址
                    Response response = client.newCall(request).execute();
                    String responseData = response.body().string();
                    ParseJson(responseData);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                handler.post(runnableUi);
            }
        }.start();
    }

    /*解析json文件*/
    private void ParseJson(String jsonData) {
        try {
            JSONArray jsonArray = new JSONArray(jsonData);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                floor= jsonObject.getString("floor");
                dorm= jsonObject.getString("dorm");
                water= jsonObject.getString("water");
                electric= jsonObject.getString("electric");
                info= jsonObject.getString("info");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*更新UI*/
    Runnable runnableUi = new Runnable() {
        public void run() {
            GithubResponse.setText("宿舍楼号: " + floor + "\n" + "\n" + "宿舍号: " + dorm + "\n" + "\n" + "水费欠费金额: " + water + "\n" + "\n"+ "电费欠费金额: " + electric + "\n" + "\n"+ "通知: " + info + "\n" + "\n"

            );//显示解析结果
        }
    };
}

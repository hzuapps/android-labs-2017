package homeworks.androids.hzuapps.edu.application.net1414080903219;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;

import org.json.JSONObject;
import android.os.Handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.net.HttpURLConnection;
import java.net.URL;

import homeworks.androids.hzuapps.edu.application.R;

public class JsonActivity extends AppCompatActivity implements View.OnClickListener{
    TextView responseText;

    private Handler handler = null;
    private String english;
    private String mean;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.json_net1414080903219);

        handler = new Handler();

        Button sendRequest = (Button) findViewById(R.id.send_request);
        responseText = (TextView) findViewById(R.id.response_text);
        sendRequest.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.send_request) {
            sendRequestWithHttpURLConnection();
        }
    }


    private void sendRequestWithHttpURLConnection() {
        //开启线程来发起网络请求
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                BufferedReader reader = null;
                try {
                    URL url = new URL("https://raw.githubusercontent.com/14w2mary/android-labs-2017/master/AndroidLabs/app/src/main/java/edu/hzuapps/androidlabs/homeworks/net1414080903219/getdata.json");
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);
                    InputStream in = connection.getInputStream();
                    //下面对获取到的输入流进行读取
                    reader = new BufferedReader(new InputStreamReader(in));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }

                    String responseData = response.toString();
                    //parseXMLWithPull(response.toString());//解析数据
                    parseJSONWithObject(responseData);


                    //showResponse(response.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (connection != null) {
                        connection.disconnect();
                    }
                }
                handler.post(runnableUi);
            }
        }).start();
    }


    private void parseJSONWithObject(String jsonData){
        try{
            JSONArray jsonArray=new JSONArray(jsonData);
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                english= jsonObject.getString("english");
                mean= jsonObject.getString("mean");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    Runnable runnableUi = new Runnable() {
        public void run() {
            responseText.setText("单词: " + english + "\n" + "\n" + "释义: " + mean + "\n" + "\n");//显示解析结果
        }
    };




}

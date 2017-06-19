package edu.hzuapps.androidlabs.homeworks.net1414080903114;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.app.DownloadManager.Request;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;



public class AboutActivity extends Activity{
	private TextView tv_softwareName, tv_authorName;
	private String softwareName,authorName;
	private Handler handler = null;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about_net1414080903114);
		handler = new Handler();
		sendRequest();
	}
	
	private void sendRequest() {
        new Thread(){
            @Override
            public void run() {
                	String url = "https://github.com/QuanGuanQiao/android-labs-2017/tree/master/AndroidLabs/app/src/main/java/edu/hzuapps/androidlabs/homeworks/net1414080903114/about.json";
                	OkHttpClient okHttpClient = new OkHttpClient();
                	Request request = new Request.Builder()
                	    .url(url)
                	    .build();
                	Call call = okHttpClient.newCall(request);
                	try {
                	    Response response = call.execute();
                	    String responseData = response.body().string();
                	    AnalysisJson(responseData);
                	} catch (IOException e) {
                	    e.printStackTrace();
                	}
                	handler.post(runnableUi);
            }
        }.start();
    }

    private void AnalysisJson(String jsonData) {
        try {
            JSONArray jsonArray = new JSONArray(jsonData);
            for (int i = 0; i < jsonArray.length(); i++  ) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                softwareName  = jsonObject.getString("softwareName");
                authorName = jsonObject.getString("authorName");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    Runnable runnableUi = new Runnable() {
    	public void run() {
    		tv_softwareName = (TextView) findViewById(R.id.tv_softwareName);
    		tv_softwareName.setText("softwareName: " + softwareName);
    		tv_authorName = (TextView) findViewById(R.id.tv_authorName);
    		tv_authorName.setText("authorName: " + authorName);
    		
        }
    };
	
}


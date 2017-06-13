package edu.hzuapps.androidlabs.homeworks.net1414080903224;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Net1414080903224Internet extends AppCompatActivity {
    private Button b_history;
    private Button b_search;
    private EditText e_input;
    public static final int Show_response=0;
    private  N1414080903224Dao dao;  //数据库操作类

    private Handler handler=new Handler(){
        public  void handleMessage (android.os.Message msg){
           switch (msg.what){
               case Show_response:
                   String response =(String) msg.obj;
                   Intent intent = new Intent(Net1414080903224Internet.this, N1414080903224page.class);
                   intent.putExtra("page",response);
                   startActivity(intent);
           }
        }
    };
    private void sendRequestByHttpURLConnection(final String path){
        new Thread(new Runnable(){
            public void run(){
                HttpURLConnection connection=null;
                try{
                    URL url=new URL(path);
                    connection=(HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(5000);
                    InputStream in=connection.getInputStream();
                    BufferedReader reader=new BufferedReader(new InputStreamReader(in));
                    StringBuilder response =new StringBuilder();
                    String line;
                    while ((line=reader.readLine())!=null){
                        response.append(line);
                    }
                    Message message =new Message();
                    message.what=Show_response;
                    message.obj=response.toString();
                    handler.sendMessage(message);
                } catch (Exception e){
                    e.printStackTrace();
                } finally {
                    if(connection!=null){
                        connection.disconnect();
                    }
                }
            }
        }).start();
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903224_internet);
        e_input=(EditText) findViewById(R.id.e_input);
        b_history = (Button) findViewById(R.id.button1);
        b_search = (Button) findViewById(R.id.button);
        b_history.setOnClickListener(new ButtonListener());
        b_search.setOnClickListener(new ButtonListener());
        dao=new N1414080903224Dao(this);
    }


    private class ButtonListener implements View.OnClickListener {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button1:
                    Intent intent = new Intent(Net1414080903224Internet.this, N1414080903224history.class);
                    startActivity(intent);
                    break;
            }
            switch (v.getId()) {
                case R.id.button:
                   final  String path=e_input.getText().toString().trim(); //获取用户输入的信息
                    N1414080903224Address a=new N1414080903224Address(path);
                    dao.insert(a);  //插入数据库
                    sendRequestByHttpURLConnection(path);
                    break;
            }
        }
    }
}

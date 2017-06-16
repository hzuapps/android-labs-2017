package edu.hzuapps.androidlabs.homeworks.net1414080903125;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import edu.hzuapps.androidlabs.R;

public class Text_net1414080903125 extends AppCompatActivity {
    private TextView TgameI;
    private Handler handler=new Handler(){
        public void handleMessage(android.os.Message msg){
            switch(msg.what){
                case 0:
                    new AlertDialog.Builder(Text_net1414080903125.this).setTitle("提示").setMessage("获取数据失败").setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    }).show();
                case 1:
                    JSONAnalysis(msg.obj.toString());
                    /*new AlertDialog.Builder(Net1414080903127GameInstructions.this).setTitle("54").setMessage(msg.obj.toString()).setPositiveButton("确定",new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    }).show();*/
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_net1414080903125);
        TgameI=(TextView)findViewById(R.id.text);
        runable();
    }
    protected void JSONAnalysis(String string){
        try {
            JSONArray jsonArray=new JSONArray(string);
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject=jsonArray.getJSONObject(i);
                String name=jsonObject.getString("name");
                TgameI.setText(name);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void runable(){
        final String path="https://raw.githubusercontent.com/czb125/android-labs-2017/AndroidLabs/app/src/main/java/edu/hzuapps/androidlabs/homeworks/net1414080903125/1414080903125.json";
        new Thread(){
            private HttpURLConnection conn;
            public void run(){
                int code;
                try{
                    URL url=new URL(path);
                    conn=(HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    conn.setConnectTimeout(5000);
                    code=conn.getResponseCode();
                    if(code==200){
                        InputStream is=conn.getInputStream();
                        BufferedReader reader=new BufferedReader(new InputStreamReader(is));
                        StringBuilder response=new StringBuilder();
                        String Line;
                        String result;
                        while((Line= reader.readLine())!=null){
                            response.append(Line);
                        }
                        result=response.toString();
                        Message msg=new Message();
                        msg.what = 1;
                        msg.obj=result;
                        handler.sendMessage(msg);
                    }
                }catch (Exception e){
                    Message msg=new Message();
                    msg.what=0;
                    handler.sendMessage(msg);
                }
            }
        }.start();
    }
}

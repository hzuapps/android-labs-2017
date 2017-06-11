package com.example.administrator.net1414080903214;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class wordTranslation extends Activity implements View.OnClickListener {
    private Button button;
    private EditText editText ;
    private String inputText;
    private TextView textView;
    private String text;

    private static final String APP_ID = "20170531000049673";
    private static final String SECURITY_KEY = "7oz2iDBn4123HWHOJ1VI";
    //获取编辑框的内容存入sd卡中
    public void  getContent(){
        try {
            File file=new File("/sdcard/temp.txt");
            FileOutputStream fos=new FileOutputStream(file);
            byte[] data=inputText.getBytes("UTF-8");
            fos.write(data);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    };

    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wordtranslaton1414080903214);
        button=(Button)findViewById(R.id.bt_start);
        editText= (EditText) findViewById(R.id.editText);
        textView= (TextView) findViewById(R.id.tv);
        button.setOnClickListener(this);
    }

    public void onClick(View view){
        switch(view.getId()){
            case R.id.bt_start:
                inputText=editText.getText().toString();
                getContent();
                new Thread(){
                    public void run(){
                        TransApi api = new TransApi(APP_ID, SECURITY_KEY);
                        String query = inputText;
                        //返回一个包含api标准的字符串，里面是这样{"from":"auto","to":"en","trans_result":[{"src":原文","dst":译文"}]}
                        text=api.getTransResult(query, "auto", "en");
                        //提取译文部分
                        int i1=text.indexOf("dst");
                        int i2=text.indexOf("]");
                        final String t=text.substring(i1+6,i2-2);
                        if (t!=null){
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    textView.setText(t);
                                    Toast.makeText(wordTranslation.this,"成功",Toast.LENGTH_SHORT).show();
                                }
                            });
                        }else {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(wordTranslation.this,"失败",Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }
                }.start();
                break;
            default:
                break;
        }
    }

}



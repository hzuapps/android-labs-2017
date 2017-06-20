package edu.hzuapps.androidlabs.homeworks.net1414080903203;


import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import edu.hzuapps.androidlabs.R;

/**
 * Created by Administrator on 2017/6/20 0020.
 */

public class Net1414080903203Network extends Activity {
    protected static final int CHANGE_UI=1;
    protected static final int ERROR=2;
    private EditText et_path;
    private ImageView iv;
    //主线线程创建信息处理器
    private Handler handler=new Handler(){
        public void handlerMessage(android.os.Message msg){
            if(msg.what==CHANGE_UI){
                Bitmap bitmap=(Bitmap) msg.obj;
                iv.setImageBitmap(bitmap);
            }else if(msg.what==ERROR){
                Toast.makeText(Net1414080903203Network.this,
                        "显示图片错误",Toast.LENGTH_SHORT).show();
            }
        };
    };
    protected void onCreate(Bundle saveInstaneState){
        super.onCreate(saveInstaneState);
        setContentView(R.layout.activity_net1414080903203network);
        et_path=(EditText) findViewById(R.id.et_path);
        iv=(ImageView) findViewById(R.id.iv);
    }
    public void click(View view){
        final  String path=et_path.getText().toString().trim();
        if(TextUtils.isEmpty(path)){
            Toast.makeText(this,"图片路径不能为空",Toast.LENGTH_SHORT).show();
        }else{
            //子线程请求网络，Anroid4.0以后不能放在主线程
            new Thread(){
                private HttpURLConnection conn;
                private Bitmap bitmap;
                public void run(){
                    //链接服务器get请求，获取图片
                    try{
                        URL url=new URL(path);
                        conn=(HttpURLConnection) url.openConnection();
                        conn.setRequestMethod("GET");
                        conn.setConnectTimeout(5000);
                        conn.setRequestProperty("User-Agent",
                        "Mozilla/4.0(compatible;MSIE 6.0;Windows NT 5.1;"+ "SV1;.NET4.0C;NET4.0E;.NET CLR 2.0.50727;"+".NET CLR 3.0.4506.2152;.NET CLR 3.5.30729;Shuame)");
                        int code=conn.getResponseCode();
                        if(code==200){
                            InputStream is=conn.getInputStream();
                            bitmap= BitmapFactory.decodeStream(is);
                            Message msg=new Message();
                            msg.what=CHANGE_UI;
                            msg.obj=bitmap;
                            handler.sendMessage(msg);
                        }else {
                            Message msg=new Message();
                            msg.what=ERROR;
                            handler.sendMessage(msg);
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                        Message msg=new Message();
                        msg.what=ERROR;
                        handler.sendMessage(msg);
                    }
                };

            }.start();
        }
    }

}

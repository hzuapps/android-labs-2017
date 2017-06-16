package homeworks.androidlabs.hzuapps.edu.net1414080903232;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.text.TextUtilsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.io.InputStream;
import java.net.HttpRetryException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import homeworks.androidlabs.hzuapps.edu.net141408090323.cn.itcast.domain.ItemInfo;
import homeworks.androidlabs.hzuapps.edu.net141408090323.dao.AccountDao;


public class MainActivity extends AppCompatActivity {
    private Button button;
    private List<ItemInfo> list;
    private AccountDao dao;
    private Button button2;//用于实验6
    private EditText et_path;//用于实验6（解析时需要的路径）
    private TextView tv;//用于实验6（解析得到的内容显示在tv上）
    private static final int CHANGE_UI=1;//用于实验6
    private static final int ERROR=2;//用于实验6
    private Handler handler=new Handler(){//用于实验6
        public void handleMessage(android.os.Message msg){
            if(msg.what==CHANGE_UI){
                String context=(String)msg.obj;
                tv.setText(context);
            }else if(msg.what==ERROR){
                Toast.makeText(MainActivity.this,"错误",0).show();
            }
        }
    };
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_net1414080903232);

        dao=new AccountDao(this);// 有这条语句dao.insert(itemInfo);没有dao=new AccountDao(this);语句的话，将提示错误：空对象尝试去调用虚函数insert()

        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);//用于实验6
        tv=(TextView)findViewById(R.id.textView1111);//用于实验6
        et_path=(EditText) findViewById(R.id.editText);//用于实验6
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                passDate();
            }
        });
        //用于实验6
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               a();
            }
        });
    }
    public void passDate(){
        ItemInfo itemInfo;
        itemInfo = new ItemInfo("周贵浩", "*****", "2017/04/17", "惠州学院计算机系 ", "0123456789 ", "规格为XL的短袖T恤一件");

        dao.insert(itemInfo);


        Intent intent = new Intent(this, Activity02.class);
        intent.putExtra("name", itemInfo.getName());
        intent.putExtra("address", itemInfo.getAddress());
        intent.putExtra("detail", itemInfo.getDetail());
        intent.putExtra("phone_number", itemInfo.getPhone_number());
        intent.putExtra("TB_name", itemInfo.getTB_name());
        intent.putExtra("time", itemInfo.getTime());
        startActivity(intent);
    }
    public void a()
    {
        final String path=et_path.getText().toString().trim();
        if (TextUtils.isEmpty(path)){
            Toast.makeText(this,"路径不能为空",0).show();
        }else {
            new Thread(){
                private HttpURLConnection conn;
                public void run(){
                    try{
                        URL url=new URL(path);
                        conn=( HttpURLConnection) url.openConnection();
                        conn.setRequestMethod("GET");
                        conn.setConnectTimeout(5000);
                        conn.setRequestProperty("User-Agent","Mozilla/4.0(compatible;MSIE 6.0;Windows NT 5.1;"+"SV1;.NET4.0C;.NET4.0E;.NET CLR 2.0.50727;"+".NET CLR 3.0.4506.2152;.NET CLR 3.5.30729;Shuame)");
                        int code=conn.getResponseCode();
                        if(code==200){
                            InputStream is=conn.getInputStream();
                            Message msg=new Message();
                            String ss=b(is);
                            msg.obj=ss;
                            msg.what=CHANGE_UI;
                            handler.sendMessage(msg);

                        }else{
                            Message msg=new Message();
                            msg.what=ERROR;
                            handler.sendMessage(msg);
                        }
                    }catch(Exception e){
                        e.printStackTrace();
                        Message msg=new Message();
                        msg.what=ERROR;
                        handler.sendMessage(msg);
                    }
                };
            }.start();

        }

    }
    public String b(InputStream c) {
        try {

            byte[] buf = new byte[1024];
            StringBuilder stringBuilder = new StringBuilder();
            String text;
            int len;
            while ((len = c.read(buf)) != -1) {
                text = new String(buf,0,len);
                stringBuilder.append(text);
            }
            return stringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}



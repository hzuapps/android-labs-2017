package edu.hzuapps.androidlabs.homeworks.net1414080903104;
/*
 * 两个问题：
 * 1、api的使用  即url的使用
 * 2、要用handler 参考：http://blog.csdn.net/superjunjin/article/details/7540064
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.google.gson.Gson;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import edu.hzuapps.androidlabs.R;

public class Net1414080903104obtainjsonActivity extends ActionBarActivity {
	private static final int UPDATE_UI = 1;  
	private static final int ERROR = 2; 

	private static String jsonData;//用于存放获取得到的json数据
	private Sentence sentence;//用于存放解析json得到的数据
	private TextView tv;//用于显示json数据
	private TextView tv1;
	private TextView tv2;
	private Handler handler=new Handler(){  
        // 但有新消息时调用  
        @Override  
        public void handleMessage(Message msg) {  
            if (msg.what == UPDATE_UI) {  
                // 获取消息对象  
            	String ou=(String) msg.obj;
            	System.out.println(ou);
            	try {
					sentence=parseJsonByOrgJson(ou);
					tv.setText(sentence.getName());
					tv1.setText(sentence.getTime());
					tv2.setText(sentence.getOffer());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	
            } else if (msg.what == ERROR) {  
                // Toast也是属于UI的更新  
                Toast.makeText(getApplicationContext(), "获取失败！", 0).show();  
            }  
        }  ;
    }; 
	

	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.obtainjson_net1414080903104);
        tv=(TextView)findViewById(R.id.jsoninfo);
        tv1=(TextView)findViewById(R.id.jsoninfo1);
        tv2=(TextView)findViewById(R.id.jsoninfo2);
        new Thread(){
        	public void run() {
        		try {
        			getJsonData();

        		}catch (Exception e) {
        			e.printStackTrace();
        			System.out.println("worry!");
       		}
            }
        }.start();
	}
	/**
     * 连接网络请求数据，这里使用HttpURLConnection
     */
    public void getJsonData() {
    	 URL url = null;
			//String jsonData1 = ""; //请求服务器返回的json字符串数据 
			InputStreamReader in = null; //读取的内容（输入流）
			try {
			    url = new URL("https://raw.githubusercontent.com/1414080903104/android-labs-2017/master/AndroidLabs/app/src/main/java/edu/hzuapps/androidlabs/homeworks/net1414080903104/jsoninfornation.json");
			    //这个地方的url不对！需要获取到github的api接口。
			    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			    conn.setRequestMethod("GET");  
                // 设置超时时间  
                conn.setConnectTimeout(10000);  
                int code = conn.getResponseCode();  
                if (code == 200) {  
			    //这一步会连接网络得到输入流
			    in = new InputStreamReader(conn.getInputStream());
			 // 为输入创建BufferedReader
	            BufferedReader br = new BufferedReader(in);
	            String inputLine = null;
	            while (((inputLine = br.readLine()) != null)) {
	                jsonData += inputLine;
	            }
	            in.close(); // 关闭InputStreamReader
	           // System.out.println(jsonData);
			 // 告诉主线程一个消息，帮我更新ui，内容：bitmap  
                Message msg = new Message();  
                // 消息的代号，是一个int类型  
                msg.what = UPDATE_UI;  
                // 要传递的消息对象  
                msg.obj = jsonData;  
                // 利用handler发送消息  
                handler.sendMessage(msg);  
            } else {  
                Message msg = new Message();  
                msg.what = ERROR;  
                handler.sendMessage(msg);  
            }  
			} catch (Exception ex) {
			    ex.printStackTrace();
			    Message msg = new Message();  
                msg.what = ERROR;  
                handler.sendMessage(msg);  
			}
			
    }
    /**
     * 通过org.json解析json
     */
    public static Sentence parseJsonByOrgJson(String jsonStr) throws JSONException{
    	// 使用该方法解析思路，遇到大括号用JsonObject，中括号用JsonArray
        // 第一个是大括号
        JSONObject jsonObj = new JSONObject(jsonStr.replaceAll("null", ""));
        //不知道为啥HttpURLConnection这个方法获取到的json数据，前面均有null开头，即获取到的数据格式为：null["xxx":"xxx"]
        //所以这里用replaceALL去掉null即可解析成功
        
        // 新建Sentence对象
        Sentence sen = new Sentence();
        sen.setName(jsonObj.getString("name")); 
        sen.setTime(jsonObj.getString("time") ); 
        sen.setOffer(jsonObj.getString("offer") );
        

        return sen;  
    }

}

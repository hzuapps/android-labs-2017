package edu.hzuapps.androidlabs.homeworks.net1414080903121;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.EditText;

import java.util.HashMap;
import java.util.Map;


public class Net1414080903121Utils {
    //保存QQ号码和密码到DATA.txt文件
    public static boolean saveUserInfo(Context context,String number,String password){
        SharedPreferences sp = context.getSharedPreferences("data",Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putString("userName",number);
        edit.putString("password",password);
        return edit.commit();
    }
    //从data.txt文件获取存储的QQ号码和密码
    public static Map<String,String> getUserInfo(Context context){
        SharedPreferences sp = context.getSharedPreferences("data",Context.MODE_PRIVATE);
        String number = sp.getString("userName",null);
        String password = sp.getString("password",null);
        Map<String,String> userMap = new HashMap<String, String>();
        userMap.put("number",number);
        userMap.put("password",password);
        return userMap;
    }


}

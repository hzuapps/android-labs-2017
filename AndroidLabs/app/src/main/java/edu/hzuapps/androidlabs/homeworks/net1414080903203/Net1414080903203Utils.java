package edu.hzuapps.androidlabs.homeworks.net1414080903203;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.StaticLayout;

import java.util.HashMap;
import java.util.Map;



public class Net1414080903203Utils {
    //保存用户帐号和密码到date.xml文件中
    public static boolean saveUserInfo(Context context, String number,String password){
        SharedPreferences sp = context.getSharedPreferences("date", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putString("userName",number);
        edit.putString("pwd",password);
        edit.commit();
        return true;
    }
    //从data.xml文件中获取存储的用户帐号和密码
    public static Map<String, String> getUserInfo(Context context){
        SharedPreferences sp = context.getSharedPreferences("date", Context.MODE_PRIVATE);
        String number =sp.getString("uesrName",null);
        String password =sp.getString("pwd",null);
        Map<String, String> userMap = new HashMap<String, String>();
        userMap.put("number",number);
        userMap.put("password",password);
        return userMap;
    }

}

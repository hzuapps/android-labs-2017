package edu.hzuapps.androidlabs.homeworks.net1414080903212;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;
import java.util.Map;

public class Utils {
    //保存登录账号和密码到data1414080903212.xml文件中
    public static boolean saveUserInfo(Context context, String number,
                                       String password) {
        SharedPreferences sp = context.getSharedPreferences("data1414080903212", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putString("userName", number);
        edit.putString("pwd", password);
        edit.commit();
        return true;
    }
    //从data1414080903212.xml文件中获取存储的帐号和密码
    public static Map<String, String> getUserInfo(Context context)  {
        SharedPreferences sp = context.getSharedPreferences("data1414080903212", Context.MODE_PRIVATE);
        String number = sp.getString("userName", null);
        String password = sp.getString("pwd", null);
        Map<String, String> userMap = new HashMap<String, String>();
        userMap.put("number", number);
        userMap.put("password", password);
        return userMap;
    }
}

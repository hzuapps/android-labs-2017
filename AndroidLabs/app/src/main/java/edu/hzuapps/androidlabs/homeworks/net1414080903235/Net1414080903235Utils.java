package Utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/14.
 */
//实现登录功能：登录时保存用户数据到data.xml文件里面去
public class Net1414080903235Utils {
    public static boolean saveUserInfo(Context context,String number,String password){
        SharedPreferences sp=context.getSharedPreferences("data",Context.MODE_PRIVATE);
        SharedPreferences.Editor edit=sp.edit();
        edit.putString("username",number);
        edit.putString("pwd",password);
        edit.commit();
        return true;
    }
    public static Map<String,String> getUserInfo(Context context){
        SharedPreferences sp=context.getSharedPreferences("data",Context.MODE_PRIVATE);
        String number=sp.getString("number",null);
        String password=sp.getString("password",null);
        Map<String,String> userMap=new HashMap<>();//这里可以通过number找到对应的password
        userMap.put("number",number);
        userMap.put("password",password);
        return userMap;
    }
}

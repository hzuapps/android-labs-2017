package edu.hzuapps.androidlabs.homeworks.net1414080903138;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/28.
 */
public class Net1414080903138Cashbook_Utils
{
    //保存日消费和月消费到data.xml文件中
    public static boolean saveCashbook(Context context,int daycost,int monthcost)
    {
        SharedPreferences sp = context.getSharedPreferences("data",Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putInt("Daycost",daycost);
        edit.putInt("Monthcost",monthcost);
        edit.commit();
        return true;
    }
    //从data.xml文件获取存储的日消费与月消费额
    public static Map<String,String>getCashbook(Context context)
    {
        SharedPreferences sp = context.getSharedPreferences("data",Context.MODE_PRIVATE);
        String daycost = sp.getString("Daycost",null);
        String monthcost = sp.getString("Monthcost",null);
        Map<String,String> userMap = new HashMap<String, String>();
        userMap.put("daycost",daycost);
        userMap.put("monthcost",monthcost);
        return userMap;
    }
}

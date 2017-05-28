package edu.hzuapps.androidlabs.homeworks.net1414080903128;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hzu on 2017/5/26.
 */

public class Utils
{
    //保存游戏的次数和数字
    public  static boolean saveData(Context context, int mysteryNumber, int guessMade)
    {
        SharedPreferences sp=context.getSharedPreferences("data",Context.MODE_PRIVATE);
        SharedPreferences.Editor edit=sp.edit();
        edit.putInt("number",mysteryNumber);
        edit.putInt("guess",guessMade);
        edit.commit();
        return true;
    }
    //提取存储的数据
    public static Map<String,String> getData(Context context)
    {
        SharedPreferences sp=context.getSharedPreferences("data",Context.MODE_PRIVATE);
        String mysteryNumber=sp.getString("number",null);
        String guessMade=sp.getString("guess",null);
        Map<String,String> userMap=new HashMap<String,String>();
        userMap.put("mysteryNumber",mysteryNumber);
        userMap.put("guessMade",guessMade);
        return userMap;
    }
}



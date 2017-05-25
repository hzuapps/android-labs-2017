package edu.hzuapps.androidlabs.homeworks.net1414080903117;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/4/27.
 */

public class Net1414080903117TimeUtil {

    public static  String getDateYMD(){
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        return format.format(new Date());
    }
}

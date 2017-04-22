package edu.hzuapps.androidlabs.homeworks.net1414080903231activity;

import edu.hzuapps.androidlabs.homeworks.net1414080903231activity.Net1414080903231_time;
/**
 * Created by hzu on 2017/4/21.
 */

public class Net1414080903231_setting {
    private int clock_id;
    private  Net1414080903231_time clock_time;
    private String clock_name;
    private int clock_ringnum;
    private String clock_music;
    public void Net1414080903231_setting(int id,Net1414080903231_time time, String name,int ringnum,String music){
        clock_id=id;
        clock_time=time;
        clock_name=name;
        clock_ringnum=ringnum;
        clock_music=music;
    }
}
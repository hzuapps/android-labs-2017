package edu.hzuapps.androidlabs.homeworks.net1414080903231;

import edu.hzuapps.androidlabs.homeworks.net1414080903231.Net1414080903231Time;
/**
 * Created by ILEYINAN on 2017/4/27.
 */

public class Net1414080903231Setting {
    private int clock_id;
    private  Net1414080903231Time clock_time;
    private String clock_name;
    private int clock_ringnum;
    private String clock_music;
    public void Net1414080903231Setting(int id,Net1414080903231Time time, String name,int ringnum,String music){
        clock_id=id;
        clock_time=time;
        clock_name=name;
        clock_ringnum=ringnum;
        clock_music=music;
    }
}
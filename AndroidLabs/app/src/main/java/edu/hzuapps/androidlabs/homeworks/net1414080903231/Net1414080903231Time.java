package edu.hzuapps.androidlabs.homeworks.net1414080903231;

/**
 * Created by ILEYINAN on 2017/4/27.
 */

public class Net1414080903231Time {

    private int id;
    private int hour;
    private int minute;
    private String repeatCycle;
    private String ring;
    private int isShake;
    private String tag;

    public Net1414080903231Time(int i,int h,int m,String r,String ri,int is,String t) {
        id=i;
        hour=h;
        minute=m;
        repeatCycle=r;
        ring=ri;
        isShake=is;
        tag=t;
    }
    public int getId(){
        return id;
    }
    public int getHour(){ return hour;}
    public int getMinute(){return minute;}
    public String getRepeatCycle(){return repeatCycle;}
    public String ring(){return ring;}
    public int getIsShake(){return isShake;}
    public String getTag(){return tag;}

}

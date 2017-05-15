package edu.hzuapps.androidlabs.homework.net1414080903234;

/**
 * Created by admin on 2017/4/14.
 */

public class Outlay { //支出记录
    private double outlay; //支出金额
    private String usage; //用途
    private String out_date; //日期

    public Outlay(double out,String use, String date){
        outlay = out;
        usage = use;
        out_date = date;
    }
}

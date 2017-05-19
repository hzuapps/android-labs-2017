package edu.hzuapps.androidlabs.homework.net1414080903234;

/**
 * Created by admin on 2017/4/14.
 */

public class Income { //收入记录
    private String drawee; //付款人
    private double income;//收入金额
    private String in_date;//日期
    public void Income(String user,double in, String date){
        drawee = user;
        income = in;
        in_date = date;
    }
}

package edu.hzuapps.androidlabs.homework.net1414080903234;

/**
 * Created by admin on 2017/4/14.
 */

public class Income {
    private String drawee;
    private double income;
    private String in_date;
    public void Income(String user,double in, String date){
        drawee = user;
        income = in;
        in_date = date;
    }
}

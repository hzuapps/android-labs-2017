package edu.hzuapps.androidlabs.homework.net1414080903234;

import java.util.Date;

/**
 * Created by admin on 2017/4/14.
 */

public class Income { //收入记录

    private int id;
    private String payer; //付款人
    private double money;//收入金额
    private String date;//日期

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer;
    }

    public void Income(){
    }
}

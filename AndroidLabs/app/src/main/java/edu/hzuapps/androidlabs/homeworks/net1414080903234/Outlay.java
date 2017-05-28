package edu.hzuapps.androidlabs.homework.net1414080903234;

/**
 * Created by admin on 2017/4/14.
 */

public class Outlay { //支出记录
    private int id;
    private double money; //支出金额
    private String usage; //用途
    private String date; //日期


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }
    public Outlay(){
    }
}

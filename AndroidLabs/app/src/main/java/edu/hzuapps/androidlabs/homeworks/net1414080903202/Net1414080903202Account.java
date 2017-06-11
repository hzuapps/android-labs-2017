package edu.hzuapps.androidlabs.homeworks.net1414080903202;

/**
 * Created by Administrator on 2017/5/23.
 */

public class Net1414080903202Account {
    private String date;
    private Float input;
    private Float output;
    private String beizhu;
    private Float yingkui;
    private Float total;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Float getInput() {
        return input;
    }

    public void setInput(Float input) {
        this.input = input;
    }

    public Float getOutput() {
        return output;
    }

    public void setOutput(Float output) {
        this.output = output;
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }

    public Float getYingkui() {
        return yingkui;
    }

    public void setYingkui(Float yingkui) {
        this.yingkui = yingkui;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Net1414080903202Account(String date, Float input, Float output, String beizhu, Float yingkui, Float total) {
        super();
        this.date = date;
        this.input = input;
        this.output = output;
        this.beizhu = beizhu;
        this.yingkui = yingkui;
        this.total = total;
    }

    public Net1414080903202Account() {
        super();
    }

    @Override
    public String toString() {
        return "Net1414080903202Account{" +
                "date='" + date + '\'' +
                ", input=" + input +
                ", output=" + output +
                ", beizhu='" + beizhu + '\'' +
                ", yingkui=" + yingkui +
                ", total=" + total +
                '}';



    }
}

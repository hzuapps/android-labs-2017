package edu.hzuapps.androidlabs.homeworks.net1414080903106;

/**
 * Created by Administrator on 2017/5/25.
 */

public class Net1414080903106City {
    private String province;
    private String city;
    private String number;
    private String firstPY;
    private String allPY;
    private String allFirstPY;
    public Net1414080903106City(String province, String city, String number, String firstPY, String allPY, String allFirstPY){
        this.province=province;
        this.city=city;
        this.number=number;
        this.firstPY=firstPY;
        this.allPY=allPY;
        this.allFirstPY=allFirstPY;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getProvince() {
        return province;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setFirstPY(String firstPY) {
        this.firstPY = firstPY;
    }

    public String getFirstPY() {
        return firstPY;
    }

    public void setAllPY(String allPY) {
        this.allPY = allPY;
    }

    public String getAllPY() {
        return allPY;
    }

    public void setAllFirstPY(String allFirstPY) {
        this.allFirstPY = allFirstPY;
    }

    public String getAllFirstPY() {
        return allFirstPY;
    }
}

package edu.hzuapps.androidlabs.homeworks.net1414080903121;

/**
 * 作者：zgw on 2017/6/20 14:21
 * 邮箱：zhanmu123@163.com
 */

public class NewsInfo {
    private String iconPath;      //图片路径
    private String title;          //任务标题
    private String des;             //任务描述
    private int type;            //任务类型
    private long salary;            //任务酬金

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }
}

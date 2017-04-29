package edu.hzuapps.androidlabs.homeworks.net1414080903110;

/**
 * Created by Administrator on 2017/4/29 0029.
   作业信息类，主要包括id，名字和内容
 */

public class Work_Info {
    private String workid;
    private String workname;
    private String workcontent;
    public String getWorkname() {
        return workname;
    }

    public void setWorkname(String workname) {
        this.workname = workname;
    }

    public String getWorkid() {
        return workid;
    }

    public void setWorkid(String workid) {
        this.workid = workid;
    }

    public void setWorkcontent(String workcontent) {
        this.workcontent = workcontent;
    }


    public String getWorkcontent() {
        return workcontent;
    }

}
package edu.hzuapps.androidlabs.homeworks.net1414080903229;

/**
 * Created by Administrator on 2017-6-1.
 */

public class PlanInfo {
    private String event;
    private String time;
    private String content;

    public PlanInfo(){
        super();
    }

    public void setEvent(String event){
        this.event = event;
    }
    public String getEvent(){
        return event;
    }
    public void setTime(String time){
        this.time = time;
    }
    public String getTime(){
        return time;
    }
    public void setContent(String content){
        this.content = content;
    }
    public String getContent(){
        return  content;
    }


}

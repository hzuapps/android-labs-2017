package edu.hzuapps.androidlabs.homeworks.net1414080903212;

public class Assignment {  //布置作业相关内容
    private int id;
    private String homework_title;   //作业标题
    private String homework_content;    //作业内容
    private String submit_time;     //提交时间

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHomework_title() {
        return homework_title;
    }

    public void setHomework_title(String homework_title) {
        this.homework_title = homework_title;
    }

    public String getHomework_content() {
        return homework_content;
    }

    public String getSubmit_time() {
        return submit_time;
    }

    public void setSubmit_time(String submit_time) {
        this.submit_time = submit_time;
    }

    public void setHomework_content(String homework_content) {
        this.homework_content = homework_content;
    }

    public void Assignment() {
    }
}

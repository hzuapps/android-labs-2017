package edu.hzuapps.androidlabs.homeworks.net1414080903212;
import android.app.Activity;

public class Mark extends Activity  {   //批改作业相关内容
    private int idm;
    private String stuid; //学生学号
    private String homework_title;  //作业标题
    private String grade;   //成绩
    private String comment; //评语

    public int getIdm() {
        return idm;
    }

    public void setIdm(int idm) {
        this.idm = idm;
    }

    public String getHomework_title() {
        return homework_title;
    }

    public void setHomework_title(String homework_title) {
        this.homework_title = homework_title;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getStuid() {  return stuid;}

    public void setStuid(String stuid) {    this.stuid = stuid; }

}
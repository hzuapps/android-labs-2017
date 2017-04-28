package edu.hzuapps.androidlabs.homeworks.net1414080903116;

/**
 * Created by LZR on 2017/4/24.
 */

public class Comment {
    private String critic;
    private String param_content;
    private java.util.Date comment_time = new java.util.Date();
    public Comment(String critic,String param_content){
        this.critic=critic;
        this.param_content=param_content;
    }
}

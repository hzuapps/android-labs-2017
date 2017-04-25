package edu.hzuapps.androidlabs.homeworks.net1414080903116;

/**
 * Created by LZR on 2017/4/24.
 */

public class TextDynamic {
    private String promulgator;
    private String text_dynamic;
    private java.util.Date release_time = new java.util.Date();
    public void TextDynamic(String userid,String text_content){
        promulgator=userid;
        text_dynamic=text_content;
    }
}

package edu.hzuapps.androidlabs.homeworks.net1414080903116;

/**
 * Created by LZR on 2017/4/24.
 */

public class PictureDynamic {
    private String promulgator;
    private String picture_dynamic;
    private java.util.Date release_time = new java.util.Date();
    public void PictureDynamic(String userid,String picture_path){
        promulgator=userid;
        picture_dynamic=picture_path;
    }
}

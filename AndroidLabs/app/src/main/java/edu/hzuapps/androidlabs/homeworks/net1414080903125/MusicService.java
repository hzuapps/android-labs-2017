package edu.hzuapps.androidlabs.homeworks.net1414080903125;

import android.media.MediaPlayer;

/**
 * Created by Administrator on 2017/5/3.
 */

public class MusicService {
    private String[] musicDir = new String[]{
            "mnt/sdcard/也罢.mp3",
            "mnt/sdcard/对号入座.mp3",
            "mnt/sdcard/春风十里不及你.mp3",
            "mnt/sdcard/恋爱的犀牛.mp3"

    };
    private int musicNumber = 1;

    public MediaPlayer mp = new MediaPlayer();

    public MusicService(){
        try {
            musicNumber = 1;
            mp.setDataSource(musicDir[musicNumber]);
            System.out.println(musicDir[musicNumber]);
        }catch (Exception e){}


    }
}

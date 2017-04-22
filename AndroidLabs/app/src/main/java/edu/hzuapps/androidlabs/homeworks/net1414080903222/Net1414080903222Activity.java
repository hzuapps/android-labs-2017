package edu.hzuapps.androidlabs.homeworks.net1414080903222;

import android.graphics.PixelFormat;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ListView;

import java.io.File;

public class Net1414080903222Activity extends AppCompatActivity  {

    private Button btn_start, btn_stop;
    private ListView lv_content;
    private File sdcardfile = null;
    private String[] files;
    private MediaRecorder recorder = null;
    private File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFormat(PixelFormat.TRANSLUCENT);// 让界面横屏
        requestWindowFeature(Window.FEATURE_NO_TITLE);// 去掉界面标题
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // 重新设置界面大小
        setContentView(R.layout.activity_net1414080903222);
        initView();

    }

    /**
     * ① 实例化控件
     */
    private void initView() {
        btn_start = (Button) findViewById(R.id.Astart);
        btn_stop = (Button) findViewById(R.id.Astop);


    }


}

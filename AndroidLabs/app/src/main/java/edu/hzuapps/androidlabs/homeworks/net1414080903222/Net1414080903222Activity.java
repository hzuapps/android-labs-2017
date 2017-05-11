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

    private Button btn_start, btn_stop,btn_play;
    private File sdcardfile = null;
   // private String[] files;
    private MediaRecorder recorder = null;
    private File file;
    //文件路径
    private String filePath;
    //文件夹路径
    private File FolderPath;

     protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFormat(PixelFormat.TRANSLUCENT);// 让界面横屏
        requestWindowFeature(Window.FEATURE_NO_TITLE);// 去掉界面标题
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // 重新设置界面大小
        setContentView(R.layout.first_fragment1414080903222);
        initView();
        getSDCardFile();
    }


   
    /**
     * 实例化控件
     */
    private void initView() {
        btn_start = (Button) findViewById(R.id.Astart);
        btn_stop = (Button) findViewById(R.id.Astop);
 	btn_play= (Button) findViewById(R.id.Aplay);

 	//时间控件
        mImageView = (ImageView) findViewById(R.id.iv_recording_icon);
        mTextView = (TextView) findViewById(R.id.tv_recording_time);


        //给按钮添加监听事件
        btn_start.setOnClickListener(this);
        btn_stop.setOnClickListener(this);
 	btn_play.setOnClickListener(this);

        //设置起始状态开始按钮可用，停止按钮不可用
        btn_start.setEnabled(true);
        btn_stop.setEnabled(false);
        btn_play.setEnabled(false);

    }

    /**
     * 获取内存卡中文件的方法
     */
    private void getSDCardFile() {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {//内存卡存在
            sdcardfile = Environment.getExternalStorageDirectory();//获取目录文件

            Toast.makeText(this, "找到内存卡", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "未找到内存卡", Toast.LENGTH_SHORT).show();
        }
    }


}

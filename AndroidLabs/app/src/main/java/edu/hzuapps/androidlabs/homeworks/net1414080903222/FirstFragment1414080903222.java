package edu.hzuapps.androidlabs.homeworks.net1414080903222;

import android.app.Fragment;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;



public class FirstFragment1414080903222 extends Fragment

   private Button btn_start, btn_stop,btn_play;
    private File sdcardfile = null;
   // private String[] files;
    private MediaRecorder recorder = null;
    private File file;
    //文件路径
    private String filePath;
    //文件夹路径
    private File FolderPath;
    View view;


    private ImageView mImageView;
    private TextView mTextView;



    @Nullable

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.first_fragment1414080903222,container,false);
        initView();
        getSDCardFile();
        return view;
    }

    /**
     * ① 实例化控件
     */
    private void initView() {
        //录音按键
        btn_start = (Button) view.findViewById(R.id.Astart);
        btn_stop = (Button) view.findViewById(R.id.Astop);
        btn_play= (Button) view.findViewById(R.id.Aplay);

        //时间控件
        mImageView = (ImageView) view.findViewById(R.id.iv_recording_icon);
        mTextView = (TextView) view.findViewById(R.id.tv_recording_time);

        //⑤给按钮添加监听事件
        btn_start.setOnClickListener(this);
        btn_stop.setOnClickListener(this);
        btn_play.setOnClickListener(this);

        //设置起始状态开始按钮可用，停止按钮不可用
        btn_start.setEnabled(true);
        btn_stop.setEnabled(false);
        btn_play.setEnabled(false);
    }

    /**
     * ②获取内存卡中文件的方法
     */
    private void getSDCardFile() {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {//内存卡存在
            sdcardfile = Environment.getExternalStorageDirectory();//获取目录文件

      //      Toast.makeText(getActivity(), "找到内存卡", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), "未找到内存卡", Toast.LENGTH_SHORT).show();
        }
    }

 @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Astart:
                //⑧申请录制音频的动态权限
                if (ContextCompat.checkSelfPermission(getActivity(), android.Manifest.permission.RECORD_AUDIO)
                        != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(getActivity(), new String[]{
                            android.Manifest.permission.RECORD_AUDIO, android.Manifest.permission.WRITE_EXTERNAL_STORAGE},  1);
                } else {
                    startRecord();
                }
                break;
            case R.id.Astop:
                
                break;
            case R.id.Aplay:
                
                break;
        }
    }

	/**
     * 录音
     */
    private void startRecord() {

        if (recorder == null) {
            recorder = new MediaRecorder();
        }
        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);//设置音频源为手机麦克风
        recorder.setOutputFormat(MediaRecorder.OutputFormat.RAW_AMR);//设置输出格式
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);//设置音频编码为AMR格式
        //获取内存卡的根目录，创建临时文件
        try {

            // file = File.createTempFile("录音_", ".amr", this.getFilesDir());
            filePath = sdcardfile.getCanonicalPath().toString() + "/audio";
            File path = new File(filePath);
            if(!path.exists()) {
                path.mkdirs();
            }
            FolderPath =path ;
            file = File.createTempFile("录音_", ".amr", FolderPath);

            recorder.setOutputFile(file.getAbsolutePath());//设置文件输出路径
            //准备和启动录制音频
            recorder.prepare();
            recorder.start();
            startTime = System.currentTimeMillis();
            updateMicStatus();
            Toast.makeText(getActivity(), "录音中!", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Toast.makeText(getActivity(), "录音失败!", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
        //启动后交换两个按钮的可用状态
        btn_start.setEnabled(false);
        btn_stop.setEnabled(true);

    }
}




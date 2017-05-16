package edu.hzuapps.androidlabs.homeworks.net1414080903222;

import android.app.Fragment;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;



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



}




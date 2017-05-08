package edu.hzuapps.androidlab.Net1414080903118;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.administrator.video.R;

import java.io.File;

public class Net1414080903118PlayActivity extends AppCompatActivity {

    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903118_play);
        getSupportActionBar().hide();
        String path= getIntent().getStringExtra("path");
        videoView= (VideoView) findViewById(R.id.video);
        File file=new File(path);
        Log.d("path",file.getAbsolutePath());
        videoView.setVideoPath(file.getAbsolutePath());
        MediaController mediaController=new MediaController(this);
        mediaController.setMediaPlayer(videoView);
        videoView.setMediaController(mediaController);
        if(!videoView.isPlaying()){
            videoView.start();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(getRequestedOrientation()!= ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(videoView!=null){
            videoView.suspend();
        }
    }
}

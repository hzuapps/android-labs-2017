package edu.hzuapps.androidlabs.homeworks.net1414080903125;


import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.os.Environment;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import edu.hzuapps.androidlabs.R;

public class Net1414080903125Activity extends AppCompatActivity implements View.OnClickListener{

    private MusicService musicService;
    private SeekBar seekBar;
    private TextView name,singerName,musicTime;
    private ImageButton btnPlayOrPause,meun;
    private SimpleDateFormat time = new SimpleDateFormat("m:ss");



    private ServiceConnection sc = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            musicService = ((MusicService.MyBinder)iBinder).getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            musicService = null;
        }
    };

    private void bindServiceConnection() {
        Intent intent = new Intent(Net1414080903125Activity.this, MusicService.class);
        startService(intent);
        bindService(intent, sc, this.BIND_AUTO_CREATE);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903125);

        Log.d("hint", "ready to new MusicService");
        musicService = new MusicService();
        Log.d("hint", "finish to new MusicService");
        bindServiceConnection();

        seekBar = (SeekBar) this.findViewById(R.id.playSeekBar);
        seekBar.setProgress(musicService.mp.getCurrentPosition());
        seekBar.setMax(musicService.mp.getDuration());

        btnPlayOrPause = (ImageButton)findViewById(R.id.playOrStopMusic);
        meun = (ImageButton)findViewById(R.id.munu);
        musicTime = (TextView)findViewById(R.id.MusicTime);
        name = (TextView) findViewById(R.id.name);
        singerName = (TextView)findViewById((R.id.singerName));

        Log.d("hint", Environment.getExternalStorageDirectory().getAbsolutePath() + "/You.mp3");


    }

    public android.os.Handler handler = new android.os.Handler();
    public Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (musicService.mp.isPlaying()) {
                //musicStatus.setText(getResources().getString(R.string.playing));
                btnPlayOrPause.setBackground(getResources().getDrawable(R.drawable.stop_net1414080903125));
            } else {
                //musicStatus.setText(getResources().getString(R.string.pause));
                btnPlayOrPause.setBackground(getResources().getDrawable(R.drawable.play_net1414080903125));
            }
            switch (musicService.MusicNumberGet()){
                case 1:
                    name.setText(R.string.name_1);
                    singerName.setText(R.string.singer_1);
                    break;
                case 2:
                    name.setText(R.string.name_2);
                    singerName.setText(R.string.singer_2);
                    break;
                case 3:
                    name.setText(R.string.name_3);
                    singerName.setText(R.string.singer_3);
                    break;
                case 4:
                    name.setText(R.string.name_4);
                    singerName.setText(R.string.singer_4);
                    break;
                default:
                    break;
            }

            musicTime.setText(time.format(musicService.mp.getCurrentPosition()) + "/"
                    + time.format(musicService.mp.getDuration()));
            seekBar.setProgress(musicService.mp.getCurrentPosition());
            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    if (fromUser) {
                        musicService.mp.seekTo(seekBar.getProgress());
                    }
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });
            handler.postDelayed(runnable, 100);
        }
    };

    @Override
    protected void onResume() {
        if(musicService.mp.isPlaying()) {
            btnPlayOrPause.setBackground(getResources().getDrawable(R.drawable.stop_net1414080903125));
        } else {
            btnPlayOrPause.setBackground(getResources().getDrawable(R.drawable.play_net1414080903125));
        }

        seekBar.setProgress(musicService.mp.getCurrentPosition());
        seekBar.setMax(musicService.mp.getDuration());
        handler.post(runnable);
        super.onResume();
        Log.d("hint", "handler post runnable");
    }




    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.playOrStopMusic:
                musicService.playOrPause();
                break;
            case R.id.munu:
                Intent intent=new Intent(Net1414080903125Activity.this,Text_net1414080903125.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }



    @Override
    public void onDestroy() {
        unbindService(sc);
        super.onDestroy();
    }




  }



package edu.hzuapps.androidlabs.homeworks.net1414080903209;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Environment;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;


public  class Net1414080903209Activity extends AppCompatActivity implements View.OnClickListener {

    private String path;
    private Button btn_start;
    private EditText et_path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .detectDiskReads().detectDiskWrites().detectNetwork()
                .detectAll().penaltyLog().build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                .detectLeakedSqlLiteObjects().penaltyLog().penaltyDeath()
                .build());
        SharedPreferences shconfig = getSharedPreferences("ConFigShare",
                Context.MODE_PRIVATE);
        setContentView(R.layout.newtask);
        btn_start= (Button) findViewById(R.id.btn_start);
        et_path= (EditText) findViewById(R.id.et_path);
        btn_start.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btn_start:
                try {
                    String url = et_path.getText().toString();

                    String sdcardPath =  Environment.getExternalStorageDirectory().toString();
                    Log.i("System.out","sdcardPath:"+sdcardPath+",url:"+url);
                    DownLoad downLoad = new DownLoad(url, sdcardPath);
                    Log.i("System.out","sdcardPath:"+sdcardPath+",url:"+url);
                    Toast.makeText(this,"下载文件"+DownLoadThread.getFileName(url),Toast.LENGTH_LONG).show();
                    downLoad.Start();
                }catch (IOException ex){

                }
        }
    }


}

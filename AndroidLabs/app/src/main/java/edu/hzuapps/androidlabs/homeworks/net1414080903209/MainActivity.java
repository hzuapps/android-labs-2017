package edu.hzuapps.androidlabs.homeworks.net1414080903209;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private Intent intent;
    private int size;
    private boolean add;
    private String fileName;
    private String path;
    private int lastPostion;
    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903209);
        //控件
        LinearLayout ll_pb = (LinearLayout) findViewById(R.id.ll_pb);
        View view = View.inflate(getApplicationContext(), R.layout.progressbar, null);
        TextView tv_fileName = (TextView) findViewById(R.id.tv_fileName);
        TextView tv_fileSize = (TextView) findViewById(R.id.tv_fileSize);
        ProgressBar pb = (ProgressBar) findViewById(R.id.pb);


    }
}

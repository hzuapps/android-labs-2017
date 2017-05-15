package edu.hzuapps.androidlabs.homeworks.Net1414080903101;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Net1414080903101MasterActivity extends AppCompatActivity implements View.OnClickListener{

    TextView tv1;
    TextView tv2;
    TextView tv3;

    String a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903101_master);
        tv1= (TextView) findViewById(R.id.tv_master1);
        tv2= (TextView) findViewById(R.id.tv_master2);
        tv3= (TextView) findViewById(R.id.tv_master3);
        int type=getIntent().getIntExtra("type",1);
        switch (type){
            case 1:
                a="http://www.56.com/w99/play_album-aid-9172784_vid-NDczODQ3MDY.html";
                break;
            case 2:
                a="http://www.56.com/w99/play_album-aid-9172784_vid-NDczODQ3MDY.html";
                break;
            case 3:
                a="http://v.youku.com/v_show/id_XMTkwNTgxNzQw.html";
                break;
            case 4:
                a="http://pan.baidu.com/s/1eRYJe50";
                break;
            case 5:
                a="http://pan.baidu.com/s/1nv3CSNR";
                break;
            case 6:
                a="http://pan.baidu.com/s/1pKAKeJx";
                break;
            case 7:
                a="http://pan.baidu.com/s/1kVicqTD";
                break;
            case 8:
                a="http://pan.baidu.com/s/1i44kJf3";
                break;
        }
        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);
        tv3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(Net1414080903101MasterActivity.this,Net1414080903101ConnectActivity.class);
        intent.putExtra("connect",a);
        startActivity(intent);
    }
}

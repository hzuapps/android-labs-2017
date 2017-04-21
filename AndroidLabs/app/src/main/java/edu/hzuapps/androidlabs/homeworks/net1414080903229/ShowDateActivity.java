package edu.hzuapps.androidlabs.homeworks.net1414080903229;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class ShowDateActivity extends AppCompatActivity {
    private TextView tv_username,tv_password,tv_sex;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showdata_net1414080903229);
        //获取Intent对象
        Intent intent=getIntent();
        //取出Key对应的value值
        String username = intent.getStringExtra("name");
        String password = intent.getStringExtra("password");
        String sex = intent.getStringExtra("sex");
        tv_username = (TextView) findViewById(R.id.tv_username);
        tv_password = (TextView) findViewById(R.id.tv_password);
        tv_sex = (TextView) findViewById(R.id.tv_sex);
        tv_username.setText("用户名："+username);
        tv_password.setText("密  码：" +password);
        tv_sex.setText("性  别："+sex);
    }
}

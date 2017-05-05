package edu.hzuapps.androidlabs.homeworks.net1414080903122;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import edu.hzuapps.androidlabs.R;

public class Activity02 extends AppCompatActivity {
    private TextView tv_name,tv_password,tv_sex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_02);
        //获取intent对象
        Intent intent=getIntent();
        //取出参数
        String name=intent.getStringExtra("name");
        String password=intent.getStringExtra("password");
        String sex=intent.getStringExtra("sex");
        tv_name=(TextView)findViewById(R.id.tv_name);
        tv_password=(TextView)findViewById(R.id.tv_password);
        tv_sex=(TextView)findViewById(R.id.tv_sex);
        tv_name.setText("用户名："+ name);
        tv_password.setText("密码："+ password);
        tv_sex.setText("性别："+ sex);

    }
}

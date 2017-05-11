package edu.hzuapps.androidlabs.homeworks.net1414080903121;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import edu.hzuapps.androidlabs.R;

/**
 * Created by 1 on 2017/5/4.
 */

public class Net1414080903121Get extends AppCompatActivity {
    private TextView tv_name,tv_password,tv_sex;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903121get);
        //获取Intent对象
        Intent intent = getIntent();
        //取出key对应的value值
        String name = intent.getStringExtra("name");
        String password = intent.getStringExtra("password");
        String sex = intent.getStringExtra("sex");
        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_password = (TextView) findViewById(R.id.tv_password);
        tv_sex = (TextView) findViewById(R.id.tv_sex);
        tv_name.setText("用户名： " + name);
        tv_password.setText("密码： " + password);
        tv_sex.setText("性别： " + sex);
    }
}
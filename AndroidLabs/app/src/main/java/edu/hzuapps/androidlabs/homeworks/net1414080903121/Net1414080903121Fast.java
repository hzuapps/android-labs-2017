package edu.hzuapps.androidlabs.homeworks.net1414080903121;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Map;

import edu.hzuapps.androidlabs.R;

/**
 * 作者：zgw on 2017/6/17 16:14
 * 邮箱：zhanmu123@163.com
 */

public class Net1414080903121Fast extends Activity implements View.OnClickListener {
    private EditText etNumber;
    private EditText etPassword;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903121login);
        initView();

        //取出号码
        Map<String,String> userInfo=Utils.getUserInfo(this);
        if (userInfo!= null){
            //显示在界面
            etNumber.setText(userInfo.get("number"));
            etPassword.setText(userInfo.get("password"));
        }
    }
    private void initView(){
        etNumber = (EditText) findViewById(R.id.et_text);
        etPassword = (EditText) findViewById(R.id.et_password);
        findViewById(R.id.btn_login).setOnClickListener(this);
    }

    public void onClick(View v){
        //当单击登录时，获取QQ号码和密码
        String number = etNumber.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        //检查号码和密码是否正确
        if (TextUtils.isEmpty(number)){
            Toast.makeText(this,"请输入账号",Toast.LENGTH_SHORT).show();
            //return;
        }
        if (TextUtils.isEmpty(password)){
            Toast.makeText(this,"请输入密码",Toast.LENGTH_SHORT).show();
        }
        //登录成功
        Toast.makeText(this,"登录成功",Toast.LENGTH_SHORT).show();
        //如果正确，判断是否勾选记住密码
        Log.i("Net1414080903121Fast","记住密码:"+number+","+password);
        //保存用户信息
        boolean isSaveSuccess = Utils.saveUserInfo(this,number,password);
        if (isSaveSuccess){
            Toast.makeText(this,"保存成功",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this,"保存失败",Toast.LENGTH_SHORT).show();
        }

    }
}

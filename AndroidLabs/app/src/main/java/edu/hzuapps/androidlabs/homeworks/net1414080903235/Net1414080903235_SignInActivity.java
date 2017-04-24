package edu.hzuapps.androidlabs.homeworks.net1414080903235;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Map;

import Utils.Net1414080903235Utils;

public class Net1414080903235_SignInActivity extends Activity implements View.OnClickListener {
    private EditText etNumber;
    private EditText etPassword;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903235__signin);
        initView();
        Map<String, String> userInfo = Net1414080903235Utils.getUserInfo(this);
        if (userInfo != null) {
            etNumber.setText(userInfo.get("number"));
            etPassword.setText(userInfo.get("password"));
        }
    }

    private void initView(){
        etNumber=(EditText) findViewById(R.id.et_number);
        etPassword=(EditText) findViewById(R.id.et_password);
        findViewById(R.id.btn_login).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String number=etNumber.getText().toString().trim();
        String password=etPassword.getText().toString();
        if(TextUtils.isEmpty(number)){
            Toast.makeText(this,"请输入账号",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"请输入密码",Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
        Log.i("MainActivity","记住密码："+number+"，"+password);
        boolean isSaveSuccess=Net1414080903235Utils.saveUserInfo(this,number,password);
        if(isSaveSuccess){
            Toast.makeText(this, "保存成功", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "失败", Toast.LENGTH_SHORT).show();
        }
    }
}


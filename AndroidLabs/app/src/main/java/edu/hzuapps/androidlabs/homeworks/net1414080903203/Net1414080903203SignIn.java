package edu.hzuapps.androidlabs.homeworks.net1414080903203;
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
 * Created by Administrator on 2017/6/7 0007.
 */

public class Net1414080903203SignIn extends Activity implements OnClickListener {
   private EditText etNumber;
   private EditText etPassword;
   protected void onCreate(Bundle SavedInstanceState){
      super.onCreate(SavedInstanceState);
      setContentView(R.layout.activity_net1414080903203signIn);
      initview();
      //取出号码
      Map<String,String> userInfo= Net1414080903203Utils.getUserInfo(this);
      if(userInfo != null){
         //现实在上面
         etNumber.setText(userInfo.get("number"));
         etPassword.setText(userInfo.get("password"));
      }
   }

private void initview(){
   etNumber=(EditText)findViewById(R.id.et_number);
   etPassword=(EditText)findViewById(R.id.et_password);
}

public void onClick(View v) {
   //单点击“登录”按钮是，获取用户帐号和密码
   String number = etNumber.getText().toString().trim();
   String password = etPassword.getText().toString();
   //检测号码和密码是否正确
   if(TextUtils.isEmpty(number)){
      Toast.makeText(this,"请输入用户帐号",Toast.LENGTH_SHORT).show();
      return;
   }
   if(TextUtils.isEmpty(password)){
      Toast.makeText(this,"请输入密码",Toast.LENGTH_SHORT).show();
      return;
   }
   //登录成功
   Toast.makeText(this,"登录成功",Toast.LENGTH_SHORT).show();
   //如果正确，判断是否勾选了记住密码
   Log.i("Net1414080903203SignIn","记住密码"+number+","+password);
   //保存用户信息
   boolean isSaveSuccess=Net1414080903203Utils.saveUserInfo(this,number,password);
   if(isSaveSuccess){
      Toast.makeText(this,"保存成功",Toast.LENGTH_SHORT).show();
   }else{
      Toast.makeText(this,"保存失败",Toast.LENGTH_SHORT).show();
   }
}
}

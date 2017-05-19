package edu.hzuapps.androidlabs.homeworks.net1414080903201;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

/**
 * Created by hzu on 2017/5/8.
 */

public class Net1414080903201Activity01 extends Activity {
    private RadioButton manRadio;
    private  RadioButton womanRadio;
    private EditText et_password;
    private EditText et_name;
    private Button btn_send;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.net1414080903201_loginActivity);
        et_name=(EditText) findViewById(R.id.et_name);
        et_password=(EditText) findViewById(R.id.et_password);
        btn_send=(Button) findViewById(R.id.btn_send);
        manRadio=(RadioButton) findViewById(R.id.radioMale);
        womanRadio=(RadioButton) findViewById(R.id.radioFemale);
        btn_send=(Button) findViewById(R.id.btn_send);
        //点击提交用户信息按钮进行数据传递
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passDate();
            }
        });
    }
    //传递数据
    public void passDate(){
        //创建Intent对象，启动net1414080903201_loginActivity2
        Intent intent=new Intent(this,Activity01.class);
        //将数据存入Intent对象
        intent.putExtra("name",et_name.getText().toString().trim());
        intent.putExtra("password",et_password.getText().toString().trim());
        String str="";
        if(manRadio.isChecked()){
            str="男";
        }else if(womanRadio.isChecked()){
            str="女";
        }
        intent.putExtra("sex",str);
        startActivity(intent);
    }
}
}

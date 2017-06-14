package edu.hzuapps.androidlabs.homeworks.net1414080903202;

import android.accounts.Account;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

import edu.hzuapps.androidlabs.R;

public class Net1414080903202manage extends AppCompatActivity {
    private List<Net1414080903202Account> list;
    private EditText et_input;
    private EditText et_output;
    private EditText et_beizhu;
    private Button btn_tijiao;

    @SuppressLint("LongLogTag")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903202manage);
        //获取布局文件中的控件
        et_input=(EditText) findViewById(R.id.input);
        et_output=(EditText) findViewById(R.id.output);
        et_beizhu=(EditText) findViewById(R.id.beizhu);
        btn_tijiao=(Button) findViewById(R.id.tijiao);
        btn_tijiao.setOnClickListener(new ButtonListener());
    }

       //定义Button按钮的点击事件
    private class ButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View view){
            switch (view.getId()){
                case R.id.tijiao:
                    Net1414080903202AccountDao accountDao=new Net1414080903202AccountDao(Net1414080903202manage.this);
                    String date=getDate();
                    String input=et_input.getText().toString().trim();
                    String output=et_output.getText().toString().trim();
                    String beizhu=et_beizhu.getText().toString().trim();
                    String yingkui=String.valueOf(Float.parseFloat(input)-Float.parseFloat(output));
                    list=accountDao.queryAll();
                    Float total=0f;
                    if (list.size()>1)
                    { total=list.get(list.size()-1).getTotal();
                        total=total+Float.parseFloat(yingkui);
                    }
                    else {
                        total=Float.parseFloat(yingkui);
                    }

                    Net1414080903202Account account=new Net1414080903202Account(date,Float.parseFloat(input),Float.parseFloat(output),beizhu,Float.parseFloat(yingkui),total);
                    accountDao.insert(account);
                    finish();
                    Toast.makeText(Net1414080903202manage.this,"数据提交成功",Toast.LENGTH_SHORT).show();
                    break;
            }
        }

    }

    public  String getDate(){
        Date date=new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }


}

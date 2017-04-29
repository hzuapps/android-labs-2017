package edu.hzuapps.androidlabs.homeworks.net1414080903110;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import edu.hzuapps.androidlabs.R;

public class Net1414080903110_SubmitActivity extends AppCompatActivity {

     private EditText workname;
     private String i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903110_submit);
        Intent intent=getIntent();
        String work_name=intent.getStringExtra("workname");//获取WorkList活动传递过来的作业名
        i=intent.getStringExtra("i"); //获取WorkList活动传递过来的参数，用来判断登录的用户类型
        //Toast.makeText(Net1414080903110_SubmitActivity.this,i,Toast.LENGTH_SHORT).show();
        workname=(EditText)findViewById(R.id.work_info);
        workname.setText(work_name);//将作业名显示在TextView
        Button btn_s=(Button)findViewById(R.id.submit);
        btn_s.setVisibility(View.GONE);
        if("user".equals(i))
        {
            btn_s.setVisibility(View.GONE); //如果是学生用户就只显示作业内容
        }
        else
        {
            btn_s.setVisibility(View.VISIBLE);//如果是教师用户除了显示作业内容之外，还显示提交按钮，教师用户编辑作业内容之后点此按钮提交
        }

    }
}

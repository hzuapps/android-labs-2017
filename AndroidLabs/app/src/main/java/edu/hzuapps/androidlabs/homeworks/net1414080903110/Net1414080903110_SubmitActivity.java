package edu.hzuapps.androidlabs.homeworks.net1414080903110;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import edu.hzuapps.androidlabs.R;

public class Net1414080903110_SubmitActivity extends AppCompatActivity implements View.OnClickListener {

     private EditText workname;
     private EditText workconten;
     private ImageView submit;
     private String i;
     private WorkDatabaseHelper dbHelper;
     private String work_contents;
     private  String work_names;
     private String flag="false";
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903110_submit);
        dbHelper=new WorkDatabaseHelper(this,"Test.db",null,2);
        Intent intent=getIntent();
        String work_name=intent.getStringExtra("workname");//获取WorkList活动传递过来的作业名
        String workn=intent.getStringExtra("content");
        i=intent.getStringExtra("i"); //获取WorkList活动传递过来的参数，用来判断登录的用户类型
        workconten=(EditText)findViewById(R.id.add_content);
        workname=(EditText)findViewById(R.id.work_info);
        submit=(ImageView)findViewById(R.id.sub);
        submit.setOnClickListener(this);
        if(!"".equals(work_name)) {
            workname.setText(work_name);//将作业名显示在TextView
            if(!"".equals(workn))
            workconten.setText(workn); //显示作业内容
        }
        if("user".equals(i))
        {
            submit.setVisibility(View.GONE);//如果是学生用户就只显示作业内容
            workname.setFocusable(false);
            workconten.setFocusable(false);
        }
        else if("".equals(i))
        {
            submit.setVisibility(View.VISIBLE);//如果是教师用户除了显示作业内容之外，还显示提交按钮，教师用户编辑作业内容之后点此按钮提交
        }

    }
	
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.sub:
                work_names=workname.getText().toString().trim();
                work_contents=workconten.getText().toString().trim();
                insert(work_contents,work_names);// 插入作业名称，作业内容
                flag="true";
                Intent intent3=new Intent(this,Net1414080903110_WorkListActivity.class);
                intent3.putExtra("flag",flag);
                this.finish();
                startActivity(intent3);
        }

    }
	
   /*添加作业*/
    public void insert(String work_contentt,String work_namet){
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("workname",work_namet);
        values.put("workcontent",work_contentt);
        db.insert("work",null,values);
        Toast.makeText(this,"成功提交",Toast.LENGTH_SHORT).show();
        values.clear();
    }
}

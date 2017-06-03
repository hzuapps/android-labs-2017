package edu.hzuapps.androidlabs.homeworks.net1414080903135;

import android.content.ContentValues;
import android.webkit.WebView;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Net1414080903135AddObject extends AppCompatActivity implements View.OnClickListener {

    private EditText ccourse;
    private EditText cteacher;
    private EditText cperiod;
    private EditText ccredit;
    private EditText cclassroom;
    private WorkDatabaseHelper dbHelper;
    private String mcourse;
    private String mteacher;
    private String mperiod;
    private String mcredit;
    private String mclassroom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903135_add_object);
        dbHelper=new WorkDatabaseHelper(this,"Test.db",null,2);
        Button msubmit = (Button) findViewById(R.id.submit);
        msubmit.setOnClickListener(this);
        ccourse = (EditText) findViewById(R.id.vcourse);
        cteacher = (EditText) findViewById(R.id.vteacher);
        cperiod = (EditText) findViewById(R.id.vperiod);
        ccredit = (EditText) findViewById(R.id.vcredit);
        cclassroom = (EditText) findViewById(R.id.vclassroom);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.submit:
                mcourse = ccourse.getText().toString().trim();
                mteacher = cteacher.getText().toString().trim();
                mperiod = cperiod.getText().toString().trim();
                mcredit = ccredit.getText().toString().trim();
                mclassroom = cclassroom.getText().toString().trim();

                insert(mcourse,mteacher,mperiod,mcredit,mperiod);// 插入课程信息
                Intent intent3=new Intent(this,Net1414080903135AddObject.class);
                this.finish();
                startActivity(intent3);
			case R.id.send_request://点击按钮从github抓取json文件
                Intent intent4=new Intent(Net1414080903135AddObject.this,Net1414080903135_AnalysisJsonActivity.class);
                startActivity(intent4);
        }

    }

    public void insert(String mcourse,String mteacher,String mperiod,String mcredit,String mclassroom){
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("course",mcourse);
        values.put("teacher",mteacher);
        values.put("period",mperiod);
        values.put("credit",mcredit);
        values.put("classroom",mclassroom);
        db.insert("work",null,values);
        Toast.makeText(this,"成功提交课程",Toast.LENGTH_SHORT).show();
        values.clear();
    }
}

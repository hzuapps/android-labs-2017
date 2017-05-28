package edu.hzuapps.androidlabs.homeworks.net1414080903135;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Net1414080903135ChangeActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText ccourse;
    private EditText cteacher;
    private EditText cperiod;
    private EditText ccredit;
    private EditText cclassroom;
    private WorkDatabaseHelper dbHelper;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903135_change);
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
                String   mcourse = ccourse.getText().toString().trim();
                String   mteacher = cteacher.getText().toString().trim();
                String   mperiod = cperiod.getText().toString().trim();
                String   mcredit = ccredit.getText().toString().trim();
                String   mclassroom = cclassroom.getText().toString().trim();

                update(mcourse,mteacher,mperiod,mcredit,mclassroom);// 插入课程信息
                Intent intent3=new Intent(this,Net1414080903135AddObject.class);
                this.finish();
                startActivity(intent3);
        }

    }

    public void update(String mcourse,String mteacher,String mperiod,String mcredit,String mclassroom){
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("course",mcourse);
        values.put("teacher",mteacher);
        values.put("period",mperiod);
        values.put("credit",mcredit);
        values.put("classroom",mclassroom);
        db.update("work",values,"teacher=?",new String[]{mteacher});
//        int course=db.update("work",values,"period=?",new String[]{mperiod});
//        int course=db.update("work",values,"credit=?",new String[]{mcredit});
//        int course=db.update("work",values,"classroom=?",new String[]{mclassroom});
        Toast.makeText(this,"成功修改课程",Toast.LENGTH_SHORT).show();
        values.clear();
    }

}

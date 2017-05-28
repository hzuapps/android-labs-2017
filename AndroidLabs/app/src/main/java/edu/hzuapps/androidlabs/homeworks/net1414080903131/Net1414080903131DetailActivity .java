package edu.hzuapps.androidlabs.homeworks.net1414080903131;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.studentinfo.R;

public class Net1414080903131DetailActivity extends AppCompatActivity {

    TextView etName;
    TextView etId;
    TextView etClass;
    TextView etDormitory;
    TextView etSex;

    Button btDelete;
    Button btEdit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903131_detail);
        etName= (TextView) findViewById(R.id.tv_detail_name);
        etClass= (TextView) findViewById(R.id.tv_detail_class);
        etDormitory= (TextView) findViewById(R.id.tv_detail_dormitory);
        etId= (TextView) findViewById(R.id.tv_detail_id);
        etSex= (TextView) findViewById(R.id.tv_detail_sex);
        StudentBean bean=get(getIntent().getStringExtra("id"));
        if(bean!=null){
            etSex.setText(bean.getSex());
            etId.setText(bean.getId());
            etDormitory.setText(bean.getDormitory());
            etClass.setText(bean.getClazz());
            etName.setText(bean.getName());
        }

        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Net1414080903131MySQLiteOpenHelper helper=new Net1414080903131MySQLiteOpenHelper(Net1414080903131DetailActivity.this);
                SQLiteDatabase db=helper.getWritableDatabase();
                db.delete("student","id=?",new String[]{getIntent().getStringExtra("id")});
                db.close();
            }
        });
        btEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Net1414080903131DetailActivity.this,Net1414080903131EditActivity.class));
            }
        });
    }

    public StudentBean get(String id){
        StudentBean bean=null;
        Net1414080903131MySQLiteOpenHelper helper=new Net1414080903131MySQLiteOpenHelper(this);
        SQLiteDatabase db=helper.getReadableDatabase();
        Cursor cursor=db.query("student",null,null,null,null,null,null);
        while(cursor.moveToNext()){
            if(cursor.getString(cursor.getColumnIndex("id")).equals(id)){
                bean=new StudentBean();
                bean.setName(cursor.getString(cursor.getColumnIndex("name")));
                bean.setClazz(cursor.getString(cursor.getColumnIndex("clazz")));
                bean.setDormitory(cursor.getString(cursor.getColumnIndex("dormitory")));
                bean.setSex(cursor.getString(cursor.getColumnIndex("sex")));
            }
        }
        cursor.close();
        return bean;
    }
}

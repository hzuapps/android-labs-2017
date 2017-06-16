package edu.androidlabs.homeworks.Net1414080903113;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.administrator.studentjob.R;

public class Net1414080903113AddActivity extends AppCompatActivity {

    EditText etName;
    EditText etSalary;
    EditText etTime;
    EditText etLocation;

    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903113_add);
        etName= (EditText) findViewById(R.id.et_name);
        etSalary= (EditText) findViewById(R.id.et_salary);
        etTime= (EditText) findViewById(R.id.et_time);
        etLocation= (EditText) findViewById(R.id.et_location);
        bt= (Button) findViewById(R.id.bt_submit);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Net1414080903113JobInfo net1414080903113JobInfo =new Net1414080903113JobInfo();
                net1414080903113JobInfo.setName(etName.getText().toString());
                net1414080903113JobInfo.setLocation(etLocation.getText().toString());
                net1414080903113JobInfo.setOccurTime(etTime.getText().toString());
                net1414080903113JobInfo.setSalary(etSalary.getText().toString());
                save(net1414080903113JobInfo);
            }
        });

    }

    public void save(Net1414080903113JobInfo bean){
        SQLiteOpenHelper helper=new Net1414080903113MySQLiteOpenHelper(this);
        SQLiteDatabase db=helper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("name",bean.getName());
        values.put("salary",bean.getSalary());
        values.put("time",bean.getOccurTime());
        values.put("location",bean.getLocation());
        db.insert("job",null,values);
        db.close();
    }
}

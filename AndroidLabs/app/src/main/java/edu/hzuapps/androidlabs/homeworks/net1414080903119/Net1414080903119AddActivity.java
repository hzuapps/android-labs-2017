package edu.hzuapps.androidlabs.homeworks.net1414080903119;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.administrator.linjingzhen.R;

public class Net1414080903119AddActivity extends AppCompatActivity {

    EditText etName;
    EditText etSchool;
    EditText etAge;
    EditText etHours;

    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903119_add);
        etName= (EditText) findViewById(R.id.et_add_name);
        etAge= (EditText) findViewById(R.id.et_add_age);
        etHours= (EditText) findViewById(R.id.et_add_hours);
        etSchool= (EditText) findViewById(R.id.et_add_school);
        bt= (Button) findViewById(R.id.bt_add);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Teacher teacher=new Teacher();
                teacher.setSchool(etSchool.getText().toString());
                teacher.setHours(etHours.getText().toString());
                teacher.setAge(etAge.getText().toString());
                teacher.setName(etName.getText().toString());
                Net1414080903119Presenter.getInstance(Net1414080903119AddActivity.this).addTeacher(teacher);
            }
        });
    }
}

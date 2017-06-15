package edu.hzuapps.androidlabs.net1414080903109;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.administrator.maminjian.R;

/**
 * Created by Administrator on 2017/6/3.
 */

public class Net1414080903109AddActivity extends AppCompatActivity {

    EditText etName;
    EditText etOccur;

    Button bt;

    @Override
 /*添加节假日 后期添加功能*/
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903109_add);
        etName= (EditText) findViewById(R.id.et_add_name);
        etOccur= (EditText) findViewById(R.id.et_add_age);
        bt= (Button) findViewById(R.id.bt_add);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Net1414080903109DayBean day=new Net1414080903109DayBean();
                day.setName(etName.getText().toString());
                day.setOccur(etOccur.getText().toString());
            }
        });
    }
}

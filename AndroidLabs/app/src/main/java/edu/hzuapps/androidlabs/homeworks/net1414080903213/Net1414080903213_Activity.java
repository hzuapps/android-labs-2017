package edu.hzuapps.androidlabs.homeworks.net1414080903213;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


/**
 * Created by 刘泽钊 on 2017/4/21.
 */

public class Net1414080903213_Activity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903213);

        Button b1 = (Button) findViewById(R.id.button1);
        Button b2 = (Button) findViewById(R.id.button2);
        Button b3 = (Button) findViewById(R.id.button3);
        //跳转到日程安排界面
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Net1414080903213_Activity.this,Net1414080903213_Schedule.class);
                startActivity(intent);
            }
        });
        //跳转到日历界面
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Net1414080903213_Activity.this,Net1414080903213_Calendar.class);
                startActivity(intent);
            }
        });
        //跳转到笔记本界面
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Net1414080903213_Activity.this,Net1414080903213_Note.class);
                startActivity(intent);
            }
        });


        }
}




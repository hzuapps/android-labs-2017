package edu.hzuapps.androidlabs.homeworks.Net1414080903101;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Net1414080903101MainActivity extends AppCompatActivity {

    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4;
    TextView tv5;
    TextView tv6;
    TextView tv7;
    TextView tv8;
    Button send; 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903101_main);
        tv1= (TextView) findViewById(R.id.tv1);
        tv2= (TextView) findViewById(R.id.tv2);
        tv3= (TextView) findViewById(R.id.tv3);
        tv4= (TextView) findViewById(R.id.tv4);
        tv5= (TextView) findViewById(R.id.tv5);
        tv6= (TextView) findViewById(R.id.tv6);
        tv7= (TextView) findViewById(R.id.tv7);
        tv8= (TextView) findViewById(R.id.tv8);
		send=(Button)findViewById(R.id.send_request);

        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Net1414080903101MainActivity.this,Net1414080903101MasterActivity.class);
                intent.putExtra("type",1);
                startActivity(intent);
            }
        });
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Net1414080903101MainActivity.this,Net1414080903101MasterActivity.class);
                intent.putExtra("type",2);
                startActivity(intent);
            }
        });
        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Net1414080903101MainActivity.this,Net1414080903101MasterActivity.class);
                intent.putExtra("type",3);
                startActivity(intent);
            }
        });
        tv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Net1414080903101MainActivity.this,Net1414080903101MasterActivity.class);
                intent.putExtra("type",4);
                startActivity(intent);
            }
        });
        tv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Net1414080903101MainActivity.this,Net1414080903101MasterActivity.class);
                intent.putExtra("type",5);
                startActivity(intent);
            }
        });
        tv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Net1414080903101MainActivity.this,Net1414080903101MasterActivity.class);
                intent.putExtra("type",6);
                startActivity(intent);
            }
        });
        tv7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Net1414080903101MainActivity.this,Net1414080903101MasterActivity.class);
                intent.putExtra("type",7);
                startActivity(intent);
            }
        });
        tv8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Net1414080903101MainActivity.this,Net1414080903101MasterActivity.class);
                intent.putExtra("type",8);
                startActivity(intent);
            }
        });
		/*点击按钮解析到github解析json文件*/
		 send_request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Net1414080903101MainActivity.this,Net1414080903101JsonActivity.class);
                intent.putExtra("type",8);
                startActivity(intent);
            }
        });
    }
}

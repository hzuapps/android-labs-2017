package edu.androidlabs.homeworks.Net1414080903113;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.administrator.studentjob.R;

public class Net1414080903113MainActivity extends AppCompatActivity {


    Button btJson;
    Button btAdd;
    Button btQuery;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903113_main);
        btAdd= (Button) findViewById(R.id.bt_add);
        btJson= (Button) findViewById(R.id.bt_json);
        btQuery= (Button) findViewById(R.id.bt_query);
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Intent(Net1414080903113MainActivity.this,Net1414080903113AddActivity.class);
            }
        });
        btQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Intent(Net1414080903113MainActivity.this,Net1414080903113ListInfoActivity.class);
            }
        });
        btJson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Intent(Net1414080903113MainActivity.this,Net1414080903113ShowJsonActivity.class);
            }
        });
    }
}

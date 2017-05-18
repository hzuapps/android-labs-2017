package edu.hzuapps.androidlabs.homeworks.net1414080903140;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Net1414080903140MainActivity extends AppCompatActivity {

    Button btStart;
    Button btRecord;
    Button btHighest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903140_main);
        btStart= (Button) findViewById(R.id.bt_main_start);
        btRecord= (Button) findViewById(R.id.bt_main_record);
        btHighest= (Button) findViewById(R.id.bt_main_highest);

        btStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Net1414080903140MainActivity.this,Net1414080903140GameActivity.class));
            }
        });

        btRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Net1414080903140MainActivity.this,Net1414080903140RecordActivity.class));
            }
        });

        btHighest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}

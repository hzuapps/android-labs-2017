package edu.hzuapps.andridlabs.homeworks.net1414080903139;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.hzuapps.myapplication.R;

public class Net1414080903139MainActivity extends AppCompatActivity {

    Button btRecord;
    Button btCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.net1414080903139activity01);
        btRecord= (Button) findViewById(R.id.bt_record_birthday);
        btCheck= (Button) findViewById(R.id.bt_check_birthday);

        btCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Net1414080903139MainActivity.this,Net1414080903139CheckActivity.class));
            }
        });

        btRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Net1414080903139MainActivity.this,Net1414080903139AddRecordActivity.class));
            }
        });
    }
}
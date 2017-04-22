package edu.hzuapps.androidlabs.homeworks.net1414080903240;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Net1414080903240Activity extends AppCompatActivity {
    private Button btn_send1;
    private Button btn_send2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_1414080903240);


        btn_send1 = (Button) findViewById(R.id.button1);
        btn_send2 = (Button) findViewById(R.id.button2);
        btn_send1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Net1414080903240Activity.this,Net1414080903240_NewAccount.class);
                startActivity(intent);
            }
        });

        btn_send2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Net1414080903240Activity.this,Net1414080903240_OrderRecord.class);
                startActivity(intent);
            }
        });
    }



}

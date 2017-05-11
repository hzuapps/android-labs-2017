package edu.hzuapps.androidlabs.homeworks.net1414080903117;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.hzuapps.androidlabs.R;

public class Net1414080903117MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903117_menu);

        Button shuidianfei = (Button)findViewById(R.id.shuidianfei);
        Button kanjilu = (Button)findViewById(R.id.kanjilu);

        shuidianfei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        kanjilu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}

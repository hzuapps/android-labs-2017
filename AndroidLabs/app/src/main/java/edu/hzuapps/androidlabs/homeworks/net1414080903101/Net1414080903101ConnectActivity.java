package edu.hzuapps.androidlabs.homeworks.Net1414080903101;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Net1414080903101ConnectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903101_connect);
        String a =getIntent().getStringExtra("connect");
        TextView tv= (TextView) findViewById(R.id.tv_connect);
        tv.setText(a);
    }
}

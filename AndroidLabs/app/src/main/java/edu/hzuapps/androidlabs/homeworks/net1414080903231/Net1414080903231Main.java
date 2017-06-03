package edu.hzuapps.androidlabs.homeworks.net1414080903231;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Net1414080903231Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903231_main);
    }
    public void click_clock(View view) {
        Intent intent = new Intent(this, Net1414080903231Clock.class);
        startActivity(intent);
    }

    public void click_sleep(View view) {
        Intent intent = new Intent(this, Net1414080903231Sleep.class);
        startActivity(intent);
    }
}

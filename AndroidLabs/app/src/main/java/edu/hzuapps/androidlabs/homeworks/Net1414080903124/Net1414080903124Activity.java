package edu.hzuapps.androidlabs.homeworks.net1414080903124;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import edu.hzuapps.androidlabs.R;

public class Net1414080903124Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903124);
    }
    public void click1(View view) {
        Intent intent = new Intent(this, Activity02.class);
        startActivity(intent);
    }
    public void click2(View view) {
        Intent intent = new Intent(this, Activity03.class);
        startActivity(intent);
    }
    public void click3(View view) {
        Intent intent = new Intent(this, Activity04.class);
        startActivity(intent);
    }
}


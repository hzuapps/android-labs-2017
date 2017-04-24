package edu.hzuapps.androidlabs.homeworks.net1414080903114;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void clickDisk(View view){
        Intent intent = new Intent(this, DiskActivity.class);
        startActivity(intent);
    }
    public void clickNetwork(View view){
        Intent intent = new Intent(this, NetworkActivity.class);
        startActivity(intent);
    }
}
    

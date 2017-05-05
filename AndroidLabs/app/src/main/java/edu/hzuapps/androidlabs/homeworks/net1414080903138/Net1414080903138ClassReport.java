package edu.hzuapps.androidlabs.homeworks.net1414080903138;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.hzuapps.androidlabs.R;

public class Net1414080903138ClassReport extends AppCompatActivity {

    Button rep_return;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903138_class_report);
        rep_return = (Button)findViewById(R.id.Classreport_But);
    }
    //返回主页面
    public void onClick(View v) {
        if (v.getId() == R.id.report_return) {
            Intent intent = new Intent(this, Net1414080903138Activity.class);
        }
    }
}

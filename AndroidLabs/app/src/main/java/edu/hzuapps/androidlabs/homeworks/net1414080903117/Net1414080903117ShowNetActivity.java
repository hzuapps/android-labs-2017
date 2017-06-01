package edu.hzuapps.androidlabs.homeworks.net1414080903117;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import edu.hzuapps.androidlabs.R;

public class Net1414080903117ShowNetActivity extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903117_show_net);
        tv= (TextView) findViewById(R.id.tv_show_net);
        tv.setText(getIntent().getStringExtra("net"));
    }
}

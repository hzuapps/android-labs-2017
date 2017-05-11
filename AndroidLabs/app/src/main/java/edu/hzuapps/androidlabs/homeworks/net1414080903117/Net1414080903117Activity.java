package edu.hzuapps.androidlabs.homeworks.net1414080903117;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import edu.hzuapps.androidlabs.R;

public class Net1414080903117Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903117);

        EditText dianfei = (EditText)findViewById(R.id.dianfei);
        String dian = dianfei.getText().toString();

        EditText shuifei = (EditText)findViewById(R.id.shuifei);
        String shui = shuifei.getText().toString();
    }
}

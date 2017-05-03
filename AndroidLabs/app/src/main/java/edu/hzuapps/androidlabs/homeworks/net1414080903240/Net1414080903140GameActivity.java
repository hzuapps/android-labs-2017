package edu.hzuapps.androidlabs.homeworks.net1414080903140;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.administrator.wangzhe.R;

public class Net1414080903140GameActivity extends AppCompatActivity {

    CheckBox cbSingle;
    CheckBox cbDouble;

    Button btStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903140_game);
        cbSingle= (CheckBox) findViewById(R.id.cb_single);
        cbDouble= (CheckBox) findViewById(R.id.cb_double);

        btStart= (Button) findViewById(R.id.bt_start_game);

        btStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void Start(){

    }
}

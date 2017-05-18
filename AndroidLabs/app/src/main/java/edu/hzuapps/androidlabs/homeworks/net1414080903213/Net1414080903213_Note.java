package edu.hzuapps.androidlabs.homeworks.net1414080903213;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by 刘泽钊 on 2017/4/16.
 */

public class Net1414080903213_Note extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_net1414080903213);
        Button b4 = (Button) findViewById(R.id.note_save);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
    }
}
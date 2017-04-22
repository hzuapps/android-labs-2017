package edu.hzuapps.androidlabs.homeworks.net1414080903224;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Net1414080903224Internet extends AppCompatActivity {
    private Button b_history;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903224_internet);
        b_history = (Button) findViewById(R.id.button1);
    }
        public  void onClick (View v) {
            switch ( v.getId()){
                case R.id.button1:
                    Intent intent = new Intent(this,N1414080903224history.class);
                    startActivity(intent);
                    break;
            }
            switch ( v.getId()){
                case R.id.button:
                    Intent intent = new Intent(this,N1414080903224page.class);
                    startActivity(intent);
                    break;
            }
        }
    }


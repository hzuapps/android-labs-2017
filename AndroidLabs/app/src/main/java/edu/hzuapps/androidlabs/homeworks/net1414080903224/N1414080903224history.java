package edu.hzuapps.androidlabs.homeworks.net1414080903224;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class N1414080903224history extends AppCompatActivity {
private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n1414080903224history);
        button= (Button) findViewById(R.id.button2);
    }
    public  void onClick (View v) {
        switch ( v.getId()){
            case R.id.button2:
                Intent intent = new Intent(this,Net1414080903224Internet.class);
                startActivity(intent);
                break;
        }
    }
}

package edu.hzuapp.androidlabs.homworks.net1414080903126;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.hzuapp.androidlabs.R;

public class Act2 extends AppCompatActivity {
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act2);
        btn=(Button) findViewById(R.id.btn);
    }
    public void click(View view) {
        switch (view.getId()) {
            case R.id.btn:
                Intent intent = new Intent(this, initialAct1.class);
                startActivity(intent);
                break;
        }
    }
}
package edu.hzuapp.androidlabs.homeworks.net1414080903135;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import edu.hzuapp.androidlabs.R;

public class Net1414080903135AdminActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903135_admin);
        Button button = (Button) findViewById(R.id.add);
        button.setOnClickListener(this);
        Button change1 = (Button) findViewById(R.id.change);
        change1.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add:
				/*跳转添加课表*/
                    Intent intent = new Intent(this,Net1414080903135AddObject.class);
                    startActivity(intent);
                /*跳转修改课表*/
           case R.id.change:
               Intent intento = new Intent(this,Net1414080903135ChangeActivity.class);
               startActivity(intento);
        }
    }
}

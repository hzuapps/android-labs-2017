package edu.hzuapps.androidlabs.homeworks.net1414080903130;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import edu.hzuapps.androidlabs.R;

public class Net1414080903130LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903130_login);


        Button b = (Button)findViewById(R.id.login_register);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Net1414080903130LoginActivity.this,Net1414080903130EnrollActivity.class);
                startActivity(intent);
            }
        });

        Button a = (Button) findViewById(R.id.login_login);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText name = (EditText) findViewById(R.id.login_username);//提取数据
                final EditText password = (EditText) findViewById(R.id.login_userpassword);
                String str_name = name.getText().toString();
                String str_password = password.getText().toString();
                //判断语句
                Log.d("LoginActivity", str_name);
                Log.d("LoginActivity", str_password);
                if ("guke".equals(str_name) && "123".equals(str_password)) {
                    Intent intent = new Intent(Net1414080903130LoginActivity.this, Net1414080903130CustomerActivity.class);
                    startActivity(intent);
                } else if ("yuangong".equals(str_name) && "123".equals(str_password)) {
                    Intent intent = new Intent(Net1414080903130LoginActivity.this, Net1414080903130EmployeesActivity.class);
                    startActivity(intent);
                }

            }
        });
    }

}




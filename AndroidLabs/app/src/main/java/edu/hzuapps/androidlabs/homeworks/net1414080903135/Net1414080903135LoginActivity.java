package edu.hzuapps.androidlabs.homeworks.net1414080903135;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Net1414080903135LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText uname;
    private EditText psword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903135_login);
        Button button = (Button) findViewById(R.id.login);
        button.setOnClickListener(this);
        uname = (EditText) findViewById(R.id.username);
        psword = (EditText) findViewById(R.id.password);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                String name = uname.getText().toString().trim();
                String password = psword.getText().toString().trim();
				/*管理员用户*/
                if ("LittleUncle".equals(name) && "12345".equals(password)) {
                    Intent intent = new Intent(this, Net1414080903135AdminActivity.class);
                    intent.putExtra("username", name);
                    intent.putExtra("password", password); /*将用户名和密码通过Intent传递给下一个活动*/
                    startActivity(intent);
					/*学生用户*/
                } else if ("student".equals(name) && "54321".equals(password)) {
                    Intent intent = new Intent(this, Net1414080903135SelectActivity.class);
                    intent.putExtra("username", name);
                    intent.putExtra("password", password); /*将用户名和密码通过Intent传递给下一个活动*/
                    startActivity(intent);
                } else {

                }
        }
    }
}

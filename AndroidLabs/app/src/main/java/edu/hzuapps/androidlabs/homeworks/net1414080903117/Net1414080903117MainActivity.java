package edu.hzuapps.androidlabs.homeworks.net1414080903117;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import edu.hzuapps.androidlabs.R;

public class Net1414080903117MainActivity extends AppCompatActivity {


    EditText etUsername;
    EditText etPassword;

    Button btLogin;

    Button btNetWork;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903117_main);

        etUsername = (EditText) findViewById(R.id.et_main_username);
        etPassword = (EditText) findViewById(R.id.et_main_password);

        btLogin = (Button) findViewById(R.id.bt_login);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                if (check(username, password)) {
                    startActivity(new Intent(Net1414080903117MainActivity.this, Net1414080903117MenuActivity.class));
                } else {
                    Toast.makeText(Net1414080903117MainActivity.this, "账号/密码错误！！", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


    public boolean check(String username, String password) {
        if (username.equals("linjianchao") && password.equals("123"))
            return true;
        return false;
    }
}

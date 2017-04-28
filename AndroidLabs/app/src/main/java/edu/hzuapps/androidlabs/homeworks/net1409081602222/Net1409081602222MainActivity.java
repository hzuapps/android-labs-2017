package edu.hzuapps.androidlabs.homeworks.net1409081602222;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.luyoucong.R;

public class Net1409081602222MainActivity extends AppCompatActivity {

    EditText etUsername;
    EditText etPassword;
    
    Button btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_net1409081602222);

        etUsername = (EditText) findViewById(R.id.et_username);
        etPassword = (EditText) findViewById(R.id.et_password);

        btLogin = (Button) findViewById(R.id.bt_login);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                if (check(username, password)) {
                    startActivity(new Intent(Net1409081602222MainActivity.this, Net1409081602222MenuActivity.class));
                } else {
                    Toast.makeText(Net1409081602222MainActivity.this, "账号/密码错误！！", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


    public boolean check(String username, String password) {
        if (username.equals("pengliangjun") && password.equals("123"))
            return true;
        return false;
    }

}

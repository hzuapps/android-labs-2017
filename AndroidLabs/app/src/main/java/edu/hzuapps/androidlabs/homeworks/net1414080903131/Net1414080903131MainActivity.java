package edu.hzuapps.androidlab.net1414080903131;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.administrator.studentinfo.R;

public class Net1414080903131MainActivity extends AppCompatActivity {


    Button btLogin;
    Button btRegister;

    EditText etUsername;
    EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903131_main);
        btLogin= (Button) findViewById(R.id.bt_login);
        btRegister= (Button) findViewById(R.id.bt_register);

        etUsername= (EditText) findViewById(R.id.et_id);
        etPassword= (EditText) findViewById(R.id.et_password);

        String username=etUsername.getText().toString();
        String password=etPassword.getText().toString();





    }
}

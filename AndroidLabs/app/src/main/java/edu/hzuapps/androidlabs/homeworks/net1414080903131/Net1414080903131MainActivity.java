package edu.hzuapps.androidlabs.homeworks.net1414080903131;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.administrator.studentinfo.R;

public class Net1414080903131MainActivity extends AppCompatActivity {


    Button btLogin;
    Button btRegister;
    Button btJson;

    EditText etUsername;
    EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903131_main);
        btLogin= (Button) findViewById(R.id.bt_login);
        btRegister= (Button) findViewById(R.id.bt_register);
        btJson= (Button) findViewById(R.id.bt_json);

        etUsername= (EditText) findViewById(R.id.et_id);
        etPassword= (EditText) findViewById(R.id.et_password);

        String username=etUsername.getText().toString();
        String password=etPassword.getText().toString();
        if (check(username,password)){
            startActivity(new Intent(Net1414080903131MainActivity.this,Net1414080903131MenuActivity.class));
        }

        btJson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Net1414080903131MainActivity.this,Net1414080903131ShowJsonActivity.class));
            }
        });


    }

    public boolean check(String name,String password){
        if (name.equals("linzihong")&&password.equals("123456")){
            return true;
        }return false;
    }
}

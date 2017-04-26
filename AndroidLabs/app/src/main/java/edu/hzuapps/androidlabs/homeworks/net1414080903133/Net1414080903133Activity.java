package edu.hzuapps.androidlabs.homeworks.net1414080903133;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import edu.hzuapps.androidlabs.R;

public class Net1414080903133Activity extends AppCompatActivity {
    private EditText et_password;
    private Button btn_login;
    private EditText et_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903133);
        et_name=(EditText) findViewById(R.id.et_name);
        et_password=(EditText) findViewById(R.id.et_password);
        btn_login=(Button) findViewById(R.id.btn_login);
        String username=et_name.getText().toString();
        String password=et_password.getText().toString();

    }
}


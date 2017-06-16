package edu.hzuapps.androidlabs.homeworks.net1412070501227;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import edu.hzuapps.androidlabs.R;


public class Net1412070501227login extends AppCompatActivity {
	private EditText username;
	private EditText password;
	private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1412070501227_login);

        username = (EditText)findViewById(R.id.editText);
        password = (EditText)findViewById(R.id.editText2);
        login = (Button)findViewById(R.id.button);

        login.setOnClickListener(new View.OnClickListener(){
        	@Override
        	public void onClick(View v){
        		String name = username.getText().toString();
        		String pwd = password.getText().toString();

        		if("livehan".equals(name) 
        			&& "liweihan1".equals(pwd)){
        			Intent intent = new Intent(Net1412070501227login.this,Net1412070501227index.class);
        			startActivity(intent);
        		}else{
        			Toast.makeText(Net1412070501227login.this,"账号或密码错误",
        				Toast.LENGTH_SHORT).show();
        		}
        	}
        });
    }
}

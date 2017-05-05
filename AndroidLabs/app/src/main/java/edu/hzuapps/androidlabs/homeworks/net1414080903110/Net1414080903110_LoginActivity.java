
package edu.hzuapps.androidlabs.homeworks.net1414080903110;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import edu.hzuapps.androidlabs.R;

/*
用户登录（设置了两个用户user、zzj,分别对应学生和教师，各自有不同的权限，权限在Net1414080903110_SubmitActivity和Net1414080903110_WorkListActivity进行限制）
*/
public class Net1414080903110_LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText uname;
    private EditText psword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903110_login);
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
				/*教师用户*/
                if ("zzj".equals(name) && "12345".equals(password)) {
                    Intent intent = new Intent(Net1414080903110_LoginActivity.this, Net1414080903110_WorkListActivity.class);
                    intent.putExtra("username", name);
                    intent.putExtra("password", password); /*将用户名和密码通过Intent传递给下一个活动*/
                    startActivity(intent);
					/*学生用户*/
                } else if ("user".equals(name) && "54321".equals(password)) {
                    Intent intent = new Intent(Net1414080903110_LoginActivity.this, Net1414080903110_WorkListActivity.class);
                    intent.putExtra("username", name);
                    intent.putExtra("password", password); /*将用户名和密码通过Intent传递给下一个活动*/
                    startActivity(intent);
                } else {

                }
        }
    }
}

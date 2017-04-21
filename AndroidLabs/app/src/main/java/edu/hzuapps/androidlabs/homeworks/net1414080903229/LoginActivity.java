package edu.hzuapps.androidlabs.homeworks.net1414080903229;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText et_username;
    private EditText et_password;
    private Button btn_login;
    private RadioButton manRadio;
    private RadioButton womanRadio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_net1414080903229);
        et_username = (EditText) findViewById(R.id.et_username);
        et_password = (EditText) findViewById(R.id.et_password);
        manRadio = (RadioButton) findViewById(R.id.manRadio);
        womanRadio = (RadioButton) findViewById(R.id.womanRadio);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = et_username.getText().toString();
                String password = et_password.getText().toString();
                if (username == null || username.equals("")) {
                    Toast.makeText(getApplicationContext(), "账号不为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (password == null || username.equals("")) {
                    Toast.makeText(getApplicationContext(), "密码不为空", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    Toast.makeText(getApplicationContext(), "登陆成功", Toast.LENGTH_SHORT).show();
                    passDate();
                }
                /*
                if (username.equals("mxj") && password.equals("147258")) {
                    Toast.makeText(getApplicationContext(), "登陆成功", Toast.LENGTH_SHORT).show();
                    passDate();
                }
                else {
                    Toast.makeText(getApplicationContext(), "账号或密码错误", Toast.LENGTH_SHORT).show();
                }
                */
            }
        });
    }

    public void passDate() {
        //创建Intent对象，启动Ativity_afterlogin
        Intent intent = new Intent(this, ShowDateActivity.class);
        //将数据存入Intent对象
        intent.putExtra("name", et_username.getText().toString().trim());
        intent.putExtra("password", et_password.getText().toString().trim());
        String str = "";
        if (manRadio.isChecked()) {
            str = "男";
        } else if (womanRadio.isChecked()) {
            str = "女";
        }
        intent.putExtra("sex", str);
        startActivity(intent);
    }
}

package edu.hzuapps.androidlabs.homeworks.net1414080903120.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.hyphenate.chat.EMChatManager;
import com.hyphenate.chat.EMClient;
import com.hyphenate.exceptions.HyphenateException;

import edu.hzuapps.androidlabs.R;

/**
 * Created by Lenovo on 2017/5/23 0023.
 */

public class RegisterActivity extends AppCompatActivity {
    private static final String TAG = RegisterActivity.class.getSimpleName();
    private static final String EXTRA_USERNAME = RegisterActivity.class.getName() + "username";
    EditText accountEditText;
    EditText passwordEditText;
    EditText repasswordEditText;
    Button registButton;
    TextView warningTextView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.net1414080903120_activity_register);
        this.accountEditText = (EditText) findViewById(R.id.register_account);
        this.passwordEditText = (EditText) findViewById(R.id.register_password);
        this.repasswordEditText = (EditText) findViewById(R.id.register_repassword);
        this.registButton = (Button) findViewById(R.id.rigister_btn_register);
        this.warningTextView = (TextView) findViewById(R.id.register_warning);

        String userName = getIntent().getStringExtra(EXTRA_USERNAME);
        accountEditText.setText(userName);

        this.registButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!valide()) {
                    return;
                }

                new Thread() {
                    @Override
                    public void run() {

                        final String acccount = accountEditText.getText().toString();
                        String password = passwordEditText.getText().toString();
                        // 调用sdk注册方法
                        //注册失败会抛出HyphenateException
                        try {
                            EMClient.getInstance().createAccount(acccount, password);//同步方法
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Log.d(TAG, "注册成功");
                                    Toast.makeText(RegisterActivity.this, "注册成功，请登录", Toast.LENGTH_SHORT).show();
                                    setUserNameResult(acccount);
                                    finish();
                                }
                            });
                        } catch (HyphenateException e) {
                            e.printStackTrace();
                            Log.d(TAG, "注册失败");
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(RegisterActivity.this, "注册失败", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }
                }.start();
            }
        });
    }

    private void setUserNameResult(String userName) {
        Intent data = new Intent();
        data.putExtra(EXTRA_USERNAME, userName);
        setResult(RESULT_OK, data);
    }

    /**
     * 前端校验
     * @return
     */
    protected boolean valide() {
        warningTextView.setText("");  //清空
        String acccount = accountEditText.getText().toString();
        if (acccount.isEmpty()) {
            warningTextView.setText("账号不能为空");
            return false;
        }
        if (!acccount.matches("\\d{1,11}")) {
            warningTextView.setText("账号只能为1-11位数字");
            return false;
        }
        String password = passwordEditText.getText().toString();
        String repassword = repasswordEditText.getText().toString();

        if (!password.equals(repassword)) {
            warningTextView.setText("密码和确认密码不相同");
            return false;
        }

        if (!password.matches("^[a-zA-Z\\d_]{6,11}$")) {
            warningTextView.setText("密码必须是-16个字母或数字或_");
            return false;
        }

        return true;
    }

    /**
     * 创建打开本Activity（一个用户名参数的Intent)
     * @param packageContext
     * @param userName
     * @return
     */
    public static Intent newIntent(Context packageContext, String userName) {
        Intent i = new Intent(packageContext, RegisterActivity.class);
        i.putExtra(EXTRA_USERNAME, userName);
        return i;
    }

    public static String getUserName(Intent data) {
        return data.getStringExtra(EXTRA_USERNAME);
    }
}

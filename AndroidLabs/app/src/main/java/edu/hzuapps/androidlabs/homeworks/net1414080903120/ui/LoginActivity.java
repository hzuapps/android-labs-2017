package edu.hzuapps.androidlabs.homeworks.net1414080903120.ui;
import java.io.IOException;
import java.io.ObjectOutputStream;



import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;

import edu.hzuapps.androidlabs.R;

public class LoginActivity extends AppCompatActivity {
	public static final String SP_USER = "user";
	private static final String TAG = LoginActivity.class.getSimpleName();
	private static final int REQUEST_CODE_REGISTER = 0;
	private static final String KEY_USERNAME = "userName";
	private static final String KEY_PASSWORD = "password";
	private static final String KEY_IS_REMEMBER_ME = "isRemmemberMe";
	EditText accountEt,passwordEt;
	CheckBox rememberCb;
    Button btnLogin;
	//
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
	    setContentView(R.layout.net1414080903120_activity_login);


	    accountEt=(EditText) findViewById(R.id.et_account);
	    passwordEt=(EditText) findViewById(R.id.et_password);
		rememberCb = (CheckBox) findViewById(R.id.cb_remember);
	    btnLogin=(Button) findViewById(R.id.btn_login);

		restoreUserInfo();   //恢复记住的密码

		findViewById(R.id.btn_register).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = RegisterActivity.newIntent(LoginActivity.this, accountEt.getText().toString());
				startActivityForResult(i, REQUEST_CODE_REGISTER);
			}
		});

		EMClient.getInstance().logout(true, new EMCallBack() {

			@Override
			public void onSuccess() {
				// TODO Auto-generated method stub

			}

			@Override
			public void onProgress(int progress, String status) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onError(int code, String message) {
				// TODO Auto-generated method stub

			}
		});

		btnLogin.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (!checkLogin()) {   //检查用户名密码不为空
					return;
				}

				EMClient.getInstance().login(accountEt.getText().toString(),passwordEt.getText().toString()
						,new EMCallBack() {//回调
					@Override
					public void onSuccess() {
						if (rememberCb.isChecked()) {   //如果记住密码为真，执行记住密码
							savaUserInfo();
						}else {
							clearUserInfo();
						}
						Log.d(TAG, "登录聊天服务器成功！");
						Intent i = new Intent(LoginActivity.this, GroupListActivity.class);
						startActivity(i);
					}

					@Override
					public void onProgress(int progress, String status) {

					}

					@Override
					public void onError(int code, final String message) {
                        Log.d("main", "登录聊天服务器失败！");
                        runOnUiThread(new Runnable() {
							@Override
							public void run() {
								Toast.makeText(LoginActivity.this, "登录失败" + message, Toast.LENGTH_SHORT).show();
							}
						});
                    }
				});
			}
		});
	}

	/**
	 * 前端校验
	 * @return
	 */
	private boolean checkLogin() {
		if (accountEt.getText().toString().isEmpty()) {
			Toast.makeText(this, "用户名不能为空", Toast.LENGTH_SHORT).show();
			return false;
		}

		if (passwordEt.getText().toString().isEmpty()) {
			Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
			return false;
		}

		return true;
	}

	/**
	 * 记住账户密码
	 */
	protected void savaUserInfo() {
		SharedPreferences sp = getSharedPreferences(SP_USER, MODE_PRIVATE);
		SharedPreferences.Editor editor = sp.edit();
		editor.putString(KEY_PASSWORD, passwordEt.getText().toString());
		editor.putString(KEY_USERNAME, accountEt.getText().toString());
		editor.putBoolean(KEY_IS_REMEMBER_ME, rememberCb.isChecked());
		editor.commit();
	}

	/**
	 * 读取记住的密码
	 */
	protected void restoreUserInfo() {
		SharedPreferences sp = getSharedPreferences(SP_USER, MODE_PRIVATE);
		String userName = sp.getString(KEY_USERNAME, "");
		String password = sp.getString(KEY_PASSWORD, "");
		boolean isRememberMe = sp.getBoolean(KEY_IS_REMEMBER_ME, false);

		accountEt.setText(userName);
		passwordEt.setText(password);
		rememberCb.setChecked(isRememberMe);
	}

	/**
	 * 清除密码
	 */
	protected void clearUserInfo() {
		SharedPreferences sp = getSharedPreferences(SP_USER, MODE_PRIVATE);
		SharedPreferences.Editor editor = sp.edit();
		editor.clear();
		editor.commit();
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		if (savedInstanceState != null) {
			accountEt.setText(savedInstanceState.getString(KEY_USERNAME));
			passwordEt.setText(savedInstanceState.getString(KEY_PASSWORD));
			rememberCb.setChecked(savedInstanceState.getBoolean(KEY_IS_REMEMBER_ME));
		}
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putString(KEY_USERNAME, accountEt.getText().toString());
		outState.putString(KEY_PASSWORD, passwordEt.getText().toString());
		outState.putBoolean(KEY_IS_REMEMBER_ME, rememberCb.isChecked());
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode != RESULT_OK) {
			return;
		}

		if (resultCode == REQUEST_CODE_REGISTER) {
			String userName = RegisterActivity.getUserName(data);
			this.accountEt.setText(userName);
		}
	}
}

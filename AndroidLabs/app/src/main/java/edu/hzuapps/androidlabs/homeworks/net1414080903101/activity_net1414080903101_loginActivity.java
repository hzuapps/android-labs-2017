package com.intelligent_chest.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.intelligentchest.R;
import com.intelligent_chest.db.SQLOperateImpl;
import com.intelligent_chest.entity.User;
import com.intelligent_chest.util.ActivityUtil;

import java.util.Timer;
import java.util.TimerTask;

import static com.intelligent_chest.util.MyApplication.getContext;

/**
 * 登陆界面
 */
public class activity_net1414080903101_loginActivity extends Activity implements OnClickListener {
    private final String IOFO_ERROR = "您输入的信息有误或是您还没进行注册";
    private Boolean mIsExit = false;
    private Button mButFinish;
    private TextView mButWantRegister, mButforgetPassword;
    private EditText mEtAccountName, mEtPasswrod;
    private String mAccountName, mPasswrod;
    private ActivityUtil mActivityUtil;
    private Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
        mActivityUtil = ActivityUtil.getInstance();
        mActivityUtil.addActivity(this);

        findViewById();
        judgeIsFirstUse();
    }

    /**
     * 判断用户是否为第一次登陆——即之前从未成功注册过
     */
    private void judgeIsFirstUse() {
        // 第一次使用，没有用户数据存储在SharePreference中
        if (mSp.getString("accountName", "") == ""
                || mSp.getString("password", "") == "") {
            return;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            // 当注册成功并跳转至登陆界面时，让EditText内容为""
            case 1:
                if (resultCode == RESULT_OK) {
                    mEtAccountName.setText("");
                    mEtPasswrod.setText("");
                }
                break;
            default:
                break;
        }
    }


    @Override
    public void onClick(View v) {
        mAccountName = mEtAccountName.getText().toString().trim();
        mPasswrod = mEtPasswrod.getText().toString().trim();
        switch (v.getId()) {
            // 点击注册按钮
            case R.id.id_but_want_register:
                mIntent = new Intent(this, RegisterActivity.class);
                startActivityForResult(mIntent, 1);
                break;
            // 点击登陆按钮
            case R.id.id_but_login_finish:
                SQLOperateImpl test = new SQLOperateImpl(getContext());
                // 判断是否与 sqlite 数据是否一致
                String name = mAccountName;
                String psw = mPasswrod;
                User user = test.get(name);
                if (user != null && psw.equals(user.getPsw())) {
                    mIntent = new Intent(this, activity_net1414080903101_main.class);
                    startActivity(mIntent);
                    finish();
                }else{
                    Toast.makeText(this,"用户名或密码错误，请重新输入",Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            // 调用双击退出函数
            exitByTwoClick();
        }
        return false;

    }

    /**
     * 连续双击退出程序
     */
    public void exitByTwoClick() {
        Timer tExit = null;
        if (!mIsExit) {
            // 准备退出
            mIsExit = true;
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            tExit = new Timer();
            //延迟两秒执行此方法————根据schedule方法参数决定如何执行
            //schedule(TimerTask task, long delay);
            tExit.schedule(new TimerTask() {
                public void run() {
                    // 取消退出
                    mIsExit = false;
                }
            }, 2000); // 如果2秒钟内没有按下返回键，则启动定时器取消掉刚才执行的任务
        } else {
            //退出整个Activity
            mActivityUtil.finishAll();
        }
    }

    @Override
    protected void onDestroy() {
        mActivityUtil.remove(this);
        super.onDestroy();
    }

    private void findViewById() {
        mButFinish = (Button) findViewById(R.id.id_but_login_finish);
        mEtAccountName = (EditText) findViewById(R.id.id_et_login_accountName);
        mEtPasswrod = (EditText) findViewById(R.id.id_et_login_password);
        mButWantRegister = (TextView) findViewById(R.id.id_but_want_register);

        mButFinish.setOnClickListener(this);
        mButWantRegister.setOnClickListener(this);
//		mButforgetPassword.setOnClickListener(this);
    }
}

package edu.hzuapps.androidlabs.homeworks.net1414080903101;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.intelligentchest.R;
import com.intelligent_chest.db.SQLOperateImpl;
import com.intelligent_chest.entity.User;
import com.intelligent_chest.util.ActivityUtil;

import java.util.Timer;
import java.util.TimerTask;

import static com.intelligent_chest.util.MyApplication.getContext;

/**
 * 实现注册功能
 */
public class activity_net1414080903101_registerActivity extends Activity implements OnClickListener {
    public final String REGISTER_SUCCESS = "注册成功";
    public final String CHECK_PASSWORD_INFO = "两次密码输入不一致，请重新输入";
    public final String INFO_INCOMPLETE = "您的信息填写尚未完整，请继续填写";
    public final String PASSWORD_TOO_SHORT = "密码应不小于6位";
    public final String ACCOUNTNAME_EXIST = "该用户名已存在，请更换...";
    public static int PERMISSION = -1;
    public static final int USER_AGREE = 1;
    public static final int USER_DISAGREE = 0;
    public ImageView mImgBack;
    public Button mButFinish;
    public EditText mEtAccountName, mEtPassword, mEtSecPassword;
    public String mAccountName, mPasswrod, mSecondPassword;
    public ActivityUtil mActivityUtil;
    public Boolean mIsExit = false;
  
    /**
     * 注册成功，跳转到登陆
     */
    private void registerSuccess() {
        Toast.makeText(this, REGISTER_SUCCESS, Toast.LENGTH_SHORT).show();
        setResult(RESULT_OK);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_register);
        mActivityUtil = ActivityUtil.getInstance();
        mActivityUtil.addActivity(this);
        init();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.id_but_register_finish) {
            if (judgeIsReasonable()) {
                return;
            }
            // 跳转到登录界面
            registerSuccess();
        }
        else {
            finish();
        }
    }

    /**
     * 判断用户要注册的账号和密码是否合理， 不合理返回true，合理返回false
     */
    private Boolean judgeIsReasonable() {
        mAccountName = mEtAccountName.getText().toString().trim();
        mPasswrod = mEtPassword.getText().toString().trim();
        mSecondPassword = mEtSecPassword.getText().toString().trim();
        if (mAccountName.equals("") || mPasswrod.equals("")) {
            Toast.makeText(this, INFO_INCOMPLETE, Toast.LENGTH_SHORT).show();
            return true;
        }
        if (mPasswrod.length() < 6) {
            Toast.makeText(this, PASSWORD_TOO_SHORT, Toast.LENGTH_SHORT).show();
            return true;
        }
        if (!checkPassword()) {
            Toast.makeText(this, CHECK_PASSWORD_INFO, Toast.LENGTH_SHORT)
                    .show();
            return true;
        } else {
            // 将用户数据保存到SQLite中
            SQLOperateImpl test = new SQLOperateImpl(getContext());
            User user = new User(mAccountName, mPasswrod);
            test.add(user);
            // 当用户和密码都合理且不与原有的账号信息冲突时，则返回false，表示注册成功
            return false;
        }
    }

    /**
     * 判断两次输入的密码是否一致，若一致，true，否则返回false
     */
    public boolean checkPassword() {
        return mSecondPassword.equals(mPasswrod);
    }

    /**
     * 连续双击退出程序
     */
    public void exitByTwoClick() {
        Timer tExit = null;
        if (mIsExit == false) {
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

    /**
     * 初始化控件，事件
     */
    private void init() {
        mEtAccountName = (EditText) findViewById(R.id.id_et_register_accountName);
        mEtPassword = (EditText) findViewById(R.id.id_et_register_password);
        mEtSecPassword = (EditText) findViewById(R.id.id_et_secPassword);
        mButFinish = (Button) findViewById(R.id.id_but_register_finish);
        mImgBack = (ImageView) findViewById(R.id.id_img_back);

        mImgBack.setOnClickListener(this);
        mButFinish.setOnClickListener(this);

    }

    @Override
    protected void onDestroy() {
        mActivityUtil.remove(this);
        super.onDestroy();
    }
}

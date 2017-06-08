package edu.hzuapps.androidlabs.homeworks.net1414080903212;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Map;

public class Net1414080903212Activity extends AppCompatActivity implements View.OnClickListener{

    private TextView tab_assign;
    private TextView tab_mark;
    private TextView tab_homepage;
    private TextView tab_xml;

    private HomeFragment fra_home;
    private AssignFragment fra_assign;
    private MarkFragment fra_mark;
    private XmlFragment fra_xml;

    private EditText etNumber;
    private EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login1414080903212);
        initView();
        //取出账号
        Map<String, String > userInfo = Utils.getUserInfo(this);
        if (userInfo != null)   {
            //显示在界面上
            etNumber.setText(userInfo.get("number"));
            etPassword.setText(userInfo.get("password"));
        }
    }

    public void initView()  {
        etNumber = (EditText) findViewById(R.id.et_number);
        etPassword = (EditText) findViewById(R.id.et_password);
        findViewById(R.id.btn_login).setOnClickListener(this);
    }

    //UI组件初始化与事件绑定
    protected void bindView() {
        tab_homepage = (TextView)this.findViewById(R.id.navigation_home);
        tab_assign = (TextView)this.findViewById(R.id.navigation_assign);
        tab_mark = (TextView)this.findViewById(R.id.navigation_mark);
        tab_xml = (TextView)this.findViewById(R.id.navigation_xml);
        tab_homepage.setOnClickListener(this);
        tab_assign.setOnClickListener(this);
        tab_mark.setOnClickListener(this);
        tab_xml.setOnClickListener(this);
    }

    //初始先将所有导航设为未选中
    public void selected() {
        tab_homepage.setSelected(false);
        tab_assign.setSelected(false);
        tab_mark.setSelected(false);
        tab_xml.setSelected(false);
    }

    //隐藏所有fragment
    public void hideAllFragment(android.app.FragmentTransaction transaction) {
        if (fra_home != null)   {
            transaction.hide(fra_home);
        }
        if (fra_assign != null) {
            transaction.hide(fra_assign);
        }
        if (fra_mark != null) {
            transaction.hide(fra_mark);
        }
        if (fra_xml != null) {
            transaction.hide(fra_xml);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())  {
            case R.id.btn_login:
                //单击“登录”按钮时，获取账号和密码
                String number = etNumber.getText().toString().trim();
                String password = etPassword.getText().toString().trim();
                //检查帐号和密码是否正确
                if (TextUtils.isEmpty(number))  {
                    Toast.makeText(this, "请输入账号", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password))  {
                    Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
                    return;
                }
                //登录成功
                Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
                setContentView(R.layout.activity_net1414080903212);
                bindView();
                break;
        }

        android.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
        hideAllFragment(transaction);
        switch (v.getId()) {
            case R.id.navigation_home:
                selected();
                tab_homepage.setSelected(true);
                if (fra_home == null)   {
                    fra_home = new HomeFragment("这是主页");
                    transaction.add(R.id.ly_content, fra_home);
                }
                else {
                    transaction.show(fra_home);
                }
                break;

            case R.id.navigation_assign:
                selected();
                tab_assign.setSelected(true);
                if (fra_assign == null) {
                    fra_assign = new AssignFragment().newInstance("1");
                    transaction.add(R.id.ly_content, fra_assign);
                } else {
                    transaction.show(fra_assign);
                }
                break;

            case R.id.navigation_mark:
                selected();
                tab_mark.setSelected(true);
                if (fra_mark == null) {
                    fra_mark = new MarkFragment().newInstance("2");
                    transaction.add(R.id.ly_content, fra_mark);
                } else {
                    transaction.show(fra_mark);
                }
                break;

            case R.id.navigation_xml:
                selected();
                tab_xml.setSelected(true);
                if (fra_xml == null) {
                    fra_xml = new XmlFragment();
                    transaction.add(R.id.ly_content, fra_xml);
                }
                else {
                    transaction.show(fra_xml);
                }
                break;
        }
        transaction.commit();
    }
}

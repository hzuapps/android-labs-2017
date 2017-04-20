package edu.hzuapps.androidlabs.homework.net1414080903234;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Net1414080903234Activity extends AppCompatActivity implements View.OnClickListener {

    private TextView tabmoney;
    private TextView tabincome;
    private TextView taboutlay;
    private TextView tabsetting;

    private FrameLayout ly_content;
    private Net1414080903234_M f1,f2,f3,f4;
    private android.app.FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903234);
        bindView();
        tabmoney.performClick();
    }

    protected void bindView(){
        tabmoney = (TextView)this.findViewById(R.id.text_money);
        tabincome = (TextView)this.findViewById(R.id.text_income);
        taboutlay = (TextView)this.findViewById(R.id.text_outlay);
        tabsetting = (TextView)this.findViewById(R.id.text_setting);

        tabmoney.setOnClickListener(this);
        tabincome.setOnClickListener(this);
        taboutlay.setOnClickListener(this);
        tabsetting.setOnClickListener(this);
    }

    public void selected(){
        tabmoney.setSelected(false);
        tabincome.setSelected(false);
        taboutlay.setSelected(false);
        tabsetting.setSelected(false);
    }
    public void hideAllFragment(android.app.FragmentTransaction transaction){
        if(f1!= null){
            transaction.hide(f1);
        }
        if(f2!=null){
            transaction.hide(f2);
        }
        if(f3!=null){
            transaction.hide(f3);
        }
        if(f4!=null){
            transaction.hide(f4);
        }
    }

    @Override
    public void onClick(View v) {
        android.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
        hideAllFragment(transaction);
        switch(v.getId()) {
            case R.id.text_money:
                selected();
                tabmoney.setSelected(true);
                if (f1 == null) {
                    f1 = new Net1414080903234_M().newInstance("总额");
                    transaction.add(R.id.ly_content, f1);
                } else {
                    transaction.show(f1);
                }
                break;
            case R.id.text_income:
                selected();
                tabincome.setSelected(true);
                if (f2 == null) {
                    f2 = new Net1414080903234_M().newInstance("收入");
                    transaction.add(R.id.ly_content, f2);
                } else {
                    transaction.show(f2);
                }
                break;
            case R.id.text_outlay:
                selected();
                taboutlay.setSelected(true);
                if (f3 == null) {
                    f3 = new Net1414080903234_M().newInstance("支出");
                    transaction.add(R.id.ly_content, f3);
                } else {
                    transaction.show(f3);
                }
                break;
            case R.id.text_setting:
                selected();
                tabsetting.setSelected(true);
                if (f4 == null) {
                    f4 = new Net1414080903234_M().newInstance("设置");
                    transaction.add(R.id.ly_content, f4);
                } else {
                    transaction.show(f4);
                }
        }
        transaction.commit();
    }
}

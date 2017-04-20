package edu.hzuapps.androidlabs.homeworks.net1414080903212;

import android.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;

public class Net1414080903212Activity extends AppCompatActivity implements View.OnClickListener{

    private TextView topBar;
    private TextView tabAssign;
    private TextView tabMark;

    private FrameLayout ly_content;

    private Net1414080903212FirstFragment f1,f2;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_net1414080903212);

        bindView();
    }

    //UI组件初始化与事件绑定
    private void bindView() {
        topBar = (TextView)this.findViewById(R.id.txt_top);
        tabAssign = (TextView)this.findViewById(R.id.txt_assign);
        tabMark = (TextView)this.findViewById(R.id.txt_mark);
        ly_content = (FrameLayout) findViewById(R.id.fragment_container);

        tabAssign.setOnClickListener(this);
        tabMark.setOnClickListener(this);
    }
    //重置所有文本的选中状态
    public void selected(){
        tabAssign.setSelected(false);
        tabMark.setSelected(false);
    }
    //隐藏所有Fragment
    public void hideAllFragment(FragmentTransaction transaction){
        if(f1!=null){
            transaction.hide(f1);
        }
        if(f2!=null){
            transaction.hide(f2);
        }
    }


    @Override
    public void onClick(View v) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        hideAllFragment(transaction);
        switch(v.getId()){
            case R.id.txt_assign:
                selected();
                tabAssign.setSelected(true);
                if(f1==null){
                    f1 = new Net1414080903212FirstFragment("布置作业任务Fragment");
                    transaction.add(R.id.fragment_container,f1);
                }else{
                    transaction.show(f1);
                }
                break;

            case R.id.txt_mark:
                selected();
                tabMark.setSelected(true);
                if(f2==null){
                    f2 = new Net1414080903212FirstFragment("记录作业成绩Fragment");
                    transaction.add(R.id.fragment_container,f2);
                }else{
                    transaction.show(f2);
                }
                break;

        }

        transaction.commit();
    }
}

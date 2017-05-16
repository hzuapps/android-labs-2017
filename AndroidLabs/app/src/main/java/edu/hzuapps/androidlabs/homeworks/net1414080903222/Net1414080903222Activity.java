package edu.hzuapps.androidlabs.homeworks.net1414080903222;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView topBar;
    private TextView tabRecoder;
    private TextView tabList;

    private FirstFragment1414080903222 f1,f2;
    private Net1414080903222Activity net1414080903222Activity;
    private FrameLayout ly_content;
    private FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_net1414080903222);
        bindView();

    }

    //UI组件初始化与事件绑定
    private void bindView() {
      //  topBar = (TextView)this.findViewById(R.id.txt_top);
        tabRecoder = (TextView)this.findViewById(R.id.recorder);
        tabList = (TextView)this.findViewById(R.id.list);
        ly_content = (FrameLayout) findViewById(R.id.fragment_container);

        tabRecoder.setOnClickListener(this);
        tabList.setOnClickListener(this);

    }

    //重置所有文本的选中状态
    public void selected(){
        tabRecoder.setSelected(false);
        tabList.setSelected(false);
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
            case R.id.recorder:
               selected();
                tabRecoder.setSelected(true);
                if(f1==null){
                    f1 = new FirstFragment1414080903222();
                    transaction.add(R.id.fragment_container,f1);
                }else{
                    transaction.show(f1);
                }
                break;

            case R.id.list:
                selected();
                tabList.setSelected(true);
                if(f2==null){

                    transaction.add(R.id.fragment_container,f2);
                }else{
                    transaction.show(f2);
                }
                break;

        }
        transaction.commit();
    }


}

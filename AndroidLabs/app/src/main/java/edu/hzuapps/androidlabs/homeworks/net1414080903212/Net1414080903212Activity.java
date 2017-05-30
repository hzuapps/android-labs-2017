package edu.hzuapps.androidlabs.homeworks.net1414080903212;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class Net1414080903212Activity extends AppCompatActivity implements View.OnClickListener{

    private TextView tab_assign;
    private TextView tab_mark;

    private FrameLayout ly_content;
    private AssignFragment fra_assign;
    private MarkFragment fra_mark;
    private android.app.FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903212);
        bindView();
    }

    protected void bindView() {
        tab_assign = (TextView)this.findViewById(R.id.navigation_assign);
        tab_mark = (TextView)this.findViewById(R.id.navigation_mark);
        tab_assign.setOnClickListener(this);
        tab_mark.setOnClickListener(this);
    }

    //初始先将所有导航设为未选中
    public void selected() {
        tab_assign.setSelected(false);
        tab_mark.setSelected(false);
    }

    //隐藏所有fragment
    public void hideAllFragment(android.app.FragmentTransaction transaction) {
        if (fra_assign != null) {
            transaction.hide(fra_assign);
        }
        if (fra_mark != null) {
            transaction.hide(fra_mark);
        }
    }

    @Override
    public void onClick(View v) {
        android.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
        hideAllFragment(transaction);
        switch (v.getId()) {
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
        }
        transaction.commit();
    }
}

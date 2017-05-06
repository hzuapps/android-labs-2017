package edu.hzuapps.androidlabs.homeworks.net1414080903220.knowdev.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.hzuapps.androidlabs.homeworks.net1414080903220.knowdev.R;
import edu.hzuapps.androidlabs.homeworks.net1414080903220.knowdev.activity.Net1414080903220MainActivity;
import edu.hzuapps.androidlabs.homeworks.net1414080903220.knowdev.widget.KnowDevToolbar;

/**
 * ProjectName: knowdev
 * PackName：edu.hzuapps.androidlabs.homeworks.net1414080903220.knowdev.fragment
 * Class describe:头条新闻Fragment
 * Author: cheng
 * Create time: 2017/5/4 23:08
 */
public class NewsFragment extends Fragment implements TabLayout.OnTabSelectedListener,View.OnClickListener{
    LayoutInflater inflater;
    TabLayout newsTypeTabLayout;

    public static final int TAG_KEJI=0;
    public static final int TAG_STARTUP=1;
    public static final int TAG_MOBILE=2;
    public static final int TAG_IT=3;

    int texts[]={R.string.keji,R.string.startup,R.string.mobile,R.string.it};
    int tags[]={TAG_KEJI,TAG_STARTUP,TAG_MOBILE,TAG_IT};

    private KnowDevToolbar knowDevToolbar;
    private DrawerLayout drawerLayout;

    String FragmentTAG="NewsFragment";
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_net1414080903220_newslist,container,false);

 
        initTab(view);

        return view;
    }


    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        Log.i("news","attach");

        View contentView = getLayoutInflater().inflate(R.layout.activity_net1414080903220_rg, null);
        Net1414080903220MainActivity mainActivity= (Net1414080903220MainActivity) context;
        inflater=LayoutInflater.from(context);
        View contentView =inflater.inflate(R.layout.activity_net1414080903220_rg, null);
        knowDevToolbar= (KnowDevToolbar) contentView.findViewById(R.id.knowDevToolbar);

    }



    public void initTab(View view){
        newsTypeTabLayout=(TabLayout)view.findViewById(R.id.tab_layout);
        for(int i=0;i<4;i++){
            TabLayout.Tab tab=newsTypeTabLayout.newTab();
            tab.setText(texts[i]);
            tab.setTag(tags[i]);
            newsTypeTabLayout.addTab(tab);
        }
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        //当前只是测试tab点中是否有效，具体逻辑后期加入;
        String tabText= (String) tab.getText();
        Log.i(FragmentTAG,tabText);
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {
        //当前只是测试tab点中是否有效，具体逻辑后期加入;
        String tabText= (String) tab.getText();
        Log.i(FragmentTAG,tabText);
    }

    @Override
    public void onClick(View v) {

    }
}

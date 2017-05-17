package edu.hzuapps.androidlabs.homeworks.net1414080903220.knowdev.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.hzuapps.androidlabs.homeworks.net1414080903220.knowdev.R;
import edu.hzuapps.androidlabs.homeworks.net1414080903220.knowdev.activity.Net1414080903220MainActivity;
import edu.hzuapps.androidlabs.homeworks.net1414080903220.knowdev.adapter.DevAdapter;
import edu.hzuapps.androidlabs.homeworks.net1414080903220.knowdev.widget.KnowDevToolbar;

/**
 * ProjectName: knowdev
 * PackName：edu.hzuapps.androidlabs.homeworks.net1414080903220.knowdev.fragment
 * Class describe:开发
 * Author: cheng
 * Create time: 2017/5/5 10:03
 */
public class DevFragment extends Fragment implements TabLayout.OnTabSelectedListener,View.OnClickListener{
    LayoutInflater inflater;
    DrawerLayout drawerLayout;
    private KnowDevToolbar knowDevToolbar;
    TabLayout devTypeTabLayout;
    DevAdapter devAdapter;
    RecyclerView devRv;
    public static final int TAG_ANDROID=0;
    public static final int TAG_IOS=1;
    public static final int TAG_WEB=2;
    public static final int TAG_EXPAND=3;


    int texts[]={R.string.android,R.string.ios,R.string.web,R.string.expand};
    int tags[]={TAG_ANDROID,TAG_IOS,TAG_WEB,TAG_EXPAND};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_net1414080903220_dev_article,container,false);
        devRv= (RecyclerView) view.findViewById(R.id.rv_dev);
        knowDevToolbar= (KnowDevToolbar) view.findViewById(R.id.knowDevToolbar);

        knowDevToolbar.setMenuButtonOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        initTab(view);
        initData();
        return view;
    }

    private void initData() {
        devAdapter=new DevAdapter(getActivity());
        devRv.setAdapter(devAdapter);
        devRv.setLayoutManager(new LinearLayoutManager(DevFragment.this.getActivity()));
    }

    private void initTab(View view) {
        devTypeTabLayout=(TabLayout)view.findViewById(R.id.tab_dev_layout);

        for(int i=0;i<texts.length;i++){
            TabLayout.Tab tab=devTypeTabLayout.newTab();
            tab.setText(texts[i]);
            tab.setTag(tags[i]);
            devTypeTabLayout.addTab(tab);
        }
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        if(context instanceof Net1414080903220MainActivity){
           Net1414080903220MainActivity mainActivity= (Net1414080903220MainActivity) context;
            drawerLayout= (DrawerLayout) mainActivity.findViewById(R.id.dl_left);

          /*   knowDevToolbar= (KnowDevToolbar) mainActivity.findViewById(R.id.knowDevToolbar);*/

        }

        //initToolbar();
    }
/*    void initToolbar(){
        knowDevToolbar.setTitle("每日干货");
    }*/


    @Override
    public void onTabSelected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    public void onClick(View v) {

    }
}

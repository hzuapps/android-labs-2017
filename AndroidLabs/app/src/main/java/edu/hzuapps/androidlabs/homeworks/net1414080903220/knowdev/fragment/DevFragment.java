package edu.hzuapps.androidlabs.homeworks.net1414080903220.knowdev.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
 * Class describe:开发
 * Author: cheng
 * Create time: 2017/5/5 10:03
 */
public class DevFragment extends Fragment {
    LayoutInflater inflater;
    private KnowDevToolbar knowDevToolbar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_net1414080903220_dev_article,container,false);

        return view;
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        Net1414080903220MainActivity mainActivity= (Net1414080903220MainActivity) context;
        knowDevToolbar= (KnowDevToolbar) mainActivity.findViewById(R.id.knowDevToolbar);
        initToolbar();
    }



}

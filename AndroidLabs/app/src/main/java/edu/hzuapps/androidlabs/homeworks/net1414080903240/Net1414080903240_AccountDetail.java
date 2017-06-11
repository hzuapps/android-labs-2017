package edu.hzuapps.androidlabs.homeworks.net1414080903240;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Net1414080903240_AccountDetail extends AppCompatActivity {
    private ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accountdetail_1414080903240);
        SharedPreferences sp=getSharedPreferences("zhangmu",MODE_PRIVATE);
        int sum0=sp.getInt("count",0);
        ListView lv = (ListView) findViewById(R.id.lv);
        ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String,Object>>();
        for(int i=1;i<=sum0;i++)
        {
            String a=sp.getString("countnum"+i,"0");
            String b=sp.getString("countclass"+i,"null");
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("tt_value",a);
            map.put("project_value",b);
            listItem.add(map);
        }
        SimpleAdapter mSimpleAdapter = new SimpleAdapter(this,listItem,R.layout.list_item, new String[] {"tt_value", "project_value"},new int[]{R.id.tt_value,R.id.project_value});
        lv.setAdapter(mSimpleAdapter);
    }

    }
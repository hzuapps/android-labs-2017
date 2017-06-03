package edu.hzuapps.androidlabs.homeworks.net1414080903231;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.database.Cursor;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;


public class Net1414080903231Sleep extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903231_sleep);
        //绑定XML中的ListView，作为Item的容器
        ListView list = (ListView) findViewById(R.id.SleepListView);

        //生成动态数组，并且转载数据
        ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();
        for(int i=0;i<5;i++)
        {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("ItemTitle", "This is Music.....");
            map.put("ItemText", "This is text.....");
            mylist.add(map);
        }
        //生成适配器，数组===》ListItem
        SimpleAdapter mSchedule = new SimpleAdapter(this, //没什么解释
                mylist,//数据来源
                R.layout.net1414080903231_sleep_listitem,//ListItem的XML实现

                //动态数组与ListItem对应的子项
                new String[] {"ItemTitle", "ItemText"},

                //ListItem的XML文件里面的两个TextView ID
                new int[] {R.id.SleepItemTitle,R.id.SleepItemText});
        //添加并且显示
        list.setAdapter(mSchedule);
    }


}

package edu.hzuapps.androidlabs.homeworks.net1414080903231;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Net1414080903231Clock extends AppCompatActivity {

    private int  index = 0;
    private ArrayList<HashMap<String,String>> mylist;
    public Net1414080903231ClockDao ncd;
    private ListView list;

    public void refresh() {
        onCreate(null);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903231_clock);
        //绑定XML中的ListView，作为Item的容器
        list = (ListView) findViewById(R.id.MyListView);
         ncd=new Net1414080903231ClockDao(Net1414080903231Clock.this);
        List<Net1414080903231Time> li=ncd.findAll();
        //生成动态数组，并且转载数据
        mylist = new ArrayList<HashMap<String, String>>();

        if(!li.isEmpty()){

        for(int i=0;i<li.size();i++)
        {
            HashMap<String, String> map = new HashMap<String, String>();
            String title=Integer.toString(li.get(i).getHour())+":"+Integer.toString(li.get(i).getMinute());
            String text="ID"+Integer.toString(li.get(i).getId())+" | "+li.get(i).getRepeatCycle()+" | "+li.get(i).getTag();
            map.put("ItemTitle", title);
            map.put("ItemText", text);
            mylist.add(map);
        }
        }
        //生成适配器，数组===》ListItem
        SimpleAdapter mSchedule = new SimpleAdapter(this,
                mylist,//数据来源
                R.layout.my_listitem,//ListItem的XML实现
                //动态数组与ListItem对应的子项
                new String[] {"ItemTitle", "ItemText"},
                //ListItem的XML文件里面的两个TextView ID
                new int[] {R.id.ItemTitle,R.id.ItemText});
        //添加并且显示
        list.setAdapter(mSchedule);

        /*list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int arg2, long arg3) {
                // TODO Auto-generated method stub
                index = arg2;
                String idn0 = mylist.get(index).get("ItemText").toString();
                String idn1=idn0.substring(idn0.indexOf("D") + 1, idn0.indexOf(" "));
                boolean b=ncd.deletebyid( Integer.parseInt(idn1));

                Intent intent=new Intent();
                intent.setClass(Net1414080903231Clock.this,Net1414080903231Clock.class);
                startActivity(intent);
                return false;
            }
        });*/

        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int arg2, long arg3) {
                // TODO Auto-generated method stub
                index = arg2;
                android.content.DialogInterface.OnClickListener listener=new android.content.DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog,int which){
                        String idn0 = mylist.get(index).get("ItemText").toString();
                        String idn1=idn0.substring(idn0.indexOf("D") + 1, idn0.indexOf(" "));
                        boolean b=ncd.deletebyid( Integer.parseInt(idn1));

                        Intent intent=new Intent();
                        intent.setClass(Net1414080903231Clock.this,Net1414080903231Clock.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        //onCreate(null);
                    }
                };
                AlertDialog.Builder builder=new AlertDialog.Builder(Net1414080903231Clock.this);
                builder.setTitle("确定要删除吗？");
                builder.setPositiveButton("确定",listener);
                builder.setNegativeButton("取消",null);
                builder.show();
                return false;
            }



        });

    }



    public void clock_add(View view) {
        Intent intent = new Intent(this, Net1414080903231EditClock.class);
        startActivity(intent);
    }


}


package edu.hzuapps.androidlabs.homeworks.net1414080903110;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import edu.hzuapps.androidlabs.R;

/*
   作业列表
*/
public class Net1414080903110_WorkListActivity extends AppCompatActivity implements View.OnClickListener {

    private List<Work_Info> work_infoList=new ArrayList<>();
    private String i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initwork_info();
        setContentView(R.layout.activity_net1414080903110_worklist);
        Button button=(Button)findViewById(R.id.btn1);
        button.setOnClickListener(this);
        Intent intent=getIntent();
        String uname=intent.getStringExtra("username");/*获取Net1414080903110_LoginActivity传递过来的用户名和密码*/
        String psword=intent.getStringExtra("password");
        if("zzj".equals(uname)&&"12345".equals(psword)) /*教师用户*/
        {
            WorkAdapter adapter=new WorkAdapter(Net1414080903110_WorkListActivity.this,R.layout.net1414080903110_work_item,work_infoList);
            ListView listView=(ListView)findViewById(R.id.list_view);
            listView.setAdapter(adapter);
			/*给ListView的各Item项设置长按监听事件（这里主要是用来删除作业的，后期会把功能加进去）*/
            listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                public boolean onItemLongClick(AdapterView<?>parent, View view, int position, long id) {
                    Work_Info work_info=work_infoList.get(position);
                    Toast.makeText(Net1414080903110_WorkListActivity.this,work_info.getWorkname(),Toast.LENGTH_SHORT).show();
                    return true;
                }
            });
            button.setVisibility(View.VISIBLE);/*教师用户，让布置作业按钮显示.*/
            i="admin";
        }
        else{
            button.setVisibility(View.GONE);/*如果是学生用户 让布置作业按钮隐藏.*/
            i="user";
        }
        WorkAdapter adapter=new WorkAdapter(Net1414080903110_WorkListActivity.this,R.layout.work_item,work_infoList);//实例化WorkAdapter适配器
        ListView listView=(ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);//将listView加入适配器
		/*给ListView的各Item项设置监听事件*/
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?>parent,View view,int position,long id){
                Work_Info work_info=work_infoList.get(position); //获取Work_Info实例
                Intent intent=new Intent(Net1414080903110_WorkListActivity.this,Net1414080903110_SubmitActivity.class);
                String workname=work_info.getWorkname();
                intent.putExtra("workname",workname);//将作业名传递给Net1414080903110_SubmitActivity
                intent.putExtra("i",i);
                startActivity(intent);
            }
        });

    }
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btn1:
                Intent intent=new Intent(Net1414080903110_WorkListActivity.this,Net1414080903110_SubmitActivity.class);
                startActivity(intent);
        }
    }
	/*初始化作业信息*/
    private void initwork_info()
    {
        for(int i=0;i<3;i++) {
            Work_Info work = new Work_Info();
            work.setWorkname("作业一");
            work_infoList.add(work);
            Work_Info work2 = new Work_Info();
            work2.setWorkname("作业二");
            work_infoList.add(work2);
            Work_Info work3 = new Work_Info();
            work3.setWorkname("作业三");
            work_infoList.add(work3);
        }
    }
}



package edu.hzuapps.androidlabs.homeworks.net1414080903110;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
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
    private WorkDatabaseHelper dbHelper;
    private ImageView buzhi;
    private Button send;
    private TextView responseText;
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showlist();//列出所有作业
        setContentView(R.layout.activity_net1414080903110_worklist);
        final WorkAdapter adapter=new WorkAdapter(Net1414080903110_WorkListActivity.this,R.layout.work_item,work_infoList);
        ListView listView=(ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        buzhi=(ImageView)findViewById(R.id.buzhi);
        send=(Button)findViewById(R.id.send_request);
        buzhi.setOnClickListener(this);
        send.setOnClickListener(this);
        Intent intent=getIntent();
        String uname=intent.getStringExtra("username");/*获取Net1414080903110_LoginActivity传递过来的用户名和密码*/
        String psword=intent.getStringExtra("password");
        String flag=intent.getStringExtra("flag");
        if(("zzj".equals(uname) ) &&("12345".equals(psword))||("true".equals(flag))) /*教师用户*/
        {
			/*给ListView的各Item项设置长按监听事件（这里主要是用来删除作业)*/
            listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                public boolean onItemLongClick(AdapterView<?>parent, View view, final int position, long id) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(Net1414080903110_WorkListActivity.this);
        builder.setTitle("Delete")
                .setMessage("确定删除这个作业吗?")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
				    Work_Info work_info=work_infoList.get(position);
					SQLiteDatabase db = dbHelper.getWritableDatabase();
                        String name=work_info.getWorkname();
                        db.delete("work","workname=?",new String[]{name}); //删除作业
                        work_infoList.remove(position); //根据position从work_infoList中删除对应的作业
                        Toast.makeText(Net1414080903110_WorkListActivity.this,"Delete Done",Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                        adapter.refresh();// 刷新作业列表
					}
				})
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setCancelable(true)
                .show();
                    return true;
                }
            });
            buzhi.setVisibility(View.VISIBLE);/*让布置作业按钮显示*/
            i="admin";
        }
        else{
            buzhi.setVisibility(View.GONE);/*如果是学生用户 让布置作业按钮隐藏*/
            i="user";
        }
		/*给ListView的各Item项设置监听事件*/
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?>parent,View view,int position,long id){
				Work_Info work_info=work_infoList.get(position); //获取Work_Info实例
                Intent intent=new Intent(Net1414080903110_WorkListActivity.this,Net1414080903110_SubmitActivity.class);
                intent.putExtra("workname",work_info.getWorkname());//将作业名传递给Net1414080903110_SubmitActivity
                intent.putExtra("content",work_info.getWorkcontent());
                intent.putExtra("i",i);
                startActivity(intent);
            }
        });
       
    }
	
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.buzhi:
                Intent intent2=new Intent(Net1414080903110_WorkListActivity.this,Net1414080903110_SubmitActivity.class);
                this.finish();
                startActivity(intent2);
            case R.id.send_request://点击按钮从github抓取json文件
                Intent intent3=new Intent(Net1414080903110_WorkListActivity.this,Net1414080903110_AnalysisJsonActivity.class);
                startActivity(intent3);
        }
    }
	
/* 列出作业*/
    public void showlist(){
        dbHelper=new WorkDatabaseHelper(this,"Test.db",null,2);
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        Cursor cursor=db.query("work",null,null,null,null,null,null);
        if(cursor.moveToFirst()) {
            do {
                String workname = cursor.getString(cursor.getColumnIndex("workname"));
                String workcontent=cursor.getString(cursor.getColumnIndex("workcontent"));
                Work_Info work_info = new Work_Info();
                work_info.setWorkname(workname); //将数据库查询到的作业名称和作业内容赋值给work_info的成员变量 workname、workcontent 
                work_info.setWorkcontent(workcontent);
                work_infoList.add(work_info);
            }while(cursor.moveToNext());
        }
        cursor.close();
    }

}


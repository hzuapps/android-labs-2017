package edu.hzuapps.androidlabs.homeworks.net1414080903116;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import java.util.List;
import edu.hzuapps.androidlabs.R;

public class Net1414080903116Index extends AppCompatActivity {
    private TextView show_name;
    //需要适配的数据合集
    private List<Net1414080903116TextDynamic> list;
    //数据库操作类
    private Net1414080903116TextDynamicDao dao;
    private EditText text_dynamic;
    //适配器
    private MyBaseAdapter adapter;
    //ListView
    private ListView dynamicLV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903116_index);
        Intent intent=getIntent();
        String name=intent.getStringExtra("name");
        show_name=(TextView) findViewById(R.id.show_name);
        show_name.setText("欢迎你:"+name);
        //初始化控件
        initView();
        dao=new Net1414080903116TextDynamicDao(this);
        //从数据库查询出所有数据
        list=dao.queryAll();
        adapter=new MyBaseAdapter();
        dynamicLV.setAdapter(adapter);//给ListView添加适配器
    }
    //初始化控件
    private void initView(){
        dynamicLV=(ListView) findViewById(R.id.lv);
        text_dynamic=(EditText) findViewById(R.id.text_dynamic);
    }
    public void add(View v){
        Intent intent=getIntent();
        String promulgator=intent.getStringExtra("name");
        String textdynamic=text_dynamic.getText().toString().trim();
        Net1414080903116TextDynamic a=new Net1414080903116TextDynamic(promulgator,textdynamic);
        dao.insert(a);
        list.add(a);
        adapter.notifyDataSetChanged();
        //选中最后一个
        dynamicLV.setSelection(dynamicLV.getCount()-1);
        text_dynamic.setText("");
    }
    //创建一个类继承BaseAdapter
    class MyBaseAdapter extends BaseAdapter {
        //得到Item的总数
        public int getCount() {
            return list.size();
        }
        //得到Item代表的对象
        public Object getItem(int position){
            return list.get(position);
        }
        //得到Item的id
        public long getItemId(int position){
            return position;
        }
        //得到Item的视图
        public View getView(int position, View convertView, ViewGroup parent){
            //重用convertView
            View item=convertView!=null?convertView:View.inflate(getApplicationContext(),R.layout.list_item1414080903116,null);
            //获取该视图中的TextView
            TextView tv_promulgator=(TextView) item.findViewById(R.id.tv_promulgator);
            TextView tv_list=(TextView) item.findViewById(R.id.tv_list);
            //根据当前位置获取Net1414080903116TextDynamic对象
            final Net1414080903116TextDynamic a=list.get(position);
            tv_promulgator.setText(a.getPromulgator());
            tv_list.setText(a.getText_dynamic());
            Button deleteTV=(Button) item.findViewById(R.id.tv_delete);
            Button commentTV=(Button) item.findViewById(R.id.tv_comment);
            commentTV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent();
                    intent.setClass(Net1414080903116Index.this,Net1414080903116SendText.class);
                    startActivity(intent);
                }
            });
            deleteTV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //删除数据之前首先弹出一个对话框
                android.content.DialogInterface.OnClickListener listener=new android.content.DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog,int which){
                        list.remove(a);
                        dao.delete(a.getId());
                        notifyDataSetChanged();
                    }
                };
                //创建对话框
                    AlertDialog.Builder builder=new AlertDialog.Builder(Net1414080903116Index.this);
                    builder.setTitle("确定要删除吗？");
                    builder.setPositiveButton("确定",listener);
                    builder.setNegativeButton("取消",null);
                    builder.show();
                }
            });
            return item;
        }
    }
    /*public void click(View view){
        Intent intent=new Intent(this,Net1414080903116SendText.class);
        intent.putExtra("name",show_name.getText().toString().trim());
        startActivity(intent);
    }*/
}

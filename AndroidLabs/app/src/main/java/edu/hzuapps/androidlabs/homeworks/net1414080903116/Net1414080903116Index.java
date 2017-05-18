package edu.hzuapps.androidlabs.homeworks.net1414080903116;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import edu.hzuapps.androidlabs.R;

public class Net1414080903116Index extends AppCompatActivity {
    private TextView show_name;
    private ListView mListView;
    //由于还没有连接数据库，所以暂时使用String类型的数组代替需要适配的数据
    private String[] names={"我是动态一","我是动态二","我是动态三","我是动态四"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903116_index);
        Intent intent=getIntent();
        String name=intent.getStringExtra("name");
        show_name=(TextView) findViewById(R.id.show_name);
        show_name.setText("欢迎你，"+name);
        mListView=(ListView) findViewById(R.id.lv);
        //创建一个Adapter的实例
        MyBaseAdapter mAdapter=new MyBaseAdapter();
        //设置Adapter
        mListView.setAdapter(mAdapter);//
    }
    //创建一个类继承BaseAdapter
    class MyBaseAdapter extends BaseAdapter {
        //得到Item的总数
        public int getCount() {
            return names.length;
        }
        //得到Item代表的对象
        public Object getItem(int position){
            return names[position];
        }
        //得到Item的id
        public long getItemId(int position){
            return position;
        }
        //得到Item的视图
        public View getView(int position, View convertView, ViewGroup parent){
            View view=View.inflate(Net1414080903116Index.this,R.layout.list_item1414080903116,null);
            TextView mTextView=(TextView) view.findViewById(R.id.tv_list);
            mTextView.setText(names[position]);
            return view;
        }
    }
    public void click(View view){
        Intent intent=new Intent(this,Net1414080903116SendText.class);
        startActivity(intent);
    }
}

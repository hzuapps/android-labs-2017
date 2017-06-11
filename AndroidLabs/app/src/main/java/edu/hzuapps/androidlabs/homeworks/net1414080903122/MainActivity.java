package edu.hzuapps.androidlabs.homeworks.net1414080903122;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import edu.hzuapps.androidlabs.R;

public class MainActivity extends AppCompatActivity {
    private ListView mListView;
    //需要适配的数据代码，调用存储。。。。。。。。。
    private String[] names={"京东商城","QQ","QQ斗地主","新浪微博","天猫","UC浏览器","微信"};
    //图片集合
    private int[] icons ={R.drawable.jd,R.drawable.qq,R.drawable.qq_dizhu,R.drawable.sina,R.drawable.tmall,R.drawable.uc,R.drawable.weixin,};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_net1414080903122);
        //初始化ListView控件
        mListView=(ListView)findViewById(R.id.lv);
        //创建一个Adapter实例
        MyBaseAdapter mAdapter=new MyBaseAdapter();
        //设置Adapter
        mListView.setAdapter(mAdapter);
    }

    class MyBaseAdapter extends BaseAdapter{
        //得到Item的总数
        @Override
        public int getCount() {
            return names.length;
        }

        @Override
        public Object getItem(int position) {
            return names[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //把list_item.xml文件转换成View对象
            View view =View.inflate(MainActivity.this,R.layout.list_item_net1414080903122,null);
            //找到list_item.xml文件中创建的TextView
            TextView mTextView=(TextView)view.findViewById(R.id.tv_list);
            mTextView.setText(names[position]);
            ImageView imageView=(ImageView)view.findViewById(R.id.image);
            imageView.setBackgroundResource(icons[position]);

            return view;
        }

    }
}



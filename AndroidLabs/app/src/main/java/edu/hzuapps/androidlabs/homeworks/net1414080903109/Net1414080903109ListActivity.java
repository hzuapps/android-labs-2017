package edu.hzuapps.androidlabs.net1414080903109;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.maminjian.R;

import java.util.List;

public class Net1414080903109ListActivity extends AppCompatActivity {

    ListView lv;
    List<Net1414080903109DayBean> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903109_list);
        list= Net1414080903109Presenter.getInstance(this).list();
        final MyAdapter adapter=new MyAdapter();
        lv.setAdapter(adapter);
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            /*长监听，实现删除功能,在后面数据储存实验再加上*/
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }

    class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        /*列出所有节假日*/
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView==null){
                convertView= LayoutInflater.from(Net1414080903109ListActivity.this).inflate(R.layout.item_net1414080903109,null);
            }
            Net1414080903109DayBean day=list.get(position);
            TextView tvName= (TextView) findViewById(R.id.tv_item_name);
            TextView tvOccur= (TextView) findViewById(R.id.tv_item_occur);;
            tvOccur.setText(day.getOccur());
            tvName.setText(day.getName());
            return convertView;
        }
    }
}

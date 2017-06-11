package edu.hzuapps.androidlabs.homeworks.net1414080903202;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

import edu.hzuapps.androidlabs.R;

public class Net1414080903202Main_Check extends AppCompatActivity {
    private List<Net1414080903202Account> list;
    private Net1414080903202AccountDao dao;
    private ListView accountCheck;
    private MyAdpapter adpater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903202_main_check);
        initView();
        dao=new Net1414080903202AccountDao(this);
        //从数据库中查询出所有数据
        list=dao.queryAll();
        adpater=new MyAdpapter();
        accountCheck.setAdapter(adpater);                          //给ListView添加适配器
    }

    //初始化控件
    private void initView(){
        accountCheck=(ListView) findViewById(R.id.accountCheck);
        //添加监听器
        accountCheck.setOnItemClickListener(new MyOnItemClickListener());
    }

    //自定义适配器
    private class MyAdpapter extends BaseAdapter{
        public int getCount(){                                  //获取条目总数
            return list.size();
        }

        @Override
        public Object getItem(int position) {                   //根据位置获取对象
            return null;
        }

        @Override
        public long getItemId(int position) {                  //根据位置获取ID
            return 0;
        }

        //获取一个条目视图
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View item=LayoutInflater.from(Net1414080903202Main_Check.this).inflate(R.layout.activity_net1414080903202_list_check,null);
            TextView date=(TextView) item.findViewById(R.id.date);
            TextView input=(TextView) item.findViewById(R.id.input);
            TextView output=(TextView) item.findViewById(R.id.output);
            TextView beizhu=(TextView) item.findViewById(R.id.beizhu);
            TextView yingkui=(TextView) item.findViewById(R.id.yingkui);
            TextView total=(TextView) item.findViewById(R.id.total);
            date.setText(list.get(position).getDate());
            input.setText(list.get(position).getInput()+"");
            output.setText(list.get(position).getOutput()+"");
            beizhu.setText(list.get(position).getBeizhu());
            yingkui.setText(list.get(position).getYingkui()+"");
            total.setText(list.get(position).getTotal()+"");
            return null;
        }

    }

    //ListView的Item点击事件
    private class MyOnItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //获取点击位置上的数据
            Net1414080903202Account a=(Net1414080903202Account) parent.getItemAtPosition(position);
            Toast.makeText(getApplicationContext(),a.toString(),Toast.LENGTH_SHORT).show();
        }
    }
}

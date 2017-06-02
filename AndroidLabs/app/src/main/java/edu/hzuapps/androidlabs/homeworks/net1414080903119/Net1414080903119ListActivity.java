package edu.hzuapps.androidlabs.homeworks.net1414080903119;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.linjingzhen.R;

import java.util.List;

public class Net1414080903119ListActivity extends AppCompatActivity {

    ListView lv;
    List<Teacher> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903119_list);
        list= Net1414080903119Presenter.getInstance(this).listTeacher();
        final MyAdapter adapter=new MyAdapter();
        lv.setAdapter(adapter);
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Net1414080903119Presenter.getInstance(Net1414080903119ListActivity.this).deleteTeacher(list.get(position).getName());
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
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView==null){
                convertView= LayoutInflater.from(Net1414080903119ListActivity.this).inflate(R.layout.item_net1414080903119,null);
            }
            Teacher teacher=list.get(position);
            TextView tvName= (TextView) findViewById(R.id.tv_item_name);
            TextView tvAge= (TextView) findViewById(R.id.tv_item_age);;
            TextView tvSchool= (TextView) findViewById(R.id.tv_item_school);;
            TextView tvHours= (TextView) findViewById(R.id.tv_item_hours);;
            tvAge.setText(teacher.getAge());
            tvName.setText(teacher.getName());
            tvSchool.setText(teacher.getSchool());
            tvHours.setText(teacher.getHours());
            return convertView;
        }
    }
}

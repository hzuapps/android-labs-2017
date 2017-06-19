package edu.androidlabs.homeworks.Net1414080903113;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.studentjob.R;

import java.util.ArrayList;
import java.util.List;

public class Net1414080903113ListInfoActivity extends AppCompatActivity {

    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903113_list_info);
        lv= (ListView) findViewById(R.id.lv);
        Net1414080903113ListInfoActivity.MyAdapter adapter=new MyAdapter(getData(),this);
        lv.setAdapter(adapter);
    }
    public List<Net1414080903113JobInfo> getData(){
        List<Net1414080903113JobInfo> beans=new ArrayList<>();
        Net1414080903113MySQLiteOpenHelper helper=new Net1414080903113MySQLiteOpenHelper(this);
        SQLiteDatabase db=helper.getReadableDatabase();
        Cursor cursor=db.query("job",null,null,null,null,null,null);
        while(cursor.moveToNext()){
            Log.d("asdfsadf", "getData: ");
            Net1414080903113JobInfo bean=new Net1414080903113JobInfo();
            bean.setOccurTime(cursor.getString(cursor.getColumnIndex("occur_tim")));
            bean.setSalary(cursor.getString(cursor.getColumnIndex("salary")));
            bean.setName(cursor.getString(cursor.getColumnIndex("name")));
            bean.setLocation(cursor.getString(cursor.getColumnIndex("location")));
            beans.add(bean);
        }
        cursor.close();
        db.close();
        return beans;
    }


    public class MyAdapter extends BaseAdapter {

        List<Net1414080903113JobInfo> beans;
        Context context;

        public MyAdapter(List<Net1414080903113JobInfo> beans, Context context) {
            this.beans = beans;
            this.context = context;
        }

        @Override
        public int getCount() {
            return beans.size();
        }

        @Override
        public Object getItem(int position) {
            return beans.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView==null)
                convertView= LayoutInflater.from(context).inflate(R.layout.net1414080903113_item_recoed,null);
            TextView tvElectricity= (TextView) convertView.findViewById(R.id.tv_item_location);
            TextView tvWater= (TextView) convertView.findViewById(R.id.tv_item_water);
            TextView tvTotal= (TextView) convertView.findViewById(R.id.tv_item_salary);
            TextView tvDate= (TextView) convertView.findViewById(R.id.tv_item_time);
            tvElectricity.setText(beans.get(position).getLocation());
            tvWater.setText(beans.get(position).getName());
            tvTotal.setText(beans.get(position).getSalary());
            tvDate.setText(beans.get(position).getOccurTime());
            return convertView;
        }
    }
}

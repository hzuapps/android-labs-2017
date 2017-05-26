package edu.hzuapps.androidlabs.homeworks.net1414080903117;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import edu.hzuapps.androidlabs.R;

public class Net1414080903117RecordActivity extends AppCompatActivity {

    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903117_record);
        lv= (ListView) findViewById(R.id.lv);
        MyAdapter adapter=new MyAdapter(getData(),this);
        lv.setAdapter(adapter);
    }
    public List<Net1414080903117RecordBean> getData(){
        List<Net1414080903117RecordBean> beans=new ArrayList<>();
        Net1414080903117MySQLiteOpenHelper helper=new Net1414080903117MySQLiteOpenHelper(this);
        SQLiteDatabase db=helper.getReadableDatabase();
        Cursor cursor=db.query("record",null,null,null,null,null,null);
        while(cursor.moveToNext()){
            Net1414080903117RecordBean bean=new Net1414080903117RecordBean();
            bean.setDate(cursor.getString(cursor.getColumnIndex("date")));
            bean.setElectricity(cursor.getDouble(cursor.getColumnIndex("electricity")));
            bean.setWater(cursor.getDouble(cursor.getColumnIndex("water")));
            beans.add(bean);
        }
        return beans;
    }


    public class MyAdapter extends BaseAdapter{

        List<Net1414080903117RecordBean> beans;
        Context context;

        public MyAdapter(List<Net1414080903117RecordBean> beans, Context context) {
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
                convertView=LayoutInflater.from(context).inflate(R.layout.item_net1414080903117_recoed,null);
            TextView tvElectricity= (TextView) convertView.findViewById(R.id.tv_item_electricity);
            TextView tvWater= (TextView) convertView.findViewById(R.id.tv_item_water);
            TextView tvTotal= (TextView) convertView.findViewById(R.id.tv_item_total);
            TextView tvDate= (TextView) convertView.findViewById(R.id.tv_item_date);
            tvElectricity.setText(String.valueOf(beans.get(position).getElectricity()));
            tvWater.setText(String.valueOf(beans.get(position).getWater()));
            tvTotal.setText(String.valueOf(beans.get(position).getElectricity()+beans.get(position).getWater()));
            tvDate.setText(beans.get(position).getDate());
            return convertView;
        }
    }
}

package edu.hzuapps.androidlabs.homeworks.net1414080903140;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Net1414080903140RecordActivity extends AppCompatActivity {


    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903140_record);
        final List<Net1414080903140Bean> list=getData();
        rv= (RecyclerView) findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new RecyclerView.Adapter() {

            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View item=LayoutInflater.from(Net1414080903140RecordActivity.this).inflate(R.layout.item,parent);
                return new MyHolder(item);
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                MyHolder myHolder= (MyHolder) holder;
                myHolder.tvTime.setText(list.get(position).getDate());
                myHolder.tvScore.setText(list.get(position).getScore());
            }

            @Override
            public int getItemCount() {
                return list.size();
            }
        });
    }
    class MyHolder extends RecyclerView.ViewHolder{

        TextView tvTime;
        TextView tvScore;

        private MyHolder(View itemView) {
            super(itemView);
            tvScore= (TextView) itemView.findViewById(R.id.tv_item_score);
            tvTime= (TextView) itemView.findViewById(R.id.tv_item_time);
        }
    }
    public List<Net1414080903140Bean> getData(){
        List<Net1414080903140Bean> list=new ArrayList<>();
        Net1414080903140MyOpenHelper helper=new Net1414080903140MyOpenHelper(this);
        SQLiteDatabase db=helper.getReadableDatabase();
        Cursor cursor=db.query("record",null,null,null,null,null,null);
        while (cursor.moveToNext()){
            Net1414080903140Bean bean=new Net1414080903140Bean();
            bean.setScore(cursor.getInt(cursor.getColumnIndex("score")));
            bean.setDate(cursor.getString(cursor.getColumnIndex("play_time")));
            list.add(bean);
        }
        cursor.close();
        return list;
    }
}

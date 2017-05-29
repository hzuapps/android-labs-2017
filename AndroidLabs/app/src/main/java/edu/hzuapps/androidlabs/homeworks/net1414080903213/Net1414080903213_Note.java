package edu.hzuapps.androidlabs.homeworks.net1414080903213;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

/**
 * Created by 刘泽钊 on 2017/4/16.
 */

public class Net1414080903213_Note extends AppCompatActivity {
    private ListView mylistview;
    private EditText mynote;
    private MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_net1414080903213);
        mylistview=(ListView) findViewById(R.id.lv);
        adapter=new MyAdapter();
        mylistview.setAdapter(adapter);
        Button b4 = (Button) findViewById(R.id.note_save);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }
    private class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return null;
        }
    }
}
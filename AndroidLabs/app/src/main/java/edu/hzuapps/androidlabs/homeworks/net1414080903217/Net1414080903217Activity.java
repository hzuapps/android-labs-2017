package edu.hzuapps.androidlabs.homeworks.net1414080903217;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import edu.hzuapps.androidlabs.homeworks.net1414080903217.Bean.Mypicture;
import edu.hzuapps.androidlabs.homeworks.net1414080903217.dao.PictureDao;

public class Net1414080903217Activity extends AppCompatActivity {
private ListView listView;
    protected void onCreate(Bundle savedInstanceState) {
        FloatingActionButton b1= (FloatingActionButton) findViewById(R.id.fab);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_picture_net1414080903217);
        MyListView();



    b1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Net1414080903217Activity.this,Net1414080903217_xml.class);
            startActivity(intent);
        }
    });}
    public void MyListView(){
        final String[] strings = new String[]{
                "图片1",
                "图片2",
                "图片3",
                "图片4"

        };
        int[] imgId = new int[]{
                R.drawable.a,
                R.drawable.b,
                R.drawable.c,
                R.drawable.d

        };
        listView = (ListView)findViewById(R.id.list_view);
        List<Map<String,Object>> listItems = new ArrayList<Map<String, Object>>();
        for (int i=0;i<strings.length;i++){
            Map<String,Object> listItem = new HashMap<String,Object>();
            listItem.put("img",imgId[i]);
            listItem.put("text",strings[i]);
            listItems.add(listItem);
        }
        SimpleAdapter mSimpleAdapter = new SimpleAdapter(this,listItems,R.layout.content_load_picture_net1414080903217,new String[]{"img","text"},new int[]{R.id.image_view,R.id.text_view});
        listView.setAdapter(mSimpleAdapter);


            }

    }

package edu.hzuapps.andridlabs.homeworks.net1414080903139;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import edu.hzuapps.andridlabs.homeworks.net1414080903139.MySQLiteHelper;
import edu.hzuapps.myapplication.R;

public class Net1414080903139CheckActivity extends AppCompatActivity {

    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903139_check);
        lv= (ListView) findViewById(R.id.lv);
        MySQLiteHelper helper=new MySQLiteHelper(this);
        SQLiteDatabase db=helper.getReadableDatabase();
        Cursor cursor=db.query("birthday",null,null,null,null,null,null);
        List<String> beans=new ArrayList<>();
        while (cursor.moveToNext()){
            String item=cursor.getString(cursor.getColumnIndex("name"))+" 生日： "+cursor.getString(cursor.getColumnIndex("birthday"));
            beans.add(item);
        }
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,beans);
        lv.setAdapter(adapter);

    }


}

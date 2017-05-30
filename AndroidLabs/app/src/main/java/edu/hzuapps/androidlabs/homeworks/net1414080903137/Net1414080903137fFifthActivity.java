package edu.hzuapps.androidlabs.homworks.net1414080903137;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.util.Log;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import edu.hzuapps.androidlabs.R;

public class Net1414080903137fFifthActivity extends AppCompatActivity {

    private GoodsDatabaseHelper dbHelper;
    private EditText delete_name;
    private Button shan;
    String goodsname;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.net1414080903137fifth);

        dbHelper = new GoodsDatabaseHelper(this, "Goods.db", null, 2);
        delete_name = (EditText) findViewById(R.id.delete_name);
        shan = (Button) findViewById(R.id.shancu);
        Log.d("fifth",shan.toString());
        shan.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                goodsname = delete_name.getText().toString();
                delete(goodsname);
            }
        });
    }

    public void delete(String goodsname){
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        ContentValues values=new ContentValues();


        db.delete("goods","goodsname=?",new String[]{goodsname});
        Toast.makeText(this,"删除成功",Toast.LENGTH_SHORT).show();

    }
}
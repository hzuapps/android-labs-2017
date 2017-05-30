package edu.hzuapps.androidlabs.homworks.net1414080903137;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import edu.hzuapps.androidlabs.R;

public class Net1414080903137FourthActivity extends AppCompatActivity  {


    private GoodsDatabaseHelper dbHelper;
    private EditText goodname;
    private EditText goodnumber;
    private Button sumbit;
    String goodsname;
    String goodsnumber;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.net1414080903137fourth);
        dbHelper = new GoodsDatabaseHelper(this, "Goods.db", null, 2);
        goodname = (EditText) findViewById(R.id.Editname);
        goodnumber = (EditText) findViewById(R.id.Editnumber);
        sumbit = (Button) findViewById(R.id.sumbit);

        sumbit.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                goodsname = goodname.getText().toString();
                goodsnumber = goodnumber.getText().toString();
                insert(goodsname, goodsnumber);

            }
        });
    }

    public void insert(String goodsname,String goodsnumber){
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("goodsname",goodsname);
        values.put("goodsnumber",goodsnumber);
        db.insert("goods",null,values);
        Toast.makeText(this,"添加成功",Toast.LENGTH_SHORT).show();
        values.clear();
    }
}

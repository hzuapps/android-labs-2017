package edu.hzuapps.androidlabs.homworks.net1414080903137;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import edu.hzuapps.androidlabs.R;

public class Net1414080903137ThirdActivity extends AppCompatActivity {

    private EditText goodname;
    private EditText goodnumber;
    private Button xiugai;
    private GoodsDatabaseHelper dbHelper;
    String goodsname;
    String goodsnumber;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.net1414080903137third);
            dbHelper = new GoodsDatabaseHelper(this, "Goods.db", null, 2);
            goodname = (EditText) findViewById(R.id.xiugai_name);
            goodnumber = (EditText) findViewById(R.id.xiugai_number);
        xiugai = (Button) findViewById(R.id.xiugai);

        xiugai.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    goodsname=goodname.getText().toString();
                    goodsnumber=goodnumber.getText().toString();

                    update(goodsname,goodsnumber);
                }
        });
    }



        public void update(String goodsname,String goodsnumber){
            SQLiteDatabase db=dbHelper.getWritableDatabase();
            ContentValues values=new ContentValues();

            values.put("goodsnumber", goodsnumber);
            db.update("goods", values, "goodsname = ?", new String[] {goodsname});

            Toast.makeText(this,"修改成功",Toast.LENGTH_SHORT).show();
            values.clear();
        }
    }



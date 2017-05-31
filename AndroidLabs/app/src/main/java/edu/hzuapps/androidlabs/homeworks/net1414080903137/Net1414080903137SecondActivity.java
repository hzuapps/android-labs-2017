package edu.hzuapps.androidlabs.homworks.net1414080903137;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import edu.hzuapps.androidlabs.R;

public class Net1414080903137SecondActivity extends AppCompatActivity {
    private GoodsDatabaseHelper dbHelper;
    private List<Goods_info> goods_infoList=new ArrayList<>();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.net1414080903137second);
        showlist();
        final GoodsAdapter adapter=new GoodsAdapter(Net1414080903137SecondActivity.this,R.layout.goods_item,goods_infoList);
        ListView listView=(ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }

    public void showlist(){
        dbHelper=new GoodsDatabaseHelper(this,"Goods.db",null,2);
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        Cursor cursor=db.query("goods",null,null,null,null,null,null);
        if(cursor.moveToFirst()) {
            do {
                String goodsname = cursor.getString(cursor.getColumnIndex("goodsname"));
                String goodsnumber=cursor.getString(cursor.getColumnIndex("goodsnumber"));
                //Toast.makeText(this,workcontent,Toast.LENGTH_SHORT).show();
                Goods_info goods_info = new Goods_info();
                goods_info.setGoodsname(goodsname);
                goods_info.setGoodsnumber(goodsnumber);
                goods_infoList.add(goods_info);
            }while(cursor.moveToNext());
        }
        cursor.close();
    }
}

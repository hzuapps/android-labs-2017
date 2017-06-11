package edu.hzuapps.androidlabs.homeworks.net1414080903202;

import android.accounts.Account;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.renderscript.Sampler;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by Administrator on 2017/5/26.
 */

public class Net1414080903202AccountDao {
    private Net1414080903202MyHelper helper;
    public Net1414080903202AccountDao(Context context){
        //创建Dao时，创建Helper
        helper=new Net1414080903202MyHelper(context);
    }

    public void insert(Net1414080903202Account account){
        //获取数据对象
        SQLiteDatabase db=helper.getWritableDatabase();
        //用来装载要插入的数据的MAP
        ContentValues values=new ContentValues();
        values.put("date",account.getDate());
        values.put("input",account.getInput());
        values.put("output",account.getOutput());
        values.put("beizhu",account.getBeizhu());
        values.put("yingkui",account.getYingkui());
        values.put("total",account.getTotal());
        //向account表插入数据values
        db.insert("account",null,values);
        db.close();
    }

    public List<Net1414080903202Account> queryAll() {
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.query("account", null, null, null, null, null, null);
        List<Net1414080903202Account> list = new ArrayList<>();
        while (cursor.moveToNext()) {
            String date = cursor.getString(cursor.getColumnIndex("date"));
            Float input = cursor.getFloat(1);
            Float output = cursor.getFloat(2);
            String beizhu = cursor.getString(3);
            Float yingkui = cursor.getFloat(4);
            Float total = cursor.getFloat(5);
            list.add(new Net1414080903202Account(date, input, output, beizhu, yingkui, total));
        }
        cursor.close();
        db.close();
        return list;
    }
}

package edu.hzuapps.androidlabs.homework.net1414080903234;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/5/26.
 */

public class Outlaydao {
    private CostSQLiteOpenHelper helper;
    public Outlaydao(Context context){
        helper  = new CostSQLiteOpenHelper(context);
    }
    public int  add(Outlay out){
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("out_money",out.getMoney());
        values.put("usage",out.getUsage());
        values.put("out_date",out.getDate());
        int id = (int)db.insert("outlay",null,values);
        db.close();
        return id;
    }
    public int delete(int id){
        String stringid = String.valueOf(id);
        SQLiteDatabase db = helper.getWritableDatabase();
        int number = db.delete("outlay","id=?",new String[]{stringid});
        db.close();
        return number;
    }
    public List<Outlay> findALL() {
        List<Outlay> outlays = new ArrayList<Outlay>();
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.query("outlay",new String[]{"id","out_money","usage","out_date"},null,null,null,null,null);
        while(cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String usage = cursor.getString((cursor.getColumnIndex("usage")));
            double money = cursor.getDouble(cursor.getColumnIndex("out_money"));
            String date = cursor.getString(cursor.getColumnIndex("out_date"));
            Outlay out = new Outlay();
            out.setId(id);
            out.setMoney(money);
            out.setUsage(usage);
            out.setDate(date);
            outlays.add(out);
        }
        db.close();
        cursor.close();
        return outlays;
    }
}

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

public class Incomedao {
    private CostSQLiteOpenHelper helper;
    public Incomedao(Context context){
        helper  = new CostSQLiteOpenHelper(context);
    }
    public int add(Income in){
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("payer",in.getPayer());
        values.put("in_money",in.getMoney());
        values.put("in_date",in.getDate());
        int id = (int)db.insert("income",null,values);
        db.close();
        return id;
    }
    public boolean find(String payer){
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.query("income",null,"payer=?",new String[]{payer},null,null,null);
        boolean result = cursor.moveToNext();
        cursor.close();
        db.close();
        return result;
    }
    public int delete(int id){
        String stringid = String.valueOf(id);
        SQLiteDatabase db = helper.getWritableDatabase();
        int number = db.delete("income","id=?",new String[]{stringid});
        db.close();
        return number;
    }
    public List<Income> findALL() {
        List<Income> incomes = new ArrayList<Income>();
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.query("income",new String[]{"id","payer","in_money","in_date"},null,null,null,null,null);
        while(cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String payer = cursor.getString((cursor.getColumnIndex("payer")));
            double money = cursor.getDouble(cursor.getColumnIndex("in_money"));
            String date = cursor.getString(cursor.getColumnIndex("in_date"));
            Income in = new Income();
            in.setId(id);
            in.setPayer(payer);
            in.setMoney(money);
            in.setDate(date);
            incomes.add(in);
        }
        db.close();
        cursor.close();
        return incomes;
    }
}

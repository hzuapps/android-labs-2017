package edu.hzuapps.androidlabs.homework.net1414080903234;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by admin on 2017/5/26.
 */

public class CostSQLiteOpenHelper extends SQLiteOpenHelper {
    public CostSQLiteOpenHelper(Context context){
        super(context,"cost.db",null,5);
    }
    public void onCreate(SQLiteDatabase db){
        db.execSQL("create table income(id integer primary key autoincrement," +
                "payer varchar(20)," +
                "in_money money," +
                "in_date date)");
        db.execSQL("create table outlay(id integer primary key autoincrement," +
                "out_money money," +
                "usage varchar(200)," +
                "out_date date)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

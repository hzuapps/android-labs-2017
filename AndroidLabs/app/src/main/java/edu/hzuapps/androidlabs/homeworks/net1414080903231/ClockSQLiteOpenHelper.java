package edu.hzuapps.androidlabs.homeworks.net1414080903231;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import edu.hzuapps.androidlabs.homeworks.net1414080903231.Net1414080903231Time;


public class ClockSQLiteOpenHelper extends SQLiteOpenHelper {

    public  ClockSQLiteOpenHelper(Context context){
        super(context,"clock.db",null,5);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table alarmclock (id integer primary key autoincrement, hour integer, minute integer, "
                + "repeatCycle varchar(20), ring varchar(20), shake integer, tag varchar(20) )";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("alter table person add account varchar(20)");
    }



}

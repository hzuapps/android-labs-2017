package edu.hzuapps.androidlabs.homeworks.net1414080903131;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2017/5/26.
 */

public class Net1414080903131MySQLiteOpenHelper extends SQLiteOpenHelper {
    public Net1414080903131MySQLiteOpenHelper(Context context) {
        super(context, "student", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table student(id varchar(20) primary key," +
                "name varchar(20)," +
                "sex varchar(20)," +
                "clazz varchar(20)," +
                "dormitory varchar(20));");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

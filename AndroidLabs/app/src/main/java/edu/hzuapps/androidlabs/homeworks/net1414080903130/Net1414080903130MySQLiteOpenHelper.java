package edu.hzuapps.androidlabs.homeworks.net1414080903130;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 程序出错 on 2017/5/25.
 */

public class Net1414080903130MySQLiteOpenHelper extends android.database.sqlite.SQLiteOpenHelper {
    public Net1414080903130MySQLiteOpenHelper(Context context) {
        super(context, "Hotel", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table user(username varchar(20),password varchar(20),customer varchar(4));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

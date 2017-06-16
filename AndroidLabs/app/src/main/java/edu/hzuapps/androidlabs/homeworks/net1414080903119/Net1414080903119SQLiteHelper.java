package edu.hzuapps.androidlabs.homeworks.net1414080903119;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2017/5/31.
 */

public class Net1414080903119SQLiteHelper extends SQLiteOpenHelper {


    public Net1414080903119SQLiteHelper(Context context) {
        super(context, "teacher", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table teacher(name varchar(20),school varchar(20),hours varchar(20),age varchar(20));");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

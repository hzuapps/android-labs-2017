package edu.hzuapps.androidlabs.homeworks.net1409081602222;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2017/6/2.
 */

public class Net1409081602222Helper extends SQLiteOpenHelper {
    public Net1409081602222Helper(Context context) {
        super(context, "record", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table certificate(name varchar(255),apply_time varchar(20));");
        db.execSQL("create table budget(money varchar(255));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

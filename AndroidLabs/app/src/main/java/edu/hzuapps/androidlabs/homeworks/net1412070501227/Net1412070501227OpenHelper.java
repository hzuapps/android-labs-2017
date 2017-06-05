package edu.hzuapps.androidlabs.homeworks.net1412070501227;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2017/6/5.
 */

public class Net1412070501227OpenHelper extends SQLiteOpenHelper {
    public Net1412070501227OpenHelper(Context context) {
        super(context, "car", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table car(name varchar(50),phone varchar(50),location varchar(100),id varchar(10));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

package edu.hzuapps.androidlabs.homeworks.net1414080903117;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2017/4/27.
 */

public class Net1414080903117MySQLiteOpenHelper extends SQLiteOpenHelper {


    public Net1414080903117MySQLiteOpenHelper(Context context) {
        super(context, "fee", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table record(\n" +
                "electricity double,\n" +
                "water double,\n" +
                "date varchar(20)\n" +
                ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

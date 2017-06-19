package edu.androidlabs.homeworks.Net1414080903113;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2017/5/26.
 */

public class Net1414080903113MySQLiteOpenHelper extends SQLiteOpenHelper {
    public Net1414080903113MySQLiteOpenHelper(Context context) {
        super(context, "studentJob", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table job("+
                "name varchar(20)," +
                "salary varchar(20)," +
                "location varchar(20)," +
                "occur_tim varchar(20));");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

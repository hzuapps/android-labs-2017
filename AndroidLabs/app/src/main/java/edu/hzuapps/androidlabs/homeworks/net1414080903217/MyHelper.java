package edu.hzuapps.androidlabs.homeworks.net1414080903217.dao;

/**
 * Created by mgb on 2017/6/6.
 */


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyHelper extends SQLiteOpenHelper {

    public MyHelper(Context context) {
        super(context, "Picture.db", null, 2);
    }

    public void onCreate(SQLiteDatabase db) {
        System.out.println("onCreate");
        db.execSQL("CREATE TABLE picture(imgId INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "strings VARCHAR(20),");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        System.out.println("onUpgrade");
    }
}

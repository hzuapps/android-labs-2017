package edu.hzuapps.androidlabs.homeworks.net1414080903105;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2017/6/16.
 */

public class Net1414080903105MySqlOpenHelper extends SQLiteOpenHelper {
    public Net1414080903105MySqlOpenHelper(Context context) {
        super(context, "football", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table info(" +
                "name varchar(20)," +
                "age integer," +
                "height double," +
                "weight double," +
                "nation varchar(20));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

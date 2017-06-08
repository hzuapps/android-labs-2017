package edu.hzuapps.androidlabs.homeworks.net1414080903140;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2017/5/18.
 */

public class Net1414080903140MyOpenHelper extends SQLiteOpenHelper {
    public Net1414080903140MyOpenHelper(Context context) {
        super(context, "game", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        db.execSQL("create table record(play_time varchar(20),score integer);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

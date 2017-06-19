package edu.hzuapps.androidlabs.net1414080903109;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2017/5/31.
 */

/*SQLHelper*/
public class Net1414080903109OpenHelper extends SQLiteOpenHelper {


    public Net1414080903109OpenHelper(Context context) {
        super(context,"day", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table day(name varchar(20),occur varchar(20));");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

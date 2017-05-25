package edu.hzuapps.androidlabs.homeworks.net1414080903133;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2017/5/14.
 */

public class Net1414080903133MySqlHelper extends SQLiteOpenHelper {

    public Net1414080903133MySqlHelper(Context context) {
        super(context, "student", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table student(\n" +
                "id varchar(20) primary key,\n" +
                "name varchar(20),\n" +
                "sex varchar(4),\n" +
                "clazz varchar(20),\n" +
                "dormitory varchar(20),\n" +
                "phone varchar(20),\n" +
                "age varchar(20),\n" +
                "location varchar(20)\n" +
                ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

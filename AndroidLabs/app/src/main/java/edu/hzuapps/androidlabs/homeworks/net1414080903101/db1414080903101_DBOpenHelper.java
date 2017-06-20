package com.intelligent_chest.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Czd on 2017/6/1.
 * function:
 */

class DBOpenHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;//版本
    private static final String DB_NAME = "user.db";//数据库名
    public static final String TABLE_NAME = "user";//表名
    public static final String PSW = "psw";//表中的列名
    public static final String NAME = "name";//表中的列名
    private static final String CREATE_TABLE =
            "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ( "
                    + "id Integer primary key autoincrement, "
                    + NAME + " varchar(20), "
                    + PSW + " varchar(20))";


    public DBOpenHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

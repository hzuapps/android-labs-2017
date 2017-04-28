package com.example.rem.androidlabs;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Rem on 2017/4/15.
 */
public class NoteDatabaseHelper extends SQLiteOpenHelper {
    public static final String CREATE_NOTE = "create table note("
            + "id integer primary key autoincrement,"
            + "name text,"
            + "time text)";

    private Context noteContext;

    public NoteDatabaseHelper(Context context, String name,
                              SQLiteDatabase.CursorFactory factory,
                              int version) {
        super(context, name, factory, version);
        noteContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_NOTE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

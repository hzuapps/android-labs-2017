package edu.hzuapps.androidlabs.homeworks.net1414080903212;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class HomeworkSQLiteOpenHelper extends SQLiteOpenHelper {
    public HomeworkSQLiteOpenHelper(Context context) {
        super(context, "homework.db", null, 5);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table assign_homework( id integer primary key autoincrement,"+
                "homework_title varchar(40),"+
                "homework_content varchar(100),"+
                "submit_time varchar(15))");
        db.execSQL("create table mark_homework(idm integer primary key autoincrement," +
                "stuid varchar(13)," +
                "mark_title varchar(40)," +
                "grade varchar(5)," +
                "comment varchar(50))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

}

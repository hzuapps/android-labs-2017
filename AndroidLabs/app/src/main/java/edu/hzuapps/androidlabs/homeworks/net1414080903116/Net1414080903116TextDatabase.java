package edu.hzuapps.androidlabs.homeworks.net1414080903116;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Net1414080903116TextDatabase extends SQLiteOpenHelper{
    public Net1414080903116TextDatabase(Context context){

        super(context,"social.db",null,2);
    }
    public void onCreate(SQLiteDatabase db){
        System.out.println("onCreate");
        db.execSQL("CREATE TABLE text_database(_id INTEGER PRIMARY KEY AUTOINCREMENT,promulgator VARCHAR(20) not null,text_dynamic VARCHAR(80) not null)");
    }
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
        System.out.println("onUpgrade");
    }
}
package edu.hzuapps.androidlabs.homeworks.net1414080903202;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2017/5/15.
 */

public class Net1414080903202MyHelper extends SQLiteOpenHelper{

    public Net1414080903202MyHelper(Context context){
        super(context,"itcast",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println("onCreate");
        db.execSQL("CREATE TABLE accont(date VARCHAR(20) PRIMARY KEY AUTOINCREMENT,input REA" +
                "L,output REAL,beizhu VARCHAR(20),yingkui REAL,total REAL)");
    }
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
        System.out.println("onUpgrade");
    }

}

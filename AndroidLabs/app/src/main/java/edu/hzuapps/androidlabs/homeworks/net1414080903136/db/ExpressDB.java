
package edu.hzuapps.androidlabs.homworks.net1414080903136.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;




public class ExpressDB extends SQLiteOpenHelper{

    //数据库版本号
    private static final int DATABASE_VERSION=1;
    //数据库名称
    private static final String DATABASE_NAME="express.db";
    public ExpressDB(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {

        //创建数据表

      String CREATE_TABLE_EXPRESS="CREATE TABLE Express("
                +"ExpressCom TEXT,"
                +"ExNumber TEXT,"
                +"ExTime TEXT,"
                +"ExContext TEXT,"
                +"ExStatus TEXT)";
        db.execSQL(CREATE_TABLE_EXPRESS);
   }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Express");

        onCreate(db);
    }
}


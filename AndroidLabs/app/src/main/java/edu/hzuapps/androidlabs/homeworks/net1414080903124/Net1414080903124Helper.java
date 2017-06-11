package edu.hzuapps.androidlabs.homeworks.net1414080903124;

import android.content.Context;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
/**
 * Created by home-wbq on 2017/6/6.
 */

public class Net1414080903124Helper extends SQLiteOpenHelper {
    private final static String DATABASE_NAME = "account.db";
    private final static int DATABASE_VERSION = 1;
    private final static String TABLE_NAME = "account_table";
    public final static String USER_ID = "user_id";
    public final static String USER_NAME = "user_name";
    public final static String USER_NUMBER = "user_number";
    public final static String USER_BALANCE = "user_balance";
    public Net1414080903124Helper (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE_NAME + " (" + USER_ID
                + " INTEGER primary key autoincrement, " + USER_NAME+ " text, "+USER_NUMBER +" text"+USER_BALANCE+"texr);";
        db.execSQL(sql);
    }
    //查询操作
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){}
    public Cursor select() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db
                .query(TABLE_NAME, null, null, null, null, null, null);
        return cursor;
    }
    //增加操作
    public long insert(String name,String number)
    {
        SQLiteDatabase db = this.getWritableDatabase();
/* ContentValues */
        ContentValues cv = new ContentValues();
        cv.put(USER_NAME, name);
        cv.put(USER_NUMBER, number);
        long row = db.insert(TABLE_NAME, null, cv);
        return row;
    }
    //删除操作
    public void delete(int id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String where = USER_ID + " = ?";
        String[] whereValue ={ Integer.toString(id) };
        db.delete(TABLE_NAME, where, whereValue);
    }
}

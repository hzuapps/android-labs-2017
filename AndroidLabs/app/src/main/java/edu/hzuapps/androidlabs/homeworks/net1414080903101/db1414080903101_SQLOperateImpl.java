package com.intelligent_chest.db;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.intelligent_chest.entity.User;

/**
 * Created by Czd on 2017/6/1.
 * function:接口实现类
 */
public class SQLOperateImpl implements SQLOperate {

    private DBOpenHelper dbOpenHelper;

    public SQLOperateImpl(Context context) {
        dbOpenHelper = new DBOpenHelper(context);
    }

    /**
     * 将用户输入的信息存到sqlite中
     */
    @Override
    public void add(User user) {
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
        db.execSQL("INSERT INTO user(name,psw) VALUES (?,?)",new String[]{user.getName(),user.getPsw()});
    }

    /**
     * 从sqlite中取出用户信息
     */
    @Override
    public User get(String name) {
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
        Cursor cursor = db.query(DBOpenHelper.TABLE_NAME, null, DBOpenHelper.NAME + "=?", new String[]{name}, null, null, null);
        User user = new User("","");
        if(cursor != null && cursor.moveToFirst()){
           do {
               String name2 = cursor.getString(cursor.getColumnIndex("name"));
               String psw = cursor.getString(cursor.getColumnIndex("psw"));
               user.setPsw(psw);
               user.setName(name2);
           }while (cursor.moveToNext());
        }
        return user;
    }
}

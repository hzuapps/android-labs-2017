//数据逻辑操作类
package edu.hzuapps.androidlabs.homeworks.net1414080903224;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by peng on 2017/6/1.
 */
public class N1414080903224Dao {
    private N1414080903224MyHelper helper;
    public N1414080903224Dao(Context context){
        helper=new N1414080903224MyHelper(context);
    }
    //插入数据方法
    public  void insert(N1414080903224Address address){
        SQLiteDatabase db=helper.getWritableDatabase(); //获取数据库对象
        ContentValues values=new ContentValues();
        values.put("url",address.getUrl());
        long id =db.insert("address",null,values); // 插入数据到 address 数据表里
        db.close();
    }

}

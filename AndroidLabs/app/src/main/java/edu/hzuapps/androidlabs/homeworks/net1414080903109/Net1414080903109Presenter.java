package edu.hzuapps.androidlabs.net1414080903109;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/31.
 */

public class Net1414080903109Presenter {

    private SQLiteOpenHelper helper;
    private static Net1414080903109Presenter presenter;

    private Net1414080903109Presenter(Context context){
        if (helper==null){
            helper=new Net1414080903109OpenHelper(context);
        }
    }

    public static Net1414080903109Presenter getInstance(Context context){
        if (presenter==null){
            presenter=new Net1414080903109Presenter(context);
        }
        return presenter;
    }
    
    /*添加节日*/
    public void add(Net1414080903109DayBean day){
        SQLiteDatabase db=helper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("name",day.getName());
        values.put("occur",day.getOccur());
        db.insert("day",null,values);
        db.close();
    }
   /*查找所有节日*/
    public List<Net1414080903109DayBean> list(){
        List<Net1414080903109DayBean> list=new ArrayList<>();
        SQLiteDatabase db=helper.getReadableDatabase();
        Cursor cursor=db.query("day",null,null,null,null,null,null);
        while (cursor.moveToNext()){
            Net1414080903109DayBean day=new Net1414080903109DayBean();
            day.setName(cursor.getColumnName(cursor.getColumnIndex("name")));
            day.setOccur(cursor.getColumnName(cursor.getColumnIndex("occur")));
            list.add(day);
        }
        cursor.close();
        db.close();
        return list;
    }
    
    /*删除节日*/
    public void delete(String name){
        SQLiteDatabase db=helper.getWritableDatabase();
        db.delete("day","name=?",new String[]{name});
        db.close();
    }


}

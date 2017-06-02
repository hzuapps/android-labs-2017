package edu.hzuapps.androidlabs.homeworks.net1414080903119;

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

public class Net1414080903119Presenter {

    private SQLiteOpenHelper helper;
    private static Net1414080903119Presenter presenter;

    private Net1414080903119Presenter(Context context){
        if (helper==null){
            helper=new Net1414080903119SQLiteHelper(context);
        }
    }

    public static Net1414080903119Presenter getInstance(Context context){
        if (presenter==null){
            presenter=new Net1414080903119Presenter(context);
        }
        return presenter;
    }

    public void addTeacher(Teacher teacher){
        SQLiteDatabase db=helper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("name",teacher.getName());
        values.put("age",teacher.getAge());
        values.put("school",teacher.getSchool());
        values.put("hours",teacher.getHours());
        db.insert("teacher",null,values);
        db.close();
    }

    public List<Teacher> listTeacher(){
        List<Teacher> list=new ArrayList<>();
        SQLiteDatabase db=helper.getReadableDatabase();
        Cursor cursor=db.query("teacher",null,null,null,null,null,null);
        while (cursor.moveToNext()){
            Teacher teacher=new Teacher();
            teacher.setName(cursor.getColumnName(cursor.getColumnIndex("name")));
            teacher.setAge(cursor.getColumnName(cursor.getColumnIndex("age")));
            teacher.setHours(cursor.getColumnName(cursor.getColumnIndex("hours")));
            teacher.setSchool(cursor.getColumnName(cursor.getColumnIndex("school")));
            list.add(teacher);
        }
        cursor.close();
        db.close();
        return list;
    }

    public void update(String data,String name,String where){

    }

    public void deleteTeacher(String name){
        SQLiteDatabase db=helper.getWritableDatabase();
        db.delete("teacher","name=?",new String[]{name});
        db.close();
    }


}

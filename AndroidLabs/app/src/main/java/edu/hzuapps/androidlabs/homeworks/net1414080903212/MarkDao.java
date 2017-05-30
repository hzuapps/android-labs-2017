package edu.hzuapps.androidlabs.homeworks.net1414080903212;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class MarkDao {
    public static HomeworkSQLiteOpenHelper dbHelper;
    public MarkDao(Context context){
        dbHelper = new HomeworkSQLiteOpenHelper(context);
    }

    public int mark(Mark mar){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("stuid", mar.getStuid());
        values.put("mark_title", mar.getHomework_title());
        values.put("grade", mar.getGrade());
        values.put("comment", mar.getComment());
        int idm = (int)db.insert("mark_homework", null, values);
        db.close();
        return idm;
    }

    public List<Mark> findAll() {
        List<Mark> marks = new ArrayList<Mark>();
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query("mark_homework", new String[]{"idm", "stuid", "mark_title", "grade", "comment"}, null, null, null, null, null);
        while (cursor.moveToNext()) {
            int idm = cursor.getInt(cursor.getColumnIndex("idm"));
            String stu_id = cursor.getString((cursor.getColumnIndex("stuid")));
            String mark_title = cursor.getString((cursor.getColumnIndex("mark_title")));
            String grade = cursor.getString((cursor.getColumnIndex("grade")));
            String comment = cursor.getString((cursor.getColumnIndex("comment")));
            Mark mar = new Mark();
            mar.setIdm(idm);
            mar.setStuid(stu_id);
            mar.setHomework_title(mark_title);
            mar.setGrade(grade);
            mar.setComment(comment);
            marks.add(mar);
        }
        db.close();
        cursor.close();
        return marks;
    }
}
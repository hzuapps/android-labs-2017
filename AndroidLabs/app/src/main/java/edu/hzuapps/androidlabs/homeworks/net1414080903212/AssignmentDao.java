package edu.hzuapps.androidlabs.homeworks.net1414080903212;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class AssignmentDao {
    public static HomeworkSQLiteOpenHelper dbHelper;
    public AssignmentDao(Context context){
        dbHelper = new HomeworkSQLiteOpenHelper(context);
    }

    public int assign(Assignment ass){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("homework_title", ass.getHomework_title());
        values.put("homework_content", ass.getHomework_content());
        values.put("submit_time", ass.getSubmit_time());
        int id = (int)db.insert("assign_homework", null, values);
        db.close();
        return id;
    }

    public List<Assignment> findAll() {
        List<Assignment> assignments = new ArrayList<Assignment>();
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query("assign_homework", new String[]{"id", "homework_title", "homework_content", "submit_time"}, null, null, null, null, null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String homework_title = cursor.getString((cursor.getColumnIndex("homework_title")));
            String homework_content = cursor.getString((cursor.getColumnIndex("homework_content")));
            String submit_time = cursor.getString((cursor.getColumnIndex("submit_time")));
            Assignment ass = new Assignment();
            ass.setId(id);
            ass.setHomework_title(homework_title);
            ass.setHomework_content(homework_content);
            ass.setSubmit_time(submit_time);
            assignments.add(ass);
        }
        db.close();
        cursor.close();
        return assignments;
    }
}

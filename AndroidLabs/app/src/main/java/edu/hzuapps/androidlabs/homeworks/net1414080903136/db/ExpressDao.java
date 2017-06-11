package edu.hzuapps.androidlabs.homworks.net1414080903136.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class ExpressDao  {
    private ExpressDB expressDB;

    public ExpressDao(Context context){
        expressDB=new ExpressDB(context);
    }

    public int insert(String company,String exNum,String time,String context,String status){
        SQLiteDatabase db=expressDB.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("ExpressCom",company);
        values.put("ExNumber",exNum);
        values.put("ExTime",time);
        values.put("ExContext",context);
        values.put("ExStatus",status);
        long exID=db.insert("Express",null,values);
        db.close();
        return (int)exID;
    }
    public void update(String company,String exNum,String time,String context,String status){
        SQLiteDatabase db=expressDB.getWritableDatabase();
        ContentValues values=new ContentValues();

        values.put("ExTime",time);
        values.put("ExContext",context);
        values.put("ExStatus",status);
        db.update("Express",values,"ExNumber=?",new String[] {exNum });
        db.close();
    }

    public String getContentById(String ExNumber){
        SQLiteDatabase db=expressDB.getReadableDatabase();
        String content="";
        String selectQuery="SELECT *"+
                " FROM Express"
                + " WHERE "
                +"ExNumber=?";
        int iCount=0;
        Cursor cursor=db.rawQuery(selectQuery,new String[]{ExNumber});
        if(cursor.moveToFirst()){
            do{
                content =cursor.getString(cursor.getColumnIndex("ExContext"));
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return content;
    }




}

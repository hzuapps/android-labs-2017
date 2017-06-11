package edu.hzuapps.androidlabs.homeworks.net1414080903231;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public class Net1414080903231ClockDao {

    private Context context;
    private ClockSQLiteOpenHelper dbHelper;
    private static String ALARM_CLOCK_TABLE_NAME="alarmclock";

    public Net1414080903231ClockDao(Context context) {
        this.context = context;
        dbHelper = new ClockSQLiteOpenHelper(this.context);
    }

    public void insert(int id,int hour, int minute, String repeatCycle, String ring, int isShake, String tag){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        if(db.isOpen()){
            ContentValues values = new ContentValues();
            values.put("id",id);
            values.put("hour", hour);
            values.put("minute", minute);
            values.put("repeatCycle", repeatCycle);
            values.put("ring", ring);
            values.put("shake", isShake);
            values.put("tag", tag);
            db.insert(ALARM_CLOCK_TABLE_NAME, null, values);
            db.close();
        }
    }

    /**
     * 查询所有闹钟的信息
     * @return
     */
    public List<Net1414080903231Time> findAll(){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        List<Net1414080903231Time> infos = new ArrayList<Net1414080903231Time>();
        if(db.isOpen()){
            Cursor cursor = db.query(ALARM_CLOCK_TABLE_NAME, null, null, null, null, null, null);
            while(cursor.moveToNext()){
                int id = cursor.getInt(cursor.getColumnIndex("id"));
                int hour = cursor.getInt(cursor.getColumnIndex("hour"));
                int minute = cursor.getInt(cursor.getColumnIndex("minute"));
                String repeatCycle = cursor.getString(cursor.getColumnIndex("repeatCycle"));
                String ring = cursor.getString(cursor.getColumnIndex("ring"));
                int isShake = cursor.getInt(cursor.getColumnIndex("shake"));
                String tag = cursor.getString(cursor.getColumnIndex("tag"));
                Net1414080903231Time info = new Net1414080903231Time(id, hour, minute, repeatCycle, ring, isShake, tag);
                infos.add(info);
            }
            cursor.close();
            db.close();
        }
        return infos;
    }
    //查找未被使用的ID号
    public int findid(){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        int i=0;
        int id=0;
        if(db.isOpen()){
            Cursor cursor = db.query(ALARM_CLOCK_TABLE_NAME, null, null, null, null, null, null);
            while(cursor.moveToNext()){
                if(cursor.getInt(id)!=i)break;
                else i++;
            }
            cursor.close();
            db.close();
        }
        return i;
    }


    //根据ID号删除闹钟
    public boolean deletebyid(int id){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        int rt=0;
        if(db.isOpen()){
            rt=db.delete(ALARM_CLOCK_TABLE_NAME,"id=?",new String[]{Integer.toString(id)});
            db.close();
        }
        if(rt==0)return false;
        else return true;
    }
    /**
     * 根据闹钟的 id 更新闹钟信息
     * @param id 闹钟id
     * @param hour 小时
     * @param minute 分钟
     * @param repeatCycle 重复周期
     * @param ring 铃声
     * @param tag 备注

     */
    public void update(int id, int hour, int minute, String repeatCycle, String ring, int isShake, String tag, int state){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        if(db.isOpen()){
            ContentValues values = new ContentValues();
            values.put("hour", hour);
            values.put("minute", minute);
            values.put("repeatCycle", repeatCycle);
            values.put("ring", ring);
            values.put("shake", isShake);
            values.put("tag", tag);
            db.update(ALARM_CLOCK_TABLE_NAME, values, "id ="+id, null);
            db.close();
        }
    }

}

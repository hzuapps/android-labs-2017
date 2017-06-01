package edu.hzuapps.androidlabs.homeworks.net1414080903116;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class Net1414080903116TextDynamicDao {
    private Net1414080903116TextDatabase helper;
    public Net1414080903116TextDynamicDao(Context context){
        helper=new Net1414080903116TextDatabase(context);
    }
    public void insert(Net1414080903116TextDynamic textdynamic){
        //获取数据库对象
        SQLiteDatabase db=helper.getWritableDatabase();
        //用来装载要插入的数据的Map<列名，列的值>
        ContentValues values=new ContentValues();
        values.put("promulgator",textdynamic.getPromulgator());
        values.put("text_dynamic",textdynamic.getText_dynamic());
        long id =db.insert("text_database",null,values);
        textdynamic.setId(id);
        db.close();
    }
    //根据id删除数据
    public  int delete(long id){
        SQLiteDatabase db=helper.getWritableDatabase();
        //按条件删除指定表中的数据，返回受影响的数据行数
        int count=db.delete("text_database","_id=?",new String[] {id+""});
        db.close();
        return count;
    }

    //查询所有数据的倒序排列
    public List<Net1414080903116TextDynamic> queryAll(){
        SQLiteDatabase db=helper.getReadableDatabase();
        Cursor c=db.query("text_database",null,null,null,null,null,"_id DESC");
        List<Net1414080903116TextDynamic> list=new ArrayList<>();
        while (c.moveToNext()){
            //可以根据列名获取索引
            long id=c.getLong(c.getColumnIndex("_id"));
            String promulgator=c.getString(1);
            String text_dynamic=c.getString(2);
            list.add(new Net1414080903116TextDynamic(id,promulgator,text_dynamic));
        }
        c.close();
        db.close();
        return list;

    }
}

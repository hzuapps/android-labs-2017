package edu.hzuapps.androidlabs.homeworks.net1414080903104;
/*
 * 数据逻辑操作类
 * 实现对数据库的查询操作
 * 
 */
import java.util.*;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class Visitdatabases {
	private Linkdatabases helper;
	public Visitdatabases(Context context){
		helper=new Linkdatabases(context);
	}
	public Accessdata queryOne(int num){
		SQLiteDatabase db = helper.getReadableDatabase();
		Cursor c = db.rawQuery("select * from cards where id = ?", new String[]{Integer.toString(num)});
		c.moveToNext();
		/*
		 * 原先存在问题：05-27 23:16:34.134: E/AndroidRuntime(29343): 
		 * java.lang.RuntimeException: Unable to start activity ComponentInfo
		 * {edu.hzuapps.androidlabs/edu.hzuapps.androidlabs.homeworks.net1414
		 * 080903104.Net1414080903104extractActivity}: android.database.Curso
		 * rIndexOutOfBoundsException: Index -1 requested, with a size of 1
		 * 原因在于Cursor的对象c原先就指向的是-1.
		 * 解决方案：添加c.moveToNext();
		*/
		int id = c.getInt(c.getColumnIndex("id"));
		String name = c.getString(1);
		String level = c.getString(2);
		String background = c.getString(3);
		String strength = c.getString(4);
		String defensive = c.getString(5);
		String hp = c.getString(6);
		Accessdata onecard = new Accessdata(id,name,level,background,strength,defensive,hp);
		c.close();
		db.close();
		return onecard;
		
	}
	public List<Accessdata> queryAll(){
		SQLiteDatabase db = helper.getReadableDatabase();
		Cursor c = db.query("cards", null, null, null, null, null, null);
		List<Accessdata> list = new ArrayList<Accessdata>();
		while(c.moveToNext()){
			int id = c.getInt(c.getColumnIndex("id"));
			String name = c.getString(1);
			String level = c.getString(2);
			
			list.add(new Accessdata(id,name,level));
		}
		c.close();
		db.close();
		return list;
	}

}

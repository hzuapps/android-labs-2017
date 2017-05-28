package edu.hzuapps.androidlabs.homeworks.net1414080903104;
/*
 *实现sqlite数据库连接和创建
 *已经利用软件SQLite Expert Professional初始化数据好了
 *
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class Linkdatabases extends SQLiteOpenHelper{
	public Linkdatabases (Context context){
		super(context,"card.db",null,1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		System.out.println("OnCreate");
		db.execSQL("create table cards(id integer primary key,name varchar(20),level char(5),background varchar(50),strength char(5),defensive char(5),hp char(5) )");
		//db.execSQL("insert into cards values (1,'库丘林Alter','SSR','凯尔特神话','9999','9999','9999')");
		/*ContentValues cv = new ContentValues();
		cv.put("id",1);
        cv.put("name", "库丘林Alter");
        cv.put("level", "SSR");
        cv.put("background", "凯尔特神话");
        cv.put("strength", "9999");
        cv.put("defensive", "9999");
        cv.put("hp", "9999");
        db.insert("cards", null, cv);
        */
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		// TODO Auto-generated method stub
		System.out.println("onUpGrade");
	}
}

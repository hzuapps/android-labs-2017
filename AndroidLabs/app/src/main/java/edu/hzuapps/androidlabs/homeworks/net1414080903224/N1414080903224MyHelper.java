//创建数据库的类
package edu.hzuapps.androidlabs.homeworks.net1414080903224;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.Settings;

/**
 * Created by peng on 2017/6/1.
 */
public class N1414080903224MyHelper  extends SQLiteOpenHelper{
    public  N1414080903224MyHelper(Context context){
        super (context,"item.db",null,2);  // 创建数据库，数据库名为 item
    }
    public void onCreate(SQLiteDatabase db){
        System.out.println("onCreate");
        db.execSQL("CREATE TABLE address(_id INTEGER KEY AUTOINCREMENT , path Varchar(20))") ; //创建address 数据表，字段名为 id,path
    }
    public  void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
        System.out.println("onUpgrade");
    }
}

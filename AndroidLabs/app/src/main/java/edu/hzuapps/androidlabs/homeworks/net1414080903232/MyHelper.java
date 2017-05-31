package homeworks.androidlabs.hzuapps.edu.net141408090323.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by pc on 2017/5/30.
 */

public class MyHelper extends SQLiteOpenHelper {
    public MyHelper(Context context){super(context,"itcast.db",null,2);
    }
    public void onCreate(SQLiteDatabase db)
    {
         System.out.println("onCreate");
        db.execSQL("CREATE TABLE account(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name VARCHAR(20)," +
                "TB_name VARCHAR(20)," +
                "time VARCHAR(20)," +
                "address VARCHAR(50)," +
                "phone_number VARCHAR(20)," +
                "detail VARCHAR(50))");

    }
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
        System.out.println("onUpgrade");

    }
}

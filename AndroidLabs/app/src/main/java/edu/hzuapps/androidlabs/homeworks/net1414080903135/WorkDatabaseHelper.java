package edu.hzuapps.androidlabs.homeworks.net1414080903135;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;
/**
 * Created by Administrator on 2017/5/26 0026.
 */


public class WorkDatabaseHelper extends SQLiteOpenHelper {
    public static final String CREATE_1="create table work ("
            +"course text integer primary key,"
            +"teacher text,"
            +"period text,"
            +"credit text,"
            +"classroom text)";
    private Context mContext;

    public WorkDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,int version)
    {
        super(context,name,factory,version);
        mContext=context;
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_1);
        Toast.makeText(mContext,"数据库创建成功",Toast.LENGTH_SHORT).show();
    }

    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion)
    {

    }
}


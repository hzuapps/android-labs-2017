package edu.hzuapps.androidlabs.homworks.net1414080903137;

import android.content.Context;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;
        import android.widget.Toast;


public class GoodsDatabaseHelper extends SQLiteOpenHelper {
    public static final String CREATE_TABLE="create table goods ("
            +"goodsid integer primary key autoincrement,"
            +"goodsname text,"
            +"goodsnumber text)";
    private Context mContext;

    public GoodsDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,int version)
    {
        super(context,name,factory,version);
        mContext=context;
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_TABLE);
        Toast.makeText(mContext,"数据库创建成功",Toast.LENGTH_SHORT).show();
    }

    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion)
    {

    }
}


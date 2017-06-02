package edu.hzuapps.androidlabs.homeworks.net1414080903118;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class RecordDatabaseHelper extends SQLiteOpenHelper{
	public static final String CREATE_RECORD = "create table Record("
		+"id integer primary key autoincrement,"
		+"name text,"
		+"watched integer)";

	private Context recordContext;

	public RecordDatabaseHelper(Context context,String name,
								SQLiteDatabase.CursorFactory factory,
								int version){
		super(context,name,factory,version);
		recordContext = context;
	}

	@Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_RECORD);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
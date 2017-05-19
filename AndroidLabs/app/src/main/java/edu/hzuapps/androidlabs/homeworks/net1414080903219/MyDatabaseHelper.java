package homeworks.androids.hzuapps.edu.application.net1414080903219;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by mary on 2017/5/3.
 */

public class MyDatabaseHelper extends SQLiteOpenHelper {
    public static final String CREATE_WORD="create table Word("
            +"id integer primary key autoincrement,"
            +"word string,"
            +"mean string,"
            +"status string)";

    private Context mContext;;


    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                            int version){
        super(context,name,factory,version);
        mContext=context;
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_WORD);
        Toast.makeText(mContext,"Create succeeded",Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){}
}

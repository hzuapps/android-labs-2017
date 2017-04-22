package edu.hzuapps.androidlabs.homeworks.net1414080903213;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;


/**这是保存备忘录信息的表
 * Created by 刘泽钊 on 2017/4/16.
 */

public class Net1414080903213_Data extends SQLiteOpenHelper {
    public Net1414080903213_Data(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        StringBuilder sql = new StringBuilder();
        sql.append("create table if not exists tb_bwl(")
                .append("id integer primary key autoincrement,")
                .append("title varchar(50),")
                .append("content varchar(200),")
                .append("createDate varchar(10),")
                .append("noticeDate varchar(10),")
                .append("noticeTime varchar(5) )");
        db.execSQL(sql.toString());

    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub

    }


}

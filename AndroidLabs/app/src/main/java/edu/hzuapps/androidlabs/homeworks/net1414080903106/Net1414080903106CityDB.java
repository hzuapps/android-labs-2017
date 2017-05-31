package edu.hzuapps.androidlabs.homeworks.net1414080903106;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/26.
 */

public class Net1414080903106CityDB {
    public static final String CITY_DB_NAME="city.db";
    private static final String CITY_TABLE_NAME="city";
    private SQLiteDatabase db;

    public Net1414080903106CityDB(Context context, String path){
        db=context.openOrCreateDatabase(path,Context.MODE_PRIVATE,null);
    }

    public List<Net1414080903106City> getCityList(){
        List<Net1414080903106City> list=new ArrayList<>();
        Cursor cursor=db.rawQuery("SELECT * from "+CITY_TABLE_NAME,null);
        while (cursor.moveToNext()){
            String province=cursor.getString(cursor.getColumnIndex("province"));
            String city=cursor.getString(cursor.getColumnIndex("city"));
            String number=cursor.getString(cursor.getColumnIndex("number"));
            String firstPY=cursor.getString(cursor.getColumnIndex("firstpy"));
            String allPY=cursor.getString(cursor.getColumnIndex("allpy"));
            String allFirstPY=cursor.getString(cursor.getColumnIndex("allfirstpy"));
            Net1414080903106City item=new Net1414080903106City(province,city,number,allPY,allFirstPY,firstPY);
            list.add(item);
        }
        return list;
    }

}

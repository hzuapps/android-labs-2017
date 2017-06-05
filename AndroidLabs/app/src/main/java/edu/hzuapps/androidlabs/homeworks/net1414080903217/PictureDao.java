package edu.hzuapps.androidlabs.homeworks.net1414080903217.dao;

/**
 * Created by mgb on 2017/6/6.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import edu.hzuapps.androidlabs.homeworks.net1414080903217.Bean.Mypicture;

public class PictureDao{
    private MyHelper helper;
    public PictureDao(Context context) {
        helper = new MyHelper(context);}
    public void insert(Mypicture mypicture) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("strings", mypicture.getStrings());
      long imgId = db.insert("mypicture", null, values);
      mypicture.setImgId(imgId);
        db.close();
    }

    public int delete(long imgId) {
        SQLiteDatabase db = helper.getWritableDatabase();

        int count = db.delete("mypicture", "imgId=?", new String[] { imgId + "" });
        db.close();
        return count;
    }

    public int update(Mypicture mypicture){
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("strings", mypicture.getStrings());
        int count = db.update("account", values, "imgId=?",
                new String[] { mypicture.getImgId() + "" });
        db.close();
        return count;
    }


}


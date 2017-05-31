package homeworks.androidlabs.hzuapps.edu.net141408090323.dao;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import homeworks.androidlabs.hzuapps.edu.net141408090323.cn.itcast.domain.ItemInfo;

/**
 * Created by pc on 2017/5/30.
 */

public class AccountDao {
    private MyHelper helper;
    public AccountDao(Context context)
    {
        helper=new MyHelper(context);

    }
    public void insert(ItemInfo I_account){
        SQLiteDatabase db=helper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("name",I_account.getName());
        values.put("TB_name",I_account.getTB_name());
        values.put("time",I_account.getTime());
        values.put("address",I_account.getAddress());
        values.put("phone_number",I_account.getPhone_number());
        values.put("detail",I_account.getDetail());
        long id=db.insert("account",null,values);
        I_account.setId(id);
        db.close();
    }

}

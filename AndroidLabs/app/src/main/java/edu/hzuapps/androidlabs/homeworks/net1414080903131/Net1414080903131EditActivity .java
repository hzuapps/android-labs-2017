package edu.hzuapps.androidlabs.homeworks.net1414080903131;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.example.administrator.studentinfo.R;

public class Net1414080903131EditActivity extends AppCompatActivity {

    EditText etName;
    EditText etId;
    EditText etClass;
    EditText etDormitory;
    EditText etSex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903131_edit);
        etName= (EditText) findViewById(R.id.et_edit_name);
        etClass= (EditText) findViewById(R.id.et_edit_class);
        etDormitory= (EditText) findViewById(R.id.et_edit_dormitory);
        etId= (EditText) findViewById(R.id.et_edit_id);
        etSex= (EditText) findViewById(R.id.et_edit_sex);
    }

    public void save(StudentBean bean){
        SQLiteOpenHelper helper=new Net1414080903131MySQLiteOpenHelper(this);
        SQLiteDatabase db=helper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("name",bean.getName());
        values.put("id",bean.getId());
        values.put("clazz",bean.getClazz());
        values.put("sex",bean.getSex());
        values.put("dormitory",bean.getDormitory());
        db.insert("student",null,values);
        db.close();
    }
}

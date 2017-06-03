package edu.hzuapps.andridlabs.homeworks.net1414080903139;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import edu.hzuapps.myapplication.R;

/**
 * Created by 阳飞 on 2017/4/29.
 */

public class Net1414080903139AddRecordActivity extends AppCompatActivity {

    EditText etName;
    EditText etBirthday;

    Button btSubmit;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.net1414080903139activity02);

        etBirthday= (EditText) findViewById(R.id.et_name);
        etName= (EditText) findViewById(R.id.et_birthday);

        btSubmit= (Button) findViewById(R.id.btn_submit);

        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Net1414080903139MySQLiteHelper helper=new Net1414080903139MySQLiteHelper(Net1414080903139AddRecordActivity.this);
                SQLiteDatabase db=helper.getWritableDatabase();
                ContentValues values=new ContentValues();
                values.put("birthday",etBirthday.getText().toString().trim());
                values.put("name",etName.getText().toString().trim());
                db.insert("birthday",null,values);
                db.close();
            }
        });
    }
}

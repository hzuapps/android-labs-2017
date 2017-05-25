package edu.hzuapps.androidlabs.homeworks.net1414080903133;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import edu.hzuapps.androidlabs.R;

public class Net1414080903133SaveActivity extends AppCompatActivity {

    EditText etId;
    EditText etName;
    EditText etSex;
    EditText etClazz;
    EditText etDormitory;
    EditText etAge;
    EditText etPhone;
    EditText etLocation;


    Button btSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903133_save);
        etId= (EditText) findViewById(R.id.et_save_id);
        etName= (EditText) findViewById(R.id.et_save_name);
        etSex= (EditText) findViewById(R.id.et_save_sex);
        etClazz= (EditText) findViewById(R.id.et_save_clazz);
        etAge= (EditText) findViewById(R.id.et_save_age);
        etDormitory= (EditText) findViewById(R.id.et_save_dormitory);
        etPhone= (EditText) findViewById(R.id.et_save_phone);
        etLocation= (EditText) findViewById(R.id.et_save_location);
        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Net1414080903133MySqlHelper helper=new Net1414080903133MySqlHelper(Net1414080903133SaveActivity.this);
                SQLiteDatabase db=helper.getWritableDatabase();
                ContentValues values=new ContentValues();
                values.put("id",etId.getText().toString());
                values.put("name",etName.getText().toString());
                values.put("sex",etSex.getText().toString());
                values.put("clazz",etClazz.getText().toString());
                values.put("dormitory",etDormitory.getText().toString());
                values.put("age",etAge.getText().toString());
                values.put("location",etLocation.getText().toString());
                values.put("phone",etPhone.getText().toString());
                db.insert("student",null,values);
                db.close();
            }
        });
    }
}

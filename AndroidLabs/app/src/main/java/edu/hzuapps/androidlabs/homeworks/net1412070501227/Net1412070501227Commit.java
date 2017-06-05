package edu.hzuapps.androidlabs.homeworks.net1412070501227;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import edu.hzuapps.androidlabs.R;


public class Net1412070501227Commit extends AppCompatActivity {

    EditText etName;
    EditText etPhone;
    EditText etLocation;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1412070501227_commit);
        final int carId=getIntent().getIntExtra("id",1);
        etName= (EditText) findViewById(R.id.editText3);
        etPhone= (EditText) findViewById(R.id.editText4);
        etLocation= (EditText) findViewById(R.id.editText5);
        button= (Button) findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=etName.getText().toString();
                String phone=etPhone.getText().toString();
                String location=etLocation.getText().toString();
                SQLiteOpenHelper helper=new Net1412070501227OpenHelper(Net1412070501227Commit.this);
                SQLiteDatabase db=helper.getWritableDatabase();
                ContentValues values=new ContentValues();
                values.put("name",name);
                values.put("phone",phone);
                values.put("location",location);
                values.put("id",carId);
                db.insert("car",null,values);
                db.close();
            }
        });

    }
}

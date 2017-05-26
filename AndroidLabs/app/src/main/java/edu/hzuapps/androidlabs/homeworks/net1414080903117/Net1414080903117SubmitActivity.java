package edu.hzuapps.androidlabs.homeworks.net1414080903117;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import edu.hzuapps.androidlabs.R;

public class Net1414080903117SubmitActivity extends AppCompatActivity {

    EditText etElectricity;
    EditText etWater;

    Button btSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903117_submit);

        etElectricity= (EditText) findViewById(R.id.et_submit_electricity);
        etWater= (EditText) findViewById(R.id.et_submit_water);

        btSubmit= (Button) findViewById(R.id.bt_submit_submit);

        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp=Net1414080903117SubmitActivity.this.getSharedPreferences("fee",MODE_PRIVATE);
                SharedPreferences.Editor editor=sp.edit();
                int water=sp.getInt("water",0);
                water+=Integer.parseInt(etWater.getText().toString().trim());
                editor.putInt("water",water);
                int ele=sp.getInt("ele",0);
                ele+=Integer.parseInt(etElectricity.getText().toString().trim());
                editor.putInt("ele",ele);
                editor.apply();
                Net1414080903117MySQLiteOpenHelper helper=new Net1414080903117MySQLiteOpenHelper(Net1414080903117SubmitActivity.this);
                SQLiteDatabase db=helper.getWritableDatabase();
                ContentValues values=new ContentValues();
                values.put("electricity",etElectricity.getText().toString());
                values.put("water",etWater.getText().toString());
                values.put("date", Net1414080903117TimeUtil.getDateYMD());
                db.insert("record",null,values);
                db.close();
                setResult(1);
                finish();
            }
        });
    }
}

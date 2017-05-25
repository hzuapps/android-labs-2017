package edu.hzuapps.androidlabs.homeworks.net1414080903133;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import edu.hzuapps.androidlabs.R;

public class Net1414080903133DeleteActivity extends AppCompatActivity {

    Button btDelete;
    EditText etId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903133_delete);
        btDelete= (Button) findViewById(R.id.bt_delete);
        etId= (EditText) findViewById(R.id.et_delete_id);
        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Net1414080903133MySqlHelper helper=new Net1414080903133MySqlHelper(Net1414080903133DeleteActivity.this);
                SQLiteDatabase db=helper.getWritableDatabase();
                db.delete("student","id=?",new String[]{etId.getText().toString()});
                Toast.makeText(Net1414080903133DeleteActivity.this,"delete success!!",Toast.LENGTH_SHORT).show();
            }
        });

    }
}

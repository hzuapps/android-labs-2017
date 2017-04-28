package edu.hzuapps.androidlabs.homeworks.net1414080903133;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.hzuapps.androidlabs.R;

public class Net1414080903133_Admin extends AppCompatActivity {

    Button btInsert;
    Button btUpdate;
    Button btDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903133_admin);
        btDelete = (Button) findViewById(R.id.bt_admin_delete);
        btInsert = (Button) findViewById(R.id.bt_admin_insert);
        btUpdate = (Button) findViewById(R.id.bt_admin_update);

        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Net1414080903133_Admin.this,Net1414080903133_Delete.class));
            }
        });
    }
}

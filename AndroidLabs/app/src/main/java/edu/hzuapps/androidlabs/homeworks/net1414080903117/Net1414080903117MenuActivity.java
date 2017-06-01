package edu.hzuapps.androidlabs.homeworks.net1414080903117;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.hzuapps.androidlabs.R;

public class Net1414080903117MenuActivity extends AppCompatActivity {

    Button btFee;
    Button btRecord;
    Button btsend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903117_menu);
        btFee= (Button) findViewById(R.id.bt_menu_fee);
        btRecord= (Button) findViewById(R.id.bt_menu_record);
        btsend=(Button)findViewById(R.id.bt_send);

        btFee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Net1414080903117MenuActivity.this,Net1414080903117FeeActivity.class));
            }
        });

        btRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Net1414080903117MenuActivity.this,Net1414080903117RecordActivity.class));
            }
        });
        btsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Net1414080903117MenuActivity.this,Net1414080903117ParseJsonActivity.class));
            }
        });
    }
}

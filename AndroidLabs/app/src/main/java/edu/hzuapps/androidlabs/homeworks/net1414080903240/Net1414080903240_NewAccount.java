package edu.hzuapps.androidlabs.homeworks.net1414080903240;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.android.gms.common.api.GoogleApiClient;

public class Net1414080903240_NewAccount extends AppCompatActivity {
    private Spinner spinner1;
    private EditText value;
    private Button btn_send;
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newaccount_1414080903240);
        value = (EditText) findViewById(R.id.et_value);
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        btn_send = (Button) findViewById(R.id.button);
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Net1414080903240_NewAccount.this,Net1414080903240_OrderRecord.class);
                intent.putExtra("value",value.getText().toString().trim());
                intent.putExtra("spinner1",spinner1.getSelectedItem().toString().trim());
                startActivity(intent);
            }
        });


    }



}

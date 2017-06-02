package edu.hzuapps.androidlabs.homeworks.net1414080903240;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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
                if(!value.getText().toString().equals("")){
                Intent intent = new Intent(Net1414080903240_NewAccount.this,Net1414080903240_OrderRecord.class);
                    SharedPreferences sp=getSharedPreferences("zhangmu",MODE_PRIVATE);
                    SharedPreferences.Editor al=sp.edit();
                    String str=value.getText().toString().trim();
                    String str2=spinner1.getSelectedItem().toString().trim();
                    switch(str2){
                        case "娱乐":
                            str2="cheer";
                            break;
                        case "饮食":
                            str2="food";
                            break;
                        case "车费":
                            str2="car";
                            break;
                        case "服装":
                            str2="dress";
                            break;
                        case "礼品":
                            str2="gift";
                            break;
                    }
                    int a = Integer.parseInt(str);
                    int value=sp.getInt(str2,0);
                    int value2=sp.getInt("sum",0);
                    int sum=a+value2;
                    int addvalue=a+value;
                    al.putInt("sum",sum);
                    al.putInt(str2,addvalue);
                    //al.putInt("food",0);
                    //al.putInt("sum",0);
                    al.commit();
                intent.putExtra("value",str);
                intent.putExtra("spinner1",spinner1.getSelectedItem().toString().trim());
                startActivity(intent);
                }else if(value.getText().toString()==""){
                    Toast.makeText(Net1414080903240_NewAccount.this,"没有数据", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }



}

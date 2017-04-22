package edu.hzuapps.androidlabs.homeworks.net1414080903240;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Net1414080903240_OrderRecord extends AppCompatActivity {
    private TextView tv_value,tv_cla;
    private Button btn_send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orderrecord_1414080903240);
        Intent intent=getIntent();
        String value=intent.getStringExtra("value");
        String cla=intent.getStringExtra("spinner1");
        tv_value=(TextView)findViewById(R.id.tt_value);
        switch(cla){
            case "娱乐":
                tv_cla=(TextView)findViewById(R.id.cheer_value);
                break;
            case "饮食":
                tv_cla=(TextView)findViewById(R.id.food_value);
                break;
            case "车费":
                tv_cla=(TextView)findViewById(R.id.car_value);
                break;
            case "服装":
                tv_cla=(TextView)findViewById(R.id.dress_value);
                break;
            case "礼品":
                tv_cla=(TextView)findViewById(R.id.gift_value);
                break;
        }
        tv_value.setText(value);
        tv_cla.setText(value);
        btn_send = (Button) findViewById(R.id.button);
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Net1414080903240_OrderRecord.this,Net1414080903240_AccountDetail.class);
                startActivity(intent);
            }
        });
    }
}

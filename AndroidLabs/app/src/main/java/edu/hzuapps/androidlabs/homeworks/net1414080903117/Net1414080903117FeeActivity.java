package edu.hzuapps.androidlabs.homeworks.net1414080903117;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import edu.hzuapps.androidlabs.R;

public class Net1414080903117FeeActivity extends AppCompatActivity {

    TextView tvWater;
    TextView tvEle;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903117_fee);
        tvWater= (TextView) findViewById(R.id.tv_fee_water);
        tvEle= (TextView) findViewById(R.id.tv_fee_ele);
        Button bt= (Button) findViewById(R.id.bt_fee_submit);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(Net1414080903117FeeActivity.this,Net1414080903117SubmitActivity.class),1);
            }
        });
        setData();
    }
    public void setData(){
        SharedPreferences sp=getSharedPreferences("fee",MODE_PRIVATE);
        tvWater.setText(sp.getInt("water",0)+"元");
        tvEle.setText(sp.getInt("ele",0)+"元");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==1){
            setData();
        }
    }
}

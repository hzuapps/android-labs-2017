package edu.hzuapps.androidlabs.homeworks.net1414080903240;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.FileOutputStream;

public class Net1414080903240_OrderRecord extends AppCompatActivity {
    private TextView tv_value,tv_cla,tv_cheer,tv_food,tv_car,tv_dress,tv_gift;
    private Button btn_send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orderrecord_1414080903240);
        Intent intent=getIntent();
        ProgressBar cheer_bar = (ProgressBar)findViewById(R.id.cheer_bar);
        ProgressBar food_bar = (ProgressBar)findViewById(R.id.food_bar);
        ProgressBar car_bar = (ProgressBar)findViewById(R.id.car_bar);
        ProgressBar dress_bar = (ProgressBar)findViewById(R.id.dress_bar);
        ProgressBar gift_bar = (ProgressBar)findViewById(R.id.gift_bar);
        SharedPreferences sp=getSharedPreferences("zhangmu",MODE_PRIVATE);
        int sum0=sp.getInt("sum",0);
        int cheer=sp.getInt("cheer",0);
        int food=sp.getInt("food",0);
        int car=sp.getInt("car",0);
        int dress=sp.getInt("dress",0);
        int gift=sp.getInt("gift",0);

        float cheer_a=(float)cheer/sum0*100;
        float food_a=(float)food/sum0*100;
        float car_a=(float)car/sum0*100;
        float dress_a=(float)dress/sum0*100;
        float gift_a=(float)gift/sum0*100;


        String sum=String.valueOf(sum0);
        String cheer_value=String.valueOf(cheer);
        String food_value=String.valueOf(food);
        String car_value=String.valueOf(car);
        String dress_value=String.valueOf(dress);
        String gift_value=String.valueOf(gift);

        tv_value=(TextView)findViewById(R.id.tt_value);
        tv_cheer=(TextView)findViewById(R.id.cheer_value);
        tv_food=(TextView)findViewById(R.id.food_value);
        tv_car=(TextView)findViewById(R.id.car_value);
        tv_dress=(TextView)findViewById(R.id.dress_value);
        tv_gift=(TextView)findViewById(R.id.gift_value);

        tv_value.setText(sum);
        tv_cheer.setText(cheer_value);
        tv_food.setText(food_value);
        tv_car.setText(car_value);
        tv_dress.setText(dress_value);
        tv_gift.setText(gift_value);

        if(cheer == 0){
            cheer_bar.setProgress(0);
        }else{
            cheer_bar.setProgress((int)cheer_a);
        }
        if(food == 0){
            food_bar.setProgress(0);
        }else{
            food_bar.setProgress((int)food_a);
        }
        if(car == 0){
            car_bar.setProgress(0);
        }else{
            car_bar.setProgress((int)car_a);
        }
        if(dress == 0){
            dress_bar.setProgress(0);
        }else{
            dress_bar.setProgress((int)dress_a);
        }
        if(gift == 0){
            gift_bar.setProgress(0);
        }else{
            gift_bar.setProgress((int)gift_a);
        }

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

package edu.hzuapps.androidlabs.homeworks.net1414080903140;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class Net1414080903140GameActivity extends AppCompatActivity {

    CheckBox cbSingle;
    CheckBox cbDouble;

    Button btStart;

    ImageView iv;
    TextView tvResult;
    TextView tvCurrent;
    int choose = 0;
    int bt = 0;
    int current=1;
    MyOpenHelper helper;

    int[] pictures = new int[]{R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.five, R.drawable.four, R.drawable.six};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903140_game);
        cbSingle = (CheckBox) findViewById(R.id.cb_single);
        cbDouble = (CheckBox) findViewById(R.id.cb_double);

        btStart = (Button) findViewById(R.id.bt_start_game);
        iv = (ImageView) findViewById(R.id.iv_game_result);
        tvResult = (TextView) findViewById(R.id.tv_game_result);
        tvCurrent= (TextView) findViewById(R.id.tv_current);
        tvCurrent.setText("1");
        helper=new MyOpenHelper(this);
        btStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (bt) {
                    case 0:
                        if (Net1414080903140GameActivity.this.Start()) {
                            current++;
                            btStart.setText("下一关");
                            tvResult.setText("恭喜你！！压对了，请进入下一关");
                        } else {
                            save();
                            current=1;
                            btStart.setText("重新开始");
                            tvResult.setText("真遗憾，压错了，请重启游戏");
                        }
                        break;
                    //下一关
                    case 1:
                        init();
                        break;
                    //重新开始
                    case 2:
                        init();
                        break;
                }


            }
        });
        cbSingle.setChecked(true);
        cbSingle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    choose = 1;
                    cbDouble.setChecked(false);
                } else
                    choose = 0;
            }
        });
        cbDouble.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    choose = 2;
                    cbSingle.setChecked(false);
                } else
                    choose = 0;
            }
        });
    }

    public boolean Start() {
        Random ran = new Random();
        int i = ran.nextInt(6);
        iv.setImageDrawable(getResources().getDrawable(pictures[i]));
        if ((i + 1) % 2 == 0 && choose == 2) {
            bt=1;
            return true;
        } else if ((i + 1) % 2 != 0 && choose == 1) {
            bt=1;
            return true;
        }
        bt=2;
        return false;
    }
    public void save(){
        SQLiteDatabase db=helper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("play_time",getDate());
        values.put("score",current);
        db.insert("record",null,values);
        db.close();
    }
    public void init(){
        btStart.setText("开始游戏");
        tvCurrent.setText(String.valueOf(current));
        bt=0;
        iv.setImageDrawable(getResources().getDrawable(R.drawable.what));
    }
    public String getDate(){
        Date date=new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-mm-dd hh:mm:ss", Locale.CHINA);
        return format.format(date);
    }
}

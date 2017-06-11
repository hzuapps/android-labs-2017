package edu.hzuapps.androidlabs.homeworks.net1414080903231;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TimePicker;
import android.widget.Toast;

import edu.hzuapps.androidlabs.homeworks.net1414080903231.ClockSQLiteOpenHelper;
import java.util.Calendar;
import java.util.List;

public class Net1414080903231EditClock extends AppCompatActivity {

    private TimePicker timePicker;
    private Calendar cal;
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private String repeat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903231_edit_clock);

        timePicker = (TimePicker)findViewById(R.id.tp_alarm_clock_setting);
        //获取时分秒信息
        cal     = Calendar.getInstance();
        year    = cal.get(Calendar.YEAR);
        month   = cal.get(Calendar.MONTH);
        day     = cal.get(Calendar.DAY_OF_MONTH) + 1 ; //月份从0开始的 所以要加1
        hour    = cal.get(Calendar.HOUR_OF_DAY);
        minute  = cal.get(Calendar.MINUTE);

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int min) {
                hour = hourOfDay;
                minute = min;
            }
        });

        LinearLayout ll =(LinearLayout)findViewById(R.id.rl_alarm_clock_setting_repeat);
        ll.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                ShowChoise();
            }
        });

    }

    private void ShowChoise()
    {

        AlertDialog.Builder builder = new AlertDialog.Builder(this,android.R.style.Theme_Holo_Light_Dialog);
        builder.setIcon(R.drawable.clockpic);
        builder.setTitle("闹钟重复次数");
        //    指定下拉列表的显示数据
        final String[] cities = {"只响一次", "每天", "周一到周五"};
        //    设置一个下拉的列表选择项
        builder.setItems(cities, new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                Toast.makeText(Net1414080903231EditClock.this, "选择的次数为：" + cities[which], Toast.LENGTH_SHORT).show();
                repeat=cities[which];

            }
        });
        builder.show();
    }

    public void clock_cancel(View view) {

        Intent intent = new Intent(this, Net1414080903231Clock.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void clock_save(View view){
        Net1414080903231ClockDao ncd=new Net1414080903231ClockDao(Net1414080903231EditClock.this);
        int num=ncd.findid();
        if(repeat==null)repeat="只响一次";
        ncd.insert(num,hour,minute,repeat,"hello",0,"first clock");
        //ncd.deletebyid(4);

        Intent intent = new Intent(this, Net1414080903231Clock.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}

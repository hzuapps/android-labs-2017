package edu.hzuapps.androidlabs.homeworks.net1414080903138;

import android.content.Intent;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import edu.hzuapps.androidlabs.R;

public class Net1414080903138Cashbook extends AppCompatActivity {

    Button CashReturn;
    Button CashSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903138_cashbook);
        CashReturn = (Button)findViewById(R.id.cashbook_But);
        CashSave = (Button)findViewById(R.id.but_save);
    }
    //返回主页面
    public void onClick(View v) {
        if (v.getId() == R.id.cash_return) {
            Intent intent = new Intent(this, Net1414080903138Activity.class);
        }
        if (v.getId() == R.id.but_save)
        {
            boolean isSaveSuccess = Net1414080903138Cashbook_Utils.saveCashbook(this,0,0);
            if(isSaveSuccess)
            {
                Toast.makeText(this,"消费记录保存成功",Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this,"消费记录未保存成功",Toast.LENGTH_SHORT).show();
            }
        }
    }
}


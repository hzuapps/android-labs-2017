package edu.hzuapps.androidlabs.homework.net1414080903234;

import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class Net1414080903234AddIncomeActivity extends AppCompatActivity  implements View.OnClickListener{
    private Button btn;
    private Button btn1;
    private EditText editpayer;
    private EditText editmoney;
    private EditText edityear;
    private EditText editmonth;
    private EditText editday;
    private Income in = new Income();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903234_add_income);
        btn=(Button)findViewById(R.id.buttonCancleIncome);
        btn1=(Button)findViewById(R.id.buttonAddIncome);
        btn.setOnClickListener(this);
        btn1.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.buttonCancleIncome:
                super.finish();
                break;
            case R.id.buttonAddIncome:
                String date;
                editpayer = (EditText)findViewById(R.id.textpincome);
                editmoney = (EditText)findViewById(R.id.textincome);
                edityear = (EditText)findViewById(R.id.itextyear);
                editmonth = (EditText)findViewById(R.id.itextmonth);
                editday = (EditText)findViewById(R.id.itextday);
                if(validate()) {
                    date = edityear.getText().toString() + "-" + editmonth.getText().toString() + "-" + editday.getText().toString();
                    in.setPayer(editpayer.getText().toString());
                    in.setMoney(Double.valueOf(editmoney.getText().toString()));
                    in.setDate(date);
                    Incomedao indao = new Incomedao(this);
                    int id = -1;
                    if((id = indao.add(in))!= -1){
                        in.setId(id);
                        Net1414080903234_I.inlist.add(in);
                        Net1414080903234_M.income += in.getMoney();
                        Net1414080903234_M.money += in.getMoney();
                        Toast.makeText(this,"添加成功",Toast.LENGTH_SHORT).show();
                    }else Toast.makeText(this,"添加失败",Toast.LENGTH_SHORT).show();
                }
        }

    }

    private boolean validate(){
        String payer = editpayer.getText().toString();
        String money = editmoney.getText().toString();
        String year = edityear.getText().toString();
        String month = editmonth.getText().toString();
        String day = editday.getText().toString();
        if(payer.equals("")){
            Toast.makeText(this,"付款人不能为空",Toast.LENGTH_SHORT).show();
            return false;
        }else if(money.equals("")){
            Toast.makeText(this,"收入不能为空",Toast.LENGTH_SHORT).show();
            return false;
        }else if(year.equals("") || month.equals("") || day.equals("")){
            Toast.makeText(this,"日期不能为空",Toast.LENGTH_SHORT).show();
            return false;
        }else if(!isDouble(money)){
            Toast.makeText(this,"请输入正确收入",Toast.LENGTH_SHORT).show();
            return false;
        }else if(Double.valueOf(money)<=0){
            Toast.makeText(this,"收入不能为负数",Toast.LENGTH_SHORT).show();
            return false;
        }else if(!isDate(year,month,day)){
            Toast.makeText(this,"请输入正确收入日期",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private boolean isInteger(String i){
        try{
            Integer.valueOf(i);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    private boolean isDouble(String i){
        try{
            Double.valueOf(i);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    private boolean isDate(String year,String month,String day) {
        if (isInteger(year) && isInteger(month) && isInteger(day)) {
            int y = Integer.valueOf(year);
            int m = Integer.valueOf(month);
            int d = Integer.valueOf(day);
            if ((y > 1899) && (m < 13) && (m > 0) && (d < 32) && (d > 0)) {
                if (m == 4 || m == 6 || m == 9 || m == 11) {
                    if (d > 30) return false;
                }
                if (y % 4 == 0 && y % 100 != 0 || y % 400 == 0) {
                    if (m == 2) {
                        if (d < 30) return true;
                        else return false;
                    }
                } else {
                    if (m == 2) {
                        if (d < 29) return true;
                        else return false;
                    }
                }
            }else{
                return false;
            }
            return true;
        }
        return false;

    }
}
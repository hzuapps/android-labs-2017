package edu.hzuapps.androidlabs.homework.net1414080903234;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Net1414080903234AddIncomeActivity extends AppCompatActivity  implements View.OnClickListener{
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903234_add_income);
        btn=(Button)findViewById(R.id.buttonCancleIncome);
        btn.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.buttonCancleIncome:
                super.finish();
        }

    }
}
package edu.hzuapps.androidlabs.homeworks.net1409081602222;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.luyoucong.R;

public class Net1409081602222ApplyBudgetActivity extends AppCompatActivity {

    EditText etBudget;
    Button btApply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_budget_net1409081602222);

        etBudget= (EditText) findViewById(R.id.et_budget);
        btApply= (Button) findViewById(R.id.bt_apply_budget);

        btApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=etBudget.getText().toString().trim();
                try{
                    int budget=Integer.parseInt(s);
                    if(budget>100000){
                        Toast.makeText(Net1409081602222ApplyBudgetActivity.this,"数值过大，请亲自与经理汇报！！",Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(Net1409081602222ApplyBudgetActivity.this,"申请成功，请等待审核！！",Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }catch (NumberFormatException e){
                    Toast.makeText(Net1409081602222ApplyBudgetActivity.this,"数值错误，请重新输入！！",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

package edu.hzuapps.androidlabs.homeworks.net1414080903126;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import edu.hzuapps.androidlabs.R;

public class Net1414080903126_initialAct1 extends AppCompatActivity {
    private Button btn_1;
    private Button btn_2;
    private Button btn_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903126_initial_act1);
        btn_1=(Button) findViewById(R.id.btn_1);
        btn_2=(Button) findViewById(R.id.btn_2);
        btn_3=(Button) findViewById(R.id.btn_3);
    }

    public void click(View view){
        switch (view.getId()){
            case R.id.btn_2:
                Intent intent2=new Intent(this,Net1414080903126_Act3.class);
                startActivity(intent2);
                break;
            case R.id.btn_3:
                Intent intent3=new Intent(this,Net1414080903126_Act4.class);
                startActivity(intent3);
                break;
            case R.id.btn_1:
                Intent intent1=new Intent(this,Net1414080903126_Act2.class);
                startActivity(intent1);
                break;
        }

    }
}

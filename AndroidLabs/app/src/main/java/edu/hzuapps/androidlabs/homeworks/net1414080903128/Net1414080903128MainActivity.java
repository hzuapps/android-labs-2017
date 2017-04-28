package edu.hzuapps.androidlabs.homeworks.net1414080903128;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.hzuapps.androidlabs.R;

public class Net1414080903128MainActivity extends AppCompatActivity implements View.OnClickListener {
    private  Button start;//“开始游戏”按钮

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903128_main);
        start=(Button) findViewById(R.id.btn_star);
        start.setOnClickListener(this);

    }

    @Override
    //“开始游戏”按钮对应的事件
    public void onClick(View v) {
        if(v.getId()==R.id.btn_star)
        {
            Intent intent=new Intent(this,Net1414080903128CompareActivity.class);
        }
    }
}

package edu.hzuapps.androidlabs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Net1414080903127MainActivity extends AppCompatActivity {
    private Button Brank;
    private Button Bstart;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903127_main);
        Brank=(Button)findViewById(R.id.rank);
        Bstart=(Button)findViewById(R.id.start);
        Brank.setOnClickListener(mylistener);
        Bstart.setOnClickListener(mylistener);
    }
    View.OnClickListener mylistener=new View.OnClickListener(){
        @Override
        public void onClick(View v){
            switch(v.getId()){
                case R.id.rank:
                    intent=new Intent();
                    intent.setClass(Net1414080903127MainActivity.this,Net1414080903127RankActivity.class);
                    Net1414080903127MainActivity.this.startActivity(intent);
                    break;
                case R.id.start:
                    intent=new Intent();
                    intent.setClass(Net1414080903127MainActivity.this,Net1414080903127GameActivity.class);
                    Net1414080903127MainActivity.this.startActivity(intent);
                    break;
                default:
                    break;

            }
        }
    };

}

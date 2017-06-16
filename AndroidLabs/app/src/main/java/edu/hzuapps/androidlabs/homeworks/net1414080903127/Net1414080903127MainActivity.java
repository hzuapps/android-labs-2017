package edu.hzuapps.androidlabs.homeworks.net1414080903127;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import edu.hzuapps.androidlabs.R;

public class Net1414080903127MainActivity extends Activity {
    private ImageButton Brank;
    private ImageButton Bstart;
    private ImageButton Bgameinstructions;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903127_main);
        Brank=(ImageButton) findViewById(R.id.rank);
        Bstart=(ImageButton)findViewById(R.id.start);
        Bgameinstructions=(ImageButton)findViewById(R.id.gameinstructions);
        Brank.setOnClickListener(mylistener);
        Bstart.setOnClickListener(mylistener);
        Bgameinstructions.setOnClickListener(mylistener);
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
                case R.id.gameinstructions:
                    intent=new Intent();
                    intent.setClass(Net1414080903127MainActivity.this,Net1414080903127GameInstructions.class);
                    Net1414080903127MainActivity.this.startActivity(intent);
                    break;
                default:
                    break;

            }
        }
    };

}

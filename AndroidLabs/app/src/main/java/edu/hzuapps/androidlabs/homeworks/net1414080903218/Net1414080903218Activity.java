package edu.hzuapps.androidlabs.homeworks.net1414080903218;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Net1414080903218Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903218);
        Button ButtonPtoC=(Button) findViewById(R.id.PtoCButton);
        if (ButtonPtoC != null) {
            ButtonPtoC.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent IntentStartBoard=new Intent(v.getContext(),Net1414080903218BoardActivity.class);
                    startActivity(IntentStartBoard);
                }
            });
        }
    }
}

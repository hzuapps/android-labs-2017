package edu.hzuapps.androidlabs.homework.net1414080903234;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Net1414080903234AddOutlayActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903234_add_outlay);
        btn=(Button)findViewById(R.id.buttonCancleOutlay);
        btn.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.buttonCancleOutlay:
               super.finish();
        }

    }
}

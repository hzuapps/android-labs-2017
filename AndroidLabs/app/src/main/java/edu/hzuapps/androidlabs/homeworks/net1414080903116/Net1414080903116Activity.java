package edu.hzuapps.androidlabs.homeworks.net1414080903116;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import edu.hzuapps.androidlabs.R;

public class Net1414080903116Activity extends AppCompatActivity implements View.OnClickListener {
    private EditText login_name;
    private EditText login_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903116);
        login_name=(EditText) findViewById(R.id.login_name);
        login_password=(EditText) findViewById(R.id.login_password);
        Button button1=(Button) findViewById(R.id.login_button);
        Button button2=(Button) findViewById(R.id.soft_info);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.login_button:
                Intent intent=new Intent(Net1414080903116Activity.this,Net1414080903116Index.class);
                intent.putExtra("name",login_name.getText().toString().trim());
                intent.putExtra("password",login_password.getText().toString().trim());
                this.finish();
                startActivity(intent);
            case R.id.soft_info:
                Intent intent1=new Intent(Net1414080903116Activity.this,Net1414080903116AnalysisJson.class);
                startActivity(intent1);
        }
    }
}

package edu.hzuapps.androidlabs.homeworks.net1414080903116;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import edu.hzuapps.androidlabs.R;

public class Net1414080903116Activity extends AppCompatActivity {
    private EditText login_name;
    private EditText login_password;
    private Button login_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903116);
        login_name=(EditText) findViewById(R.id.login_name);
        login_password=(EditText) findViewById(R.id.login_password);
        login_button=(Button) findViewById(R.id.login_button);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passDate();
            }
        });

    }

    public void passDate(){
        Intent intent=new Intent(this,Net1414080903116Index.class);
        intent.putExtra("name",login_name.getText().toString().trim());
        intent.putExtra("password",login_password.getText().toString().trim());
        startActivity(intent);
    }
}

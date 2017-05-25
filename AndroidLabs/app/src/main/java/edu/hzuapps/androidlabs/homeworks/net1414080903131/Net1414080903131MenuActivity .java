package edu.hzuapps.androidlabs.homeworks.net1414080903131;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.administrator.studentinfo.R;

public class Net1414080903131MenuActivity extends AppCompatActivity {

    EditText etId;
    Button btCheck;
    Button btAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903131_menu);
        etId= (EditText) findViewById(R.id.et_search);
        btAdd= (Button) findViewById(R.id.bt_add);
        btCheck= (Button) findViewById(R.id.bt_check);
        btCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Net1414080903131MenuActivity.this,Net1414080903131DetailActivity.class);
                intent.putExtra("id",etId.getText().toString());
                startActivity(intent);
            }
        });

    }
}

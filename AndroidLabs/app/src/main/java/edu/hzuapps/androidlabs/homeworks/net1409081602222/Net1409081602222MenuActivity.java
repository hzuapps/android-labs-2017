package edu.hzuapps.androidlabs.homeworks.net1409081602222;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.administrator.luyoucong.R;

public class Net1409081602222MenuActivity extends AppCompatActivity {

    Button btBudget;
    Button btCertificate;
	Button btJson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_net1409081602222);
        btBudget= (Button) findViewById(R.id.bt_to_apply_budget);
        btCertificate= (Button) findViewById(R.id.bt_to_apply_certificate);
        btJson=(Button)findViewById(R.id.bt_json);
        btBudget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Net1409081602222MenuActivity.this,Net1409081602222ApplyBudgetActivity.class));
            }
        });


        btCertificate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Net1409081602222MenuActivity.this,Net1409081602222ApplyCertificateActivity.class));
            }
        });
		  btJson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Net1409081602222MenuActivity.this,Net1409081602222_JsonActivity.class));
            }
        });
    }
}

package edu.hzuapps.androidlabs.homeworks.net1412070501227;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.hzuapps.androidlabs.R;

public class index_net1412070501227 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index_net1412070501227);

        Button backBtn=(Button) findViewById(R.id.btn_login);
        backBtn.setOnClickListener(new View.OnClickListener(){
        @Override
                public void onClick(View v){

            Intent intent = new
                    Intent(index_net1412070501227.this, login_net1412070501227.class);
            startActivity(intent);
        }
        });
    }

}

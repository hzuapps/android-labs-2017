package homeworks.androids.hzuapps.edu.application.net1414080903219;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import homeworks.androids.hzuapps.edu.application.R;

public class ZhucaidanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhucaidan);

        Button button1=(Button)findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(ZhucaidanActivity.this,StudyActivity.class);
                startActivity(intent);
            }
        });
    }
}

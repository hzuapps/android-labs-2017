package homeworks.androids.hzuapps.edu.application.net1414080903219;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import homeworks.androids.hzuapps.edu.application.R;

public class ZhujiemianActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zhujiemian_net1414080903219);

        //点击单词学习按钮，跳转到StudyActivity
        Button button1 = (Button) findViewById(R.id.button_1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ZhujiemianActivity.this, StudyActivity.class);
                startActivity(intent);
            }
        });

        //点击错词，跳转到LearnedActivity
        //Button button2 = (Button) findViewById(R.id.button_3);
        //button1.setOnClickListener(new View.OnClickListener() {
           // @Override
            //public void onClick(View v) {
               // Intent intent = new Intent(ZhujiemianActivity.this, LearnedActivity.class);
               // startActivity(intent);
           // }
       // });


    }


}
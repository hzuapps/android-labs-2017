package homeworks.androids.hzuapps.edu.application.net1414080903219;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import homeworks.androids.hzuapps.edu.application.R;

public class Net1414080903219ZhujiemianActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zhujiemian_net1414080903219);

        Button button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Net1414080903219ZhujiemianActivity.this, Net1414080903219StudyActivity.class);
                startActivity(intent);
            }
        });
    }
}
package homeworks.androids.hzuapps.edu.application.net1414080903219;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;

import homeworks.androids.hzuapps.edu.application.R;

public class LearnedActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.learned_net1414080903219);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }
}

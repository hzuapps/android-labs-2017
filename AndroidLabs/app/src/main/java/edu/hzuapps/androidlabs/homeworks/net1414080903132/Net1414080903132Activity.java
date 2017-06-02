package edu.hzuapps.androidlabs.homework.net1414080903132;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import edu.hzuapps.androidlabs.R;

public class Net1414080903132Activity extends AppCompatActivity {

    private Net1414080903132SnakeView mSnakeView;

    private Button mStart;
    private Button mStart1;
    private Button mStart2;

    private static String ICICLE_KEY = "snake-view";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903132);

        mSnakeView = (Net1414080903132SnakeView) findViewById(R.id.snake);

        mSnakeView.setTextView((TextView) findViewById(R.id.text));
        mSnakeView.setStartButton((Button) findViewById(R.id.start));
        mSnakeView.setStartButton1((Button) findViewById(R.id.start1));
        mSnakeView.setStartButton2((Button) findViewById(R.id.start2));

        mSnakeView.setControlButton((Button) findViewById(R.id.left), (Button) findViewById(R.id.right),
                (Button) findViewById(R.id.top), (Button) findViewById(R.id.bottom));

    }

}

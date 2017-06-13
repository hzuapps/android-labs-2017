package edu.hzuapps.androidlabs.homeworks.net1414080903224;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class N1414080903224page extends AppCompatActivity {
    private Button close_button;
    private TextView show_page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n1414080903224page);
        close_button = (Button) findViewById(R.id.Button3);
        show_page=(TextView) findViewById(R.id.show_page);
        close_button.setOnClickListener(new ButtonListener());
        Intent intent=getIntent();
        String message=intent.getStringExtra("page");
        show_page.setText(message);
    }

    private class ButtonListener implements View.OnClickListener {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.Button3:
                    Intent intent = new Intent(N1414080903224page.this, Net1414080903224Internet.class);
                    startActivity(intent);
                    break;
            }
        }
    }
}

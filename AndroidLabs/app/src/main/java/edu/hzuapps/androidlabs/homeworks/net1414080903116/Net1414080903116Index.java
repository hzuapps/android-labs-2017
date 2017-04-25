package edu.hzuapps.androidlabs.homeworks.net1414080903116;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import edu.hzuapps.androidlabs.R;

public class Net1414080903116Index extends AppCompatActivity {
    private TextView show_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903116_index);
        Intent intent=getIntent();
        String name=intent.getStringExtra("name");
        show_name=(TextView) findViewById(R.id.show_name);
        show_name.setText("欢迎你，"+name);
    }
    public void click(View view){
        Intent intent=new Intent(this,Net1414080903116SendText.class);
        startActivity(intent);
    }
}

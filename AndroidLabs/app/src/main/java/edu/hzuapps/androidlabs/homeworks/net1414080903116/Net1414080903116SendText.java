package edu.hzuapps.androidlabs.homeworks.net1414080903116;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import edu.hzuapps.androidlabs.R;


public class Net1414080903116SendText extends AppCompatActivity {
    private Net1414080903116TextDynamicDao dao;
    private EditText text_dynamic;
    private TextView show_name1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903116_send_text);
    }

    public void add(View v){
        String promulgator=show_name1.getText().toString().trim();
        String textdynamic=text_dynamic.getText().toString().trim();
        Net1414080903116TextDynamic a=new Net1414080903116TextDynamic(promulgator,textdynamic);
        dao.insert(a);
        Intent intent1=new Intent(this,Net1414080903116SendText.class);
        startActivity(intent1);
    }
}

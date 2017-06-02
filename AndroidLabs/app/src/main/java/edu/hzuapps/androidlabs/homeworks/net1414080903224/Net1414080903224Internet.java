package edu.hzuapps.androidlabs.homeworks.net1414080903224;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import java.io.FileOutputStream;
public class Net1414080903224Internet extends AppCompatActivity {
    private Button b_history;
    private Button b_search;
    private EditText e_input;
    private  N1414080903224Dao dao;  //数据库操作类

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903224_internet);
        e_input=(EditText) findViewById(R.id.e_input);
        b_history = (Button) findViewById(R.id.button1);
        b_search = (Button) findViewById(R.id.button);
        b_history.setOnClickListener(new ButtonListener());
        b_search.setOnClickListener(new ButtonListener());
        dao=new N1414080903224Dao(this);
    }

    private class ButtonListener implements View.OnClickListener {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button1:
                    Intent intent = new Intent(Net1414080903224Internet.this, N1414080903224history.class);
                    startActivity(intent);
                    break;
            }
            switch (v.getId()) {
                case R.id.button:
                    Intent intent = new Intent(Net1414080903224Internet.this, N1414080903224page.class);
                    startActivity(intent);
                    String url=e_input.getText().toString().trim(); //获取用户输入的信息
                    N1414080903224Address a=new N1414080903224Address(url);
                    dao.insert(a);  //插入数据库
                    break;
            }
        }
    }
}

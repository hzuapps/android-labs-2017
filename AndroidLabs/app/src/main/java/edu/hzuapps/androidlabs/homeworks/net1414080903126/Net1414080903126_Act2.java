package edu.hzuapps.androidlabs.homeworks.net1414080903126;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import edu.hzuapps.androidlabs.R;

public class Net1414080903126_Act2 extends AppCompatActivity {
    private Button btn;
    private EditText et2;
    private EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903126_act2);
        btn=(Button) findViewById(R.id.btn);
        btn.setOnClickListener(new ButtonListener());
        et1=(EditText) findViewById(R.id.et1);
        et2=(EditText) findViewById(R.id.et2);
    }

    private class ButtonListener implements View.OnClickListener {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn:
                    String saveinfo1 =et1.getText().toString();
                    String saveinfo2 =et2.getText().toString();
                    FileOutputStream fos;
                    try {
                        fos=openFileOutput("shuju.txt",Context.MODE_APPEND);
                        fos.write(saveinfo1.getBytes());
                        fos.write(saveinfo2.getBytes());
                        fos.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    Toast.makeText(Net1414080903126_Act2.this, "保存数据成功：", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
        }

    }
}
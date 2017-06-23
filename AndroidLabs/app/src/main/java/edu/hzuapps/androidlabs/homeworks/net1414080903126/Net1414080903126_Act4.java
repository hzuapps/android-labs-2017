package edu.hzuapps.androidlabs.homeworks.net1414080903126;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import edu.hzuapps.androidlabs.R;
import edu.hzuapps.androidlabs.R;


public class Net1414080903126_Act4 extends AppCompatActivity {
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903126_act4);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new ButtonListener());
    }

    private class ButtonListener implements View.OnClickListener {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn:
                    String content = "";
                    try {
                        FileInputStream fis = openFileInput("shuju.txt");
                        byte[] b = new byte[fis.available()];
                        fis.read(b);
                        content = new String(b);
                        fis.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    Toast.makeText(Net1414080903126_Act4.this, "保存的数据是：" + content, Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
        }

    }
}
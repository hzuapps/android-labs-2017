package homeworks.androidlabs.hzuapps.edu.net141408090323;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Activity02 extends AppCompatActivity {
    private TextView textView14,textView15,textView16,textView17,textView18,textView19;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_net1414080903232);
        Intent intent=getIntent();
        String name=intent.getStringExtra("name");
        String TB_name=intent.getStringExtra("TB_name");
        String time=intent.getStringExtra("time");
        String address=intent.getStringExtra("address");
        String phone_number=intent.getStringExtra("phone_number");
        String detail=intent.getStringExtra("detail");
        textView14=(TextView)findViewById(R.id.textView14);
        textView15=(TextView)findViewById(R.id.textView15);
        textView16=(TextView)findViewById(R.id.textView16);
        textView17=(TextView)findViewById(R.id.textView17);
        textView18=(TextView)findViewById(R.id.textView18);
        textView19=(TextView)findViewById(R.id.textView19);

        textView14.setText(detail);
        textView15.setText(time);
        textView16.setText(TB_name);
        textView17.setText(name);
        textView18.setText(phone_number);
        textView19.setText(address);

    }
}

package edu.hzuapps.androidlabs.homeworks.net1414080903202;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import edu.hzuapps.androidlabs.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Net1414080903202ShowJson extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903202_show_json);
        String a=a("https://raw.githubusercontent.com/zhongwbang/android-labs-2017/master" +
                "/AndroidLabs/app/src/main/java/edu/hzuapps/androidlabs/homeworks" +
                "/net1414080903202/1414080903202.json");

        TextView tv= (TextView) findViewById(R.id.tv_json);
        tv.setText(a);

    }

    public String a(String u) {
        try {
            URL url = new URL(u);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            InputStream is = conn.getInputStream();
            byte[] b = new byte[1024];
            StringBuilder sb = new StringBuilder();
            while (is.read(b) != -1) {
                sb.append(b);
            }
            return sb.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}

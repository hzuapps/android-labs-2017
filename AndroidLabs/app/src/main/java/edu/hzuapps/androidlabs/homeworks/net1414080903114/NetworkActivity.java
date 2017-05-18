package edu.hzuapps.androidlabs.homeworks.net1414080903114;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class NetworkActivity extends Activity{
	private TextView tv_uploadRate, tv_downloadRate;
	private float uploadRate, downloadRate;
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network_net1414080903114);
        tv_uploadRate = (TextView) findViewById(R.id.tv_networkReadRate);
        tv_downloadRate = (TextView) findViewById(R.id.tv_networkWriteRate);
        tv_uploadRate.setText("UploadRate: " + uploadRate + " KB/s");
        tv_downloadRate.setText("DownloadRate: " + downloadRate + " KB/s");
    }

}

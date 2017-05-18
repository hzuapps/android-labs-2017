package edu.hzuapps.androidlabs.homeworks.net1414080903114;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class DiskActivity extends Activity{
	private TextView tv_readRate, tv_writeRate;
	private float readRate, writeRate;
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disk_net1414080903114);
        //Log.i("OneActivity", "onCreate");
        tv_readRate = (TextView) findViewById(R.id.tv_diskReadRate);
        tv_writeRate = (TextView) findViewById(R.id.tv_diskWriteRate);
        tv_readRate.setText("ReadRate: " + readRate + " MB/s");
        tv_writeRate.setText("ReadRate: " + writeRate + " MB/s");
    }

}

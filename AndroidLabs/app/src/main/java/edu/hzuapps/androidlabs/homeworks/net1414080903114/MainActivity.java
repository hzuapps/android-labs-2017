package edu.hzuapps.androidlabs.homeworks.net1414080903114;

import edu.hzuapps.androidlabs.homeworks.net1414080903114.hardwareinfo.RateDatas;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class MainActivity extends Activity {
	private TextView tv_readRate, tv_writeRate, tv_uploadRate, tv_downloadRate;
	private float virtualRate;
	
	private Handler handler = new Handler( );
	private Runnable gsRateThread = new Runnable(){
		@Override
		public void run() {
			virtualRate++;
			if (virtualRate == 1000) {
				virtualRate = 0;
			}
			RateDatas rateD = new RateDatas();
			rateD = getRateDatas();
	    	setTextsValue(rateD);
			handler.postDelayed(this,1000);	//Causes the Runnable r to be added to the message queue, 
			//to be run after the specified amount of time elapses. 
			//The runnable will be run on the thread to which this handler is attached.
			//2秒后运行this所指的进程。？？？
			//因为在本进程内，所以相当于一个函数递归调用。 ？？
		
		}
	};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_net1414080903114);
        virtualRate = 0;
        handler.postDelayed(gsRateThread,1000); // 开始Timer 
    }
    public float getDiskReadR() {
    	float readR = 0;
    	//TODO code here to get diskReadRate
    	readR = virtualRate;
    	return readR;
    	
    }
    public float getDiskWriteR() {
    	float writeR = 0;
    	//TODO code here to get diskWriteRate
    	writeR = virtualRate + 1;
    	return writeR;
    	
    }
    public float getNetUploadR(){
    	float uploadR = 0;
    	//TODO code here to get diskUploadRate
    	uploadR = virtualRate + 2;
    	return uploadR;
    	
    }
    public float getNetDownloadR(){
    	float downloadR = 0;
    	//TODO code here to get diskDownloadRate
    	downloadR = virtualRate + 3;
    	return downloadR;
    	
    }
    public RateDatas getRateDatas() {
    	float readRate = 0, writeRate = 0, uploadRate = 0, downloadRate = 0;
    	RateDatas rateD = new RateDatas();
    	readRate = getDiskReadR();
		writeRate = getDiskWriteR();
		uploadRate = getNetUploadR();
		downloadRate = getNetDownloadR();
    	
		rateD.setReadR(readRate);
        rateD.setWriteR(writeRate);
        rateD.setUploadR(uploadRate);
        rateD.setDownloadR(downloadRate);
    	return rateD;
    }
    public void setTextsValue(RateDatas rateD) {
    	tv_readRate = (TextView) findViewById(R.id.tv_diskReadRate);
        tv_writeRate = (TextView) findViewById(R.id.tv_diskWriteRate);
        tv_readRate.setText("ReadRate: " + rateD.getReadR() + " MB/s");
        tv_writeRate.setText("WriteRate: " + rateD.getWriteR() + " MB/s");
        
        tv_uploadRate = (TextView) findViewById(R.id.tv_networkReadRate);
        tv_downloadRate = (TextView) findViewById(R.id.tv_networkWriteRate);
        tv_uploadRate.setText("UploadRate: " + rateD.getUploadR() + " KB/s");
        tv_downloadRate.setText("DownloadRate: " + rateD.getDownloadR() + " KB/s");
    }
    
}
    

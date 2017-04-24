package edu.hzuapps.androidlabs.homeworks.net1414080903104;

import edu.hzuapps.androidlabs.R;
import edu.hzuapps.androidlabs.R.id;
import edu.hzuapps.androidlabs.R.layout;
import edu.hzuapps.androidlabs.R.menu;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import edu.hzuapps.androidlabs.homeworks.net1414080903104.Net1414080903104extractActivity;
import edu.hzuapps.androidlabs.homeworks.net1414080903104.Net1414080903104lookActivity;

public class Net1414080903104Activity<btn1, Button> extends ActionBarActivity {
	Button btn1, btn2;
    
	class MyClickListener implements OnClickListener {		  
		public void onClick(View v) {
		    switch (v.getId()) {
		    case R.id.button1:
		    	//跳转到另外一个页面
		    	Intent intent=new Intent(Net1414080903104Activity.this,Net1414080903104extractActivity.class);//注意这里的参数问题，详见：http://blog.sina.com.cn/s/blog_8f1c79dd0101a732.html
		    	startActivity(intent);

		        break;
		    case R.id.button2:
		    	//跳转到另外一个页面
		    	Intent intent1=new Intent(Net1414080903104Activity.this,Net1414080903104lookActivity.class);
		    	startActivity(intent1);

		        break;
		    default:
		    break;
		    }
		}
	}


    @SuppressWarnings("unchecked")
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903104);
        
        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
     
        ((View) btn1).setOnClickListener(new MyClickListener());
        ((View) btn2).setOnClickListener(new MyClickListener());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.net1414080903104, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

package edu.hzuapps.androidlabs.homeworks.net1414080903104;
/*
 * 实现“查看最新卡牌池”按钮的事件：
 * 定义一个List存放数据库内所有卡牌的id、name、level，并显示出来
 */
import edu.hzuapps.androidlabs.R;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;

import java.util.*;
import edu.hzuapps.androidlabs.homeworks.net1414080903104.Visitdatabases;
import edu.hzuapps.androidlabs.homeworks.net1414080903104.Accessdata;

public class Net1414080903104lookActivity extends ActionBarActivity {
	List<Accessdata> U=new ArrayList<Accessdata>();//用于存放从数据库获取得到的卡牌数据
	Visitdatabases Visit=new Visitdatabases();//定义一个Visitdatabases变量以便想数据库传送数据或者从数据库内获取数据
	
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lookactivity_net1414080903104);
        /*
        try {
			U=Visit.Querycard();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.e("android", "fail to connect!"+"  "+e.getMessage());
		}//利用Visit对象执行方法访问数据库内所有卡牌的id、name、level数据；
        //利用对象U将上述访问得到的数据全部利用getXXX方法取出；
        //将获得的数据显示出来。(待编写代码)
         * 
         */
    }
    
}

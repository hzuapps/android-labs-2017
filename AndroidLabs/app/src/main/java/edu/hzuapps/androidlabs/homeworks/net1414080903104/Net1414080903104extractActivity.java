package edu.hzuapps.androidlabs.homeworks.net1414080903104;

/*
 * 实现”抽卡“按钮的相关事情：
 * 从10个id号码（0-9）内随机选取一个号码，并根据这个id号码从数据库总提取该卡牌的所有数据
 */
import edu.hzuapps.androidlabs.homeworks.net1414080903104.Visitdatabases;
import edu.hzuapps.androidlabs.homeworks.net1414080903104.Accessdata;
import edu.hzuapps.androidlabs.R;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.*;


public class Net1414080903104extractActivity extends ActionBarActivity {
    int num;//用于存放随机得到的数字，该数字代表着卡牌的id
    Accessdata U=new Accessdata();//定义一个Accessdata变量以便用于存放从数据库获取得到的某卡牌数据
	Visitdatabases Visit=new Visitdatabases();//定义一个Visitdatabases变量以便想数据库传送数据或者从数据库内获取数据
    
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.extractactivity_net1414080903104);
        
        num=randomnum();
        System.out.print(num);
        /*
        try {
			U=Visit.findonecard(num);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.e("android", "fail to connect!"+"  "+e.getMessage());
		}//将num利用Visitdatabases类（即上述创建的对象  V ）封装起来，并访问到数据库中相应的数据；
        //将对象Visit返回的类型赋值给对象U；* 
         */
        //这时候对象U可以利用getXXX方法获取到数据库内的数据；
        TextView textView2_1 = (TextView)findViewById(R.id.textView2_1);
        TextView textView3_1 = (TextView)findViewById(R.id.textView3_1);
        TextView textView4_1 = (TextView)findViewById(R.id.textView4_1);
        TextView textView5_1 = (TextView)findViewById(R.id.textView5_1);
        TextView textView6_1 = (TextView)findViewById(R.id.textView6_1);
        TextView textView7_1 = (TextView)findViewById(R.id.textView7_1);
        TextView textView8_1 = (TextView)findViewById(R.id.textView8_1);
        textView2_1.setText("1");
        textView3_1.setText("库丘林Alter");
        textView4_1.setText("SSR");
        textView5_1.setText("凯尔特神话");
        textView6_1.setText("9999");
        textView7_1.setText("9999");
        textView8_1.setText("9999");
        //没办法从封装类读取出来
        /*textView3_1.setText(U.getName());
        textView4_1.setText(U.getLevel());
        textView5_1.setText(U.getBackground());
        textView6_1.setText(U.getStrength());
        textView7_1.setText(U.getDefensive());
        textView8_1.setText(U.getHp());
        * 
        */
        //将获得的数据显示出来(待编写代码)
         
    }
	
	public int randomnum(){//定义一个在0-9之间获得随机生成数的方法
		Random random= new Random();
		int result=random.nextInt(10);
		return result;
	}
    
}

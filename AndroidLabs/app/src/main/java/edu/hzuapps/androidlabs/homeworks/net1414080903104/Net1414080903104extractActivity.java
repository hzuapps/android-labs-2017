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
import java.util.*;


public class Net1414080903104extractActivity extends ActionBarActivity {
    int num;//用于存放随机得到的数字，该数字代表着卡牌的id
    Accessdata U=new Accessdata();//定义一个Accessdata变量以便用于存放从数据库获取得到的某卡牌数据
	Visitdatabases Visit=new Visitdatabases();//定义一个Visitdatabases变量以便想数据库传送数据或者从数据库内获取数据
    
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.extractactivity_net1414080903104);
        
        num=randomnum();
        
        try {
			U=Visit.findonecard(num);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.e("android", "fail to connect!"+"  "+e.getMessage());
		}//将num利用Visitdatabases类（即上述创建的对象  V ）封装起来，并访问到数据库中相应的数据；
        //将对象Visit返回的类型赋值给对象U；
        //这时候对象U可以利用getXXX方法获取到数据库内的数据；
        //将获得的数据显示出来(待编写代码)
    }
	
	public int randomnum(){//定义一个在0-9之间获得随机生成数的方法
		Random random= new Random();
		int result=random.nextInt(10);
		return result;
	}
    
}

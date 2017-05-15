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
        /*System.out.print(num);//连接数据库失败
        
        try {
			U=Visit.findonecard(num);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.e("android", "fail to connect!"+"  "+e.getMessage());
		}//将num利用Visitdatabases类（即上述创建的对象  V ）封装起来，并访问到数据库中相应的数据；
        //将对象Visit返回的类型赋值给对象U；*/
        
        //这时候对象U可以利用getXXX方法获取到数据库内的数据；
        TextView textView2_1 = (TextView)findViewById(R.id.textView2_1);
        TextView textView3_1 = (TextView)findViewById(R.id.textView3_1);
        TextView textView4_1 = (TextView)findViewById(R.id.textView4_1);
        TextView textView5_1 = (TextView)findViewById(R.id.textView5_1);
        TextView textView6_1 = (TextView)findViewById(R.id.textView6_1);
        TextView textView7_1 = (TextView)findViewById(R.id.textView7_1);
        TextView textView8_1 = (TextView)findViewById(R.id.textView8_1);       
        U=shuju(num);       
        textView2_1.setText(String.valueOf(U.getId()));
        textView3_1.setText(U.getName());
        textView4_1.setText(U.getLevel());
        textView5_1.setText(U.getBackground());
        textView6_1.setText(U.getStrength());
        textView7_1.setText(U.getDefensive());
        textView8_1.setText(U.getHp());
        
        
        //将获得的数据显示出来(待编写代码)
         
    }
	
	public int randomnum(){//定义一个在0-9之间获得随机生成数的方法
		Random random= new Random();
		int result=random.nextInt(10);
		return result+1;
	}
	public Accessdata shuju(int a){//由于数据库连接出现错误，暂时利用函数方法来实现数据内容的获取
		Accessdata U1 = null;
		if(a==1){U1=new Accessdata(1,"库丘林Alter","SSR","凯尔特神话","9999","9999","9999");}
		if(a==2){U1=new Accessdata(2,"亚瑟・潘德拉贡","SR","亚瑟王传说","8888","8888","8888");}
		if(a==3){U1=new Accessdata(3,"詹姆斯·莫里亚蒂","R","福尔摩斯探案集系列","7777","7777","7777");}
		if(a==4){U1=new Accessdata(4,"梅林","SSR","亚瑟王传说","6666","6666","6666");}
		if(a==5){U1=new Accessdata(5,"吉尔伽美什","SSR","苏美尔文明、吉尔伽美什叙事诗","5555","5555","5555");}
		if(a==6){U1=new Accessdata(6,"恩奇都","R","古代美索不达米亚神话","4444","4444","4444");}
		if(a==7){U1=new Accessdata(7,"伊修塔尔","SR","古代美索不达米亚神话","3333","3333","3333");}
		if(a==8){U1=new Accessdata(8,"迪尔姆德・奥迪纳","R","凯尔特神话","2333","2333","2333");}
		if(a==9){U1=new Accessdata(9,"冲田总司","R","史实","2222","2222","2222");}
		if(a==10){U1=new Accessdata(10,"贞德","SR","史实","1111","1111","1111");}
		return U1;
	}
    
}

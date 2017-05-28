package edu.hzuapps.androidlabs.homeworks.net1414080903104;
/*
 * 实现“查看最新卡牌池”按钮的事件：
 * 定义一个List存放数据库内所有卡牌的id、name、level，并显示出来
 * 
 * 列表显示数据的方法：listview组件的SimpleAdapter类
 */
import edu.hzuapps.androidlabs.R;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.*;
import edu.hzuapps.androidlabs.homeworks.net1414080903104.Visitdatabases;
import edu.hzuapps.androidlabs.homeworks.net1414080903104.Accessdata;

public class Net1414080903104lookActivity extends ActionBarActivity {
	List<Accessdata> U=new ArrayList<Accessdata>();//用于存放从数据库获取得到的卡牌数据
	Visitdatabases Visit;//定义一个Visitdatabases变量以便想数据库传送数据或者从数据库内获取数据
	ListView listView;
	
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lookactivity_net1414080903104);
        listView = (ListView) this.findViewById(R.id.listView);
        Visit=new Visitdatabases(this);
        U=Visit.queryAll();
        
        show();
    }

	private void show() {
		// TODO Auto-generated method stub
		List<HashMap<String, Object>> data = new ArrayList<HashMap<String, Object>>();  
		Accessdata g = new Accessdata();//用于装对象List<Accessdata> U内的单个Accessdata g
		for(int i = 0;i < U.size();i++){
			g=U.get(i);
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("id", g.getId());  
            map.put("name", g.getName());  
            map.put("level", g.getLevel());  
            data.add(map);  
		}
		
		SimpleAdapter adapter = new SimpleAdapter(this, data, R.layout.listview_net1414080903104,  new String[] { "id", "name", "level" }, new int[] {  R.id.id, R.id.name, R.id.level }); 
		/*SimpleAdapter的参数说明
		 * 第一个参数 表示访问整个android应用程序接口，基本上所有的组件都需要
		 * 第二个参数表示生成一个Map(String ,Object)列表选项
		 * 第三个参数表示界面布局的id  表示该文件作为列表项的组件
		 * 第四个参数表示该Map对象的哪些key对应value来生成列表项
		 * 第五个参数表示来填充的组件 Map对象key对应的资源一依次填充组件 顺序有对应关系
		 * 注意的是map对象可以key可以找不到 但组件的必须要有资源填充  因为 找不到key也会返回null 其实就相当于给了一个null资源
		 * 下面的程序中如果 new String[] { "name", "head", "desc","name" } new int[] {R.id.name,R.id.head,R.id.desc,R.id.head}
		 * 这个head的组件会被name资源覆盖
		 * */
        listView.setAdapter(adapter); 
	}
    
}

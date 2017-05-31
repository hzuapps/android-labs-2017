package homeworks.androidlabs.hzuapps.edu.net141408090323;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import java.util.List;

import homeworks.androidlabs.hzuapps.edu.net141408090323.cn.itcast.domain.ItemInfo;
import homeworks.androidlabs.hzuapps.edu.net141408090323.dao.AccountDao;


public class MainActivity extends AppCompatActivity {
    private Button button;
    private List<ItemInfo> list;
    private AccountDao dao;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_net1414080903232);

        dao=new AccountDao(this);// 有这条语句dao.insert(itemInfo);没有dao=new AccountDao(this);语句的话，将提示错误：空对象尝试去调用虚函数insert()

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                passDate();
            }
        });
    }
    public void passDate(){
        ItemInfo itemInfo;
        itemInfo = new ItemInfo("周贵浩", "*****", "2017/04/17", "惠州学院计算机系 ", "0123456789 ", "规格为XL的短袖T恤一件");

        dao.insert(itemInfo);


        Intent intent = new Intent(this, Activity02.class);
        intent.putExtra("name", itemInfo.getName());
        intent.putExtra("address", itemInfo.getAddress());
        intent.putExtra("detail", itemInfo.getDetail());
        intent.putExtra("phone_number", itemInfo.getPhone_number());
        intent.putExtra("TB_name", itemInfo.getTB_name());
        intent.putExtra("time", itemInfo.getTime());
        startActivity(intent);
    }
}



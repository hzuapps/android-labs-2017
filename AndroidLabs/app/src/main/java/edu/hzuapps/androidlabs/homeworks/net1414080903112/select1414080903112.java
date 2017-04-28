package edu.hzuapps.androidlabs.net1414080903112;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class select1414080903112 extends AppCompatActivity {


    private static final String[] m={"星期一","星期二","星期三","星期四","星期五"};
    private TextView view ;
    private Spinner spinner;
    private ArrayAdapter<String> adapter;
    private TextView view2;
    private Spinner spinner2;
    private ArrayAdapter adapter2;
    private Button my_button = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select1414080903112);

        Button btn1=(Button)findViewById(R.id.button);

        //给btn1绑定监听事件
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 给bnt1添加点击响应事件,即带参数跳转到另一页面（参数为空课室数据的筛选参数）
                Intent intent =new Intent(select1414080903112.this,result1414080903112.class);
                intent.putExtra("weekday", view.getText());
                intent.putExtra("time", view2.getText());
                //启动
                startActivity(intent);
            }
        });

        view = (TextView) findViewById(R.id.spinnerText);
        spinner = (Spinner) findViewById(R.id.Spinner01);
        spinner2 = (Spinner) findViewById(R.id.Spinner02);
        view2 = (TextView) findViewById(R.id.spinnerText2);
        //将可选内容与ArrayAdapter连接起来
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,m);
        adapter2 = ArrayAdapter.createFromResource(this, R.array.plantes, android.R.layout.simple_spinner_item);
        //设置下拉列表的风格
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //将adapter 添加到spinner中
        spinner.setAdapter(adapter);
        spinner2.setAdapter(adapter2);
        //添加事件Spinner事件监听
        spinner.setOnItemSelectedListener(new SpinnerSelectedListener());
        spinner2.setOnItemSelectedListener(new SpinnerXMLSelectedListener());
        //设置默认值
        spinner.setVisibility(View.VISIBLE);
        spinner2.setVisibility(View.VISIBLE);
    }

    //使用数组形式操作，对用户选择的下拉框内容进行读取
    class SpinnerSelectedListener implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
                                   long arg3) {
            view.setText("你选择的是："+m[arg2]);
        }

        public void onNothingSelected(AdapterView<?> arg0) {
        }
    }
    //使用XML形式操作，对用户选择的下拉框内容进行读取
    class SpinnerXMLSelectedListener implements AdapterView.OnItemSelectedListener {
        public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
                                   long arg3) {
            view2.setText("你选择的是："+adapter2.getItem(arg2));
        }

        public void onNothingSelected(AdapterView<?> arg0) {

        }

    }
}

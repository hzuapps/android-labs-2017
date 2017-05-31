package edu.hzuapps.androidlabs.homeworks.net1414080903106;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import edu.hzuapps.androidlabs.R;

/**
 * Created by Administrator on 2017/4/24.
 */

public class Net1414080903106SelectCity extends AppCompatActivity implements View.OnClickListener {
    private ImageButton backBtn;
    private ListView cityListLv;
    private EditText searchEt;

    private List<Net1414080903106City> mCityList;
    private MyApplication mApplication;
    private ArrayList<String> mArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903106_select_city);

        //绑定“返回”按钮
        backBtn=(ImageButton) findViewById(R.id.btn_selectCity_back);
        backBtn.setOnClickListener(this);

        searchEt=(EditText) findViewById(R.id.et_cityName);

        mApplication=(MyApplication) getApplication();
        mCityList=mApplication.getCityList();
        mArrayList=new ArrayList<String>();
        for(int i=0;i<mCityList.size();i++){
            String provinceName=mCityList.get(i).getProvince();
            String cityName=mCityList.get(i).getCity();
            mArrayList.add(cityName+" "+provinceName);
        }
        cityListLv=(ListView) findViewById(R.id.selectcity_lv);
        final ArrayAdapter<String> adapter=new ArrayAdapter<String>(Net1414080903106SelectCity.this,android.R.layout.simple_list_item_1,mArrayList);
        cityListLv.setAdapter(adapter);

        //添加LiatView项的点击事件的动作
        AdapterView.OnItemClickListener itemClickListener=new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int updateCityCode=Integer.parseInt(mCityList.get(i).getNumber());
                Intent intent=new Intent(Net1414080903106SelectCity.this,Net1414080903106MainActivity.class);
                intent.putExtra("citycode",updateCityCode);
                startActivity(intent);
            }
        };
        //为组件绑定监听
        cityListLv.setOnItemClickListener(itemClickListener);

        //EditText实现搜索功能效果
        searchEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_selectCity_back:
                finish();
                break;
            default:
                break;
        }
    }
}

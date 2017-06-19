package edu.hzuapps.androidlabs.homeworks.net1414080903106;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

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
    private TextView searchBtn;

    private List<Net1414080903106City> mCityList;
    private MyApplication mApplication;
    private ArrayList<String> mArrayList;
    ArrayAdapter<String> adapter;

    private String updateCityCode="-1";
    private String selectNo;
    boolean searched = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903106_select_city);

        //绑定组件
        backBtn=(ImageButton) findViewById(R.id.btn_selectCity_back);
        backBtn.setOnClickListener(this);
        searchBtn=(TextView) findViewById(R.id.btn_search);
        searchBtn.setOnClickListener(this);

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
        adapter=new ArrayAdapter<String>(Net1414080903106SelectCity.this,android.R.layout.simple_list_item_1,mArrayList);
        adapter.notifyDataSetChanged();
        cityListLv.setAdapter(adapter);

        final Intent intent = new Intent(this,Net1414080903106MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        //添加LiatView项的点击事件的动作
        AdapterView.OnItemClickListener itemClickListener=new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(searched){
                    updateCityCode = mCityList.get(Integer.parseInt(selectNo)).getNumber();
                }else {
                    updateCityCode = mCityList.get(i).getNumber();
                }
                Log.d("update city code",updateCityCode);

                Log.d("updateCityCode",updateCityCode);
            }
        };
        //为组件绑定监听
        cityListLv.setOnItemClickListener(itemClickListener);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_search:
                String city=searchEt.getText().toString();
                for(int i=0;i<mCityList.size();i++){
                    String provinceName=mCityList.get(i).getProvince();
                    String cityName=mCityList.get(i).getCity();
                    if(cityName.equals(city)){
                        searched = true;
                        selectNo = Integer.toString(i);
                        mArrayList.clear();
                        mArrayList.add(cityName+" "+provinceName);
                        Log.d("changed adapter data",cityName+" "+provinceName);
                    }
                    adapter=new ArrayAdapter<String>(Net1414080903106SelectCity.this,android.R.layout.simple_list_item_1,mArrayList);
                    cityListLv.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
                Intent intent=new Intent(this,Net1414080903106MainActivity.class);
                intent.putExtra("citycode",updateCityCode);
                startActivity(intent);
            case R.id.btn_selectCity_back:
                finish();
                //Intent intent=new Intent(this,Net1414080903106MainActivity.class);
                //intent.putExtra("citycode",updateCityCode);
                //startActivity(intent);
                break;
            default:
                break;
        }
    }
}

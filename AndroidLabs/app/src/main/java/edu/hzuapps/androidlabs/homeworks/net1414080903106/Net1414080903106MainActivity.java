package edu.hzuapps.androidlabs.homworks.net1414080903106;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import edu.hzuapps.androidlabs.R;

/**
 * Created by Administrator on 2017/4/24.
 */

public class Net1414080903106MainActivity extends Activity implements View.OnClickListener {
    private TextView SelectCityBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903106_main);

        //绑定“切换城市”文本
        SelectCityBtn=(TextView) findViewById(R.id.title_city_locate);
        SelectCityBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.title_city_locate)
        {
            Intent intent=new Intent(this,Net1414080803016SelectCity.class);
            startActivity(intent);
        }
    }
}

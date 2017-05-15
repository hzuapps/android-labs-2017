package edu.hzuapps.androidlabs.homworks.net1414080903106;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import edu.hzuapps.androidlabs.R;

/**
 * Created by Administrator on 2017/4/24.
 */

public class Net1414080803016SelectCity extends Activity implements View.OnClickListener {
    private ImageButton backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903106_select_city);

        //绑定“返回”按钮
        backBtn=(ImageButton) findViewById(R.id.btn_selectCity_back);
        backBtn.setOnClickListener(this);
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

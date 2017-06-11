package edu.hzuapps.androidlabs.homworks.net1414080903136;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import edu.hzuapps.androidlabs.R;
import edu.hzuapps.androidlabs.homworks.net1414080903136.db.ExpressDB;
import edu.hzuapps.androidlabs.homworks.net1414080903136.db.ExpressDao;

import static edu.hzuapps.androidlabs.homworks.net1414080903136.Net1414080903136Activity.bt;

/**
 * Created by xx on 2017/5/15.
 */

public class Net1414080903136ExpressInquiry extends Fragment{

    ExpressDB expressDB;
    private Button queryBt;
    private EditText comName;
    private EditText exNum;
    private ExpressDao expressDao;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.tab1_net1414080903136,container,false);
        queryBt= (Button) view.findViewById(R.id.bt);
        comName= (EditText) view.findViewById(R.id.et1);
        exNum=(EditText) view.findViewById(R.id.et2);
        expressDao=new ExpressDao(getContext());
        queryBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //测试数据
                String companyName=comName.getText().toString();
                String expressNum=exNum.getText().toString();
                String date="2017-5-18";
                String content="惠州学院快递服务站正在第1次派件 电话:15766844117 请保持电话畅通、耐心等待";
                String state="派件";
                expressDao.insert(companyName,expressNum,date,content,state);
            }
        });
        return view;


    }

}

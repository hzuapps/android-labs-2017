package edu.hzuapps.androidlabs.homeworks.net1414080903127;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import edu.hzuapps.androidlabs.R;

public class Net1414080903127RankActivity extends Activity {
    private TextView TfirstG;
    private TextView TsecondG;
    private TextView TthreeG;
    private int[] data={0,0,0};
    private String[] Tdata={"","",""};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903127_rank);
        TfirstG=(TextView)findViewById(R.id.firstG);
        TsecondG=(TextView)findViewById(R.id.secondG);
        TthreeG=(TextView)findViewById(R.id.threeG);
        getGrade();
        change();
        TfirstG.setText(Tdata[0]);
        TsecondG.setText(Tdata[1]);
        TthreeG.setText(Tdata[2]);
    }

    /*读取历史分数*/
    public void getGrade(){
        SharedPreferences sp=getSharedPreferences("Data", Activity.MODE_PRIVATE);
        SharedPreferences.Editor edit=sp.edit();
        if(!sp.contains("First")){
            edit.putInt("First", 0);
            edit.putInt("Second", 0);
            edit.putInt("Third", 0);
            edit.commit();

        }
        data[0]=sp.getInt("First",0);
        data[1]=sp.getInt("Second",0);
        data[2]=sp.getInt("Three",0);
    }
    /*类型转化*/
    public void change(){
        for(int i=0;i<3;i++){
            Tdata[i]=Integer.toString(data[i]);

        }
    }
}

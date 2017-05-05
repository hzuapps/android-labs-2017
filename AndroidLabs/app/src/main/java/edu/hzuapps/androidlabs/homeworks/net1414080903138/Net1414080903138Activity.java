package edu.hzuapps.androidlabs.homeworks.net1414080903138;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import edu.hzuapps.androidlabs.R;



public class Net1414080903138Activity extends AppCompatActivity {
    Button Cashbook;
    Button Classreport;
    Button Memoire;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903138);
        Cashbook = (Button)findViewById(R.id.cashbook_But);
        Classreport = (Button)findViewById(R.id.Classreport_But);
        Memoire = (Button)findViewById(R.id.Memoire_But);
    }
    public void onClick(View v) {
        //响应记账本事件
        if(v.getId()==R.id.cashbook_But)
        {
            Intent intent=new Intent(this,Net1414080903138Cashbook.class);
        }
        //响应类别报表事件
        if(v.getId()==R.id.Classreport_But)
        {
            Intent intent=new Intent(this,Net1414080903138ClassReport.class);
        }
        //响应备忘录事件
        if(v.getId()==R.id.Memoire_But)
        {
            Intent intent=new Intent(this,Net1414080903138Memoire.class);
        }
    }
}


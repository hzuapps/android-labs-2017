package edu.hzuapps.androidlabs.homeworks.net1414080903212;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MarkActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn;
    private Button btn1;
    private EditText editstuid;
    private EditText edittitle2;
    private EditText editgrade;
    private EditText editcomment;
    private Mark mar = new Mark();

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.mark_fragment1414080903212);
        btn = (Button)findViewById(R.id.buttonMark);
        btn1 = (Button)findViewById(R.id.buttonCancelMark) ;
        btn.setOnClickListener(this);
        btn1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonCancelMark:
                super.finish();
                break;
            case R.id.buttonMark:
                editstuid = (EditText)findViewById(R.id.textstuid);
                edittitle2 = (EditText)findViewById(R.id.texttitle2);
                editgrade = (EditText)findViewById(R.id.textgrade);
                editcomment = (EditText)findViewById(R.id.textcomment);

                mar.setStuid(editstuid.getText().toString());
                mar.setHomework_title(edittitle2.getText().toString());
                mar.setGrade(editgrade.getText().toString());
                mar.setComment(editcomment.getText().toString());

                MarkDao mardao = new MarkDao(this);
                int idm=-1;
                if ( (idm = mardao.mark(mar))!=-1 ) {
                    mar.setIdm(idm);
                    MarkFragment.marklist.add(mar);
                    Toast.makeText(this, "点评成功", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "点评失败", Toast.LENGTH_SHORT).show();
                }
        }
    }
}

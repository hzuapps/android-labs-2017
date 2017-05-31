package edu.hzuapps.androidlabs.homeworks.net1414080903212;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AssignActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn;
    private Button btn1;
    private EditText edittitle;
    private EditText editcontent;
    private EditText edittime;
    private Assignment ass = new Assignment();

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.assign_fragment1414080903212);
        btn = (Button)findViewById(R.id.buttonAssign);
        btn1 = (Button)findViewById(R.id.buttonCancelAssign);
        btn.setOnClickListener(this);
        btn1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonCancelAssign:
                super.finish();
                break;
            case R.id.buttonAssign:
                edittitle = (EditText)findViewById(R.id.texttitle);
                editcontent = (EditText)findViewById(R.id.textcontent);
                edittime = (EditText)findViewById(R.id.textdate);

                ass.setHomework_title(edittitle.getText().toString());
                ass.setHomework_content(editcontent.getText().toString());
                ass.setSubmit_time(edittime.getText().toString());

                AssignmentDao assdao = new AssignmentDao(this);
                int id=-1;
                if ( (id = assdao.assign(ass))!=-1 ) {
                    ass.setId(id);
                    AssignFragment.assignmentlist.add(ass);
                    Toast.makeText(this, "发布成功", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "发布失败", Toast.LENGTH_SHORT).show();
                }
        }
    }
}

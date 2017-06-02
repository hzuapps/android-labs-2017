package edu.hzuapps.androidlabs.homeworks.net1414080903229;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Xml;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.xmlpull.v1.XmlSerializer;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by Administrator on 2017-4-14.
 */

public class CreateSchedule extends AppCompatActivity {
    private EditText event;
    private EditText time;
    private EditText content;
    private Button save;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createschedule_net1414080903229);
        event = (EditText) findViewById(R.id.JH);
        time = (EditText) findViewById(R.id.time);
        content = (EditText) findViewById(R.id.add_content);
        save = (Button) findViewById(R.id.btn_ok);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
             public void onClick(View v) {
                String event1 = event.getText().toString();
                String time1 = time.getText().toString();
                String content1 = content.getText().toString();
                if(event1==null || event1.equals("")){
                    Toast.makeText(CreateSchedule.this,"计划名称不为空！",Toast.LENGTH_SHORT).show();
                }else if(time1==null ||time1.equals("")){
                    Toast.makeText(CreateSchedule.this, "时间不为空！", Toast.LENGTH_SHORT).show();
                }else if(content1==null || content1.equals("")){
                    Toast.makeText(CreateSchedule.this,"内容不为空！",Toast.LENGTH_SHORT).show();
                }else{
                    PlanInfo plan = new PlanInfo();
                    plan.setEvent(event1);
                    plan.setTime(time1);
                    plan.setContent(content1);
                    saveXml(plan);
                }
            }
        }
        );
    }
    // 保存信息
    public void saveXml(PlanInfo plan) {
        try {
            File file = new File(Environment.getExternalStorageDirectory(), "plans.xml");
            FileOutputStream fos = new FileOutputStream(file);
            // 获得一个序列化工具
            XmlSerializer serializer = Xml.newSerializer();
            serializer.setOutput(fos, "utf-8");
            // 设置文件头
            serializer.startDocument("utf-8", true);
            serializer.startTag(null, "plans");
            serializer.startTag(null,"plan");
            // 写事件
            serializer.startTag(null, "event");
            serializer.text(plan.getEvent());
            serializer.endTag(null, "event");
            // 写时间
            serializer.startTag(null, "time");
            serializer.text(plan.getTime());
            serializer.endTag(null, "time");
            //写内容
            serializer.startTag(null, "content");
            serializer.text(plan.getContent());
            serializer.endTag(null, "content");
            serializer.endTag(null, "plan");
            serializer.endTag(null, "plans");
            serializer.endDocument();
            fos.close();
            Toast.makeText(getApplicationContext(), "计划创建成功！", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "计划创建失败！", Toast.LENGTH_SHORT).show();
        }
    }
}

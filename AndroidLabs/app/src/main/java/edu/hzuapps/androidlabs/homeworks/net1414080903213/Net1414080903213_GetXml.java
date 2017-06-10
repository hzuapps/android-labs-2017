package edu.hzuapps.androidlabs.homeworks.net1414080903213;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.IOException;

public class Net1414080903213_GetXml extends AppCompatActivity {

    private Handler handler=null;
    private TextView textView=null;
    private String cont="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_xml_net1414080903213);
        handler=new Handler();

        Button button = (Button) this.findViewById(R.id.btn_catch);
        textView = (TextView) this.findViewById(R.id.file_content);
    }
        //点击获取xml文件数据
        public void Click(View v) {

            new Thread(){
                public void run(){
                    try {
                        Document doc = Jsoup.connect("https://github.com/liuzezhao/android-labs-2017/blob/master/testfile_1414080903213.xml").get();
                        int i = 1;
                        Elements data = doc.select("#LC"+i);
                        while(!data.isEmpty()){
                            cont += data.text();
                            i++;
                            data = doc.select("#LC"+i);
                        }

                        Log.d("test",cont);

                    }catch(IOException e){
                        System.out.println("发生错误" + e);
                    }

                    handler.post(runnableUi);
                }
            }.start();
        }





    Runnable   runnableUi=new  Runnable(){
        @Override
        public void run() {
            //刷新
            textView.setText(cont);

        }

    };




}

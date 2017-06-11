package edu.hzuapps.androidlabs.homeworks.net1414080903212;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class XmlFragment extends Fragment {
    private TextView mTextView=null;
    TextView text;
    private Handler handler=null;
    private String hw="";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.xml_fragment1414080903212,container,false);
        handler = new Handler();

        Button button = (Button)view.findViewById(R.id.xml_btn);
        text = (TextView) view.findViewById(R.id.txt_xml);
        mTextView = (TextView) view.findViewById(R.id.txt_xml);
        button.setOnClickListener(new submitOnClickListener());

        return view;
    }
    class submitOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            //从github上采集数据
            new Thread(){
                public void run(){
                    try {
                        Document docu = Jsoup.connect("https://github.com/HardyYao/android-labs-2017/blob/master/AndroidLabs/app/src/main/java/edu/hzuapps/androidlabs/homeworks/net1414080903212/data1414080903212.xml").get();
                        int i = 1;
                        Elements data = docu.select("#LC"+i);
                        while(!data.isEmpty()){
                            hw += data.text();
                            i++;
                            data = docu.select("#LC"+i);
                        }

                    }catch(IOException e){
                        System.out.println("catch IOException: " + e);
                    }
                    handler.post(runnableUi);
                }
            }.start();
        }
    }

    Runnable   runnableUi=new  Runnable(){
        @Override
        public void run() {
            //更新界面
            mTextView.setText(hw);
        }

    };
}

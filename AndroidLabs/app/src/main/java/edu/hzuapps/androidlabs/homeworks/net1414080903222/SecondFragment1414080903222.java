package edu.hzuapps.androidlabs.homeworks.net1414080903222;

import android.os.Bundle;
import android.os.Handler;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class SecondFragment1414080903222 extends Fragment {

    TextView text;
    private Handler handler=null;
    private TextView textView=null;
    private String da="";

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.second_fragment1414080903222, container, false);
        handler=new Handler();

        Button button = (Button) view.findViewById(R.id.button2);
        text=(TextView) view.findViewById(R.id.user_content);
        textView = (TextView) view.findViewById(R.id.user_content);
        button.setOnClickListener(new submitOnClieckListener());

        return view;
    }

    class submitOnClieckListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            //从github上抓取数据
            new Thread(){
                public void run(){
                    try {

                        Document doc = Jsoup.connect("https://github.com/AmoTF/android-labs-2017/blob/master/AndroidLabs/app/src/main/res/layout/data_1414080903222.xml").get();
                        int i = 1;
                        Elements data = doc.select("#LC"+i);
                        while(!data.isEmpty()){
                            da += data.text();
                            i++;
                            data = doc.select("#LC"+i);
                        }
                    }catch(IOException e){
                        System.out.println("in procedure, catch ArithmeticException: " + e);
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
            textView.setText(da);
        }

    };
}




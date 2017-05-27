package edu.hzuapps.androidlabs.homework.net1414080903230;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import android.os.Environment;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Net1414080903230_UserFragment extends Fragment {
    TextView text;
    private Handler handler=null;
    private TextView textView=null;
    private String da="";

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_net1414080903230__user, container, false);
        handler=new Handler();

        Button button = (Button) view.findViewById(R.id.button2);
        text=(TextView) view.findViewById(R.id.user_content);
        textView = (TextView) view.findViewById(R.id.user_content);
        button.setOnClickListener(new submitOnClieckListener());
        /*
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //new Thread(new GetData()).start();
                new Thread(new Runnable() {
                    public void run() {

                        try {
                            Document doc = Jsoup.connect("https://github.com/shezhiming/android-labs-2017/blob/master/AndroidLabs/app/src/main/java/edu/hzuapps/androidlabs/homeworks/net1414080903230/data.xml").get();
                            int i = 0;
                            Elements data = doc.select("#LC"+i);
                            while(!data.isEmpty()){
                                da += data.text();
                                i++;
                                data = doc.select("#LC"+i);
                            }
                            textView.setText(da);
                        }catch(IOException e){
                            System.out.println("in procedure, catch ArithmeticException: " + e);
                        }
                        handler.post(runnableUi);
                    }
                }).start();

            }
        });
        */
        return view;
    }

    class submitOnClieckListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
//本地机器部署为服务器，从本地下载a.txt文件内容在textView上显示
            new Thread(){
                public void run(){
                    try {

                        Document doc = Jsoup.connect("https://github.com/shezhiming/android-labs-2017/blob/master/AndroidLabs/app/src/main/java/edu/hzuapps/androidlabs/homeworks/net1414080903230/data.xml").get();
                        int i = 1;
                        Elements data = doc.select("#LC"+i);
                        while(!data.isEmpty()){
                            da += data.text();
                            i++;
                            data = doc.select("#LC"+i);
                        }

                        //Log.d("test",da);
                        //textView.setText(da);
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

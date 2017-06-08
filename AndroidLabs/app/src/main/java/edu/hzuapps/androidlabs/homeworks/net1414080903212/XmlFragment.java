package edu.hzuapps.androidlabs.homeworks.net1414080903212;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
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
    private String context;
    private TextView mTextView;
    private Handler handler;
    private String hw="";

    public XmlFragment(String context){
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.xml_fragment1414080903212,container,false);
        handler = new Handler();

        Button button = (Button)view.findViewById(R.id.xml_btn);
        mTextView = (TextView)view.findViewById(R.id.txt_xml);
        mTextView.setText(context);
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

                        Document doc = Jsoup.connect("").get();
                        int i = 1;
                        Elements data = doc.select("DT"+i);
                        while(!data.isEmpty()){
                            hw += data.text();
                            i++;
                            data = doc.select("#DT"+i);
                        }

                        //Log.d("test",da);
                        //textView.setText(da);
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

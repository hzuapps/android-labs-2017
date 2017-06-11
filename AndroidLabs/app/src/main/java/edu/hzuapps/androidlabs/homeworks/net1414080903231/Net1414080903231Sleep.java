package edu.hzuapps.androidlabs.homeworks.net1414080903231;


import android.app.Activity;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.io.ByteArrayInputStream;
import java.util.List;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.image.*;


public class Net1414080903231Sleep extends Activity {

    private ListView lv_music;
    private LinearLayout loading;
    private List<MusicInfo> musicinfos;

    private class MusicAdapter extends BaseAdapter {
        public int getCount() {
            return musicinfos.size();
        }

        public View getView(int position, View covertView, ViewGroup parent) {
            View view = View.inflate(Net1414080903231Sleep.this, R.layout.net1414080903231_sleep_listitem, null);
            SmartImageView siv = (SmartImageView) view.findViewById(R.id.siv_icon);
            TextView tv_title = (TextView) view.findViewById(R.id.tv_title);
            TextView tv_des = (TextView) view.findViewById(R.id.tv_des);
            TextView tv_type = (TextView) view.findViewById(R.id.tv_type);
            MusicInfo musicinfo = musicinfos.get(position);

            siv.setImageUrl(musicinfo.getIconpath(), R.drawable.clockpic, R.drawable.clockpic);
            tv_title.setText(musicinfo.getMusicname());
            tv_des.setText(musicinfo.getDes());
            int type = musicinfo.getType();
            switch (type) {
                case 1:
                    tv_type.setText("安静");
                    break;
                case 2:
                    tv_type.setText("治愈");
                    break;
                case 3:
                    tv_type.setText("入眠");
                    break;
            }
            return view;
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }
    }

    protected  void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_net1414080903231_sleep);
            lv_music=(ListView)findViewById(R.id.lv_music);
            loading=(LinearLayout)findViewById(R.id.loading);
            fillData2();
    }
        private void fillData2(){
            AsyncHttpClient asyncHttpClient=new AsyncHttpClient();
            asyncHttpClient.get(getString(R.string.serverurl),
                    new AsyncHttpResponseHandler(){
                         public void onSuccess(String content){
                             //Toast.makeText(Net1414080903231Sleep.this,"！！",Toast.LENGTH_SHORT).show();
                             super.onSuccess(content);
                             byte[] bytes=content.getBytes();
                             ByteArrayInputStream bais=new ByteArrayInputStream(bytes);
                             musicinfos=MusicinfoService.getMusicinfos(bais);
                             if(musicinfos==null){
                                  Toast.makeText(Net1414080903231Sleep.this,"解析失败",Toast.LENGTH_SHORT).show();
                              }
                             else{
                                  loading.setVisibility(View.INVISIBLE);
                                  lv_music.setAdapter(new MusicAdapter());

                             }
                         }
                         public void onFailure(Throwable error,String content){
                                super.onFailure(error,content);
                                Toast.makeText(Net1414080903231Sleep.this,"请求失败",Toast.LENGTH_SHORT).show();
                         }
            });
        }

}

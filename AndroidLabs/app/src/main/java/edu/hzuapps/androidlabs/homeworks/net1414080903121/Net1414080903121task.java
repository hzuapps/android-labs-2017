package edu.hzuapps.androidlabs.homeworks.net1414080903121;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.image.SmartImageView;

import java.io.ByteArrayInputStream;
import java.util.List;

import edu.hzuapps.androidlabs.R;

/**
 * 作者：zgw on 2017/6/20 14:03
 * 邮箱：zhanmu123@163.com
 */

public class Net1414080903121task extends Activity {
    private ListView lv_news;
    private LinearLayout loading;
    private List<NewsInfo> newsInfos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903121task);
        lv_news = (ListView) findViewById(R.id.lv_news);
        loading = (LinearLayout) findViewById(R.id.loading);
        fillData2();
    }

    //使用AsyncHttpClient访问网络
    private void fillData2() {
        //创建AsyncHttpClient实例
        AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
        //使用GET方式请求
        asyncHttpClient.get(getString(R.string.serverurl), new AsyncHttpResponseHandler(){

            @Override
            public void onSuccess(String content) {
                //访问成功
                super.onSuccess(content)
                //将字符串装换成Byte数组
                byte[] bytes = content.getBytes();
                //将Byte数组装换成输入流
                ByteArrayInputStream bais=new ByteArrayInputStream(bytes);
                //调用NewsINfoService工具类解析XML文件
                newsInfos= Net1414080903121NewsInfoService.getNewsInfos(bais);
                if (newsInfos == null){
                    //解析失败 弹出toast
                    Toast.makeText(Net1414080903121task.this,"解析失败",Toast.LENGTH_SHORT).show();
                }else {
                    //更新界面
                    loading.setVisibility(View.INVISIBLE);
                    lv_news.setAdapter(new NewsAdapter());
                }

            }
            //请求失败
            @Override
            public void onFailure(Throwable error,String content){
                super.onFailure(error,content);
                Toast.makeText(Net1414080903121task.this,"请求失败",Toast.LENGTH_SHORT).show();
            }
        });
    }

    //ListView适配器
    private class NewsAdapter extends BaseAdapter {
        //listView的item数
        public int getCount() {
            return newsInfos.size();
        }

        //得到listView条目识图
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = View.inflate(Net1414080903121task.this, R.layout.activity_net1414080903121item1, null);
            SmartImageView siv = (SmartImageView) view.findViewById(R.id.siv_ico);
            TextView tv_title = (TextView) view.findViewById(R.id.tv_title);
            TextView tv_des = (TextView) view.findViewById(R.id.tv_des);
            TextView tv_type = (TextView) view.findViewById(R.id.tv_type);
            TextView tv_salary = (TextView) view.findViewById(R.id.tv_salary);
            NewsInfo newsInfo = newsInfos.get(position);

            //SmartImageView加载指定路径图片
            siv.setImageUrl(newsInfo.getIconPath(), R.drawable.ic_nophoto, R.mipmap.ic_launcher);
            //设置任务标题
            tv_title.setText(newsInfo.getTitle());
            //设置任务描述
            tv_des.setText(newsInfo.getDes());
            //设置任务类型
            int type1 = newsInfo.getType(); //1.跑腿任务， 2.网上任务  3.公司任务
            switch (type1) {
                case 1:
                    tv_type.setText("跑腿任务");
                    tv_type.setTextColor(Color.YELLOW);
                    //设置酬金
                    tv_salary.setText("" + newsInfo.getSalary() + "元/天");
                    tv_salary.setTextColor(Color.RED);
                    break;
                case 2:
                    tv_type.setText("网上任务");
                    tv_type.setTextColor(Color.BLUE);
                    //设置酬金
                    tv_salary.setText("" + newsInfo.getSalary() + "元/天");
                    tv_salary.setTextColor(Color.RED);
                    break;
                case 3:
                    tv_type.setText("公司任务");
                    tv_type.setTextColor(Color.GREEN);
                    //设置酬金
                    tv_salary.setText("" + newsInfo.getSalary() + "元/月");
                    tv_salary.setTextColor(Color.RED);
                    break;
            }
            //设置酬金

            return view;
        }

        //条目对象
        public Object getItem(int position) {
            return null;
        }

        //条目ID
        public long getItemId(int position) {
            return 0;
        }

    }
}

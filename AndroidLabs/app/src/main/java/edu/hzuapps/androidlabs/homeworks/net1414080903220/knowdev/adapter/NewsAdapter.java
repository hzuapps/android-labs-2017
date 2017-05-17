package edu.hzuapps.androidlabs.homeworks.net1414080903220.knowdev.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import edu.hzuapps.androidlabs.homeworks.net1414080903220.knowdev.R;
import edu.hzuapps.androidlabs.homeworks.net1414080903220.knowdev.bean.News;

/**
 * ProjectName: knowdev
 * PackName：edu.hzuapps.androidlabs.homeworks.net1414080903220.knowdev.adapter
 * Class describe:
 * Author: cheng
 * Create time: 2017/5/15 22:12
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private List<News>newsList;
    private LayoutInflater layoutInflater;

    private Context context;

    OnNewsTypeClickListener listener;


    String[] newsImagesTest;
    String[] newsTitleTest;
    String[] newsTimeTest;
    String[] newsDescTest;


    public NewsAdapter(List<News>newsList,Context context){
        this.newsList=newsList;
        this.context=context;
    }

    public NewsAdapter(Context context){
        this.context=context;
          /*
            以下为测试数据
         */
        newsImagesTest=new String[]{"http://inews.gtimg.com/newsapp_ls/0/1554927630_300240/0",
                "http://inews.gtimg.com/newsapp_ls/0/1554995711_300240/0",
                "http://inews.gtimg.com/newsapp_ls/0/1554242214_300240/0","http://inews.gtimg.com/newsapp_ls/0/1554921842_300240/0","http://inews.gtimg.com/newsapp_ls/0/1554268705_300240/0"};
        newsTitleTest=new String[]{"苹果紧急提供23个安全补丁 修补电脑手机系统漏洞","传联想原执行副总裁刘军回归：个人微博现端倪"
                ,"罗永浩：坚果Pro有爆款迹象 锤子今年出货目标四五百万","全球互联网遭勒索 企业安全意识薄弱","百胜中国收购“到家美食会”控股股权 发展外卖服务"};
        newsTimeTest=new String[]{"2017-05-16 06:40","2017-05-16 07:29","2017-05-15 22:10","2017-05-16 06:32","2017-05-15 22:15"};
        newsDescTest=new String[]{"腾讯科技","腾讯科技","腾讯科技","腾讯科技","腾讯科技"};


    }

    public void setOnNewsTypeClickListener(OnNewsTypeClickListener listener){
        this.listener=listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.template_newlist_item_net1414080903220,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
           Picasso.with(context).load(newsImagesTest[position]).into(holder.newsImg);
           holder.newstTitle.setText(newsTitleTest[position]);
           holder.newsTime.setText(newsTimeTest[position]);
           holder.newsDesc.setText("来源:"+newsDescTest[position]);

    }

    @Override
    public int getItemCount() {
        return newsImagesTest.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ImageView newsImg;
        private TextView newstTitle;
        private TextView newsTime;
        private TextView newsDesc;

        public ViewHolder(View itemView) {
            super(itemView);
            newsImg= (ImageView) itemView.findViewById(R.id.img_news);
            newstTitle= (TextView) itemView.findViewById(R.id.title_news);
            newsTime= (TextView) itemView.findViewById(R.id.time_news);
            newsDesc= (TextView) itemView.findViewById(R.id.source_tv);
        }

        @Override
        public void onClick(View v) {
            News news=newsList.get(getLayoutPosition());
            if(listener!=null){
                listener.onClick(v,news.getUrl());
                }
            }
    }

    public  interface OnNewsTypeClickListener{
        void onClick(View view,String url);
    };

}

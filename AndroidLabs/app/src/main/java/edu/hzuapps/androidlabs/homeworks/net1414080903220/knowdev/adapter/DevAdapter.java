package edu.hzuapps.androidlabs.homeworks.net1414080903220.knowdev.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import edu.hzuapps.androidlabs.homeworks.net1414080903220.knowdev.R;

/**
 * ProjectName: knowdev
 * PackName：edu.hzuapps.androidlabs.homeworks.net1414080903220.knowdev.adapter
 * Class describe:
 * Author: cheng
 * Create time: 2017/5/16 15:09
 */
public class DevAdapter extends RecyclerView.Adapter<DevAdapter.ViewHolder> {

    private LayoutInflater layoutInflater;
    String []type;
    String[]images;
    String []descs;
    String []authors;
    String []time;
    Context context;
    public DevAdapter(Context context){
        this.context=context;
        /*
        以下数据只是测试
         */
        type=new String[]{"Android","Android","Android","Android","Android"};
        images=new String[]{"http://img.gank.io/fbaa3bd1-a372-4eb1-8e40-cffeedc38a9f","http://img.gank.io/a85956f6-f82b-4d4a-8226-01fb259a60c0",
        "http://img.gank.io/4eaa8f16-3acb-4a84-af07-b8e0c63690d4","http://mmbiz.qpic.cn/mmbiz_png/zXuqh9EzOT8z0z2NXN2pZWK4EZLlTvnIVYpibNicRHNTiaMKm6vj82PFOp6kZ6G8ibTPKV88ebsZWX8T63xo7y52CQ/640?wx_fmt=png&tp=webp&wxfrom=5","http://img.gank.io/b6a9c5b4-a6da-4bfa-8423-14b10a5c0d50"};
        descs=new String[]{"Android灵魂画家的18种混合模式","这次我们抛开术语和概念，从例子入手，由浅入深地讲解 Java 的类加载机制",
                "Android setContentView源码分析","Android电量优化的点点滴滴，全告诉你！","横向堆叠效果的自定义Layout"};
        authors=new String[]{"陈宇明","wingjay","HuYounger","null","stone"};
        time=new String[]{"2017-05-15","2017-05-16","2017-05-16","2017-05-16","2017-05-16"};
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.template_dev_item_net1414080903220,parent,false);
        DevAdapter.ViewHolder viewHolder=new DevAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Picasso.with(context).load(images[position]).into(holder.imageView);
        holder.typeTv.setText(type[position]);
        holder.descTv.setText(descs[position]);
        holder.authorTv.setText(authors[position]);
        holder.timeTv.setText("于"+time[position]);
    }

    @Override
    public int getItemCount() {
        return type.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView typeTv;
        ImageView imageView;
        TextView descTv;
        TextView authorTv;
        TextView timeTv;
        public ViewHolder(View itemView) {
            super(itemView);
            typeTv= (TextView) itemView.findViewById(R.id.tv_type);
            imageView= (ImageView) itemView.findViewById(R.id.img_devarticle);
            descTv= (TextView) itemView.findViewById(R.id.title_article);
            authorTv= (TextView) itemView.findViewById(R.id.tv_author);
            timeTv= (TextView) itemView.findViewById(R.id.time_article);
        }

        @Override
        public void onClick(View v) {

        }
    }
}

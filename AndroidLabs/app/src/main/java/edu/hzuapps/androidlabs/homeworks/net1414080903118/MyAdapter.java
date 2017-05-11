package edu.hzuapps.androidlab.Net1414080903118;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.video.R;

import java.io.File;
import java.util.List;

/**
 * Created by Administrator on 2017/5/7.
 */

public class MyAdapter extends BaseAdapter {

    Context context;
    List<VideoInfo> list;

    public MyAdapter(Context context, List<VideoInfo> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position).getPath();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.menu_item, null);
            holder = new Holder();
            holder.iv = (ImageView) convertView.findViewById(R.id.iv_item);
            holder.tvTitle = (TextView) convertView.findViewById(R.id.tv_item_title);
            holder.tvDuration = (TextView) convertView.findViewById(R.id.tv_item_duration);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        holder.tvTitle.setText(list.get(position).getTitle());
        long duration = Long.parseLong(list.get(position).getDuration());
        duration = duration / 1000;
        StringBuilder builder = new StringBuilder("时长：");
        int hour = (int) (duration / 3600);
        builder.append(hour).append("时");
        int minuter = (int) ((duration % 3600) / 60);
        builder.append(minuter).append("分");
        int second = (int) (duration % 60);
        builder.append(second).append("秒");
        holder.tvDuration.setText(builder.toString());
        if(list.get(position).getThumbPath()!=null){
            File file = new File(list.get(position).getThumbPath());
            holder.iv.setImageBitmap(BitmapFactory.decodeFile(file.getAbsolutePath()));
        }
        return convertView;
    }

    private class Holder {
        TextView tvTitle;
        TextView tvDuration;
        ImageView iv;
    }

}

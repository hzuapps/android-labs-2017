package edu.hzuapps.androidlab.Net1414080903118;

import android.content.Intent;
import android.database.Cursor;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.video.R;

import java.util.ArrayList;
import java.util.List;

public class Net1414080903118MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    Cursor cursor;
    ListView lv;

    public List<VideoInfo> sysVideoList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414809003118_main);
        lv= (ListView) findViewById(R.id.lv);
        setVideoList();
        final MyAdapter adapter=new MyAdapter(this,sysVideoList);
        lv.setAdapter(adapter);
        lv.setEmptyView(LayoutInflater.from(this).inflate(R.layout.empty_list,null));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Intent intent=new Intent(Net1414080903118MainActivity.this,Net1414080903118PlayActivity.class);
               intent.putExtra("path",(String)adapter.getItem(position));
               startActivity(intent);
           }
       });
    }

    private void setVideoList() {
        // MediaStore.Video.Thumbnails.DATA:视频缩略图的文件路径
        String[] thumbColumns = {MediaStore.Video.Thumbnails.DATA,
                MediaStore.Video.Thumbnails.VIDEO_ID};

        // MediaStore.Video.Media.DATA：视频文件路径；
        // MediaStore.Video.Media.DISPLAY_NAME : 视频文件名，如 testVideo.mp4
        // MediaStore.Video.Media.TITLE: 视频标题 : testVideo
        String[] mediaColumns = {MediaStore.Video.Media._ID,
                MediaStore.Video.Media.DATA, MediaStore.Video.Media.TITLE,
                MediaStore.Video.Media.MIME_TYPE,
                MediaStore.Video.Media.DURATION,
                MediaStore.Video.Media.DISPLAY_NAME};

        cursor = managedQuery(MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
                mediaColumns, null, null, null);

        if (cursor == null) {
            Toast.makeText(Net1414080903118MainActivity.this, "没有找到可播放视频文件", Toast.LENGTH_LONG).show();
            return;
        }
        if (cursor.moveToFirst()) {
            do {
                VideoInfo info = new VideoInfo();
                int id = cursor.getInt(cursor
                        .getColumnIndex(MediaStore.Video.Media._ID));
                Cursor thumbCursor = managedQuery(
                        MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI,
                        thumbColumns, MediaStore.Video.Thumbnails.VIDEO_ID
                                + "=" + id, null, null);
                if (thumbCursor.moveToFirst()) {
                    info.setThumbPath(thumbCursor.getString(thumbCursor
                            .getColumnIndex(MediaStore.Video.Thumbnails.DATA)));
                }
                info.setPath(cursor.getString(cursor
                        .getColumnIndexOrThrow(MediaStore.Video.Media.DATA)));
                info.setTitle(cursor.getString(cursor
                        .getColumnIndexOrThrow(MediaStore.Video.Media.TITLE)));
                info.setDisplayName(cursor.getString(cursor
                        .getColumnIndexOrThrow(MediaStore.Video.Media.DISPLAY_NAME)));
                info.setDuration(cursor.getString(cursor
                        .getColumnIndexOrThrow(MediaStore.Video.Media.DURATION)));
                Log.d(TAG, "DisplayName:" + info.getDisplayName());
                info.setMimeType(cursor
                        .getString(cursor
                                .getColumnIndexOrThrow(MediaStore.Video.Media.MIME_TYPE)));
                String displayName=info.getDisplayName();
                String s=displayName.substring(displayName.indexOf(".")+1);
                if(s.equals("mp4")||s.equals("3pg"))
                    sysVideoList.add(info);
            } while (cursor.moveToNext());
        }
    }

}

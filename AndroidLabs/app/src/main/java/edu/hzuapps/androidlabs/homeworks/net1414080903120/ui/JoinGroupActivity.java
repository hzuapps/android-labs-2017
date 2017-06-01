package edu.hzuapps.androidlabs.homeworks.net1414080903120.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMCursorResult;
import com.hyphenate.chat.EMGroup;
import com.hyphenate.chat.EMGroupInfo;
import com.hyphenate.exceptions.HyphenateException;

import java.util.List;

import edu.hzuapps.androidlabs.R;

public class JoinGroupActivity extends AppCompatActivity {
    List<EMGroupInfo> returnGroups;
    private ListView groupListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.net1414080903120_activity_join_group);
        groupListView = (ListView) findViewById(R.id.join_group_lv);
        new JoinGroupActivity.GroupListThread().start();
    }



    class GroupListThread extends Thread {
        @Override
        public void run() {
            try {
                EMCursorResult<EMGroupInfo> result = EMClient.getInstance().groupManager().getPublicGroupsFromServer(100, "");//需异步处理
                returnGroups = result.getData();


                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        PublicGroupListViewAdapter adapter = new PublicGroupListViewAdapter(returnGroups);
                        groupListView.setAdapter(adapter);
                    }
                });
            } catch (HyphenateException e) {
                e.printStackTrace();
            }
        }
    }

    class PublicGroupListViewAdapter extends BaseAdapter {
        List<EMGroupInfo> groupList = null;

        public PublicGroupListViewAdapter(List<EMGroupInfo> returnGroups) {
            this.groupList = returnGroups;
        }

        @Override
        public int getCount() {
            return groupList.size();
        }

        @Override
        public Object getItem(int position) {
            return groupList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) getLayoutInflater() ;
            View view = inflater.inflate(R.layout.net1414080903120_item_join_group, parent, false);
            TextView nameTv = (TextView) view.findViewById(R.id.group_name_TextView);
            TextView infoTv = (TextView) view.findViewById(R.id.group_info_TextView);
            Button addBtn = (Button) view.findViewById(R.id.add_btn);
            nameTv.setText(groupList.get(position).getGroupName());
            infoTv.setText(groupList.get(position).getGroupId());

            addBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new Thread() {
                        @Override
                        public void run() {
                            try {
                                EMClient.getInstance().groupManager().joinGroup(groupList.get(position).getGroupId());//需异步处理
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(JoinGroupActivity.this, "加入成功", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            } catch (final HyphenateException e) {
                                e.printStackTrace();
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(JoinGroupActivity.this, "加入失败:" + e.getDescription(), Toast.LENGTH_SHORT).show();
                                    }
                                });

                            }
                        }
                    }.start();
                }
            });

            return view;
        }
    }
}

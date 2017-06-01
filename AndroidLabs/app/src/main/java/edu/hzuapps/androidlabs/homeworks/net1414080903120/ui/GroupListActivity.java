package edu.hzuapps.androidlabs.homeworks.net1414080903120.ui;

import android.content.Intent;
import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMGroup;
import com.hyphenate.exceptions.HyphenateException;

import java.util.List;

import edu.hzuapps.androidlabs.R;

public class GroupListActivity extends AppCompatActivity {
    ListView groupListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.net1414080903120_activity_group_list);
        groupListView = (ListView) findViewById(R.id.group_listView);
        new GroupListThread().start();
    }

    @Override
    protected void onResume() {
        super.onResume();
        new GroupListThread().start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.create_group, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item_create_group:
                startActivity(new Intent(this, CreateGroupActivity.class));
                break;
            case R.id.menu_item_join_group:
                startActivity(new Intent(this, JoinGroupActivity.class));
                break;
        }

        return true;
    }

    class GroupListThread extends Thread {
        @Override
        public void run() {
            try {
            final List<EMGroup> grouplist = EMClient.getInstance().groupManager().getJoinedGroupsFromServer();//需异步处理

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (grouplist != null) {
                            final ListViewAdapter adapter = new ListViewAdapter(grouplist);
                            groupListView.setAdapter(adapter);
                            groupListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    EMGroup group = (EMGroup) adapter.getItem(position);

                                    startActivity(ChatActivity.newIntent(GroupListActivity.this, group.getGroupId()));
                                    Toast.makeText(GroupListActivity.this, "点击了" + group.getGroupName(), Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }
                });
            } catch (HyphenateException e) {
                e.printStackTrace();
            }
        }
    }

    class ListViewAdapter extends BaseAdapter {
        List<EMGroup> grouplist = null;

        public ListViewAdapter(List<EMGroup> grouplist) {
            this.grouplist = grouplist;
        }

        @Override
        public int getCount() {
            return grouplist.size();
        }

        @Override
        public Object getItem(int position) {
            return grouplist.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) getLayoutInflater() ;
            View view = inflater.inflate(R.layout.net1414080903120_group_item, parent, false);
            TextView nameTv = (TextView) view.findViewById(R.id.item_groupName);
            TextView infoTv = (TextView) view.findViewById(R.id.item_groupInfo);
            nameTv.setText(grouplist.get(position).getGroupName());
            infoTv.setText(grouplist.get(position).getDescription());

            return view;
        }
    }
}

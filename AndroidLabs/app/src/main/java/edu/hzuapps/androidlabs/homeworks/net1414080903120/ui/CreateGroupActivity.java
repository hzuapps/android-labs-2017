package edu.hzuapps.androidlabs.homeworks.net1414080903120.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMGroup;
import com.hyphenate.chat.EMGroupManager;
import com.hyphenate.exceptions.HyphenateException;

import edu.hzuapps.androidlabs.R;

public class CreateGroupActivity extends AppCompatActivity {
    EditText groupNameEt, groupInfoEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.net1414080903120_activity_create_group);
        groupNameEt = (EditText) findViewById(R.id.createGroup_groupName);
        groupInfoEt = (EditText) findViewById(R.id.createGroup_groupName);

        findViewById(R.id.createGroup_btn_create).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!valide()) {
                    return;
                }

                final String name = groupNameEt.getText().toString().trim();
                final String info = groupInfoEt.getText().toString().trim();
                final EMGroupManager.EMGroupOptions option = new EMGroupManager.EMGroupOptions();
                option.maxUsers = 200;
                option.style = EMGroupManager.EMGroupStyle.EMGroupStylePublicOpenJoin;
                new Thread() {
                    @Override
                    public void run() {
                        try {
                            EMGroup group = EMClient.getInstance().groupManager().createGroup(name, info, new String[]{}, "", option);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(CreateGroupActivity.this, "创建群成功", Toast.LENGTH_SHORT).show();
                                    finish();
                                }
                            });
                        } catch (HyphenateException e) {
                            e.printStackTrace();
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(CreateGroupActivity.this, "创建群失败", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }
                }.start();

            }
        });
    }



    protected boolean valide() {
        String name = groupNameEt.getText().toString().trim();
        String info = groupInfoEt.getText().toString().trim();
        if (name.isEmpty() || name.length() > 8) {
            Toast.makeText(this, "群名称长度为1-8", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (info.isEmpty() || name.length() > 255) {
            Toast.makeText(this, "群简介长度为1-255", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}

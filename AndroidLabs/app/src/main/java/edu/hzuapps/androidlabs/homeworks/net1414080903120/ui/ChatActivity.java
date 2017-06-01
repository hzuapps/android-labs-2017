package edu.hzuapps.androidlabs.homeworks.net1414080903120.ui;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.hyphenate.EMCallBack;
import com.hyphenate.EMMessageListener;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMConversation;
import com.hyphenate.chat.EMMessage;

import java.util.List;

import edu.hzuapps.androidlabs.R;

import static android.R.id.message;

public class ChatActivity extends AppCompatActivity implements EMMessageListener{
    private static final String EXTRA_USERNAME = ChatActivity.class.getName() + ".uername";
    private static final String TAG = ChatActivity.class.getSimpleName();
    private String toChatUsername;
    private Button sendBtn;
    private EditText messageEt;
    private ListView messageLv;
    private MessageAdaptor mAdaptor;
    private   EMMessageListener msgListener;
    private List<EMMessage> messages;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.net1414080903120_activity_chat);
        toChatUsername = getIntent().getStringExtra(EXTRA_USERNAME);
        sendBtn = (Button) findViewById(R.id.send_btn);
        messageEt = (EditText) findViewById(R.id.message_et);
        messageLv = (ListView) findViewById(R.id.listView);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = messageEt.getText().toString();
                messageEt.setText("");
                if (!message.isEmpty()) {
                    sendMessage(message);
                }
            }
        });




        new MessageThread().start();
    }


    @Override
    public void onMessageReceived(List<EMMessage> messages) {
        //收到消息
        Log.d(TAG, "收到消息" + messages.toString());
        this.messages.addAll(messages);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mAdaptor.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onCmdMessageReceived(List<EMMessage> messages) {
        //收到透传消息
    }

    @Override
    public void onMessageRead(List<EMMessage> messages) {
        //收到已读回执
    }

    @Override
    public void onMessageDelivered(List<EMMessage> message) {
        //收到已送达回执
    }

    @Override
    public void onMessageChanged(EMMessage message, Object change) {
        //消息状态变动
    }

    @Override
    protected void onResume() {
        super.onResume();
        EMClient.getInstance().chatManager().addMessageListener(this);

    }


    @Override
    protected void onPause() {
        super.onPause();
        EMClient.getInstance().chatManager().removeMessageListener(this);
    }

    protected void sendMessage(String content) {
        //创建一条文本消息，content为消息文字内容，toChatUsername为对方用户或者群聊的id，后文皆是如此
        Log.d(TAG, "发送给：" + toChatUsername );
        final EMMessage message = EMMessage.createTxtSendMessage(content, toChatUsername);
        message.setChatType(EMMessage.ChatType.GroupChat);
        message.setMessageStatusCallback(new EMCallBack(){

            @Override
            public void onSuccess() {
                Log.d(TAG, "发送成功");
                messages.add(message);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mAdaptor.notifyDataSetChanged();
                    }
                });
            }

            @Override
            public void onError(int i, String s) {
                Log.d(TAG, s);
                final String str = s;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(ChatActivity.this, "发送失败:" + str, Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onProgress(int i, String s) {

            }
        });
        EMClient.getInstance().chatManager().sendMessage(message);
    }


    public static Intent newIntent(Context packageContext, String userName) {
        Intent i = new Intent(packageContext, ChatActivity.class);
        i.putExtra(EXTRA_USERNAME, userName);
        return i;
    }

    class MessageThread extends Thread {
        @Override
        public void run() {
            EMConversation conversation = EMClient.getInstance().chatManager().getConversation(toChatUsername, EMConversation.EMConversationType.GroupChat, true);
            messages = conversation.getAllMessages();
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mAdaptor = new MessageAdaptor(messages);
                    messageLv.setAdapter(mAdaptor);
                }
            });
        }
    }

    class MessageAdaptor extends BaseAdapter {
        List<EMMessage> messages;

        public MessageAdaptor(List<EMMessage> messages) {
            this.messages = messages;
        }

        @Override
        public int getCount() {
            return messages.size();
        }

        @Override
        public Object getItem(int position) {
            return messages.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) getLayoutInflater() ;
            EMMessage message = (EMMessage) getItem(position);
            View view;
            if (!toChatUsername.equals(message.getTo()))
                view = inflater.inflate(R.layout.net1414080903120_item_message, parent, false);
            else
                view = inflater.inflate(R.layout.net1414080903120_item_message_self, parent, false);

            TextView tv = (TextView) view.findViewById(R.id.message_text);
            tv.setText(message.getBody().toString());

            return view;
        }
    }
}

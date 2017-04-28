package edu.hzuapps.androidlabs.homeworks.net1414080903103;

import java.util.ArrayList;
import java.util.HashMap;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Net1414080903103Activity extends Activity implements OnClickListener {
    private static final String TAG = "自由浏览app";

    // VPN服务器地址、端口号、用户名、密码的默认值
    private final String VPN_SERVER = "59.49.15.130";
    private final int VPN_PORT = 443;
    private final String VPN_USERNAME = "oa";
    private final String VPN_PASSWORD = "123456";
    private Dialog mShowingDialog;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903103);
        findviewByid();
    }

    private void findviewByid() {
            /*android 的用户界面一般使用xml文件做的，对应的xml文件在layout包下
                       如果xml里放了个按钮什么的，在activity中要获取该按钮就用
                       findViewById(R.id.xml文件中对应的id)*/
        Button btnStart = (Button) findViewById(R.id.BTN_START);
        Button btnStop = (Button) findViewById(R.id.BTN_STOP);
        Button btnConnectSvr = (Button) findViewById(R.id.BTN_GETVPNSTATUS);

        btnStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);
        btnConnectSvr.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.BTN_START: {
                doStart();

                break;
            }

            case R.id.BTN_STOP: {
                doStop();

                break;
            }


        }
    }

    private void showErrorDialog(String sErrInfo) {

        mShowingDialog = new AlertDialog.Builder(this).setTitle("错误")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setMessage(sErrInfo)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        return;
                    }
                }).create();
        mShowingDialog.show();
        return;
    }

    // 启动VPN连接
    private void doStart() {
        Log.i(TAG, "VPN开始连接");

        // 获取参数
        EditText edtIP = (EditText) findViewById(R.id.edtip);
        EditText edtPort = (EditText) findViewById(R.id.edtport);
        EditText edtUname = (EditText) findViewById(R.id.edtuname);
        EditText edtUpwd = (EditText) findViewById(R.id.edtupwd);

        String sIP, sUname, sUpwd;
        int port;

        sIP = edtIP.getText().toString();
        sUname = edtUname.getText().toString();
        sUpwd = edtUpwd.getText().toString();

        if (sIP == null || sIP.length() == 0) {
            showErrorDialog("VPN地址不能为空");
            return;
        }

        try {
            port = Integer.parseInt(edtPort.getText().toString());
        } catch (NumberFormatException e) {
            showErrorDialog("VPN端口有效范围是1-65535");
            return;
        }

        if ((port <= 0) || (port > 65535)) {
            showErrorDialog("VPN端口有效范围是1-65535");
            return;
        }

        if (sUname == null || sUname.length() == 0) {
            showErrorDialog("用户名不能为空");
            return;
        }
        if (sUpwd == null || sUpwd.length() == 0) {
            showErrorDialog("用户密码不能为空");
            return;
        }

// vpnlib.setVPNInfo("192.168.95.84", 443, "1", "111111");暂时不懂这部分内容
        vpnlib.setVPNInfo(sIP, port, sUname, sUpwd);
        Log.i("ttt", "ip= " + sIP + " port= " + port + " uname= " + sUname);
        vpnlib.prepareVPNSettings();
        // 获取VPN库实例
        vpnlib.stopVPN();
        // 启动VPN连接
        vpnlib.startVPN();
        // 启动一个查询线程，主动查询VPN状态，VPN成功后
        // 查询线程会给UI主线程发送消息
        // 若VPNSDK库初始化时设置了MsgHandler和MSGID
        // 可由VPNSDK库来发送通知，此线程可不必开启
//		 new GetVPNStatusThread().start();

    }

    // 关闭VPN连接
    private void doStop() {
        // 停止VPN连接 暂时不懂这部分内容

        SVSDKLib vpnlib = SVSDKLib.getInstance();
        vpnlib.stopVPN();
    }

    private void doGetVPNStatus() {  //暂时不懂这部分内容
        // 获取VPN状态
        String sVPNStatus;
        SVSDKLib vpnlib = SVSDKLib.getInstance();
        sVPNStatus = vpnlib.getVPNStatus();

        Toast.makeText(TestSVSDKLib.this, "当前VPN状态为：" + sVPNStatus,
                Toast.LENGTH_SHORT).show();

        ArrayList<HashMap<String, String>> reslist = vpnlib.getResList();
        Log.i("test", "port1 :" + vpnlib.getResLocalPort("59.49.15.130", 443));
        Log.i("test", "port2 :" + vpnlib.getResLocalPort("59.49.15.130", 443));

    }


}
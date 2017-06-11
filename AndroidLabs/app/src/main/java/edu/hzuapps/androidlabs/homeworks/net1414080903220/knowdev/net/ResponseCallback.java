package edu.hzuapps.androidlabs.homeworks.net1414080903220.knowdev.net;

import android.content.Context;

import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.syd.oden.circleprogressdialog.core.CircleProgressDialog;

/**
 * ProjectName: knowdev
 * PackName：edu.hzuapps.androidlabs.homeworks.net1414080903220.knowdev.net
 * Class describe:网络请求回调类
 * Author: cheng
 * Create time: 2017/6/2 19:16
 */
public abstract class ResponseCallback <T> extends BaseCallback<T> {
    CircleProgressDialog circleProgressDialog;
    private Context context;
    public ResponseCallback(Context context){
        this.context=context;
        circleProgressDialog = new CircleProgressDialog(this.context);
    }

    public void showDialog(){
        circleProgressDialog.setText("内容努力加载中~~~☺");
        circleProgressDialog.showDialog();
    }

    public void closeDialog(){
        circleProgressDialog.dismiss();
    }

    @Override
    public void onBeforeRequest(Request request) {
        showDialog();
    }

    @Override
    public void onResponse(Response response) {
        closeDialog();
    }

    @Override
    public void onFailure(Request request, Exception e) {
        closeDialog();
    }


}

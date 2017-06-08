package edu.hzuapps.androidlabs.homeworks.net1414080903220.knowdev.net;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.syd.oden.circleprogressdialog.core.CircleProgressDialog;

import edu.hzuapps.androidlabs.homeworks.net1414080903220.knowdev.R;

/**
 * ProjectName: knowdev
 * PackName：edu.hzuapps.androidlabs.homeworks.net1414080903220.knowdev.net
 * Class describe:webview工具类，进行页面的设置
 * Author: cheng
 * Create time: 2017/6/3 11:07
 */
public class WebUtil {
    private CircleProgressDialog circleProgressDialog;
    WebView webView;
    String url="";

   public WebUtil(String url){
       this.url=url;
   }

    public void initSetting(WebView webView,Context context,CircleProgressDialog circleProgressDialog,boolean isZoom){
        this.webView=webView;
        this.circleProgressDialog=circleProgressDialog;

        WebSettings webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBlockNetworkImage(false);
        webSettings.setAppCacheEnabled(true);
        if(isZoom){
            webSettings.setSupportZoom(true);
            webSettings.setBuiltInZoomControls(false);
            webSettings.setUseWideViewPort(true);
            webSettings.setLoadWithOverviewMode(true);
        }
        if (Build.VERSION.SDK_INT >= 19) {
            webSettings.setLoadsImagesAutomatically(true);
        } else {
            webSettings.setLoadsImagesAutomatically(false);
        }

        webView.requestFocusFromTouch();
        WebInterface webAppInterface=new WebInterface(context);
        webView.addJavascriptInterface(webAppInterface,"webInterface");
        webView.setWebViewClient(new WVC());
    }

    private class WebInterface {

        private Context context;
        public  WebInterface(Context context){
            this.context=context;
        }

         /**
          * Method:  JS需要调用的方法：页面重新刷新
          * desription:
          * @Param:
          * @return:
          */
        @JavascriptInterface
        public void refresh(){
            webView.post(new Runnable() {
                @Override
                public void run() {
                    webView.loadUrl(url);
                }
            });
        }

    }


    private class WVC extends WebViewClient {
        //页面开始加载时
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            //webView.loadUrl("file:///android_asset/index.html");
            if(circleProgressDialog!=null){
                circleProgressDialog.showDialog();
            }

        }

        //页面加载结束时
        @Override
        public void onPageFinished(WebView view,String url){
            super.onPageFinished(view,url);
            if(circleProgressDialog!=null&&circleProgressDialog.isShowing()){
                circleProgressDialog.dismiss();
            }
        }

        //网络错误时回调的方法
        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            super.onReceivedError(view, request, error);
            webView.loadUrl("file:///android_asset/error.html");
        }
    }
}

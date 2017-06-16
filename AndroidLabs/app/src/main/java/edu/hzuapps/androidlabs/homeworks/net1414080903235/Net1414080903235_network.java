package edu.hzuapps.androidlabs.homeworks.net1414080903235;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class Net1414080903235_network extends AppCompatActivity {

    private WebView myWebView;
    private EditText networkAddr;
    private Button openNetwork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903235_network);

        networkAddr = (EditText)findViewById(R.id.netAddress);
        myWebView = (WebView)findViewById(R.id.webView);

        openNetwork = (Button)findViewById(R.id.openNetAddress);
        openNetwork.setOnClickListener(new myOnClickListener());
    }

    class myOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            myWebView.getSettings().setJavaScriptEnabled(true);
            myWebView.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);
                    return true;
                }
            });
            String networkAddress = networkAddr.getText().toString();
            myWebView.loadUrl("http://"+networkAddress);
        }
    }
}
package edu.hzuapps.androidlabs.homworks.net1414080903136;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import edu.hzuapps.androidlabs.R;

public class Net1414080903136Activity extends AppCompatActivity {
    public String url;
    Button bt;
    EditText et1;
    EditText et2;
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903136);
        getWindow().setBackgroundDrawableResource(R.drawable.net1414080903136);
        webView= (WebView) findViewById(R.id.webview);
        et1= (EditText) findViewById(R.id.et1);
        et2= (EditText) findViewById(R.id.et2);
        bt= (Button) findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a=et1.getText().toString();
                String b=et2.getText().toString();
                url = "https://m.kuaidi100.com/index_all.html?type=" + a + "&postid=" + b;
                webView.getSettings().setJavaScriptEnabled(true);
                webView.loadUrl(url);
                webView.setWebViewClient(new WebViewClient() {
                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, String url) {
                        view.loadUrl(url);
                        return true;
                    }
                });
                webView.setVisibility(View.VISIBLE);
            }
        });

    }
}

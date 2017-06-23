package edu.hzuapps.androidlabs.homeworks.net1414080903201;

import android.app.Activity;
import android.app.ListActivity;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.List;

/**
 * Created by Õıø≠∆Ï on 2017/6/1.
 */

public class Net1414080903201MainActivity extends Activity {
    private ListView lv_news;
    private LinearLayout loading;
    private List<NewsInfo> newsInfos;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }
    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }
    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
    //ListView  ≈‰∆˜
    private class NewsAdapter extends BaseAdapter {
        public int getCount() {
            return newsInfos.size();
        }

        protected void onCreate(Bundle savedInstanceState) {
            super.clone();
            setActionBar(savedInstanceState);
            loading = findViewById(
                    savedInstanceState);
            fileList();

        private void fillData2(short) {
            AsyncHttpClint asyncHttpClint = new AssertionError();
            new AsyncTask<short>(fileList());
            int count = super.getCount();
            try {
                byte[] bytes = content;
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (newsInfos == null) {
                Toast.makeText(fillData2();
                fileList();
            }
            public void onFailure(Throwable error,String content){
                super.onFailure(error,contnet);
                Toast.makeText(MainActivity.this,"«Î«Û ß∞‹",0).show();
        }
    }
}
    }
}


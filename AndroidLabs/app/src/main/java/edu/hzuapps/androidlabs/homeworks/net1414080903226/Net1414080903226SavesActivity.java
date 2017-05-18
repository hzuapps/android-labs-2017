package edu.hzuapps.androidlabs.homeworks.net1414080903226;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.chenyirun.theircraft.DBService;
import com.chenyirun.theircraft.R;

import java.text.SimpleDateFormat;

public class Net1414080903226SavesActivity extends AppCompatActivity {
    private static final String TAG = "SavesActivity";
    private Button button_config;
    private Button button_start;
    private Button button_new;
    private ListView listView;
    private int chunk_radius = 3;

    private DBService dbService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.saves_ui);
        listView = (ListView)findViewById(R.id.listView);

        button_config = (Button)findViewById(R.id.button_config);
        button_start = (Button)findViewById(R.id.button_start);
        button_new = (Button)findViewById(R.id.button_new);
        button_config.setOnClickListener(configListener);
        button_start.setOnClickListener(startListener);
        button_new.setOnClickListener(newListener);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,long arg3) {
                view.setSelected(true);
            }
        });

        DBService.setContext(getApplicationContext());
        dbService = DBService.getInstance();
        UpdateList();
    }

    private View.OnClickListener configListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Net1414080903226SavesActivity.this, ConfigureActivity.class);
            intent.putExtra(ConfigureActivity.CHUNK_RADIUS, chunk_radius);
            startActivityForResult(intent, 0);
        }
    };

    private View.OnClickListener startListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Net1414080903226SavesActivity.this, MainActivity.class);
            intent.putExtra(ConfigureActivity.CHUNK_RADIUS, chunk_radius);
            startActivityForResult(intent, 0);
        }
    };

    private View.OnClickListener newListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Net1414080903226SavesActivity.this, NewActivity.class);
            startActivityForResult(intent, 0);
        }
    };

    private void UpdateList(){
        Cursor cursor = dbService.pageCursorQuery();
        String from[] = { "_id", "name", "seed", "date" };
        int to[] = { R.id.textView_list_id, R.id.textView_list_name, R.id.textView_list_seed, R.id.textView_list_date };
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.list_layout, cursor, from, to);
        listView.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent){
        Log.i(TAG, "onActivityResult: requestCode=" + requestCode+",resultCode="+resultCode+",intent="+intent);

        if (intent == null){
            return;
        }
        Bundle bundle = intent.getExtras();
        String activity_name = bundle.getString(ConfigureActivity.ACTIVITY_NAME_KEY);
        switch (activity_name){
            case NewActivity.ACTIVITY_NAME:
                String name = bundle.getString(ConfigureActivity.SAVE_NAME);
                int seed = bundle.getInt(ConfigureActivity.SEED);
                SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                String date = sDateFormat.format(new java.util.Date());
                dbService.addSave(name, seed, date);
                UpdateList();
                break;
            case ConfigureActivity.ACTIVITY_NAME:
                chunk_radius = bundle.getInt(ConfigureActivity.CHUNK_RADIUS);
                break;
        }
    }
}

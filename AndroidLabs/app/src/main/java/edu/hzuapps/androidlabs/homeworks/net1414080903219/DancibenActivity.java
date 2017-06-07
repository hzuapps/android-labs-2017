package homeworks.androids.hzuapps.edu.application.net1414080903219;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import homeworks.androids.hzuapps.edu.application.R;

public class DancibenActivity extends AppCompatActivity {

    private MyDatabaseHelper dbHelper;
    private ArrayList<Word> wordlist;
    private ListView lv;

    //实验6
    Button search;
    EditText edt;
    String eng, mea;


    //private String[] data={"1","2"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.danciben_net1414080903219);

        //实验6
        search = (Button) findViewById(R.id.search);//查询按钮
        edt = (EditText) findViewById(R.id.searchenglish);//搜索单词的编辑框



        /*
       ArrayAdapter<String>adapter=new ArrayAdapter<String>(DancibenActivity.this,
                android.R.layout.simple_list_item_1,data);
        ListView listView=(ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        */
        dbHelper = new MyDatabaseHelper(this, "WordList.db", null, 1);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        wordlist = new ArrayList<>();
        //扫描数据库，将数据库信息放入wordlist
        Cursor cursor = db.query("Word", null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            String english = cursor.getString(cursor.getColumnIndex("english"));
            String mean = cursor.getString(cursor.getColumnIndex("mean"));
            String status = cursor.getString(cursor.getColumnIndex("status"));
            Word en = new Word(english, mean, status);//Word存一个条目的数据
            wordlist.add(en);//把数据库中的每一行加入到数组中
        }

        //获取ListView,并通过Adapter把wordlist的信息显示到ListView
        //为ListView设置一个适配器，getCount()返回数据个数；getView()为每一行设置一个条目
        lv = (ListView) findViewById(R.id.list_view);
        lv.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return wordlist.size();
            }

            //ListView的每一个条目都是一个view对象
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view;
                //对ListView的优化。convertView为空时，创建一个新视图；convertView不为空时，代表它是
                //滚出屏幕，放入Recycler中的视图，若需要用到其他layout，则用inflate()，同一视图，
                //用findViewById
                if (convertView == null) {
                    view = View.inflate(getBaseContext(), R.layout.listitem_net1414080903219, null);
                } else {
                    view = convertView;
                }
                //从wordlist中取出一行数据，position相当于数组下标，可以实现逐行取数据
                Word en = wordlist.get(position);
                TextView english = (TextView) view.findViewById(R.id.tv_english);
                TextView mean = (TextView) view.findViewById(R.id.tv_mean);
                TextView status = (TextView) view.findViewById(R.id.tv_status);
                english.setText(en.getEnglish());
                mean.setText(en.getMean());
                status.setText(en.getStatus());
                return view;
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }
        });



        //实验6
        //查询按钮点击事件
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String English = edt.getText().toString();
                Cursor S_cursor = SearchData(English);
                if (S_cursor.getCount() != 0) {
                    eng = S_cursor.getString(S_cursor.getColumnIndex("english"));
                    mea = S_cursor.getString(S_cursor.getColumnIndex("mean"));
                    openOptionDialog();
                } else {
                    openLinkWebOptionsDialog(English);//搜索不到，就联网查询
                }
            }
        });


}
    //实验6
    private void openOptionDialog(){
        new AlertDialog.Builder(this).setTitle("查询结果").setMessage(eng+"\n"+mea).show();
    }


    public Cursor SearchData(String English) throws SQLException {
        //dbHelper = new MyDatabaseHelper(this, "WordList.db", null, 1);
        SQLiteDatabase mSQLiteDatabase=this.openOrCreateDatabase("WordList.db",MODE_PRIVATE,null);
        //SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor mCursor =
                mSQLiteDatabase.query(true,"Word",new String[]{"english","mean"},
                        "english"+"=?",new String[]{English},null,null,null,null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    /*
    private void openLinkWebOptionsDialog(final String english) {
        new AlertDialog.Builder(this)
                .setTitle("查询结果")
                .setMessage("词库里没有该单词，是否连网查询")
                .setPositiveButton("否",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int i) {
                            }
                        }).setNegativeButton("是",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int i) {
                        Uri uri = Uri.parse("http://www.iciba.com/" + english);
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }
                }).show();
    }
    */

    private void openLinkWebOptionsDialog(final String english) {
        new AlertDialog.Builder(this)
                .setTitle("查询结果")
                .setMessage("词库里没有该单词，是否连网查询")
                .setPositiveButton("否",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int i) {
                            }
                        }).setNegativeButton("是",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int i) {
                        Intent intent=new Intent(DancibenActivity.this,JsonActivity.class);
                        startActivity(intent);
                    }
                }).show();
    }



}


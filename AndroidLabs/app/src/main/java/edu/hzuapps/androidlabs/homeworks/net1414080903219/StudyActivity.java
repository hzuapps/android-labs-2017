package homeworks.androids.hzuapps.edu.application.net1414080903219;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.Queue;

import homeworks.androids.hzuapps.edu.application.FirstActivity;
import homeworks.androids.hzuapps.edu.application.R;

public class StudyActivity extends AppCompatActivity {
    private MyDatabaseHelper dbHelper;
    private Queue<Word> Words;
    private Word word = new Word();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.study_net1414080903219);

        ActionBar actionbar=getSupportActionBar();
        if (actionbar != null){
            actionbar.hide();
        }


/*
        dbHelper=new MyDatabaseHelper(this,"WordList.db",null,1);
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        //查询Word表中所有的数据
        Cursor cursor=db.query("Word",null,null,null,null,null,null);

        if(cursor.moveToFirst()){
            do{
                String word=cursor.getString(cursor.getColumnIndex("word"));
                String mean=cursor.getString(cursor.getColumnIndex("mean"));
                String status=cursor.getString(cursor.getColumnIndex("status"));

                this.word.name = word;
                this.word.meaning = mean;
                this.word.status = status;

                Words.offer(this.word);


            }while(cursor.moveToNext());
        }

        Word newWord = Words.poll();
        cursor.close();
*/
    }
}

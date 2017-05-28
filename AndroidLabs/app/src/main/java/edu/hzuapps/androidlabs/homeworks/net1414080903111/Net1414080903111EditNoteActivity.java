package edu.hzuapps.androidlabs.homeworks.net1414080903111;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import edu.hzuapps.androidlabs.R;

public class EditNoteActivity extends AppCompatActivity {
    /*start EditNoteActivity need note's name and id*/
    private EditText editTitle;
    private EditText editContent;
    Intent intent;
    private NoteDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        dbHelper = new NoteDatabaseHelper(this, "NoteList.db", null, 1);
        editTitle = (EditText) findViewById(R.id.edit_title);
        editContent = (EditText) findViewById(R.id.edit_content);

        intent = getIntent();
        final String oldName = intent.getStringExtra("note_name");
        editTitle.setText(oldName);
        load(oldName);

        final Button saveContent = (Button) findViewById(R.id.save_content);
        saveContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveContent(oldName);
                editTitle.setFocusable(true);
                editContent.setFocusable(true);
            }
        });

        Button edit = (Button) findViewById(R.id.edit);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit();
            }
        });
    }

    private void saveContent(String oldName) {
        /*根据id，更新数据库中的笔记名。
        更新笔记名和内容
        */
        String newName = editTitle.getText().toString();

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query("note", new String[]{"id"}, "name=?", new String[]
                {oldName}, null, null, null);
        cursor.moveToNext();
        int id = cursor.getInt(cursor.getColumnIndex("id"));
        String str_id = String.valueOf(id);
        String content = editContent.getText().toString();
        db.execSQL("update note set name=?,content=? where id=?",
                new String[]{newName, content, str_id});
        cursor.close();
    }

    private void load(String note_name) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query("note", new String[]{"content"}, "name=?", new String[]{note_name}
                , null, null, null);
        cursor.moveToNext();
        String content = cursor.getString(cursor.getColumnIndex("content"));
        cursor.close();
        editContent.setText(content);
    }

    private void edit() {
        editTitle.setFocusable(true);
        editContent.setFocusable(true);
    }
}
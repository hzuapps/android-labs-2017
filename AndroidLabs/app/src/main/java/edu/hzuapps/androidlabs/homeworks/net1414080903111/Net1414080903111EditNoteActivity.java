package edu.hzuapps.androidlabs.homeworks.net1414080903111;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class EditNoteActivity extends Activity {
    /*start EditNoteActivity need note's name and id*/
    private EditText editTitle;
    private EditText editContent;
    Intent intent;
    private NoteDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_note);

        dbHelper = new NoteDatabaseHelper(this, "noteList.db", null, 1);
        editTitle = (EditText) findViewById(R.id.edit_title);
        editContent = (EditText) findViewById(R.id.edit_content);

        intent = getIntent();
        final String oldName = intent.getStringExtra("note_name");
        editTitle.setText(oldName);
        putContent(oldName);

        final Button saveContent = (Button) findViewById(R.id.save_content);
        saveContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveContent(oldName);
                editContent.setFocusable(false);
                String newName = editTitle.getText().toString();
                intent.putExtra("note_name", newName);
                startActivity(intent);
            }
        });
    }

    private void saveContent(String oldName) {
        /*根据id，更新数据库中的笔记名。
        检查文件名是否有变
        如果有，删除原文件，创建新笔记文件
        如果没有，覆盖原文件。
         */
        String newName = editTitle.getText().toString();
        if (!newName.equals(oldName)) {
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            Cursor cursor = db.query("note", new String[]{"id"}, "name=?", new String[]
                    {oldName}, null, null, null);
            int id;
            if (cursor.moveToNext())
                do {
                    id = cursor.getInt(cursor.getColumnIndex(oldName));
                    String str_id = String.valueOf(id);
                    db.execSQL("update note" +
                            "set name = ? where id = ?", new String[]
                            {newName, str_id});

                    String path = "data/" + getPackageName() + "/files" + newName;
                    File noteFile = new File(Environment.getDataDirectory().getPath(), path);
                    if (noteFile.exists()) {
                        noteFile.delete();
                    }
                    newNoteFile(newName);
                } while (cursor.moveToNext());



        } else {
            newNoteFile(newName);
        }

    }

    private void newNoteFile(String newName) {
        BufferedWriter writer = null;
        try {
            FileOutputStream out = openFileOutput(newName, MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(out));
            String content = editContent.getText().toString();
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void putContent(String note_name) {
        FileInputStream in;
        BufferedReader reader = null;
        try {
            in = openFileInput(note_name);
            reader = new BufferedReader(new InputStreamReader(in));

            editTitle.setText(note_name);
            String lines = null;
            String line = null;
            while ((line = reader.readLine()) != null) {
                lines += line;
            }
            editContent.setText(lines);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null)
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}
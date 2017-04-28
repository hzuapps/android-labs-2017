package com.example.rem.androidlabs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ViewContentActivity extends Activity {
    private TextView content;
    private TextView title;
    private Button editNote;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_note);

        content = (TextView) findViewById(R.id.view_content);
        title = (TextView) findViewById(R.id.view_title);
        editNote = (Button) findViewById(R.id.edit_note);

        intent = getIntent();
        final long id = intent.getLongExtra("id", 0);
        showContent();

        editNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewContentActivity.this, EditNoteActivity.class);
                intent.putExtra("id", id);
                intent.putExtra("note_name",title.getText().toString());
                startActivity(intent);
            }
        });
    }

    private void showContent() {
        /*从intent中得到要打开的文件名。
        在本地文件夹中打开笔记文件
        显示文件名和内容到ViewContentActivity中。
         */

        String note_name = intent.getStringExtra("note_name");
        title.setText(note_name);
        BufferedReader reader = null;
        try {
            FileInputStream in = openFileInput(note_name);
            reader = new BufferedReader(new InputStreamReader(in));
            String content_str="";
            String line;
            while ((line=reader.readLine())!=null){
                content_str += line;
            }
            content.setText(content_str);
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

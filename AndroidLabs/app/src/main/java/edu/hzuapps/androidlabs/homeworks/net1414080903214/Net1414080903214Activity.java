package com.example.administrator.net1414080903214;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Net1414080903214Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903214);
    }

   public void customCamera(View view) {
        startActivity(new Intent(this, CustomCamera.class));
    }

    public void wordTranslation(View view) {startActivity(new Intent(this, wordTranslation.class));}
}
package com.example.administrator.net1414080903214;


import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


/**
 * Created by Administrator on 2017/4/30.
 */

public class Result extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultlayout);
        String path=getIntent().getStringExtra("picPath");
        ImageView imageView= (ImageView) findViewById(R.id.pic);
        try {
            FileInputStream fis=new FileInputStream(path);
            Bitmap bitmap=BitmapFactory.decodeStream(fis);
            Matrix matrix=new Matrix();
            matrix.setRotate(90);
            bitmap=Bitmap.createBitmap(bitmap,0,0,bitmap.getWidth(),bitmap.getHeight(),matrix,true);
            imageView.setImageBitmap(bitmap);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

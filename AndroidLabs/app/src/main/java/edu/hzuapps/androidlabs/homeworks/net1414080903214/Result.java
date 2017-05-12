package com.example.administrator.net1414080903214;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


/**
 * Created by Administrator on 2017/4/30.
 */

public class Result extends Activity {
    private static int REQ=1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultlayout1414080903214);
        String path = getIntent().getStringExtra("picPath");
        ImageView imageView = (ImageView) findViewById(R.id.pic);
        try {
            FileInputStream fis = new FileInputStream(path);
            Bitmap bitmap = BitmapFactory.decodeStream(fis);
            Matrix matrix = new Matrix();
            matrix.setRotate(90);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            imageView.setImageBitmap(bitmap);
               Uri uri = Uri.parse(MediaStore.Images.Media.insertImage(getContentResolver(), bitmap, null, null));
                startImageZoom(uri);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

        /*图像裁切*/
    private void startImageZoom(Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
         intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
        intent.putExtra("aspectX", "1");
        intent.putExtra("aspectY", "2");
        intent.putExtra("outputX", "150");
        intent.putExtra("outputY", "150");
        intent.putExtra("return-date", "true");
        startActivityForResult(intent, REQ);

   }

}

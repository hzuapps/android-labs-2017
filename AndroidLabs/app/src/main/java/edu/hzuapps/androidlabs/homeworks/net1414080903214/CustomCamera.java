package com.example.administrator.net1414080903214;

import android.app.Activity;
import android.content.Intent;
import android.graphics.ImageFormat;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.io.IOException;

/**
 * Created by Administrator on 2017/4/29.
 */

public class CustomCamera  extends Activity implements SurfaceHolder.Callback{
    private Camera mcamera;
    private SurfaceView mpreview;
    private SurfaceHolder mHolder;
    private Camera.PictureCallback mPictureCallback=new Camera.PictureCallback(){
        @Override
        public void onPictureTaken(byte[] data, Camera camera) {
            try {
                File tempFile=new File("/sdcard/temp.png");
                FileOutputStream fos=new FileOutputStream(tempFile);
                try {
                    fos.write(data);
                    fos.close();
                    Intent intent=new Intent(CustomCamera.this,Result.class);
                    intent.putExtra("picPath",tempFile.getAbsolutePath());
                    startActivity(intent);
                    CustomCamera.this.finish();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }
    };
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.previewlayout1414080903214);
        mpreview=(SurfaceView) findViewById(R.id.preview);
        mHolder=mpreview.getHolder();
        mHolder.addCallback(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mcamera==null){
            mcamera=getCamera();
            if(mHolder!=null){
                setStartPreview(mcamera,mHolder);
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        releaseCamera();
    }

    public void capture(View view){
        Camera.Parameters parameters=mcamera.getParameters();
        parameters.setPictureFormat(ImageFormat.JPEG);
        parameters.setPictureSize(800,400);
        parameters.setFocusMode(Camera.Parameters.FOCUS_MODE_AUTO);
        mcamera.autoFocus(new Camera.AutoFocusCallback() {
            @Override
            public void onAutoFocus(boolean success, Camera camera) {
                if (success){
                    mcamera.takePicture(null,null,mPictureCallback);


                }
            }
        });

    }
    /*获取Camera对象 */
    private Camera getCamera(){
        Camera camera;
        try {
            camera=Camera.open();
        } catch (Exception e) {
            camera=null;
            e.printStackTrace();
        }
        return (camera);
    }
    /*开始预览相机内容*/
    private void setStartPreview(Camera camera,SurfaceHolder holder){
        try {
            camera.setPreviewDisplay(holder);
            camera.setDisplayOrientation(90);
            camera.startPreview();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    /*释放相机资源*/
    private void releaseCamera(){
        if(mcamera!=null){
            mcamera.setPreviewCallback(null);
            mcamera.stopPreview();
            mcamera.release();
            mcamera=null;
        }

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        setStartPreview(mcamera,mHolder);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        mcamera.stopPreview();
        setStartPreview(mcamera,mHolder);
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        releaseCamera();
    }
}

package edu.hzuapps.androidlabs.homeworks.net1414080903135;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;


public class Net1414080903135Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903135);
    }
    //响应按下事件

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Toast.makeText(this,"按键按下！",Toast.LENGTH_SHORT).show();
        return super.onKeyDown(keyCode, event);


    }



    //响应按松开事件
    public boolean onkeyUp (int keyCode, KeyEvent event){
        Toast.makeText(this,"按键弹起！",Toast.LENGTH_SHORT).show();
        return super.onKeyUp(keyCode,event);
    }
    //响应触摸事件
    /*
    public boolean onTouchEvent (int keyCode, KeyEvent event){
        float x=event.getX();
        float y=event.getY();
        Toast.makeText(this, "点击坐标为（“+x+”:"+y+"）",Toast.LENGTH_SHORT).show();
        return super.onTouchEvent(event);
    }*/
}

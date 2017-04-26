package edu.hzuapps.androidlabs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Net1414080903127GameActivity extends AppCompatActivity {
    private Button Brock;
    private Button Bscissors;
    private Button Bpaper;
    private Button Bascertain;
    private int option;//玩家的选项。
    private int result;//表示结果，0表示平局，1表示玩家赢，2表示玩家输。
    private int time;//记录游戏进行的次数。
    private int grade;//游戏分数。

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903127_game);
        Brock=(Button)findViewById(R.id.rock);
        Bscissors=(Button)findViewById(R.id.scissors);
        Bpaper=(Button)findViewById(R.id.paper);
        Bascertain=(Button)findViewById(R.id.ascertain);
        Brock.setOnClickListener(gamelistener);
        Bscissors.setOnClickListener(gamelistener);
        Bpaper.setOnClickListener(gamelistener);
        Bascertain.setOnClickListener(gamelistener);
    }

    View.OnClickListener gamelistener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.rock:
                    option=0;
                    break;
                case R.id.scissors:
                    option=1;
                    break;
                case R.id.paper:
                    option=2;
                    break;
                case R.id.ascertain:
                    /*调用GetRandomNumber()函数和compare()函数，然后记录分数和游戏的次数，完成10局游戏时跳转下一界面。*/
                    break;
                default:
                    break;
            }
        }
    };
    public int GetRandomNumber(){
        int RNumber;
        /*Soption等于一个随机数%3，获得0，1，2中的一个；*/
        RNumber=1;
        return RNumber;

    }
    public int compare(int a,int b){
        /*比较系统和玩家的出拳结果*/
        switch(a){
            case 0:
                if(b==0){
                    result=0;
                    break;
                }
                else if(b==1){
                    result=1;
                    break;
                }
                else if(b==2){
                    result=2;
                    break;
                }
            case 1:
                if(b==0){
                    result=2;
                    break;
                }
                else if(b==1){
                    result=0;
                    break;
                }
                else if(b==2){
                    result=1;
                    break;
                }
            case 2:
                if(b==0){
                    result=1;
                    break;
                }
                else if(b==1){
                    result=2;
                    break;
                }else if(b==2){
                    result=0;
                    break;
                }
            default:
                break;
        }
        return result;
    }
}

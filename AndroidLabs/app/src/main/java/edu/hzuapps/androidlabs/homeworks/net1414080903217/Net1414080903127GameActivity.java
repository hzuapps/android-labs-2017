package edu.hzuapps.androidlabs;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class Net1414080903127GameActivity extends AppCompatActivity {
    private ImageButton Brock;
    private ImageButton Bscissors;
    private ImageButton Bpaper;
    private Button Bascertain;
    private TextView TGameTime;
    private TextView TGameGrade;
    private TextView TWinner;
    private Random random;
    private int option;//玩家的选项。
    private int SystemOption;
    private int result;//表示结果，0表示平局，1表示玩家赢，2表示玩家输。
    private int time=1;//记录游戏进行的次数。
    private int grade;//游戏分数。

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903127_game);
        Brock=(ImageButton)findViewById(R.id.rock);
        Bscissors=(ImageButton)findViewById(R.id.scissors);
        Bpaper=(ImageButton)findViewById(R.id.paper);
        Bascertain=(Button)findViewById(R.id.ascertain);
        TGameTime=(TextView)findViewById(R.id.GameTime);
        TGameGrade=(TextView)findViewById(R.id.GameGrade);
        TWinner=(TextView)findViewById(R.id.Winner);
        Brock.setOnClickListener(gamelistener);
        Bscissors.setOnClickListener(gamelistener);
        Bpaper.setOnClickListener(gamelistener);
        Bascertain.setOnClickListener(gamelistener);
        TGameTime.setOnClickListener(gamelistener);
        TGameGrade.setOnClickListener(gamelistener);
        TWinner.setOnClickListener(gamelistener);
    }

    View.OnClickListener gamelistener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.rock:
                    option=0;
                    TWinner.setText(" ");
                    break;
                case R.id.scissors:
                    option=1;
                    TWinner.setText(" ");
                    break;
                case R.id.paper:
                    option=2;
                    TWinner.setText(" ");
                    break;
                case R.id.ascertain:
                    /*调用GetRandomNumber()函数和compare()函数，然后记录分数和游戏的次数，完成10局游戏时跳转下一界面。*/
                    if(time<=10){
                        SystemOption=GetRandomNumber();
                        compare(option,SystemOption);
                        if(result==1){
                            grade+=1;
                            TGameTime.setText("已进行"+time+"局游戏");
                            TGameGrade.setText("得分："+grade);
                            time+=1;
                            TWinner.setText("玩家赢");
                        }
                        else if(result==2){
                            TGameTime.setText("已进行"+time+"局游戏");
                            time+=1;
                            TWinner.setText("玩家输");
                        }
                        else if(result==0){
                            TWinner.setText("平局");
                        }
                        if(time==11){
                            /*弹出提示框*/
                            new AlertDialog.Builder(Net1414080903127GameActivity.this).setTitle("游戏结束").setMessage("得分"+grade).setPositiveButton("确定",new DialogInterface.OnClickListener(){
                                @Override
                            public void onClick(DialogInterface dialog,int which){
                                    finish();
                                }
                            }).show();
                        }
                    }
                    else{
                        /*保存比分*/
                    }
                    break;
                default:
                    break;
            }
        }
    };
    public int GetRandomNumber(){
        int RNumber;
        random=new Random();
        RNumber=random.nextInt(3);
        return RNumber;

    }
    public void compare(int a,int b){
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
    }
    public void SaveGrade(){
        /*使用SharedPreferences保存比分*/
    }
}

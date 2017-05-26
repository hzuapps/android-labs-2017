package edu.hzuapps.androidlabs.homeworks.net1414080903127;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

import edu.hzuapps.androidlabs.R;

public class Net1414080903127GameActivity extends Activity {
    private ImageButton Irock;
    private ImageButton Iscissors;
    private ImageButton Ipaper;
    private ImageButton Iplayer;
    private ImageButton Isystem;
    private Button Bascertain;
    private TextView TGameTime;
    private TextView TGameGrade;
    private TextView TWinner;
    private Random random;
    private int option;//玩家的选项。
    private int SystemOption;
    private int result;//表示结果，0表示平局，1表示玩家赢，2表示玩家输。
    private int time = 1;//记录游戏进行的次数。
    private int grade;//游戏分数。

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903127_game);
        Irock = (ImageButton) findViewById(R.id.rock);
        Iscissors = (ImageButton) findViewById(R.id.scissors);
        Ipaper = (ImageButton) findViewById(R.id.paper);
        Iplayer=(ImageButton)findViewById(R.id.palyerO);
        Isystem=(ImageButton)findViewById(R.id.systemO);
        Bascertain = (Button) findViewById(R.id.ascertain);
        TGameTime = (TextView) findViewById(R.id.GameTime);
        TGameGrade = (TextView) findViewById(R.id.GameGrade);
        TWinner = (TextView) findViewById(R.id.Winner);
        Irock.setOnClickListener(gamelistener);
        Iscissors.setOnClickListener(gamelistener);
        Ipaper.setOnClickListener(gamelistener);
        Bascertain.setOnClickListener(gamelistener);
        TGameTime.setOnClickListener(gamelistener);
        TGameGrade.setOnClickListener(gamelistener);
        TWinner.setOnClickListener(gamelistener);
    }

    View.OnClickListener gamelistener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.rock:
                    option = 0;
                    Iplayer.setBackgroundResource(R.drawable.rock_net1414080903127);
                    Isystem.setBackgroundResource(R.drawable.white_net1414080903127);
                    TWinner.setText(" ");
                    break;
                case R.id.scissors:
                    option = 1;
                    Iplayer.setBackgroundResource(R.drawable.scissors_net1414080903127);
                    Isystem.setBackgroundResource(R.drawable.white_net1414080903127);
                    TWinner.setText(" ");
                    break;
                case R.id.paper:
                    option = 2;
                    Iplayer.setBackgroundResource(R.drawable.paper_net1414080903127);
                    Isystem.setBackgroundResource(R.drawable.white_net1414080903127);
                    TWinner.setText(" ");
                    break;
                case R.id.ascertain:
                    /*调用GetRandomNumber()函数和compare()函数，然后记录分数和游戏的次数，完成10局游戏时跳转下一界面。*/
                    if (time <= 10) {
                        SystemOption = GetRandomNumber();
                        if(SystemOption==0)
                            Isystem.setBackgroundResource(R.drawable.rock_net1414080903127);
                        else if(SystemOption==1)
                            Isystem.setBackgroundResource(R.drawable.scissors_net1414080903127);
                        else if(SystemOption==2)
                            Isystem.setBackgroundResource(R.drawable.paper_net1414080903127);
                        compare(option, SystemOption);
                        if (result == 1) {
                            grade += 1;
                            TGameTime.setText("已进行" + time + "局游戏");
                            TGameGrade.setText("得分：" + grade);
                            time += 1;
                            TWinner.setText("玩家赢");
                        } else if (result == 2) {
                            TGameTime.setText("已进行" + time + "局游戏");
                            time += 1;
                            TWinner.setText("玩家输");
                        } else if (result == 0) {
                            TWinner.setText("平局");
                        }
                        if (time == 11) {
                            /*弹出提示框*/
                            SaveGrade(grade);
                            new AlertDialog.Builder(Net1414080903127GameActivity.this).setTitle("游戏结束").setMessage("得分" + grade).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                            }).show();
                        }
                    }
                    break;
                default:
                    break;
            }
        }
    };

    public int GetRandomNumber() {
        /*获取一个随机数*/
        int RNumber;
        random = new Random();
        RNumber = random.nextInt(3);
        return RNumber;

    }

    public void compare(int a, int b) {
        /*比较系统和玩家的出拳结果*/
        switch (a) {
            case 0:
                if (b == 0) {
                    result = 0;
                    break;
                } else if (b == 1) {
                    result = 1;
                    break;
                } else if (b == 2) {
                    result = 2;
                    break;
                }
            case 1:
                if (b == 0) {
                    result = 2;
                    break;
                } else if (b == 1) {
                    result = 0;
                    break;
                } else if (b == 2) {
                    result = 1;
                    break;
                }
            case 2:
                if (b == 0) {
                    result = 1;
                    break;
                } else if (b == 1) {
                    result = 2;
                    break;
                } else if (b == 2) {
                    result = 0;
                    break;
                }
            default:
                break;
        }
    }

    public void SaveGrade(int G) {
        /*使用SharedPreferences保存比分*/
        int[] data={0,0,0};
        int t;
        SharedPreferences sp = getSharedPreferences("Data", Activity.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        if (!sp.contains("First")) {
            edit.putInt("First", G);
            edit.putInt("Second", 0);
            edit.putInt("Third", 0);

        }
        else if(!sp.contains("Second")){
            edit.putInt("Second", 0);
            edit.putInt("Third", 0);
            data[0]=sp.getInt("First",0);
            if(data[0]>=G)
                edit.putInt("Second",G);
            else{
                edit.putInt("First",G);
                edit.putInt("Second",data[0]);
            }
        }
        else if(!sp.contains("Three")){
            edit.putInt("Three",0);
            data[0]=sp.getInt("First",0);
            data[1]=sp.getInt("Second",0);
            if(data[1]>=G)
                edit.putInt("Three",G);
            else if(data[0]>=G){
                edit.putInt("Second",G);
                edit.putInt("Three",data[1]);
            }
            else{
                edit.putInt("First",G);
                edit.putInt("Second",data[0]);
                edit.putInt("Three",data[1]);
            }
        }
        else{
            data[0]=sp.getInt("First",0);
            data[1]=sp.getInt("Second",0);
            data[2]=sp.getInt("Three",0);
            t=G;
            for(int i=0;i<3;i++){
                if(data[i]<t){
                    t=data[i];
                    data[i]=G;
                    G=t;
                }
            }
            edit.putInt("First",data[0]);
            edit.putInt("Second",data[1]);
            edit.putInt("Three",data[2]);
        }
        edit.commit();
    }
}
package edu.hzuapps.androidlabs.homeworks.net1414080903128;

import android.support.v7.app.AppCompatActivity;
import edu.hzuapps.androidlabs.R;


import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Net1414080903128CompareActivity extends AppCompatActivity {

    String startMessage = null;
    int mysteryNumber ;           //系统随机产生的数字
    int currentGuess;
    int guessRemaining;          //游戏次数
    int guessMade;              //猜错的次数
    String guessStatus=null;
    Boolean gameWon=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903128_compare);

        startMessage = "请输入一个0~100的数字";
        mysteryNumber = (int)Math.ceil(Math.random()*100);
        guessRemaining = 10;            //初始化这游戏最多只能猜10次
        guessMade=0;
        guessStatus = "";
        gameWon = false;
        Button guessButton = (Button)findViewById(R.id.guess);
        final TextView outputStringText = (TextView) findViewById(R.id.outputString);

        outputStringText.setText(startMessage);
        guessButton.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                guessRemaining--;
                guessMade++;
                guessStatus ="目前已经猜错了 = " +guessMade+"次，"+"还能再继续猜 " + guessRemaining + "次。";
                EditText inputText = (EditText)findViewById(R.id.inputString);
                currentGuess = Integer.parseInt(inputText.getText().toString().trim());
                if(currentGuess > mysteryNumber){
                    guessStatus = "你输入的数字太大，" + guessStatus;
                    checkGameOver();
                }
                else if(currentGuess < mysteryNumber){
                    guessStatus = "你输入的数字太小，" + guessStatus;
                    checkGameOver();
                }
                else{
                    guessStatus = "恭喜你！你赢了！";
                    gameWon = true;
                    endGame();
                    boolean isSaveSuccess=Utils.saveData(Net1414080903128CompareActivity.this,mysteryNumber,guessMade);
                    if(isSaveSuccess)
                    {
                        Toast.makeText(Net1414080903128CompareActivity.this,"保存成功",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(Net1414080903128CompareActivity.this, "保存失败", Toast.LENGTH_SHORT).show();
                    }
                }
                outputStringText.setText(guessStatus);
            }
        });


    }

    public void endGame(){
        if(gameWon){
            guessStatus = "对了，这个神秘的数字就是" + currentGuess;
        }else{
            guessStatus = "你输了，这个神秘的数字是" +mysteryNumber;
        }
    }

    public void checkGameOver(){
        if(guessRemaining <1){
            endGame();
        }
    }





}

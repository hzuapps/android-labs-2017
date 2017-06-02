package edu.hzuapps.androidlabs.homework.net1414080903132;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import edu.hzuapps.androidlabs.R;


public class Net1414080903132SnakeView extends Net1414080903132mapView implements OnClickListener {

    private int mMode = READY;// 这个是游戏的5中状态。
    public static final int PAUSE = 0;//暂停
    public static final int READY = 1;//准备
    public static final int RUNNING = 2;//运行
    public static final int LOSE = 3;//失败

    private TextView mStatusText;// 这个是开始的时候的提示语

    private Button mStart;//简单
    private Button mStart1;//普通
    private Button mStart2;//困难

    private static final int RED_STAR = 1;// 这7个标签分别来表示不同的点的drawable。比如RED_STAR代表的是蛇的身子的点
    private static final int YELLOW = 2;
    private static final int YELLOW_STAR = 3;
    private static final int HEAD_UP=4;
    private static final int HEAD_DOWN=5;
    private static final int HEAD_LEFT=6;
    private static final int HEAD_RIGHT=7;

    private Button mLeft;//这四个按钮控制蛇运行的方向
    private Button mRight;
    private Button mTop;
    private Button mBottom;

    private int mDirection = NORTH; // 蛇的四种方向和下一步前进的方向
    private int mNextDirection = NORTH;
    private static final int NORTH = 1;
    private static final int SOUTH = 2;
    private static final int EAST = 3;
    private static final int WEST = 4;

    private long mScore; // 成绩，吃了多少的苹果
    private String lishi;//历史成绩
    private double mModeAdd;//蛇前进速度增量
    private long mMoveDelay;// 间隔多少毫秒进行移动一次

    public Net1414080903132SnakeView(Context context, AttributeSet att) {
        super(context, att);
    }
    public Net1414080903132SnakeView(Context context, AttributeSet att, int def) {
        super(context, att, def);
    }

    public void setTextView(TextView newView) {
        mStatusText = newView;
    }


    public void setStartButton(Button button) {
        mStart = button;
        mStart.setOnClickListener(this);
    }
    public void setStartButton1(Button button) {
        mStart1 = button;
        mStart1.setOnClickListener(this);
    }
    public void setStartButton2(Button button) {
        mStart2 = button;
        mStart2.setOnClickListener(this);
    }
    //获得当前游戏的状态
    public void setMode(int newMode) {
        int oldMode = mMode;
        mMode = newMode;

        if (newMode == RUNNING & oldMode != RUNNING) {
            mStatusText.setVisibility(View.INVISIBLE);
            return;
        }

        Resources res = getContext().getResources();
        CharSequence str = "";

        if (newMode == PAUSE) {
            str = res.getText(R.string.mode_pause);
        }
        //如果状态为READY，将成绩储存的游戏成绩读出
        if (newMode == READY) {
            try{
                FileInputStream inputdata1=null;
                BufferedReader reader=null;
                String data1="";
                inputdata1=this.getContext().openFileInput("chji");
                reader=new BufferedReader(new InputStreamReader(inputdata1));
                lishi=reader.readLine();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            str = res.getText(R.string.mode_ready)+"\n成绩："+lishi;
        }
        //如果状态为LOSE，将历史成绩读出与当前成绩比较，如果比历史成绩大就将成绩储存起来
        if (newMode == LOSE) {
            try{
                FileInputStream inputdata1=null;
                BufferedReader reader=null;
                inputdata1=this.getContext().openFileInput("chji");
                reader=new BufferedReader(new InputStreamReader(inputdata1));
                lishi=reader.readLine();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if(lishi==null||Long.parseLong(lishi)<mScore){
                FileOutputStream outputdata1;
                BufferedWriter write1=null;
                String data=String.valueOf(mScore);
                try {
                    outputdata1=this.getContext().openFileOutput("chji", Context.MODE_PRIVATE);
                    write1=new BufferedWriter(new OutputStreamWriter(outputdata1));
                    write1.write(data);
                }catch (IOException e){
                    e.printStackTrace();
                }  finally {
                    try{
                        if(write1!=null){
                            write1.close();
                        }
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }
            str = res.getString(R.string.mode_lose_prefix) + mScore + res.getString(R.string.mode_lose_suffix);
        }

        mStatusText.setText(str);
        mStatusText.setVisibility(View.VISIBLE);
        mStart.setVisibility(View.VISIBLE);

        mStart1.setVisibility(View.VISIBLE);
        mStart2.setVisibility(View.VISIBLE);

        mLeft.setVisibility(View.INVISIBLE);
        mRight.setVisibility(View.INVISIBLE);
        mTop.setVisibility(View.INVISIBLE);
        mBottom.setVisibility(View.INVISIBLE);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start:

                mModeAdd=1;
                mMoveDelay=200;
                if (mMode == READY | mMode == LOSE) {

                    setMode(RUNNING);

                    mStart.setVisibility(View.GONE);
                    mStart1.setVisibility(View.GONE);
                    mStart2.setVisibility(View.GONE);
                    mLeft.setVisibility(View.VISIBLE);
                    mRight.setVisibility(View.VISIBLE);
                    mTop.setVisibility(View.VISIBLE);
                    mBottom.setVisibility(View.VISIBLE);
                }
                if (mMode == PAUSE) {
                    setMode(RUNNING);
                    mStart.setVisibility(View.GONE);
                    mStart1.setVisibility(View.GONE);
                    mStart2.setVisibility(View.GONE);
                    mLeft.setVisibility(View.VISIBLE);
                    mRight.setVisibility(View.VISIBLE);
                    mTop.setVisibility(View.VISIBLE);
                    mBottom.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.start1:
                mModeAdd=0.97;
                mMoveDelay=200;
                if (mMode == READY | mMode == LOSE) {

                    setMode(RUNNING);

                    mStart.setVisibility(View.GONE);
                    mStart1.setVisibility(View.GONE);
                    mStart2.setVisibility(View.GONE);
                    mLeft.setVisibility(View.VISIBLE);
                    mRight.setVisibility(View.VISIBLE);
                    mTop.setVisibility(View.VISIBLE);
                    mBottom.setVisibility(View.VISIBLE);
                }
                if (mMode == PAUSE) {
                    setMode(RUNNING);

                    mStart.setVisibility(View.GONE);
                    mStart1.setVisibility(View.GONE);
                    mStart2.setVisibility(View.GONE);
                    mLeft.setVisibility(View.VISIBLE);
                    mRight.setVisibility(View.VISIBLE);
                    mTop.setVisibility(View.VISIBLE);
                    mBottom.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.start2:
                mModeAdd=0.93;
                mMoveDelay=150;
                if (mMode == READY | mMode == LOSE) {

                    setMode(RUNNING);

                    mStart.setVisibility(View.GONE);
                    mStart1.setVisibility(View.GONE);
                    mStart2.setVisibility(View.GONE);
                    mLeft.setVisibility(View.VISIBLE);
                    mRight.setVisibility(View.VISIBLE);
                    mTop.setVisibility(View.VISIBLE);
                    mBottom.setVisibility(View.VISIBLE);
                }
                if (mMode == PAUSE) {
                    setMode(RUNNING);

                    mStart.setVisibility(View.GONE);
                    mStart1.setVisibility(View.GONE);
                    mStart2.setVisibility(View.GONE);
                    mLeft.setVisibility(View.VISIBLE);
                    mRight.setVisibility(View.VISIBLE);
                    mTop.setVisibility(View.VISIBLE);
                    mBottom.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.left:
                if (mDirection != EAST) {
                    mNextDirection = WEST;
                }
                break;
            case R.id.right:
                if (mDirection != WEST) {
                    mNextDirection = EAST;
                }
                break;
            case R.id.top:
                if (mDirection != SOUTH) {
                    mNextDirection = NORTH;
                }
                break;
            case R.id.bottom:
                if (mDirection != NORTH) {
                    mNextDirection = SOUTH;
                }
                break;
            default:
                break;

        }
    }
    public void setControlButton(Button left, Button right, Button top, Button bottom) {
        mLeft = left;
        mRight = right;
        mTop = top;
        mBottom = bottom;
        mLeft.setOnClickListener(this);
        mRight.setOnClickListener(this);
        mTop.setOnClickListener(this);
        mBottom.setOnClickListener(this);
    }
}

package edu.hzuapps.androidlabs.homework.net1414080903132;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class SnakeView extends mapView implements OnClickListener {

    private int mMode = READY;// 这个是游戏的5中状态。
    public static final int PAUSE = 0;//暂停
    public static final int READY = 1;//准备
    public static final int RUNNING = 2;//运行
    public static final int LOSE = 3;//失败

    private TextView mStatusText;// 这个是开始的时候的提示语

    private Button mStart;//简单
    private Button mStart1;//普通
    private Button mStart2;//困难

    private Button mLeft;//这四个按钮控制蛇运行的方向
    private Button mRight;
    private Button mTop;
    private Button mBottom;

    public SnakeView(Context context, AttributeSet att) {
        super(context, att);
    }
    public SnakeView(Context context, AttributeSet att, int def) {
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


    public void onClick(View v) {
        mStart.setVisibility(View.GONE);
        mStart1.setVisibility(View.GONE);
        mStart2.setVisibility(View.GONE);
    }
}

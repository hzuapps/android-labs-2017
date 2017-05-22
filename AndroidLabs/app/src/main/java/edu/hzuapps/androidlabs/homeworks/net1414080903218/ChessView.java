package edu.hzuapps.androidlabs.homeworks.net1414080903218;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.sql.Time;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Timer;
import java.util.TimerTask;

import static android.widget.Toast.*;

/**
 * Created by zzh on 2017/4/15.
 */
public class ChessView extends View {
    //控制器
    protected Net1414080903218BoardActivity controller;
    protected Paint myPaint;        //画笔
    protected int width;            //画布宽度
    protected int height;           //画布高度
    protected float boardSX;        //棋盘左上x
    protected float boardSY;        //棋盘左上y
    protected float boardEX;        //棋盘右下x
    protected float boardEY;        //棋盘右下y
    protected float grapX;          //棋盘x间隔
    protected float grapY;          //棋盘y间隔
    protected float chessRadeus;    //棋子半径
    //信息显示区
    protected float newSX;        //左上x
    protected float newSY;        //左上y
    protected float newEX;        //右下x
    protected float newEY;        //右下y
    protected float centerX;      //水平中心
    protected float textSize;     //字体大小
//    protected long startTime;       //开始时间
    protected Timer timer;          //计时器
    protected int msecond;
    protected int second;
    protected int minute;
    protected int mode;
    protected boolean isFristPut;

    public ChessView(Context context, AttributeSet attrs){
        super(context,attrs);
        if (context instanceof Net1414080903218BoardActivity)
        {
            controller = (Net1414080903218BoardActivity)context;
        }
        init();
        myPaint = new Paint();
    }
    private void init(){
        //mode = controller.mode;
        //mode = 2;
        textSize = 50;
        isFristPut = true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //初始化画布
        myPaint.setColor(Color.rgb(150, 200, 0));
        myPaint.setShadowLayer(2, 3, 3, Color.BLACK);
        Rect RectBoard = new Rect(0, 0, width, height);
        canvas.drawRect(RectBoard, myPaint);
        myPaint.setColor(Color.BLACK);
        //画信息
        RectF rectNew = new RectF(newSX,newSY,newEX,newEY);
        canvas.drawLine(rectNew.left,rectNew.top,rectNew.right,rectNew.top,myPaint);
        canvas.drawLine(rectNew.right,rectNew.top,rectNew.right,rectNew.bottom,myPaint);
        canvas.drawLine(rectNew.left,rectNew.top,rectNew.left,rectNew.bottom,myPaint);
        canvas.drawLine(rectNew.left,rectNew.bottom,rectNew.right,rectNew.bottom,myPaint);
        //画棋盘
        char c = 'A';
        for (int i = 0; i < controller.board.getRow(); i++) {
            canvas.drawLine(boardSX + grapX * i, boardSY, boardSX + grapX * i, boardEY, myPaint);
            myPaint.setTextSize(20);
            myPaint.setTextAlign(Paint.Align.CENTER);
            myPaint.setShadowLayer(0,0,0,0);
            canvas.drawText(Character.toString((char) (c+i)),boardSX + grapX * i, boardSY - 8 - chessRadeus,myPaint);
        }
        for (int j = 0; j < controller.board.getCol(); j++) {
            canvas.drawLine(boardSX, boardSY + grapY * j, boardEX, boardSY + grapY * j, myPaint);
            myPaint.setTextSize(20);
            myPaint.setTextAlign(Paint.Align.RIGHT);
            canvas.drawText(String.valueOf(j+1),boardSX - 8 -chessRadeus, boardSY + 8 + grapY * j,myPaint);
        }
        //显示棋子
        int oldColor;
        for (int i = 0; i < controller.board.getRow(); i++) {
            for (int j = 0; j < controller.board.getCol(); j++) {
                if (controller.board.getDisplay()[i][j]) {
                    oldColor = myPaint.getColor();
                    if (controller.board.getFirst()[i][j]) {
                        myPaint.setColor(controller.board.getFirstColor());
                    } else {
                        myPaint.setColor(controller.board.getLaterColor());
                    }
                    canvas.drawCircle(boardSX + grapX * i, boardSY + grapY * j, chessRadeus, myPaint);
                    myPaint.setColor(oldColor);
                }
            }
        }
        String text = "玩家 vs 电脑";
        if(mode != 1){
            text = "玩家 vs 玩家";
        }
        myPaint.setTextSize(textSize);
        myPaint.setTextAlign(Paint.Align.CENTER);
        myPaint.setShadowLayer(5,3,3,Color.BLACK);
        canvas.drawText(text,centerX,newSY+textSize,myPaint);
        text = controller.firstPlayer.countPieces+"  :  "+controller.laterPlayer.countPieces;
        canvas.drawText(text,centerX,newSY+textSize*2,myPaint);
        text = String.format("%02d",minute)+" : "+String.format("%02d",second);
        canvas.drawText(text,centerX,newSY+textSize*3,myPaint);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        //graphics.add(new PointF(event.getX(),event.getY()));
        if(event.getAction() == MotionEvent.ACTION_UP) {
            try {
                float x = event.getX();
                float y = event.getY();
                if (x + grapX / 2 > boardSX && x - grapX / 2 < boardEX
                        && y + grapY / 2 > boardSY && y - grapY / 2 < boardEY) {
                    int row = (int) ((x - boardSX + grapY / 2) / grapX);
                    int col = (int) ((y - boardSY + grapX / 2) / grapY);
                    if(mode == 1) {
                        if (controller.firstPlayer.putPiece(row, col)) {
                            controller.laterPlayer.putPiece(0, 0);
                        }
                    }
                    else if(mode == 2){

                    }
                    else if(mode == 3 ){
                        if(isFristPut){
                            if (controller.firstPlayer.putPiece(row, col)) {
                                isFristPut = false;
                            }
                        }else{
                            if (controller.laterPlayer.putPiece(row, col)) {
                                isFristPut = true;
                            }
                        }
                    }
                    if(controller.board.isGameover()){
                        timer.cancel();
                        if(controller.board.isFirstWin()){
                            Toast.makeText(this.getContext(),"黑方胜利！", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(this.getContext(),"白方胜利！", Toast.LENGTH_SHORT).show();
                        }
                    }
                    //Toast.makeText(this.getContext(),controller.laterPlayer.readfLine(1), Toast.LENGTH_SHORT).show();
                }
            } catch (Exception e) {
            }
            //controller.laterPlayer.putPiece();
            //controller.laterPut();
            invalidate(); //重新绘制区域
        }
        return true;
    }
    public boolean start(int r,int c){
        //DisplayMetrics metric = new DisplayMetrics();
        DisplayMetrics metric = getResources().getDisplayMetrics();
        //getWindowManager().getDefaultDisplay().getMetrics(metric);
        width = metric.widthPixels-50;  // 屏幕宽度（像素）
        height = metric.heightPixels-220;  // 屏幕高度（像素）
        //float density = metric.density;  // 屏幕密度（0.75 / 1.0 / 1.5）
        //int densityDpi = metric.densityDpi;  // 屏幕密度DPI（120 / 160 / 240
        //countX=10;countY=15;
        grapX = width/(controller.board.getRow()+1);
        grapY = grapX;
        boardSX = grapX;
        boardEX = boardSX + grapX*(controller.board.getRow()-1);
        boardEY = height - grapY;
        boardSY = boardEY - grapY*(controller.board.getCol()-1);
        //设置信息区宽高
        newSX = boardSX;
        newSY = grapY;
        newEX = boardEX;
        newEY = boardSY - grapY;
        //计算水平中心
        centerX = (newEX+newSX)/2;
        //设置棋子半径
        chessRadeus=(grapX<grapY?grapX:grapY)/3;
        timer = new Timer();
        msecond = 0;
        second = 0;
        minute = 0;
        timer.schedule(timerTask,1000,1000);
        invalidate();
        return true;
    }
    TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            second++;
            if(second>=60){
                second = 0;
                minute++;
            }
            postInvalidate();
            getRootView().postInvalidate();
        }
    };
}

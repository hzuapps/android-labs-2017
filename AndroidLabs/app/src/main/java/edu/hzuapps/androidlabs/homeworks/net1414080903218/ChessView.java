package edu.hzuapps.androidlabs.homeworks.net1414080903218;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import static android.widget.Toast.*;

/**
 * Created by zzh on 2017/4/15.
 */
public class ChessView extends View {
    //protected Canvas myCanvas;
    protected Paint myPaint;
    protected int width;
    protected int height;
    protected float boardSX;
    protected float boardSY;
    protected float boardEX;
    protected float boardEY;
    protected float grapX;
    protected float grapY;
    protected float chessRadeus;
    protected Net1414080903218BoardActivity controller;
    private int n;
/*    Paint paint;
    private ArrayList<PointF> graphics = new ArrayList<PointF>();
    PointF point;*/
    public ChessView(Context context, AttributeSet attrs){
        super(context,attrs);
        if (context instanceof Net1414080903218BoardActivity)
        {
            controller = (Net1414080903218BoardActivity)context;
        }
/*        paint = new Paint(); //设置一个笔刷大小是3的黄色的画笔
        paint.setColor(Color.YELLOW);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(30);*/
    }

    @Override
    protected void onDraw(Canvas canvas){
        //for (PointF point : graphics) {
        //    canvas.drawPoint(point.x, point.y, paint);
        //}
        //Toast.makeText(getContext(),Integer.valueOf(width)+","+Integer.valueOf(height),Toast.LENGTH_SHORT).show();
       //super.onDraw(canvas);
        myPaint=new Paint();
        myPaint.setColor(Color.rgb(150,200,0));
        myPaint.setShadowLayer(2,3,3,Color.BLACK);
        Rect RectBoard=new Rect(0,0,width,height);
        canvas.drawRect(RectBoard,myPaint);
        myPaint.setColor(Color.BLACK);
        for(int i=0;i<controller.board.getRow();i++){
            canvas.drawLine(boardSX+grapX*i,boardSY,boardSX+grapX*i,boardEY,myPaint);
        }
        for(int j=0;j<controller.board.getCol();j++){
            canvas.drawLine(boardSX,boardSY+grapY*j,boardEX,boardSY+grapY*j,myPaint);
        }
        int oldColor;
        for(int i=0;i<controller.board.getRow();i++){
            for(int j=0;j<controller.board.getCol();j++){
                if(controller.board.getDisplay()[i][j]){
                    oldColor = myPaint.getColor();
                    if(controller.board.getFirst()[i][j]) {
                        myPaint.setColor(controller.board.getFirstColor());
                    }
                    else{
                        myPaint.setColor(controller.board.getLaterColor());
                    }
                    canvas.drawCircle(boardSX+grapX*i,boardSY+grapY*j,chessRadeus,myPaint);
                    myPaint.setColor(oldColor);
                }
            }
        }
//        myCanvas=canvas;
        //drawChess(1,1,Color.BLACK);
/*        this.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
               try {
                    float x = event.getX();
                    float y = event.getY();
                    if (x + grapX / 2 > boardSX && x - grapX / 2 < boardEX
                            && y + grapY / 2 > boardSY && y - grapY / 2 < boardEY) {
                        int row = (int) ((x - boardSX + grapY / 2) / grapX);
                        int col = (int) ((y - boardSY + grapX / 2) / grapY);
                        Toast.makeText(getContext(), String.valueOf(row) + "  " + String.valueOf(col), Toast.LENGTH_SHORT).show();
                        drawChess(row, col, Color.BLACK);
                    }
               }catch (Exception e){

               }
                //return true;
               return false;
            }
        });*/
 /*       try {
            float x = event.getX();
            float y = event.getY();
            //ChessBoard chessBoard=(ChessBoard) findViewById(R.id.ChessBosrd);
            if (x + grapX / 2 > boardSX && x - grapX / 2 < boardEX
                    && y + grapY / 2 > boardSY && y - grapY / 2 < boardEY) {
                int row = (int) ((x - boardSX + grapY / 2) / grapX);
                int col = (int) ((y - boardSY + grapX / 2) / grapY);
                Toast.makeText(getContext(), String.valueOf(row) + "  " + String.valueOf(col), Toast.LENGTH_SHORT).show();
                drawChess(row, col, Color.BLACK);
            }
         }catch (Exception e){

            }
            return true;*/
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
                    n++;
                    if(controller.firstPlayer.putPiece(row, col)) {
                        controller.laterPlayer.putPiece();
                    }
                    if(controller.board.isGameover()){
                        if(controller.board.isFirstWin()){
                            Toast.makeText(this.getContext(),"黑方胜利！", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(this.getContext(),"白方胜利！", Toast.LENGTH_SHORT).show();
                        }

                    }
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
        //boardSX=20;boardSY=260;
        //boardEX=420;boardEY=660;
        //grapX=(boardEX-boardSX)/countX;
        //grapY=(boardEY-boardSY)/countY;
        chessRadeus=(grapX<grapY?grapX:grapY)/3;
        //controller.laterPut();
        //activity.board.
        invalidate();
        return true;
    }
}

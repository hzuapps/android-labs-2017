package edu.hzuapps.androidlabs.homeworks.net1414080903218;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by zzh on 2017/4/15.
 */
public class ChessBoard extends View {
    protected float boardSX;
    protected float boardSY;
    protected float boardEX;
    protected float boardEY;
    protected float grapX;
    protected float grapY;
    protected int countX;
    protected int countY;
    public ChessBoard(Context context, AttributeSet attrs){
        super(context,attrs);
        boardSX=20;boardSY=260;
        boardEX=420;boardEY=660;
        countX=10;countY=10;
        grapX=(boardEX-boardSX)/countX;
        grapY=(boardEY-boardSY)/countY;
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        Paint paint=new Paint();
        paint.setColor(Color.rgb(150,200,0));
        paint.setShadowLayer(2,3,3,Color.BLACK);
        Rect RectBoard=new Rect(0,0,448,687);
        canvas.drawRect(RectBoard,paint);
        paint.setColor(Color.BLACK);
         for(int i=0;i<=countX;i++){
            canvas.drawLine(boardSX+grapX*i,boardSY,boardSX+grapX*i,boardEY,paint);
        }
        for(int j=0;j<=countY;j++){
            canvas.drawLine(boardSX,boardSY+grapY*j,boardEX,boardSY+grapY*j,paint);
        }
    }
}

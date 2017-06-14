/**
 * Created by Administrator on 2017/6/10.
 */


import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import edu.hzuapps.androidlabs.homeworks.net1414080903235.Net1414080903235Activity;


public class Net1414080903235_NewView extends View{
    // 单元格的宽度和高度
    private float width;
    private float height;

    private int checkPoint = 1; // 当前关卡

    //private Number number = new Number();
    private Net1414080903235_Number net1414080903235_number = new Net1414080903235_Number() {
        @Override
        public int intValue() {
            return 0;
        }

        @Override
        public long longValue() {
            return 0;
        }

        @Override
        public float floatValue() {
            return 0;
        }

        @Override
        public double doubleValue() {
            return 0;
        }
    };


    public Net1414080903235_NewView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Net1414080903235_NewView(Net1414080903235Activity mainActivity) {
        super(mainActivity);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        this.width = w / 9f;
        this.height = h / 10f;
        super.onSizeChanged(w, h, oldw, oldh);
    }

    // 当Android系统需要绘制一个View对象时，就会调用该对象的onDraw
    @Override
    protected void onDraw(Canvas canvas) {
        // 画背景
        Paint backgroundPaint = new Paint();
        backgroundPaint.setColor(getResources().getColor(R.color.colorBackground));
        canvas.drawRect(0,0,getWidth(),getHeight(),backgroundPaint);

        Paint darkPaint = new Paint();
        darkPaint.setColor(getResources().getColor(R.color.colorDark));

        Paint hilitePaint = new Paint();
        hilitePaint.setColor(getResources().getColor(R.color.colorHilite));

        Paint lightPaint = new Paint();
        lightPaint.setColor(getResources().getColor(R.color.colorlight));

        // 绘制9X9的网络格
        // 两条距离为1的直线，视觉上会有割裂的效果
        for (int i = 0; i < 9; i++) {
            canvas.drawLine(0, i*height, getWidth(), i*height, lightPaint);
            canvas.drawLine(0, i*height+1, getWidth(), i*height+1, hilitePaint);
            canvas.drawLine(i*width, 0, i*width, getHeight(), lightPaint);
            canvas.drawLine(i*width+1, 0, i*width+1, getHeight(), hilitePaint);
        }

        // 绘制3X3的网络格
        for (int i = 0; i < 10; i++) {
            if (i % 3 != 0) {
                continue;
            }
            canvas.drawLine(0, i*height, getWidth(), i*height, darkPaint);
            canvas.drawLine(0, i*height+1, getWidth(), i*height+1, hilitePaint);
            canvas.drawLine(i*width, 0, i*width, getHeight(), darkPaint);
            //canvas.drawLine(i*width+1, 0, i*width+1, getHeight(), hilitePaint);
            canvas.drawLine(i*width, 1, i*width, getHeight(), hilitePaint);
        }
        /*这里是刚开始画的，固定了格子大小
        public class Draw {
    private float height=50;
    private float width=50;
    private float Height=450;
    private float Width=450;

    protected void OnDraw(Canvas canvas){
        Paint lightPaint= new Paint();
        lightPaint.setColor(getResources().getColor(R.color.lightPaint));
        Paint darkPaint=new Paint();
        darkPaint.setColor(getResources().getColor(R.color.darkPaint));
        for (int i = 0; i < 9; i++) {
           canvas.drawLine(i*width,0,i*width,Height,lightPaint);
            canvas.drawLine(0,i*height,Width,i*height,lightPaint);
        }
        for(int i=0;i<10;i++){
            if(i%3!=0){
                canvas.drawLine(i*width,0,i*width,Height,darkPaint);
                canvas.drawLine(0,i*height,Width,i*height,darkPaint);
            }
        }

    }

        * */

        // 绘制数字
        Paint numberPaint = new Paint();
        numberPaint.setColor(Color.BLACK);
        numberPaint.setStyle(Paint.Style.STROKE);
        numberPaint.setTextSize(height*0.75f);
        numberPaint.setTextAlign(Paint.Align.CENTER);
        numberPaint.setAntiAlias(true); // 抗锯齿

        /**
         * 数字居中位置
         * x轴居中比较容易计算
         * y轴居中的计算，依赖于FontMetrics，大家很容易百度到相关的知识
         */
        Paint.FontMetrics fm = numberPaint.getFontMetrics();
        float x = width / 2;
        float y = height / 2 - (fm.ascent + fm.descent) / 2;

//        canvas.drawText("1", 0 * width + x, 0 * height + y, numberPaint);
//        canvas.drawText("2", 1 * width + x, 1 * height + y, numberPaint);
//        canvas.drawText("3", 2 * width + x, 2 * height + y, numberPaint);
//        canvas.drawText("4", 3 * width + x, 3 * height + y, numberPaint);
//        canvas.drawText("5", 4 * width + x, 4 * height + y, numberPaint);

        /**
         * 根据Number类中的数组，绘制数字
         */
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                canvas.drawText(net1414080903235_number.getTileString(i,j), i*width+x, j*height+y, numberPaint);
            }
        }

        /**
         * 绘制一个刷新文字
         */
        canvas.drawText("刷新",4*width+x,9*height+y,numberPaint);

        /**
         * 绘制关卡文字
         */
        Paint strPaint = new Paint();
        strPaint.setTextSize(height*0.5f);
        strPaint.setAntiAlias(true); // 抗锯齿
        canvas.drawText("第" + checkPoint + "关",6*width+x,9*height+y,strPaint);

        super.onDraw(canvas);
    }

    /**
     * 获取按下的数字
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        if (event.getAction() == MotionEvent.ACTION_DOWN){
            int selectedX = (int)(event.getX() / width);
            int selectedY = (int)(event.getY() / height);

            StringBuffer sb = new StringBuffer();

            if (selectedY < 9){
                int used[] = net1414080903235_number.getUsedTilesByCoor(selectedX,selectedY);
                for (int i = 0; i < used.length; i++) {
                    sb.append(used[i]);
                }
                LayoutInflater layoutInflater = LayoutInflater.from(this.getContext());
                View layoutView = layoutInflater.inflate(R.layout.dialog,null);
                TextView textView = (TextView) layoutView.findViewById(R.id.usedTextId);
                textView.setText("该位置不可用数字 = " + sb.toString());
                AlertDialog.Builder builder = new AlertDialog.Builder(this.getContext());
                builder.setView(layoutView);
                AlertDialog dialog = builder.create();
                dialog.show();
            }

            //Toast.makeText(getContext(), "ACTION_DOWN = " + used, Toast.LENGTH_SHORT).show();
            if (selectedY == 9){
                if (selectedX>=3 && selectedX<=5){
                    //Toast.makeText(getContext(), "ACTION_DOWN = 刷新",Toast.LENGTH_SHORT).show();
                    if (checkPoint == 1){
                        checkPoint = 2;
                    } else if (checkPoint == 2){
                        checkPoint = 1;
                    }
                    //Toast.makeText(getContext(), "checkPoint = " + checkPoint, Toast.LENGTH_SHORT).show();
                    net1414080903235_number = new Net1414080903235_Number() {
                        @Override
                        public int intValue() {
                            return 0;
                        }

                        @Override
                        public long longValue() {
                            return 0;
                        }

                        @Override
                        public float floatValue() {
                            return 0;
                        }

                        @Override
                        public double doubleValue() {
                            return 0;
                        }
                    };
                    invalidate(); // onDraw()
                }
            }

        }
        return true;
    }


}
package edu.hzuapps.androidlabs.homework.net1414080903132;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import edu.hzuapps.androidlabs.R;


public class Net1414080903132mapView extends View {
    protected static int pointSize;// 地图点的大小。其实就是点的宽和高，大小一样
    private final Paint mPaint = new Paint();//画笔，用来画蛇还有点

    protected static int mXpointCount;// 地图上x轴能够容纳的tile的数量。下面类似
    protected static int mYpointCount;

    private static int mXOffset;// 地图的起始X坐标
    private static int mYOffset;//地图的起始Y坐标

    private Bitmap[] mpointArray;//地图上每个点对应的图片数组，每个点对应一个bitmap，比如mTileArray[1]对应蛇身上的点
    private int[][] mpointGrid;//地图上每个点的数组，比如mpointGrid[0][0]=1的话就是该点事蛇身s

    public Net1414080903132mapView(Context context, AttributeSet att, int def){
        super(context,att,def);
        TypedArray a = context.obtainStyledAttributes(att, R.styleable.Net1414080903132mapView);

        pointSize = a.getInt(R.styleable.Net1414080903132mapView_pointSize, 48);

        a.recycle();
    }
    public Net1414080903132mapView(Context context, AttributeSet att) {
        super(context, att);

        TypedArray a = context.obtainStyledAttributes(att, R.styleable.Net1414080903132mapView);

        pointSize = a.getInt(R.styleable.Net1414080903132mapView_pointSize, 48);

        a.recycle();
    }
    public void resetTiles(int pointcount) {

        mpointArray = new Bitmap[pointcount];
    }
    @Override
    //用来获得屏幕的大小然后获得地图的起始X坐标等参数
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        mXpointCount = (int) Math.floor(w / pointSize);
        mYpointCount = (int) Math.floor(h / pointSize);

        mXOffset = ((w - (pointSize * mXpointCount)) / 2);
        mYOffset = ((h - (pointSize * mYpointCount)) / 2);

        mpointGrid = new int[mXpointCount][mYpointCount];
        clearpoint();
    }
    public void setPoint(int pointindex, int x, int y) {
        mpointGrid[x][y] = pointindex;
    }
    public void clearpoint() {
        for (int x = 0; x < mXpointCount; x++) {
            for (int y = 0; y < mYpointCount; y++) {
                setPoint(0, x, y);
            }
        }
    }
    public void loadTile(int key, Drawable tile) {
        Bitmap bitmap = Bitmap.createBitmap(pointSize, pointSize, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        tile.setBounds(0, 0, pointSize, pointSize);
        tile.draw(canvas);

        mpointArray[key] = bitmap;
    }
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int x = 0; x < mXpointCount; x += 1) {
            for (int y = 0; y < mYpointCount; y += 1) {
                if (mpointGrid[x][y] > 0) {
                    canvas.drawBitmap(mpointArray[mpointGrid[x][y]], mXOffset + x * pointSize, mYOffset + y * pointSize, mPaint);
                }
            }
        }
    }
}

package edu.hzuapps.androidlabs.homework.net1414080903132;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import edu.hzuapps.androidlabs.R;


public class mapView extends View {
    protected static int pointSize;// 地图点的大小。其实就是点的宽和高，大小一样
    private final Paint mPaint = new Paint();//画笔，用来画蛇还有点

    public mapView(Context context, AttributeSet att, int def){
        super(context,att,def);
        TypedArray a = context.obtainStyledAttributes(att, R.styleable.mapView);

        pointSize = a.getInt(R.styleable.mapView_pointSize, 48);

        a.recycle();
    }
    public mapView(Context context, AttributeSet att) {
        super(context, att);

        TypedArray a = context.obtainStyledAttributes(att, R.styleable.mapView);

        pointSize = a.getInt(R.styleable.mapView_pointSize, 48);

        a.recycle();
    }
}

package edu.hzuapps.androidlabs.homework.net1414080903132;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;

import edu.hzuapps.androidlabs.R;


public class mapView extends View {
    protected static int pointSize;

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

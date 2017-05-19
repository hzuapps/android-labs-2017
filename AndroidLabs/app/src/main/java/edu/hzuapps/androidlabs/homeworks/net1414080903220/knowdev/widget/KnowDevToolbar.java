package edu.hzuapps.androidlabs.homeworks.net1414080903220.knowdev.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.TintTypedArray;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import edu.hzuapps.androidlabs.homeworks.net1414080903220.knowdev.R;

/**
 * ProjectName: knowdev
 * PackName：edu.hzuapps.androidlabs.homeworks.net1414080903220.knowdev.widget
 * Class describe:自定义toolbar
 * Author: cheng
 * Create time: 2017/5/3 16:12
 * Variable:
 * change:
 * chang time:
 */
public class KnowDevToolbar extends Toolbar {
    private LayoutInflater inflater;
    private View view;
    private Button menuBt;
    private Button shareBt;
    private TextView title;
    public KnowDevToolbar(Context context) {
        //super(context);
        this(context,null);
    }

    public KnowDevToolbar(Context context, @Nullable AttributeSet attrs) {
        //super(context,attrs);
        this(context, attrs, 0);
    }

    public KnowDevToolbar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
       if(attrs!=null){

           final TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes(getContext(), attrs, R.styleable.KnowDevToolBar, defStyleAttr, 0);
           final Drawable menuIcon=tintTypedArray.getDrawable(R.styleable.KnowDevToolBar_toolbarMenuIcon);
           //String toolTile=tintTypedArray.getString(R.styleable.KnowDevToolBar_toolbarTile);
           final Drawable shareIcon=tintTypedArray.getDrawable(R.styleable.KnowDevToolBar_toolbarShareIcon);

           if(menuIcon!=null){
               setMenuIcon(menuIcon);
           }
          // if(toolTile!=null){
          ///     setTitle(toolTile);
          // }
           if(shareIcon!=null){
               setShareIcon(shareIcon);
           }
           tintTypedArray.recycle();
       }

    }


    private void initView() {
        if(view==null){
        inflater=LayoutInflater.from(getContext());
        view=inflater.inflate(R.layout.activity_net1414080903220_toolbar,null);
        menuBt= (Button) view.findViewById(R.id.toolbar_menu);
        title= (TextView) view.findViewById(R.id.toolbar_title);
        shareBt= (Button) view.findViewById(R.id.toolbar_share);

        LayoutParams lp = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER_HORIZONTAL);
        addView(view, lp);
        }
    }

    public void setMenuIcon(Drawable menuIcon) {
        if(menuBt!=null){
            menuBt.setBackground(menuIcon);
        }
    }
    @Override
    public void setTitle(int toolTile) {
        setTitle(getContext().getText(toolTile));

    }

    @Override
    public void setTitle(CharSequence tooltitle){
        initView();
        if(title!=null){
            title.setText(tooltitle);
            Log.i("title is",""+tooltitle);
        }

    }

    public void setShareIcon(Drawable menuIcon) {
        if (shareBt != null) {
            shareBt.setBackground(menuIcon);
        }
    }

    public void isHideShareBt(boolean flag){
        if(shareBt!=null){
            if(flag==true){
                shareBt.setVisibility(GONE);
            }else{
                shareBt.setVisibility(VISIBLE);
            }

        }
    }

    public  void setMenuButtonOnClickListener(OnClickListener listen){
        Log.i("toolbar","点击了菜单按钮");
        menuBt.setOnClickListener(listen);

    }

    public  void setShareButtonOnClickListener(OnClickListener listen){
        shareBt.setOnClickListener(listen);
        Log.i("toolbar","点击了分享按钮");
    }



}

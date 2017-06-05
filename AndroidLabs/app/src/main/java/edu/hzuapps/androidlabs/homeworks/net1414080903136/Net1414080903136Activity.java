package edu.hzuapps.androidlabs.homworks.net1414080903136;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import edu.hzuapps.androidlabs.R;
import edu.hzuapps.androidlabs.homworks.net1414080903136.db.ExpressDB;

public class Net1414080903136Activity extends FragmentActivity {
    public static String url;
    public static Button bt;
    public static EditText et1;
    public static EditText et2;
    private ViewPager mViewpager;
    private FragmentPagerAdapter mAdapter;
    private List<Fragment> mDatas;
    private TextView ExpressInquiryTV;
    private TextView MyExpressTV;
    private TextView SiteQueryTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//去掉信息栏
        setContentView(R.layout.activity_net1414080903136);
        initView();
    }
    private void initView() {
        bt= (Button) findViewById(R.id.bt);
        et1= (EditText) findViewById(R.id.et1);
        et2= (EditText) findViewById(R.id.et2);
        ExpressInquiryTV= (TextView) findViewById(R.id.ExpressInquiry);
        SiteQueryTV= (TextView) findViewById(R.id.SiteQuery);
        MyExpressTV= (TextView) findViewById(R.id.MyExpress);
        mViewpager= (ViewPager) findViewById(R.id.viewPager);
        mDatas=new ArrayList<Fragment>();
        Net1414080903136ExpressInquiry tab1=new Net1414080903136ExpressInquiry();
        Net1414080903136SiteQuery tab2=new Net1414080903136SiteQuery();
        Net1414080903136MyExpress tab3=new Net1414080903136MyExpress();
        mDatas.add(tab1);
        mDatas.add(tab2);
        mDatas.add(tab3);
        mAdapter=new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mDatas.get(position);
            }
            @Override
            public int getCount() {
                return mDatas.size();
            }
        };
        mViewpager.setAdapter(mAdapter);
        mViewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                resetTextView();
                switch (position)
                {
                    case 0:
                        ExpressInquiryTV.setTextColor(Color.parseColor("#008000"));
                        break;
                    case 1:
                        SiteQueryTV.setTextColor(Color.parseColor("#008000"));
                        break;
                    case 2:
                        MyExpressTV.setTextColor(Color.parseColor("#008000"));
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    private void resetTextView() {
        ExpressInquiryTV.setTextColor(Color.BLACK);
        SiteQueryTV.setTextColor(Color.BLACK);
        MyExpressTV.setTextColor(Color.BLACK);
    }
}

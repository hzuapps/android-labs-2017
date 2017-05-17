package edu.hzuapps.androidlabs.homeworks.net1414080903220.knowdev.activity;


import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;


import edu.hzuapps.androidlabs.homeworks.net1414080903220.knowdev.R;
import edu.hzuapps.androidlabs.homeworks.net1414080903220.knowdev.adapter.KnowFragmentPagerAdapter;
import edu.hzuapps.androidlabs.homeworks.net1414080903220.knowdev.fragment.DevFragment;
import edu.hzuapps.androidlabs.homeworks.net1414080903220.knowdev.fragment.NewsFragment;
import edu.hzuapps.androidlabs.homeworks.net1414080903220.knowdev.widget.KnowDevToolbar;

/**
 * ProjectName: knowdev
 * PackName：edu.hzuapps.androidlabs.homeworks.net1414080903220.knowdev.activity
 * Class describe:主活动类，主要用于管理Fragment
 * Author: cheng
 * Create time: 2017/5/3 12:43
 */


public class Net1414080903220MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    private RadioGroup tabRg;
    private RadioButton newsRb;
    private RadioButton devRb;
    private ViewPager viewPager;

    DrawerLayout drawerLayout;
    KnowDevToolbar knowDevToolbar;
    private KnowFragmentPagerAdapter knowFragmentPagerAdapter;
    private FragmentTransaction transaction;
    public static final int NEWS_PAGE = 0;
    public static final int DEV_PAGE = 1;
    private NewsFragment newsFragment;
    private DevFragment devFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_net1414080903220_main);
        knowFragmentPagerAdapter = new KnowFragmentPagerAdapter(this.getSupportFragmentManager());

        newsFragment = new NewsFragment();
        devFragment = new DevFragment();

        initView();

        tabRg.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_news:
                        viewPager.setCurrentItem(NEWS_PAGE);
                        break;
                    case R.id.rb_dev_article:
                        viewPager.setCurrentItem(DEV_PAGE);
                        break;
                }
            }
        });

    }

    private void initView() {
        tabRg = (RadioGroup) findViewById(R.id.rg_tab_bar);
        newsRb = (RadioButton) findViewById(R.id.rb_news);
        devRb = (RadioButton) findViewById(R.id.rb_dev_article);

        drawerLayout= (DrawerLayout)findViewById(R.id.dl_left);

        LayoutInflater inflater;
/*        LayoutInflater.from(R.layout.);
        knowDevToolbar= (KnowDevToolbar) findViewById(R.id.knowDevToolbar);*/

        viewPager = (ViewPager) findViewById(R.id.vpager);
        viewPager.setAdapter(knowFragmentPagerAdapter);
        viewPager.setCurrentItem(0);
        viewPager.addOnPageChangeListener(this);
        viewPager.setOffscreenPageLimit(0);
        newsRb.setChecked(true);
       // initDrawer();
    }

    private void initDrawer() {


        knowDevToolbar.setMenuButtonOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }



    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        Log.i("activity","the position is"+position);
    }

    /**
     * 处理滑动完毕后radiobutton的状态
     *
     * @param state
     */
    @Override
    public void onPageScrollStateChanged(int state) {
        if (state == 2) {
            switch (viewPager.getCurrentItem()) {
                case NEWS_PAGE:
                    newsRb.setChecked(true);
                    break;
                case DEV_PAGE:
                    devRb.setChecked(true);
                    break;
            }
        }
    }



}

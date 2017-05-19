package edu.hzuapps.androidlabs.homeworks.net1414080903220.knowdev.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import edu.hzuapps.androidlabs.homeworks.net1414080903220.knowdev.activity.Net1414080903220MainActivity;
import edu.hzuapps.androidlabs.homeworks.net1414080903220.knowdev.fragment.DevFragment;
import edu.hzuapps.androidlabs.homeworks.net1414080903220.knowdev.fragment.NewsFragment;

/**
 * ProjectName: knowdev
 * PackName：edu.hzuapps.androidlabs.homeworks.net1414080903220.knowdev.adapter
 * Class describe:ViewPager的适配器
 * Author: cheng
 * Create time: 2017/5/4 23:15
 */


public class KnowFragmentPagerAdapter extends android.support.v4.app.FragmentPagerAdapter{

    private NewsFragment newsFragment;
    private DevFragment devFragment;
    public static final int FragmentCount=2;
    public KnowFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        newsFragment=new NewsFragment();
        devFragment=new DevFragment();

    }

    /**
     * 通过position来选择切换的Fragment
     * @param position
     * @return
     */
    @Override
    public Fragment getItem(int position) {
        Fragment fragment=null;
        switch (position){
            case Net1414080903220MainActivity.NEWS_PAGE:
                fragment=newsFragment;
                break;
            case Net1414080903220MainActivity.DEV_PAGE:
                fragment=devFragment;
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return FragmentCount;
    }

    @Override
    public Object instantiateItem(ViewGroup vg, int position) {
        return super.instantiateItem(vg, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }
}

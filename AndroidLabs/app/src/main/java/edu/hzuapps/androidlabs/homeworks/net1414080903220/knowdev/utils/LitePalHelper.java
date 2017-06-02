package edu.hzuapps.androidlabs.homeworks.net1414080903220.knowdev.utils;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.util.List;

import edu.hzuapps.androidlabs.homeworks.net1414080903220.knowdev.bean.News;

/**
 * ProjectName: knowdev
 * PackName：edu.hzuapps.androidlabs.homeworks.net1414080903220.knowdev.utils
 * Class describe:
 * Author: cheng
 * Create time: 2017/6/1 21:24
 */
public class LitePalHelper<T> {

    public LitePalHelper(){
        LitePal.getDatabase();
    }


}

package edu.hzuapps.androidlabs.homeworks.net1414080903101;

import com.intelligent_chest.entity.User;

/**
 * Created by Czd on 2017/6/1.
 * function:sqlite 接口
 */

interface SQLOperate {
    void add(User user);
    User get(String name);

}

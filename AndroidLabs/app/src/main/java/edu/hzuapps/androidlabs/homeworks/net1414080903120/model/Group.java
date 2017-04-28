package edu.hzuapps.androidlabs.homeworks.net1414080903120.model;

import java.util.Set;

/**
 * Created by Lenovo on 2017/3/17 0017.
 * 聊天群
 */

public class Group {
    private String name;   //群名字
    private String id;    //群id
    private Set<User> users;   //用户
    private User adminUser;   //群管理员

    public Group() {
    }

    public Group(User adminUser, String id, String name, Set<User> users) {
        this.adminUser = adminUser;
        this.id = id;
        this.name = name;
        this.users = users;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", users=" + users +
                '}';
    }

}

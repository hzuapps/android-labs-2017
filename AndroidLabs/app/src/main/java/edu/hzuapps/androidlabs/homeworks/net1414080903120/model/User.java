package edu.hzuapps.androidlabs.homeworks.net1414080903120.model;

/**
 * Created by Lenovo on 2017/3/17 0017.
 */

public class User {
    private String name;   //用户名字
    private String id;     //用户id
    private String headPic;   //用户头像
    private Type type;     //用户类型

    public User() {
    }

    public User(String headPic, String id, String name, Type type) {
        this.headPic = headPic;
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "User{" +
                "headPic='" + headPic + '\'' +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", type=" + type +
                '}';
    }

    public static enum Type {
        ORDINARY("普通用户", 1), ADMIN("管理员", 1);
        private String name;
        private int index;
        private Type(String name, int index) {
            this.name = name;
            this.index = index;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!name.equals(user.name)) return false;
        if (!id.equals(user.id)) return false;
        if (!headPic.equals(user.headPic)) return false;
        return type == user.type;

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + id.hashCode();
        result = 31 * result + headPic.hashCode();
        result = 31 * result + type.hashCode();
        return result;
    }
}

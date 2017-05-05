package edu.hzuapps.androidlabs.homeworks.net1412070501227;

/**
 * 一个user类 ，定义的变量均为用户信息
 */
public class User {
    private String username,password;
    private String phone,Email;
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getphone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return Email;
    }
    public void setEmail(String Email) {
        this.Email = Email;
    }
}

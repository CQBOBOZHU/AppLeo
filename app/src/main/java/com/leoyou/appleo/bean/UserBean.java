package com.leoyou.appleo.bean;

/**
 * Created by BoBoZhu on 2017/7/18.
 */

public class UserBean {
    String name;
    String sex;
    int id;

    public UserBean(String name, String sex, int id) {
        this.name = name;
        this.sex = sex;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

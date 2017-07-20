package com.leoyou.appleo;

/**
 * Created by BoBoZhu on 2017/7/20.
 */

public class UserBean {
    String name;
    String token;
    int id;
    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public UserBean(String name, String token, int id, int age) {
        this.name = name;
        this.token = token;
        this.id = id;
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "name='" + name + '\'' +
                ", token='" + token + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }
}

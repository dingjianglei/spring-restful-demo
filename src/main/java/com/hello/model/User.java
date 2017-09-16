package com.hello.model;

import java.io.Serializable;

/**
 * 用户实体类
 */
public class User implements Serializable{
    private String name;
    private String password;
    private int age;
    private String address;

    public String getName() {
        return name;
    }
    public User(){}
    public User(String name,int age,String address){
        this.name=name;
        this.age=age;
        this.address=address;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

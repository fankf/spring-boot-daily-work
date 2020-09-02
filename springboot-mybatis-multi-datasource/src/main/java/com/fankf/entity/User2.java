package com.fankf.entity;

import java.io.Serializable;

/**
 * (User2)实体类
 *
 * @author makejava
 * @since 2020-09-02 11:20:21
 */
public class User2 implements Serializable {
    private static final long serialVersionUID = 730428625292113917L;

    private Integer id;

    private String username;

    private Integer age;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
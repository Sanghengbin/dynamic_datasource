package com.sang.dynamic_datasource.model;

/**
 * @ClassName User
 * @Description:
 * @Author: Sang
 * @Date: 2022/05/30 21:53 星期一
 * @Version 1.0
 */
public class User {
    private Integer id;
    private String username;
    private Integer age;

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username='" + username + '\'' + ", age=" + age + '}';
    }

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

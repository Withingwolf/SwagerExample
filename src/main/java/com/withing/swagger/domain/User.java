package com.withing.swagger.domain;

/**
 * @author huangweixin1@jd.com
 * create 2018/12/6 13:55
 */
public class User {

    private Long userId;

    private String name;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

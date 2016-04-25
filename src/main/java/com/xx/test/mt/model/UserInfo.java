package com.xx.test.mt.model;

import java.util.Date;

public class UserInfo {
    private Integer id;

    private String username;

    private Integer grpid;

    private Integer isenable;

    private Date lastLogin;

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
        this.username = username == null ? null : username.trim();
    }

    public Integer getGrpid() {
        return grpid;
    }

    public void setGrpid(Integer grpid) {
        this.grpid = grpid;
    }

    public Integer getIsenable() {
        return isenable;
    }

    public void setIsenable(Integer isenable) {
        this.isenable = isenable;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }
}
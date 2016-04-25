package com.xx.test.mt.model;

import java.util.Date;

public class RoleInfo {
    private Integer id;

    private String rolecode;

    private String rolename;

    private String isenable;

    private String description;

    private Date insrttime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRolecode() {
        return rolecode;
    }

    public void setRolecode(String rolecode) {
        this.rolecode = rolecode == null ? null : rolecode.trim();
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

    public String getIsenable() {
        return isenable;
    }

    public void setIsenable(String isenable) {
        this.isenable = isenable == null ? null : isenable.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Date getInsrttime() {
        return insrttime;
    }

    public void setInsrttime(Date insrttime) {
        this.insrttime = insrttime;
    }
}
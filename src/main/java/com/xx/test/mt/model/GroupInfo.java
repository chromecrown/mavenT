package com.xx.test.mt.model;

import java.util.Date;

public class GroupInfo {
    private Integer id;

    private String grpname;

    private String isenable;

    private Date insrttime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGrpname() {
        return grpname;
    }

    public void setGrpname(String grpname) {
        this.grpname = grpname == null ? null : grpname.trim();
    }

    public String getIsenable() {
        return isenable;
    }

    public void setIsenable(String isenable) {
        this.isenable = isenable == null ? null : isenable.trim();
    }

    public Date getInsrttime() {
        return insrttime;
    }

    public void setInsrttime(Date insrttime) {
        this.insrttime = insrttime;
    }
}
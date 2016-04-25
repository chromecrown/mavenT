package com.xx.test.mt.model;

import java.util.Date;

public class GroupInfo {
    private Integer id;

    private String usergrpcode;

    private String usergrpname;

    private String isenable;

    private Date insrttime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsergrpcode() {
        return usergrpcode;
    }

    public void setUsergrpcode(String usergrpcode) {
        this.usergrpcode = usergrpcode == null ? null : usergrpcode.trim();
    }

    public String getUsergrpname() {
        return usergrpname;
    }

    public void setUsergrpname(String usergrpname) {
        this.usergrpname = usergrpname == null ? null : usergrpname.trim();
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
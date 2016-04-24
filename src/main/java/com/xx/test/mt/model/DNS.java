package com.xx.test.mt.model;

import java.util.Date;

public class DNS {
    private Integer id;

    private Date day;

    private String dnsName;

    private String ping;

    private Date insertTime;

    private String group;

    private String cnCom;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public String getDnsName() {
        return dnsName;
    }

    public void setDnsName(String dnsName) {
        this.dnsName = dnsName == null ? null : dnsName.trim();
    }

    public String getPing() {
        return ping;
    }

    public void setPing(String ping) {
        this.ping = ping == null ? null : ping.trim();
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group == null ? null : group.trim();
    }

    public String getCnCom() {
        return cnCom;
    }

    public void setCnCom(String cnCom) {
        this.cnCom = cnCom == null ? null : cnCom.trim();
    }
}
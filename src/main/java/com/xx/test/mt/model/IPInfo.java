package com.xx.test.mt.model;

import java.util.Date;

public class IPInfo {
    private Integer id;

    private String ip;

    private String linkmanemail;

    private String iptype;

    private String typename;

    private String modelname;

    private String idcroom;

    private String linkman;

    private Date insrtTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getLinkmanemail() {
        return linkmanemail;
    }

    public void setLinkmanemail(String linkmanemail) {
        this.linkmanemail = linkmanemail == null ? null : linkmanemail.trim();
    }

    public String getIptype() {
        return iptype;
    }

    public void setIptype(String iptype) {
        this.iptype = iptype == null ? null : iptype.trim();
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }

    public String getModelname() {
        return modelname;
    }

    public void setModelname(String modelname) {
        this.modelname = modelname == null ? null : modelname.trim();
    }

    public String getIdcroom() {
        return idcroom;
    }

    public void setIdcroom(String idcroom) {
        this.idcroom = idcroom == null ? null : idcroom.trim();
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman == null ? null : linkman.trim();
    }

    public Date getInsrtTime() {
        return insrtTime;
    }

    public void setInsrtTime(Date insrtTime) {
        this.insrtTime = insrtTime;
    }
}
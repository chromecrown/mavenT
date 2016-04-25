package com.xx.test.mt.model;

import java.util.Date;
import java.util.List;

public class UserInfo {
	
	private List<GroupInfo> groupList;
	
    public List<GroupInfo> getGroupList() {
		return groupList;
	}

	public void setGroupList(List<GroupInfo> groupList) {
		this.groupList = groupList;
	}

	private Integer id;

    private String username;

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
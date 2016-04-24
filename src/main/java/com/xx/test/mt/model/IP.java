package com.xx.test.mt.model;

import java.util.Date;

public class IP {
	private Integer id;

	private Date day;

	private String ip;

	private String inOut;

	private String src;

	private Date insertTime;

	private String grp;

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

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip == null ? null : ip.trim();
	}

	public String getInOut() {
		return inOut;
	}

	public void setInOut(String inOut) {
		this.inOut = inOut == null ? null : inOut.trim();
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src == null ? null : src.trim();
	}

	public Date getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}

	public String getGrp() {
		return grp;
	}

	public void setGrp(String grp) {
		this.grp = grp == null ? null : grp.trim();
	}
}
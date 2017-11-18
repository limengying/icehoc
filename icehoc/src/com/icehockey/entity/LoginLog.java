package com.icehockey.entity;

import java.util.Date;

public class LoginLog {
	private int id; // 记录编号
	private int userId; // 用户编号
	private String ipAddress; // 登录IP地址
	private Date loginTime; // 登录时间
	private Date loginOffTime; // 登出时间
	private String remark; // 备注
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	public Date getLoginOffTime() {
		return loginOffTime;
	}
	public void setLoginOffTime(Date loginOffTime) {
		this.loginOffTime = loginOffTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	public LoginLog() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public LoginLog(int id, int userId, String ipAddress, Date loginTime,
			Date loginOffTime, String remark) {
		super();
		this.id = id;
		this.userId = userId;
		this.ipAddress = ipAddress;
		this.loginTime = loginTime;
		this.loginOffTime = loginOffTime;
		this.remark = remark;
	}
	
	
	@Override
	public String toString() {
		return "LoginLog [id=" + id + ", userId=" + userId + ", ipAddress="
				+ ipAddress + ", loginTime=" + loginTime + ", loginOffTime="
				+ loginOffTime + ", remark=" + remark + "]";
	}
	



}

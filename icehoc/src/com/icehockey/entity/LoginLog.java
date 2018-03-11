package com.icehockey.entity;

public class LoginLog {
	private int id; // 记录编号
	private int userId; // 用户编号
	private String ipAddress; // 登录IP地址
	private boolean signed;//是否签到
	private String loginTime; // 登录时间
	private String loginOffTime; // 登出时间
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
	public boolean isSigned() {
		return signed;
	}
	public void setSigned(boolean signed) {
		this.signed = signed;
	}
	public String getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}
	public String getLoginOffTime() {
		return loginOffTime;
	}
	public void setLoginOffTime(String loginOffTime) {
		this.loginOffTime = loginOffTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public LoginLog(int id, int userId, String ipAddress, boolean signed, String loginTime, String loginOffTime,
			String remark) {
		super();
		this.id = id;
		this.userId = userId;
		this.ipAddress = ipAddress;
		this.signed = signed;
		this.loginTime = loginTime;
		this.loginOffTime = loginOffTime;
		this.remark = remark;
	}
	
	public LoginLog(int userId, String loginTime, String remark) {
		super();
		this.userId = userId;
		this.loginTime = loginTime;
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "LoginLog [id=" + id + ", userId=" + userId + ", ipAddress=" + ipAddress + ", signed=" + signed
				+ ", loginTime=" + loginTime + ", loginOffTime=" + loginOffTime + ", remark=" + remark + "]";
	}
	
}

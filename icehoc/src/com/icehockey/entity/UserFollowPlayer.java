package com.icehockey.entity;

import java.util.Date;

public class UserFollowPlayer {
	private int id; // 记录编号
	private int userId; // 用户编号
	private int playerId; // 运动员编号
	private Date followDate; // 关注时间
	private Date cancelDate; // 接触绑定时间
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
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	public Date getFollowDate() {
		return followDate;
	}
	public void setFollowDate(Date followDate) {
		this.followDate = followDate;
	}
	public Date getCancelDate() {
		return cancelDate;
	}
	public void setCancelDate(Date cancelDate) {
		this.cancelDate = cancelDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	public UserFollowPlayer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public UserFollowPlayer(int id, int userId, int playerId, Date followDate,
			Date cancelDate, String remark) {
		super();
		this.id = id;
		this.userId = userId;
		this.playerId = playerId;
		this.followDate = followDate;
		this.cancelDate = cancelDate;
		this.remark = remark;
	}
	
	
	@Override
	public String toString() {
		return "UserFollowPlayer [id=" + id + ", userId=" + userId
				+ ", playerId=" + playerId + ", followDate=" + followDate
				+ ", cancelDate=" + cancelDate + ", remark=" + remark + "]";
	}
	



}

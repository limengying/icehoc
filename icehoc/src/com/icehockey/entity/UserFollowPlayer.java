package com.icehockey.entity;

public class UserFollowPlayer {
	private int id; // 记录编号
	private int userId; // 用户编号
	private int playerId; // 运动员编号
	private String followDate; // 关注时间
	private String cancelDate; // 接触绑定时间
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
	public String getFollowDate() {
		return followDate;
	}
	public void setFollowDate(String followDate) {
		this.followDate = followDate;
	}
	public String getCancelDate() {
		return cancelDate;
	}
	public void setCancelDate(String cancelDate) {
		this.cancelDate = cancelDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "UserFollowPlayer [id=" + id + ", userId=" + userId + ", playerId=" + playerId + ", followDate="
				+ followDate + ", cancelDate=" + cancelDate + ", remark=" + remark + "]";
	}
	public UserFollowPlayer(int id, int userId, int playerId, String followDate, String cancelDate, String remark) {
		super();
		this.id = id;
		this.userId = userId;
		this.playerId = playerId;
		this.followDate = followDate;
		this.cancelDate = cancelDate;
		this.remark = remark;
	}
	
}

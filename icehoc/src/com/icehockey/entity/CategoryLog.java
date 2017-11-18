package com.icehockey.entity;

import java.util.Date;

public class CategoryLog {
	private int id; // 日志编号
	private int roleId; // 角色编号
	private int coachId; // 教练员编号
	private int judgerId;// 裁判员编号
	private int playerId; // 运动员编号
	private int categoryId; // 类别编号
	private Date changeDate; // 修改时间
	private boolean isUsing; // 是否有效
	private String remark; // 备注
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public int getCoachId() {
		return coachId;
	}
	public void setCoachId(int coachId) {
		this.coachId = coachId;
	}
	public int getJudgerId() {
		return judgerId;
	}
	public void setJudgerId(int judgerId) {
		this.judgerId = judgerId;
	}
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public Date getChangeDate() {
		return changeDate;
	}
	public void setChangeDate(Date changeDate) {
		this.changeDate = changeDate;
	}
	public boolean isUsing() {
		return isUsing;
	}
	public void setUsing(boolean isUsing) {
		this.isUsing = isUsing;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public CategoryLog() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CategoryLog(int id, int roleId, int coachId, int judgerId,
			int playerId, int categoryId, Date changeDate, boolean isUsing,
			String remark) {
		super();
		this.id = id;
		this.roleId = roleId;
		this.coachId = coachId;
		this.judgerId = judgerId;
		this.playerId = playerId;
		this.categoryId = categoryId;
		this.changeDate = changeDate;
		this.isUsing = isUsing;
		this.remark = remark;
	}
	
	@Override
	public String toString() {
		return "CategoryLog [id=" + id + ", roleId=" + roleId + ", coachId="
				+ coachId + ", judgerId=" + judgerId + ", playerId=" + playerId
				+ ", categoryId=" + categoryId + ", changeDate=" + changeDate
				+ ", isUsing=" + isUsing + ", remark=" + remark + "]";
	}
	
	
	

}

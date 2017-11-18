package com.icehockey.entity;

import java.util.Date;

public class HonorRecord {
	private int id; // 记录编号
	private int honorId; // 荣誉编号
	private int roleId; // 角色编号
	private int playerId; // 运动员编号
	private int coachId; // 教练员编号
	private int judgerId; // 裁判员编号
	private Date awardDate; // 颁发时间
	private String remark; // 备注
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getHonorId() {
		return honorId;
	}
	public void setHonorId(int honorId) {
		this.honorId = honorId;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
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
	public Date getAwardDate() {
		return awardDate;
	}
	public void setAwardDate(Date awardDate) {
		this.awardDate = awardDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	public HonorRecord() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public HonorRecord(int id, int honorId, int roleId, int playerId,
			int coachId, int judgerId, Date awardDate, String remark) {
		super();
		this.id = id;
		this.honorId = honorId;
		this.roleId = roleId;
		this.playerId = playerId;
		this.coachId = coachId;
		this.judgerId = judgerId;
		this.awardDate = awardDate;
		this.remark = remark;
	}
	
	
	@Override
	public String toString() {
		return "HonorRecord [id=" + id + ", honorId=" + honorId + ", roleId="
				+ roleId + ", playerId=" + playerId + ", coachId=" + coachId
				+ ", judgerId=" + judgerId + ", remark=" + remark + "]";
	}
	


}

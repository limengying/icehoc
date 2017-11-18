package com.icehockey.entity;

import java.util.Date;

public class PlayerClub {
	private int id; // 编号
	private int playerId; // 运动员编号
	private int coachId; // 教练员编号
	private Date inDate; // 加入时间
	private Date outDate; // 离开时间
	private String remark; // 备注
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public Date getInDate() {
		return inDate;
	}
	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}
	public Date getOutDate() {
		return outDate;
	}
	public void setOutDate(Date outDate) {
		this.outDate = outDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	public PlayerClub() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public PlayerClub(int id, int playerId, int coachId, Date inDate,
			Date outDate, String remark) {
		super();
		this.id = id;
		this.playerId = playerId;
		this.coachId = coachId;
		this.inDate = inDate;
		this.outDate = outDate;
		this.remark = remark;
	}
	
	
	@Override
	public String toString() {
		return "PlayerClub [id=" + id + ", playerId=" + playerId + ", coachId="
				+ coachId + ", inDate=" + inDate + ", outDate=" + outDate
				+ ", remark=" + remark + "]";
	}
	
	
	
}

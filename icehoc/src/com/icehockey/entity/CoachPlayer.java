package com.icehockey.entity;

import java.util.Date;

public class CoachPlayer {
	private int id; // 关系编号
	private int coachId; // 教练员编号
	private int playerId; // 运动员编号
	private Date inDate; // 开始时间
	private Date outDate; // 结束日期
	private double bestScore; // 最好成绩
	private String remark; // 备注
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCoachId() {
		return coachId;
	}
	public void setCoachId(int coachId) {
		this.coachId = coachId;
	}
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
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
	public double getBestScore() {
		return bestScore;
	}
	public void setBestScore(double bestScore) {
		this.bestScore = bestScore;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	public CoachPlayer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public CoachPlayer(int id, int coachId, int playerId, Date inDate,
			Date outDate, double bestScore, String remark) {
		super();
		this.id = id;
		this.coachId = coachId;
		this.playerId = playerId;
		this.inDate = inDate;
		this.outDate = outDate;
		this.bestScore = bestScore;
		this.remark = remark;
	}
	
	
	@Override
	public String toString() {
		return "CoachPlayer [id=" + id + ", coachId=" + coachId + ", playerId="
				+ playerId + ", bestScore=" + bestScore + ", remark=" + remark
				+ "]";
	}
	

}

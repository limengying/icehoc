package com.icehockey.entity;

import java.util.Date;

public class CoachResume {
	private int id; // 履历编号
	private int coachId; //教练员编号
	private int teamId; // 球队编号
	private Date inDate; // 执教开始时间
	private Date outDate; // 离开时间
	private double bestScore; // 执教最佳成绩
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
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
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
	
	
	public CoachResume() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public CoachResume(int id, int coachId, int teamId, Date inDate,
			Date outDate, double bestScore, String remark) {
		super();
		this.id = id;
		this.coachId = coachId;
		this.teamId = teamId;
		this.inDate = inDate;
		this.outDate = outDate;
		this.bestScore = bestScore;
		this.remark = remark;
	}
	
	
	@Override
	public String toString() {
		return "CoachResume [id=" + id + ", coachId=" + coachId + ", teamId="
				+ teamId + ", bestScore=" + bestScore + ", remark=" + remark
				+ "]";
	}
	

}

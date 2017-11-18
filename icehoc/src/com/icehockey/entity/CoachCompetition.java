package com.icehockey.entity;

import java.util.Date;

public class CoachCompetition {
	private int id; // 记录编号
	private int competitionId; // 赛事编号
	private int coachId; // 教练员编号
	private Date competitionTime; // 比赛时间
	private double score; // 成绩
	private String remark; // 备注
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCompetitionId() {
		return competitionId;
	}
	public void setCompetitionId(int competitionId) {
		this.competitionId = competitionId;
	}
	public int getCoachId() {
		return coachId;
	}
	public void setCoachId(int coachId) {
		this.coachId = coachId;
	}
	public Date getCompetitionTime() {
		return competitionTime;
	}
	public void setCompetitionTime(Date competitionTime) {
		this.competitionTime = competitionTime;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	public CoachCompetition() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public CoachCompetition(int id, int competitionId, int coachId,
			Date competitionTime, double score, String remark) {
		super();
		this.id = id;
		this.competitionId = competitionId;
		this.coachId = coachId;
		this.competitionTime = competitionTime;
		this.score = score;
		this.remark = remark;
	}
	
	
	@Override
	public String toString() {
		return "CoachCompetition [id=" + id + ", competitionId="
				+ competitionId + ", coachId=" + coachId + ", score=" + score
				+ ", remark=" + remark + "]";
	}
	

}

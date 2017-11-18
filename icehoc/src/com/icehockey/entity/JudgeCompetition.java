package com.icehockey.entity;

import java.util.Date;

public class JudgeCompetition {
	private int id; // 记录编号
	private int judgerId; // 裁判员编号
	private int competitionId; // 赛事编号
	private Date judgeDate; // 时间
	private String judgeRole; // 执法角色
	private String remark; // 备注
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getJudgerId() {
		return judgerId;
	}
	public void setJudgerId(int judgerId) {
		this.judgerId = judgerId;
	}
	public int getCompetitionId() {
		return competitionId;
	}
	public void setCompetitionId(int competitionId) {
		this.competitionId = competitionId;
	}
	public Date getJudgeDate() {
		return judgeDate;
	}
	public void setJudgeDate(Date judgeDate) {
		this.judgeDate = judgeDate;
	}
	public String getJudgeRole() {
		return judgeRole;
	}
	public void setJudgeRole(String judgeRole) {
		this.judgeRole = judgeRole;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	public JudgeCompetition() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public JudgeCompetition(int id, int judgerId, int competitionId,
			Date judgeDate, String judgeRole, String remark) {
		super();
		this.id = id;
		this.judgerId = judgerId;
		this.competitionId = competitionId;
		this.judgeDate = judgeDate;
		this.judgeRole = judgeRole;
		this.remark = remark;
	}
	
	
	@Override
	public String toString() {
		return "JudgeCompetition [id=" + id + ", judgerId=" + judgerId
				+ ", competitionId=" + competitionId + ", judgeRole="
				+ judgeRole + ", remark=" + remark + "]";
	}
	
	

}

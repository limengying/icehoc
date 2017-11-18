package com.icehockey.entity;

import java.util.Date;

public class CoachTeam {
	private int id; // 记录编号
	private int coachId; // 教练员编号
	private int flag; // 标志位
	private int clubId; // 俱乐部编号
	private int schoolTeamId; // 校队编号
	private Date inDate; // 加入时间
	private Date outDate; // 离开时间
	private String remark; //备注
	
	
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
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public int getClubId() {
		return clubId;
	}
	public void setClubId(int clubId) {
		this.clubId = clubId;
	}
	public int getSchoolTeamId() {
		return schoolTeamId;
	}
	public void setSchoolTeamId(int schoolTeamId) {
		this.schoolTeamId = schoolTeamId;
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
	
	
	public CoachTeam() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public CoachTeam(int id, int coachId, int flag, int clubId,
			int schoolTeamId, Date inDate, Date outDate, String remark) {
		super();
		this.id = id;
		this.coachId = coachId;
		this.flag = flag;
		this.clubId = clubId;
		this.schoolTeamId = schoolTeamId;
		this.inDate = inDate;
		this.outDate = outDate;
		this.remark = remark;
	}
	
	
	@Override
	public String toString() {
		return "CoachTeam [id=" + id + ", coachId=" + coachId + ", flag="
				+ flag + ", clubId=" + clubId + ", schoolTeamId="
				+ schoolTeamId + ", remark=" + remark + "]";
	}
	

}

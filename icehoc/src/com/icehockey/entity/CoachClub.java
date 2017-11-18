package com.icehockey.entity;

import java.util.Date;

public class CoachClub {
	private int id; // 履历编号
	private int coachId; // 教练员编号
	private int clubId; // 俱乐部编号
	private Date inDate; //执教开始时间
	private Date outDate; //离开时间
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
	public int getClubId() {
		return clubId;
	}
	public void setClubId(int clubId) {
		this.clubId = clubId;
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
	
	
	public CoachClub() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public CoachClub(int id, int coachId, int clubId, Date inDate,
			Date outDate, String remark) {
		super();
		this.id = id;
		this.coachId = coachId;
		this.clubId = clubId;
		this.inDate = inDate;
		this.outDate = outDate;
		this.remark = remark;
	}
	
	
	@Override
	public String toString() {
		return "CoachClub [id=" + id + ", coachId=" + coachId + ", clubId="
				+ clubId + ", inDate=" + inDate + ", outDate=" + outDate
				+ ", remark=" + remark + "]";
	}
	
	

}

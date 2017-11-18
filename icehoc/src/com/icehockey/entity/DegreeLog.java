package com.icehockey.entity;

import java.util.Date;

public class DegreeLog {
	private int id; // 记录编号
	private int degreeId; // 等级编号
	private int flag; // 标志位
	private int roleId; // 角色编号
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
	public int getDegreeId() {
		return degreeId;
	}
	public void setDegreeId(int degreeId) {
		this.degreeId = degreeId;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
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
	
	
	public DegreeLog() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public DegreeLog(int id, int degreeId, int flag, int roleId, int coachId,
			int judgerId, Date awardDate, String remark) {
		super();
		this.id = id;
		this.degreeId = degreeId;
		this.flag = flag;
		this.roleId = roleId;
		this.coachId = coachId;
		this.judgerId = judgerId;
		this.awardDate = awardDate;
		this.remark = remark;
	}
	
	
	@Override
	public String toString() {
		return "DegreeLog [id=" + id + ", degreeId=" + degreeId + ", flag="
				+ flag + ", roleId=" + roleId + ", coachId=" + coachId
				+ ", judgerId=" + judgerId + ", remark=" + remark + "]";
	}
	

}

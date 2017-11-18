package com.icehockey.entity;

import java.util.Date;

public class Team {
	private int teamId; // 球队编号
	private String teamName; // 球队名称
	private Date buildTime; // 组建时间
	private String linkman; // 负责人
	private String address; // 所在地
	private String remark; // 备注
	
	
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public Date getBuildTime() {
		return buildTime;
	}
	public void setBuildTime(Date buildTime) {
		this.buildTime = buildTime;
	}
	public String getLinkman() {
		return linkman;
	}
	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	public Team() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Team(int teamId, String teamName, Date buildTime, String linkman,
			String address, String remark) {
		super();
		this.teamId = teamId;
		this.teamName = teamName;
		this.buildTime = buildTime;
		this.linkman = linkman;
		this.address = address;
		this.remark = remark;
	}
	
	
	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", teamName=" + teamName
				+ ", buildTime=" + buildTime + ", linkman=" + linkman
				+ ", address=" + address + ", remark=" + remark + "]";
	}
	
}

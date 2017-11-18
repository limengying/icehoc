package com.icehockey.entity;

public class SchoolTeam {
	private int  teamId; // 校队编号
	private String teamName; // 校队名称
	private String teamLogo; // 校队LOGO
	private String teamAddress; // 校队地址
	private String buildTime; // 组建时间
	private String telephone; // 联系方式
	private String leaderName; // 领队
	private String leaderTelephone; // 领队联系方式
	private String construction; // 球队建设
	private String email; // 电子邮件
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
	public String getTeamLogo() {
		return teamLogo;
	}
	public void setTeamLogo(String teamLogo) {
		this.teamLogo = teamLogo;
	}
	public String getTeamAddress() {
		return teamAddress;
	}
	public void setTeamAddress(String teamAddress) {
		this.teamAddress = teamAddress;
	}
	public String getBuildTime() {
		return buildTime;
	}
	public void setBuildTime(String buildTime) {
		this.buildTime = buildTime;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getLeaderName() {
		return leaderName;
	}
	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}
	public String getLeaderTelephone() {
		return leaderTelephone;
	}
	public void setLeaderTelephone(String leaderTelephone) {
		this.leaderTelephone = leaderTelephone;
	}
	public String getConstruction() {
		return construction;
	}
	public void setConstruction(String construction) {
		this.construction = construction;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	public SchoolTeam() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public SchoolTeam(int teamId, String teamName, String teamLogo,
			String teamAddress, String buildTime, String telephone,
			String leaderName, String leaderTelephone, String construction,
			String email, String remark) {
		super();
		this.teamId = teamId;
		this.teamName = teamName;
		this.teamLogo = teamLogo;
		this.teamAddress = teamAddress;
		this.buildTime = buildTime;
		this.telephone = telephone;
		this.leaderName = leaderName;
		this.leaderTelephone = leaderTelephone;
		this.construction = construction;
		this.email = email;
		this.remark = remark;
	}
	
	
	@Override
	public String toString() {
		return "SchoolTeam [teamId=" + teamId + ", teamName=" + teamName
				+ ", teamLogo=" + teamLogo + ", teamAddress=" + teamAddress
				+ ", buildTime=" + buildTime + ", telephone=" + telephone
				+ ", leaderName=" + leaderName + ", leaderTelephone="
				+ leaderTelephone + ", construction=" + construction
				+ ", email=" + email + ", remark=" + remark + "]";
	}
	



}

package com.icehockey.entity;

public class DuiKang {
	private int id;
	private String competitionName;
	private int teamAId;
	private String clubAName;
	private String clubALogo;
	private int teamBId;
	private String clubBName;
	private String clubBLogo;
	private boolean competitionType;
	private String remark;
	private int rinkId;
	private String pkDate;//年月日星期几
	private String pkTime;//HH：MM
	private int competitionDegreeId;
	private int round;
	private String rinkName;
	private String environmentalIndex;
	private String address;
	private int userId;
	private String competitionDegreeName;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompetitionName() {
		return competitionName;
	}
	public void setCompetitionName(String competitionName) {
		this.competitionName = competitionName;
	}
	public int getTeamAId() {
		return teamAId;
	}
	public void setTeamAId(int teamAId) {
		this.teamAId = teamAId;
	}
	public String getClubAName() {
		return clubAName;
	}
	public void setClubAName(String clubAName) {
		this.clubAName = clubAName;
	}
	public String getClubALogo() {
		return clubALogo;
	}
	public void setClubALogo(String clubALogo) {
		this.clubALogo = clubALogo;
	}
	public int getTeamBId() {
		return teamBId;
	}
	public void setTeamBId(int teamBId) {
		this.teamBId = teamBId;
	}
	public String getClubBName() {
		return clubBName;
	}
	public void setClubBName(String clubBName) {
		this.clubBName = clubBName;
	}
	public String getClubBLogo() {
		return clubBLogo;
	}
	public void setClubBLogo(String clubBLogo) {
		this.clubBLogo = clubBLogo;
	}
	public boolean isCompetitionType() {
		return competitionType;
	}
	public void setCompetitionType(boolean competitionType) {
		this.competitionType = competitionType;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getRinkId() {
		return rinkId;
	}
	public void setRinkId(int rinkId) {
		this.rinkId = rinkId;
	}
	public String getPkDate() {
		return pkDate;
	}
	public void setPkDate(String pkDate) {
		this.pkDate = pkDate;
	}
	public String getPkTime() {
		return pkTime;
	}
	public void setPkTime(String pkTime) {
		this.pkTime = pkTime;
	}
	public int getCompetitionDegreeId() {
		return competitionDegreeId;
	}
	public void setCompetitionDegreeId(int competitionDegreeId) {
		this.competitionDegreeId = competitionDegreeId;
	}
	public int getRound() {
		return round;
	}
	public void setRound(int round) {
		this.round = round;
	}
	public String getRinkName() {
		return rinkName;
	}
	public void setRinkName(String rinkName) {
		this.rinkName = rinkName;
	}
	public String getEnvironmentalIndex() {
		return environmentalIndex;
	}
	public void setEnvironmentalIndex(String environmentalIndex) {
		this.environmentalIndex = environmentalIndex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getCompetitionDegreeName() {
		return competitionDegreeName;
	}
	public void setCompetitionDegreeName(String competitionDegreeName) {
		this.competitionDegreeName = competitionDegreeName;
	}
	
	public DuiKang(int id, String competitionName, int teamAId, String clubAName, String clubALogo, int teamBId,
			String clubBName, String clubBLogo, boolean competitionType, String remark, int rinkId, String pkDate,
			String pkTime, int competitionDegreeId, int round, String rinkName, String environmentalIndex,
			String address, int userId, String competitionDegreeName) {
		super();
		this.id = id;
		this.competitionName = competitionName;
		this.teamAId = teamAId;
		this.clubAName = clubAName;
		this.clubALogo = clubALogo;
		this.teamBId = teamBId;
		this.clubBName = clubBName;
		this.clubBLogo = clubBLogo;
		this.competitionType = competitionType;
		this.remark = remark;
		this.rinkId = rinkId;
		this.pkDate = pkDate;
		this.pkTime = pkTime;
		this.competitionDegreeId = competitionDegreeId;
		this.round = round;
		this.rinkName = rinkName;
		this.environmentalIndex = environmentalIndex;
		this.address = address;
		this.userId = userId;
		this.competitionDegreeName = competitionDegreeName;
	}
	public DuiKang() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "DuiKang [id=" + id + ", competitionName=" + competitionName + ", teamAId=" + teamAId + ", clubAName="
				+ clubAName + ", clubALogo=" + clubALogo + ", teamBId=" + teamBId + ", clubBName=" + clubBName
				+ ", clubBLogo=" + clubBLogo + ", competitionType=" + competitionType + ", remark=" + remark
				+ ", rinkId=" + rinkId + ", pkDate=" + pkDate + ", pkTime=" + pkTime + ", competitionDegreeId="
				+ competitionDegreeId + ", round=" + round + ", rinkName=" + rinkName + ", environmentalIndex="
				+ environmentalIndex + ", address=" + address + ", userId=" + userId + ", competitionDegreeName="
				+ competitionDegreeName + "]";
	}
	
	

}

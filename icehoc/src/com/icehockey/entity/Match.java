package com.icehockey.entity;

public class Match {
	private int competitionId;// 编号
	private String competitionName;// 赛事名称
	private int teamAId;// 主队编号
	private int teamBId;// 客队编号
	private int rinkId;// 场地编号
	private String competitionTime;// 比赛时间
	private int competitionDegreeId;// 比赛等级编号
	private int round;// 轮次
	private boolean competitionType;// 比赛类型
	private String remark;// 备注
	private String businessLicense;// 经营执照
	private String idCardCopyFile;// 法人身份证复印件
	private int checkId;// 是否审核
	
	private String teamAName;// 主队名称
	private String teamBName;// 客队名称
	private int clubAId;// 主队俱乐部
	private String clubAName;// 主队俱乐部名称
	private String clubALogo;// 主队俱乐部LOGO
	
	private int clubBId;// 客队俱乐部
	private String clubBName;// 客队俱乐部名称
	private String clubBLogo;// 客队俱乐部LOGO
	
	private String pkDate;// 比赛日期 年月日星期几
	private String pkTime;// 比赛时间 HH：MM
	private String competitionDegreeName;// 比赛等级名称
	private String rinkName;// 场地名称
	private int environmentalIndex;// 环境指数

	
	public int getCompetitionId() {
		return competitionId;
	}

	public void setCompetitionId(int competitionId) {
		this.competitionId = competitionId;
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

	public int getTeamBId() {
		return teamBId;
	}

	public void setTeamBId(int teamBId) {
		this.teamBId = teamBId;
	}

	public int getRinkId() {
		return rinkId;
	}

	public void setRinkId(int rinkId) {
		this.rinkId = rinkId;
	}

	public String getCompetitionTime() {
		return competitionTime;
	}

	public void setCompetitionTime(String competitionTime) {
		this.competitionTime = competitionTime;
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

	public String getBusinessLicense() {
		return businessLicense;
	}

	public void setBusinessLicense(String businessLicense) {
		this.businessLicense = businessLicense;
	}

	public String getIdCardCopyFile() {
		return idCardCopyFile;
	}

	public void setIdCardCopyFile(String idCardCopyFile) {
		this.idCardCopyFile = idCardCopyFile;
	}

	public int getCheckId() {
		return checkId;
	}

	public void setCheckId(int checkId) {
		this.checkId = checkId;
	}

	public String getTeamAName() {
		return teamAName;
	}

	public void setTeamAName(String teamAName) {
		this.teamAName = teamAName;
	}

	public String getTeamBName() {
		return teamBName;
	}

	public void setTeamBName(String teamBName) {
		this.teamBName = teamBName;
	}

	public int getClubAId() {
		return clubAId;
	}

	public void setClubAId(int clubAId) {
		this.clubAId = clubAId;
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

	public int getClubBId() {
		return clubBId;
	}

	public void setClubBId(int clubBId) {
		this.clubBId = clubBId;
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

	public String getCompetitionDegreeName() {
		return competitionDegreeName;
	}

	public void setCompetitionDegreeName(String competitionDegreeName) {
		this.competitionDegreeName = competitionDegreeName;
	}

	public String getRinkName() {
		return rinkName;
	}

	public void setRinkName(String rinkName) {
		this.rinkName = rinkName;
	}

	public int getEnvironmentalIndex() {
		return environmentalIndex;
	}

	public void setEnvironmentalIndex(int environmentalIndex) {
		this.environmentalIndex = environmentalIndex;
	}

	public Match(int competitionId, String competitionName, int teamAId, int teamBId, int rinkId, String competitionTime,
			int competitionDegreeId, int round, boolean competitionType, String remark, String businessLicense,
			String idCardCopyFile, int checkId, String teamAName, String teamBName, int clubAId, String clubAName,
			String clubALogo, int clubBId, String clubBName, String clubBLogo, String pkDate, String pkTime,
			String competitionDegreeName, String rinkName, int environmentalIndex) {
		super();
		this.competitionId = competitionId;
		this.competitionName = competitionName;
		this.teamAId = teamAId;
		this.teamBId = teamBId;
		this.rinkId = rinkId;
		this.competitionTime = competitionTime;
		this.competitionDegreeId = competitionDegreeId;
		this.round = round;
		this.competitionType = competitionType;
		this.remark = remark;
		this.businessLicense = businessLicense;
		this.idCardCopyFile = idCardCopyFile;
		this.checkId = checkId;
		this.teamAName = teamAName;
		this.teamBName = teamBName;
		this.clubAId = clubAId;
		this.clubAName = clubAName;
		this.clubALogo = clubALogo;
		this.clubBId = clubBId;
		this.clubBName = clubBName;
		this.clubBLogo = clubBLogo;
		this.pkDate = pkDate;
		this.pkTime = pkTime;
		this.competitionDegreeName = competitionDegreeName;
		this.rinkName = rinkName;
		this.environmentalIndex = environmentalIndex;
	}

	public Match() {
		super();
	}

	@Override
	public String toString() {
		return "Match [competitionId=" + competitionId + ", competitionName=" + competitionName + ", teamAId=" + teamAId + ", teamBId="
				+ teamBId + ", rinkId=" + rinkId + ", competitionTime=" + competitionTime + ", competitionDegreeId="
				+ competitionDegreeId + ", round=" + round + ", competitionType=" + competitionType + ", remark="
				+ remark + ", businessLicense=" + businessLicense + ", idCardCopyFile=" + idCardCopyFile + ", checkId="
				+ checkId + ", teamAName=" + teamAName + ", teamBName=" + teamBName + ", clubAId=" + clubAId
				+ ", clubAName=" + clubAName + ", clubALogo=" + clubALogo + ", clubBId=" + clubBId + ", clubBName="
				+ clubBName + ", clubBLogo=" + clubBLogo + ", pkDate=" + pkDate + ", pkTime=" + pkTime
				+ ", competitionDegreeName=" + competitionDegreeName + ", rinkName=" + rinkName
				+ ", environmentalIndex=" + environmentalIndex + "]";
	}

}

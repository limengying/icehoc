package com.icehockey.entity;

public class Statistic {
	private int id;//
	private int competitionId;// 赛事编号
	private int playerId;// 球员编号
	private String attackingPosi;// 冰球入射方位
	private String guardType;// 门将防守方式
	private String skatingType;// 门将移动方式
	private String attackingType;// 球员进攻方式
	private String ballArmFace;// 正杆反杆
	private String matchInTime;// 比赛阶段
	private String isGoal;// 是否进球
	private boolean isPalyer;
	private String zhugong;
	private String fangui;
	private String onDate;
	private String remark1;// 备注
	private String remark2;// 备注
	
	
	public boolean isPalyer() {
		return isPalyer;
	}
	public void setPalyer(boolean isPalyer) {
		this.isPalyer = isPalyer;
	}
	public String getZhugong() {
		return zhugong;
	}
	public void setZhugong(String zhugong) {
		this.zhugong = zhugong;
	}
	public String getFangui() {
		return fangui;
	}
	public void setFangui(String fangui) {
		this.fangui = fangui;
	}
	public String getOnDate() {
		return onDate;
	}
	public void setOnDate(String onDate) {
		this.onDate = onDate;
	}
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
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	public String getAttackingPosi() {
		return attackingPosi;
	}
	public void setAttackingPosi(String attackingPosi) {
		this.attackingPosi = attackingPosi;
	}
	public String getGuardType() {
		return guardType;
	}
	public void setGuardType(String guardType) {
		this.guardType = guardType;
	}
	public String getSkatingType() {
		return skatingType;
	}
	public void setSkatingType(String skatingType) {
		this.skatingType = skatingType;
	}
	public String getAttackingType() {
		return attackingType;
	}
	public void setAttackingType(String attackingType) {
		this.attackingType = attackingType;
	}
	public String getBallArmFace() {
		return ballArmFace;
	}
	public void setBallArmFace(String ballArmFace) {
		this.ballArmFace = ballArmFace;
	}
	public String getMatchInTime() {
		return matchInTime;
	}
	public void setMatchInTime(String matchInTime) {
		this.matchInTime = matchInTime;
	}
	public String getIsGoal() {
		return isGoal;
	}
	public void setIsGoal(String isGoal) {
		this.isGoal = isGoal;
	}
	public String getRemark1() {
		return remark1;
	}
	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}
	public String getRemark2() {
		return remark2;
	}
	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}
	
	public Statistic(int id, int competitionId, int playerId, String attackingPosi, String guardType,
			String skatingType, String attackingType, String ballArmFace, String matchInTime, String isGoal,
			boolean isPalyer, String zhugong, String fangui, String onDate, String remark1, String remark2) {
		super();
		this.id = id;
		this.competitionId = competitionId;
		this.playerId = playerId;
		this.attackingPosi = attackingPosi;
		this.guardType = guardType;
		this.skatingType = skatingType;
		this.attackingType = attackingType;
		this.ballArmFace = ballArmFace;
		this.matchInTime = matchInTime;
		this.isGoal = isGoal;
		this.isPalyer = isPalyer;
		this.zhugong = zhugong;
		this.fangui = fangui;
		this.onDate = onDate;
		this.remark1 = remark1;
		this.remark2 = remark2;
	}
	public Statistic() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Statistic [id=" + id + ", competitionId=" + competitionId + ", playerId=" + playerId
				+ ", attackingPosi=" + attackingPosi + ", guardType=" + guardType + ", skatingType=" + skatingType
				+ ", attackingType=" + attackingType + ", ballArmFace=" + ballArmFace + ", matchInTime=" + matchInTime
				+ ", isGoal=" + isGoal + ", isPalyer=" + isPalyer + ", zhugong=" + zhugong + ", fangui=" + fangui
				+ ", onDate=" + onDate + ", remark1=" + remark1 + ", remark2=" + remark2 + "]";
	}
	
	
	
}

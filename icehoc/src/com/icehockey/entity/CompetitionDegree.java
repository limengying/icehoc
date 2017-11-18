package com.icehockey.entity;

public class CompetitionDegree {
	private int competitionDegreeId; // 等级编号
	private String competitionDegreeName; // 等级编号
	private String remark; //备注
	
	
	public int getCompetitionDegreeId() {
		return competitionDegreeId;
	}
	public void setCompetitionDegreeId(int competitionDegreeId) {
		this.competitionDegreeId = competitionDegreeId;
	}
	public String getCompetitionDegreeName() {
		return competitionDegreeName;
	}
	public void setCompetitionDegreeName(String competitionDegreeName) {
		this.competitionDegreeName = competitionDegreeName;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	public CompetitionDegree() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public CompetitionDegree(int competitionDegreeId,
			String competitionDegreeName, String remark) {
		super();
		this.competitionDegreeId = competitionDegreeId;
		this.competitionDegreeName = competitionDegreeName;
		this.remark = remark;
	}
	
	
	@Override
	public String toString() {
		return "CompetitionDegree [competitionDegreeId=" + competitionDegreeId
				+ ", competitionDegreeName=" + competitionDegreeName
				+ ", remark=" + remark + "]";
	}
	

}

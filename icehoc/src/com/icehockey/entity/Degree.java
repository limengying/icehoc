package com.icehockey.entity;

public class Degree {
	private int degreeId; // 等级资质编号
	private String degreeName; // 等级资质名称
	private String organization; // 颁发单位
	private String remark; // 备注
	
	
	public int getDegreeId() {
		return degreeId;
	}
	public void setDegreeId(int degreeId) {
		this.degreeId = degreeId;
	}
	public String getDegreeName() {
		return degreeName;
	}
	public void setDegreeName(String degreeName) {
		this.degreeName = degreeName;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	public Degree() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Degree(int degreeId, String degreeName, String organization,
			String remark) {
		super();
		this.degreeId = degreeId;
		this.degreeName = degreeName;
		this.organization = organization;
		this.remark = remark;
	}
	
	
	@Override
	public String toString() {
		return "Degree [degreeId=" + degreeId + ", degreeName=" + degreeName
				+ ", organization=" + organization + ", remark=" + remark + "]";
	}
	

}

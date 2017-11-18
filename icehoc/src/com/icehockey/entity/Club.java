package com.icehockey.entity;

public class Club {
	private int clubId; // 俱乐部编号
	private String clubName; // 俱乐部名称
	private String clubLogo; //俱乐部LOGO
	private String organization; //俱乐部所属机构
	private String address; //官方地址
	private String buildTime; //成立时间
	private int countryId; //国籍编号
	private int cityId; //城市编号
	private String managerContent; //经营内容
	private String email; //电子邮件
	private String construction; //球队建设
	private String province; //省份
	private String remark; //备注
	
	
	public int getClubId() {
		return clubId;
	}
	public void setClubId(int clubId) {
		this.clubId = clubId;
	}
	public String getClubName() {
		return clubName;
	}
	public void setClubName(String clubName) {
		this.clubName = clubName;
	}
	public String getClubLogo() {
		return clubLogo;
	}
	public void setClubLogo(String clubLogo) {
		this.clubLogo = clubLogo;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBuildTime() {
		return buildTime;
	}
	public void setBuildTime(String buildTime) {
		this.buildTime = buildTime;
	}
	public int getCountryId() {
		return countryId;
	}
	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public String getManagerContent() {
		return managerContent;
	}
	public void setManagerContent(String managerContent) {
		this.managerContent = managerContent;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getConstruction() {
		return construction;
	}
	public void setConstruction(String construction) {
		this.construction = construction;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	public Club() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Club(int clubId, String clubName, String clubLogo,
			String organization, String address, String buildTime, int countryId,
			int cityId, String managerContent, String email,
			String construction, String province, String remark) {
		super();
		this.clubId = clubId;
		this.clubName = clubName;
		this.clubLogo = clubLogo;
		this.organization = organization;
		this.address = address;
		this.buildTime = buildTime;
		this.countryId = countryId;
		this.cityId = cityId;
		this.managerContent = managerContent;
		this.email = email;
		this.construction = construction;
		this.province = province;
		this.remark = remark;
	}
	
	
	@Override
	public String toString() {
		return "Club [clubId=" + clubId + ", clubName=" + clubName
				+ ", clubLogo=" + clubLogo + ", organization=" + organization
				+ ", address=" + address + ", buildTime=" + buildTime
				+ ", countryId=" + countryId + ", cityId=" + cityId
				+ ", managerContent=" + managerContent + ", email=" + email
				+ ", construction=" + construction + ", province=" + province
				+ ", remark=" + remark + "]";
	}
	
	
}

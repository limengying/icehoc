package com.icehockey.entity;

import java.util.Date;

public class Rink {
	private int rinkId; // 场地编号
	private String rinkName; // 场地名称
	private String rinkLogo; // 场地LOGO
	private int countryId; // 国籍编号
	private int cityId; // 籍贯编号
	private String telephone; // 场地电话
	private boolean indoor; // 室内or室外
	private boolean hasLocker; // 有无更衣室
	private boolean hasCarpark; // 有无停车场
	private String trainingDegree; // 冰场训练等级
	private int scale; // 规模
	private boolean hasLandTrainingRoom; // 有无陆地训练室
	private double area; // 占地面积
	private double iceArea; // 冰面面积
	private String completionDate; // 建成时间
	private String beginUseDate; // 投入使用时间
	private String openTime; // 开放时间
	private boolean allowedSlip; // 是否接受散滑
	private String email; // 电子邮件
	private String iceType; // 冰面类型
	private String address; // 地址
	private int environmentalIndex; // 环境指数
	private String changeDate; // 最后修改时间
	private String remark; // 备注

	public int getRinkId() {
		return rinkId;
	}

	public void setRinkId(int rinkId) {
		this.rinkId = rinkId;
	}

	public String getRinkName() {
		return rinkName;
	}

	public void setRinkName(String rinkName) {
		this.rinkName = rinkName;
	}

	public String getRinkLogo() {
		return rinkLogo;
	}

	public void setRinkLogo(String rinkLogo) {
		this.rinkLogo = rinkLogo;
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public boolean isIndoor() {
		return indoor;
	}

	public void setIndoor(boolean indoor) {
		this.indoor = indoor;
	}

	public boolean isHasLocker() {
		return hasLocker;
	}

	public void setHasLocker(boolean hasLocker) {
		this.hasLocker = hasLocker;
	}

	public boolean isHasCarpark() {
		return hasCarpark;
	}

	public void setHasCarpark(boolean hasCarpark) {
		this.hasCarpark = hasCarpark;
	}

	public String getTrainingDegree() {
		return trainingDegree;
	}

	public void setTrainingDegree(String trainingDegree) {
		this.trainingDegree = trainingDegree;
	}

	public int getScale() {
		return scale;
	}

	public void setScale(int scale) {
		this.scale = scale;
	}

	public boolean isHasLandTrainingRoom() {
		return hasLandTrainingRoom;
	}

	public void setHasLandTrainingRoom(boolean hasLandTrainingRoom) {
		this.hasLandTrainingRoom = hasLandTrainingRoom;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public double getIceArea() {
		return iceArea;
	}

	public void setIceArea(double iceArea) {
		this.iceArea = iceArea;
	}

	public String getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(String completionDate) {
		this.completionDate = completionDate;
	}

	public String getBeginUseDate() {
		return beginUseDate;
	}

	public void setBeginUseDate(String beginUseDate) {
		this.beginUseDate = beginUseDate;
	}

	public String getOpenTime() {
		return openTime;
	}

	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}

	public boolean isAllowedSlip() {
		return allowedSlip;
	}

	public void setAllowedSlip(boolean allowedSlip) {
		this.allowedSlip = allowedSlip;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIceType() {
		return iceType;
	}

	public void setIceType(String iceType) {
		this.iceType = iceType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getEnvironmentalIndex() {
		return environmentalIndex;
	}

	public void setEnvironmentalIndex(int environmentalIndex) {
		this.environmentalIndex = environmentalIndex;
	}

	public String getChangeDate() {
		return changeDate;
	}

	public void setChangeDate(String changeDate) {
		this.changeDate = changeDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Rink() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Rink(int rinkId, String rinkName, String rinkLogo, int countryId, int cityId, String telephone,
			boolean indoor, boolean hasLocker, boolean hasCarpark, String trainingDegree, int scale,
			boolean hasLandTrainingRoom, double area, double iceArea, String completionDate, String beginUseDate,
			String openTime, boolean allowedSlip, String email, String iceType, String address, int environmentalIndex,
			String changeDate, String remark) {
		super();
		this.rinkId = rinkId;
		this.rinkName = rinkName;
		this.rinkLogo = rinkLogo;
		this.countryId = countryId;
		this.cityId = cityId;
		this.telephone = telephone;
		this.indoor = indoor;
		this.hasLocker = hasLocker;
		this.hasCarpark = hasCarpark;
		this.trainingDegree = trainingDegree;
		this.scale = scale;
		this.hasLandTrainingRoom = hasLandTrainingRoom;
		this.area = area;
		this.iceArea = iceArea;
		this.completionDate = completionDate;
		this.beginUseDate = beginUseDate;
		this.openTime = openTime;
		this.allowedSlip = allowedSlip;
		this.email = email;
		this.iceType = iceType;
		this.address = address;
		this.environmentalIndex = environmentalIndex;
		this.changeDate = changeDate;
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Rink [rinkId=" + rinkId + ", rinkName=" + rinkName + ", rinkLogo=" + rinkLogo + ", countryId="
				+ countryId + ", cityId=" + cityId + ", telephone=" + telephone + ", indoor=" + indoor + ", hasLocker="
				+ hasLocker + ", hasCarpark=" + hasCarpark + ", trainingDegree=" + trainingDegree + ", scale=" + scale
				+ ", hasLandTrainingRoom=" + hasLandTrainingRoom + ", area=" + area + ", iceArea=" + iceArea
				+ ", completionDate=" + completionDate + ", beginUseDate=" + beginUseDate + ", openTime=" + openTime
				+ ", allowedSlip=" + allowedSlip + ", email=" + email + ", iceType=" + iceType + ", address=" + address
				+ ", environmentalIndex=" + environmentalIndex + ", changeDate=" + changeDate + ", remark=" + remark
				+ "]";
	}

}

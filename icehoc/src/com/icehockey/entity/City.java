package com.icehockey.entity;

public class City {
	private int cityId; // 城市编号
	private String cityName; // 城市名称
	private int pId; // 城市编号
	private int cId; // 城市编号
	private int countryId; // 城市编号
	private String remark; // 备注

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public City(int cityId, String cityName, int pId, int cId, int countryId, String remark) {
		super();
		this.cityId = cityId;
		this.cityName = cityName;
		this.pId = pId;
		this.cId = cId;
		this.countryId = countryId;
		this.remark = remark;
	}

	public City() {
		super();
	}

	@Override
	public String toString() {
		return "City [cityId=" + cityId + ", cityName=" + cityName + ", pId=" + pId + ", cId=" + cId + ", countryId="
				+ countryId + ", remark=" + remark + "]";
	}

}

package com.icehockey.entity;

import java.util.Date;

public class Coach {
	private int coachId; // 教练员编号
	private String name; // 姓名
	private boolean sex; // 性别
	private Date birthday; // 出生日期
	private int countryId; // 国籍编号
	private int cityId; // 城市编号
	private double height; // 身高
	private double weight; // 体重
	private String idType; // 证件类型
	private int idInfoId; // 证件类型编号
	private Date teachBeginDate; // 执教开始时间
	private int categoryId; // 类别编号
	private String image; // 头像
	private int degreeId; // 等级资质编号
	private String remark; // 备注
	
	
	public int getCoachId() {
		return coachId;
	}
	public void setCoachId(int coachId) {
		this.coachId = coachId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
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
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getIdType() {
		return idType;
	}
	public void setIdType(String idType) {
		this.idType = idType;
	}
	public int getIdInfoId() {
		return idInfoId;
	}
	public void setIdInfoId(int idInfoId) {
		this.idInfoId = idInfoId;
	}
	public Date getTeachBeginDate() {
		return teachBeginDate;
	}
	public void setTeachBeginDate(Date teachBeginDate) {
		this.teachBeginDate = teachBeginDate;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getDegreeId() {
		return degreeId;
	}
	public void setDegreeId(int degreeId) {
		this.degreeId = degreeId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	public Coach() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Coach(int coachId, String name, boolean sex, Date birthday,
			int countryId, int cityId, double height, double weight,
			String idType, int idInfoId, Date teachBeginDate, int categoryId,
			String image, int degreeId, String remark) {
		super();
		this.coachId = coachId;
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
		this.countryId = countryId;
		this.cityId = cityId;
		this.height = height;
		this.weight = weight;
		this.idType = idType;
		this.idInfoId = idInfoId;
		this.teachBeginDate = teachBeginDate;
		this.categoryId = categoryId;
		this.image = image;
		this.degreeId = degreeId;
		this.remark = remark;
	}
	
	
	@Override
	public String toString() {
		return "Coach [coachId=" + coachId + ", name=" + name + ", sex=" + sex
				+ ", birthday=" + birthday + ", countryId=" + countryId
				+ ", cityId=" + cityId + ", height=" + height + ", weight="
				+ weight + ", idType=" + idType + ", idInfoId=" + idInfoId
				+ ", teachBeginDate=" + teachBeginDate + ", categoryId="
				+ categoryId + ", image=" + image + ", degreeId=" + degreeId
				+ ", remark=" + remark + "]";
	}
	
	
	

}

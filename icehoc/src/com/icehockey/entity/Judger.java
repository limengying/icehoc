package com.icehockey.entity;

import java.util.Date;

public class Judger {
	private int judgerId; // 裁判员编号
	private String name; // 姓名
	private boolean sex; // 性别
	private Date birthday; // 出生日期
	private double height; // 身高
	private double weight; // 体重
	private int countryId; // 国籍编号
	private int cityId; // 城市编号
	private Date judgeBeginDate; // 执法开始时间
	private String idType; // 证件类型
	private int idInfoId; // 证件信息编号
	private int categoryId; // 类别编号
	private int degreeId; // 当前资质编号
	private String image; // 头像
	private Date modificateDate; // 修改日期
	private String remark; // 备注
	
	
	public int getJudgerId() {
		return judgerId;
	}
	public void setJudgerId(int judgerId) {
		this.judgerId = judgerId;
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
	public Date getJudgeBeginDate() {
		return judgeBeginDate;
	}
	public void setJudgeBeginDate(Date judgeBeginDate) {
		this.judgeBeginDate = judgeBeginDate;
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
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getDegreeId() {
		return degreeId;
	}
	public void setDegreeId(int degreeId) {
		this.degreeId = degreeId;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Date getModificateDate() {
		return modificateDate;
	}
	public void setModificateDate(Date modificateDate) {
		this.modificateDate = modificateDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	public Judger() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Judger(int judgerId, String name, boolean sex, Date birthday,
			double height, double weight, int countryId, int cityId,
			Date judgeBeginDate, String idType, int idInfoId, int categoryId,
			int degreeId, String image, Date modificateDate, String remark) {
		super();
		this.judgerId = judgerId;
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
		this.height = height;
		this.weight = weight;
		this.countryId = countryId;
		this.cityId = cityId;
		this.judgeBeginDate = judgeBeginDate;
		this.idType = idType;
		this.idInfoId = idInfoId;
		this.categoryId = categoryId;
		this.degreeId = degreeId;
		this.image = image;
		this.modificateDate = modificateDate;
		this.remark = remark;
	}
	
	
	@Override
	public String toString() {
		return "Judger [judgerId=" + judgerId + ", name=" + name + ", sex="
				+ sex + ", birthday=" + birthday + ", height=" + height
				+ ", weight=" + weight + ", countryId=" + countryId
				+ ", cityId=" + cityId + ", judgeBeginDate=" + judgeBeginDate
				+ ", idType=" + idType + ", idInfoId=" + idInfoId
				+ ", categoryId=" + categoryId + ", degreeId=" + degreeId
				+ ", image=" + image + ", modificateDate=" + modificateDate
				+ ", remark=" + remark + "]";
	}
	
	
	

}

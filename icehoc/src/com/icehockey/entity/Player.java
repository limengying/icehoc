package com.icehockey.entity;

public class Player {
	private int playerId; // 运动员编号
	private String name; // 姓名
	private boolean sex; // 性别
	private String birthday; // 出生日期
	private double height; // 身高
	private double weight; // 体重
	private int countryId; // 国籍编号
	private int cityId; // 籍贯编号
	private double firstLearnAge; // 初学年龄
	private int roleId; // 角色编号
	private int handlingId; // 持杆方式编号
	private String idType; // 证件类型
	private String idInfoId; // 证件信息编号
	private int categoryId; // 类别编号
	private String position; // 位置
	private int creatMeld; // 谁创建我
	private String image; // 头像
	private String modificateDate; // 修改时间
	private String remark; // 备注

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
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

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {

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

	public double getFirstLearnAge() {
		return firstLearnAge;
	}

	public void setFirstLearnAge(double firstLearnAge) {
		this.firstLearnAge = firstLearnAge;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getHandlingId() {
		return handlingId;
	}

	public void setHandlingId(int handlingId) {
		this.handlingId = handlingId;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getIdInfoId() {
		return idInfoId;
	}

	public void setIdInfoId(String idInfoId) {
		this.idInfoId = idInfoId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getCreatMeld() {
		return creatMeld;
	}

	public void setCreatMeld(int creatMeld) {
		this.creatMeld = creatMeld;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getModificateDate() {

		return modificateDate;
	}

	public void setModificateDate(String modificateDate) {
		this.modificateDate = modificateDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Player(int playerId, String name, boolean sex, String birthday, double height, double weight, int countryId,
			int cityId, double firstLearnAge, int roleId, int handlingId, String idType, String idInfoId,
			int categoryId, String position, int creatMeld, String image, String modificateDate, String remark) {
		super();
		this.playerId = playerId;
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
		this.height = height;
		this.weight = weight;
		this.countryId = countryId;
		this.cityId = cityId;
		this.firstLearnAge = firstLearnAge;
		this.roleId = roleId;
		this.handlingId = handlingId;
		this.idType = idType;
		this.idInfoId = idInfoId;
		this.categoryId = categoryId;
		this.position = position;
		this.creatMeld = creatMeld;
		this.image = image;
		this.modificateDate = modificateDate;
		this.remark = remark;
	}

	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Player [playerId=" + playerId + ", name=" + name + ", sex=" + sex + ", birthday=" + birthday
				+ ", height=" + height + ", weight=" + weight + ", countryId=" + countryId + ", cityId=" + cityId
				+ ", firstLearnAge=" + firstLearnAge + ", roleId=" + roleId + ", handlingId=" + handlingId + ", idType="
				+ idType + ", idInfoId=" + idInfoId + ", categoryId=" + categoryId + ", position=" + position
				+ ", creatMeld=" + creatMeld + ", image=" + image + ", modificateDate=" + modificateDate + ", remark="
				+ remark + "]";
	}

}

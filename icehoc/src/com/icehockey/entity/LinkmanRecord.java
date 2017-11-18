package com.icehockey.entity;

public class LinkmanRecord {
	private int id; // 记录编号
	private String name; // 联系人姓名
	private String telephone; // 联系电话
	private int flag; // 标志位
	private int clubId; // 俱乐部编号
	private int rinkId; // 场地编号
	private int schoolTeamId; // 校队编号
	private String photo; // 照片
	private boolean isUsing; // 是否有效
	private String remark; // 备注
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public int getClubId() {
		return clubId;
	}
	public void setClubId(int clubId) {
		this.clubId = clubId;
	}
	public int getRinkId() {
		return rinkId;
	}
	public void setRinkId(int rinkId) {
		this.rinkId = rinkId;
	}
	public int getSchoolTeamId() {
		return schoolTeamId;
	}
	public void setSchoolTeamId(int schoolTeamId) {
		this.schoolTeamId = schoolTeamId;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public boolean isUsing() {
		return isUsing;
	}
	public void setUsing(boolean isUsing) {
		this.isUsing = isUsing;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	public LinkmanRecord() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public LinkmanRecord(int id, String name, String telephone, int flag,
			int clubId, int rinkId, int schoolTeamId, String photo,
			boolean isUsing, String remark) {
		super();
		this.id = id;
		this.name = name;
		this.telephone = telephone;
		this.flag = flag;
		this.clubId = clubId;
		this.rinkId = rinkId;
		this.schoolTeamId = schoolTeamId;
		this.photo = photo;
		this.isUsing = isUsing;
		this.remark = remark;
	}
	
	
	@Override
	public String toString() {
		return "LinkmanRecord [id=" + id + ", name=" + name + ", telephone="
				+ telephone + ", flag=" + flag + ", clubId=" + clubId
				+ ", rinkId=" + rinkId + ", schoolTeamId=" + schoolTeamId
				+ ", photo=" + photo + ", isUsing=" + isUsing + ", remark="
				+ remark + "]";
	}
	
	
	
	
	

}

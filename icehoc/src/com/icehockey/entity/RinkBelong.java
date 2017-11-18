package com.icehockey.entity;

import java.util.Date;

public class RinkBelong {
	private int id; // 记录编号
	private int rinkId; // 场地编号
	private int clubId; // 俱乐部编号
	private int type; // 归属类型
	private Date registerDate; // 登记时间
	private String remark; // 备注
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRinkId() {
		return rinkId;
	}
	public void setRinkId(int rinkId) {
		this.rinkId = rinkId;
	}
	public int getClubId() {
		return clubId;
	}
	public void setClubId(int clubId) {
		this.clubId = clubId;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	public RinkBelong() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public RinkBelong(int id, int rinkId, int clubId, int type,
			Date registerDate, String remark) {
		super();
		this.id = id;
		this.rinkId = rinkId;
		this.clubId = clubId;
		this.type = type;
		this.registerDate = registerDate;
		this.remark = remark;
	}
	
	
	@Override
	public String toString() {
		return "RinkBelong [id=" + id + ", rinkId=" + rinkId + ", clubId="
				+ clubId + ", type=" + type + ", registerDate=" + registerDate
				+ ", remark=" + remark + "]";
	}
	

}

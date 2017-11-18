package com.icehockey.entity;

public class Handling {
	private int handlingId; // 持杆方式编号
	private String handlingName; // 持杆方式名称
	private String handlingValue; // 简称
	private String remark; // 备注
	
	
	public int getHandlingId() {
		return handlingId;
	}
	public void setHandlingId(int handlingId) {
		this.handlingId = handlingId;
	}
	public String getHandlingName() {
		return handlingName;
	}
	public void setHandlingName(String handlingName) {
		this.handlingName = handlingName;
	}
	public String getHandlingValue() {
		return handlingValue;
	}
	public void setHandlingValue(String handlingValue) {
		this.handlingValue = handlingValue;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	public Handling() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Handling(int handlingId, String handlingName, String handlingValue,
			String remark) {
		super();
		this.handlingId = handlingId;
		this.handlingName = handlingName;
		this.handlingValue = handlingValue;
		this.remark = remark;
	}
	
	
	@Override
	public String toString() {
		return "Handling [handlingId=" + handlingId + ", handlingName="
				+ handlingName + ", handlingValue=" + handlingValue
				+ ", remark=" + remark + "]";
	}
	

}

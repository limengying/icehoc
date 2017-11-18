package com.icehockey.entity;

public class Honor {
	private int honorId; // 荣誉编号
	private int honorName; // 荣誉名称
	private int honorDegree; // 荣誉等级
	private String remark; // 备注
	
	
	public int getHonorId() {
		return honorId;
	}
	public void setHonorId(int honorId) {
		this.honorId = honorId;
	}
	public int getHonorName() {
		return honorName;
	}
	public void setHonorName(int honorName) {
		this.honorName = honorName;
	}
	public int getHonorDegree() {
		return honorDegree;
	}
	public void setHonorDegree(int honorDegree) {
		this.honorDegree = honorDegree;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	public Honor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Honor(int honorId, int honorName, int honorDegree, String remark) {
		super();
		this.honorId = honorId;
		this.honorName = honorName;
		this.honorDegree = honorDegree;
		this.remark = remark;
	}
	
	
	@Override
	public String toString() {
		return "Honor [honorId=" + honorId + ", honorName=" + honorName
				+ ", honorDegree=" + honorDegree + ", remark=" + remark + "]";
	}
	
	
	
}

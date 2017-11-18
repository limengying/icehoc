package com.icehockey.entity;

public class Province {
	private int provinceId; // 省份编号
	private String provinceName; // 省份名称
	private String remark; // 备注
	
	
	public int getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	public Province() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Province(int provinceId, String provinceName, String remark) {
		super();
		this.provinceId = provinceId;
		this.provinceName = provinceName;
		this.remark = remark;
	}
	
	
	@Override
	public String toString() {
		return "Province [provinceId=" + provinceId + ", provinceName="
				+ provinceName + ", remark=" + remark + "]";
	}
	

}

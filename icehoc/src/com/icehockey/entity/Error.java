package com.icehockey.entity;

public class Error {
	private int errorId; // 记录编号
	private String errorType; // 错误类型
	private String errorDesc; // 错误描述
	private String telephone; // 联系方式
	private String remark; // 备注
	
	
	public int getErrorId() {
		return errorId;
	}
	public void setErrorId(int errorId) {
		this.errorId = errorId;
	}
	public String getErrorType() {
		return errorType;
	}
	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}
	public String getErrorDesc() {
		return errorDesc;
	}
	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	public Error() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Error(int errorId, String errorType, String errorDesc,
			String telephone, String remark) {
		super();
		this.errorId = errorId;
		this.errorType = errorType;
		this.errorDesc = errorDesc;
		this.telephone = telephone;
		this.remark = remark;
	}
	
	
	@Override
	public String toString() {
		return "Error [errorId=" + errorId + ", errorType=" + errorType
				+ ", errorDesc=" + errorDesc + ", telephone=" + telephone
				+ ", remark=" + remark + "]";
	}
	

}

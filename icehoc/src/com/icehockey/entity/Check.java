package com.icehockey.entity;

public class Check {
	private int id;//
	private int flag;// '标志位，区分是审核的哪个实体1表示冰场，2表示俱乐部，3表示校队，4表示赛事',
	private int flagNo;
	private boolean checkReslut;// '审核结果1表示通过，0表示驳回',
	private String reason;// '驳回原因',
	private String checkDate;//
	private int userId;// '审核时间',
	private String remark;//

	
	public int getFlagNo() {
		return flagNo;
	}

	public void setFlagNo(int flagNo) {
		this.flagNo = flagNo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public boolean isCheckReslut() {
		return checkReslut;
	}

	public void setCheckReslut(boolean checkReslut) {
		this.checkReslut = checkReslut;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}



	@Override
	public String toString() {
		return "Check [id=" + id + ", flag=" + flag + ", flagNo=" + flagNo + ", checkReslut=" + checkReslut
				+ ", reason=" + reason + ", checkDate=" + checkDate + ", userId=" + userId + ", remark=" + remark + "]";
	}

	public Check(int id, int flag, int flagNo, boolean checkReslut, String reason, String checkDate, int userId,
			String remark) {
		super();
		this.id = id;
		this.flag = flag;
		this.flagNo = flagNo;
		this.checkReslut = checkReslut;
		this.reason = reason;
		this.checkDate = checkDate;
		this.userId = userId;
		this.remark = remark;
	}

	public Check() {
		super();
		// TODO Auto-generated constructor stub
	}

}

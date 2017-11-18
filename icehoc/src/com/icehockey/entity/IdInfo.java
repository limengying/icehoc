package com.icehockey.entity;

public class IdInfo {
	private int idInfoId; // 记录编号
	private int flag; // 标志位
	private int playerId; // 运动员编号
	private int coachId; // 教练员编号
	private int judgerId; // 裁判员编号
	private String idNo; // 证件号码
	private String frontPhoto; // 正面照片
	private String reversePhoto; // 反面照片
	private String remark; // 备注
	
	
	public int getIdInfoId() {
		return idInfoId;
	}
	public void setIdInfoId(int idInfoId) {
		this.idInfoId = idInfoId;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	public int getCoachId() {
		return coachId;
	}
	public void setCoachId(int coachId) {
		this.coachId = coachId;
	}
	public int getJudgerId() {
		return judgerId;
	}
	public void setJudgerId(int judgerId) {
		this.judgerId = judgerId;
	}
	public String getIdNo() {
		return idNo;
	}
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	public String getFrontPhoto() {
		return frontPhoto;
	}
	public void setFrontPhoto(String frontPhoto) {
		this.frontPhoto = frontPhoto;
	}
	public String getReversePhoto() {
		return reversePhoto;
	}
	public void setReversePhoto(String reversePhoto) {
		this.reversePhoto = reversePhoto;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	public IdInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public IdInfo(int idInfoId, int flag, int playerId, int coachId,
			int judgerId, String idNo, String frontPhoto, String reversePhoto,
			String remark) {
		super();
		this.idInfoId = idInfoId;
		this.flag = flag;
		this.playerId = playerId;
		this.coachId = coachId;
		this.judgerId = judgerId;
		this.idNo = idNo;
		this.frontPhoto = frontPhoto;
		this.reversePhoto = reversePhoto;
		this.remark = remark;
	}
	
	
	@Override
	public String toString() {
		return "IdInfo [idInfoId=" + idInfoId + ", flag=" + flag
				+ ", playerId=" + playerId + ", coachId=" + coachId
				+ ", judgerId=" + judgerId + ", idNo=" + idNo + ", frontPhoto="
				+ frontPhoto + ", reversePhoto=" + reversePhoto + ", remark="
				+ remark + "]";
	}
	

}

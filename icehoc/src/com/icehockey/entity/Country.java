package com.icehockey.entity;

public class Country {
	private int countryId; // 国籍编号
	private String code; // 编码
	private String nameChinese; // 中文
	private String nameEnglish; // 英文
	private String remark; // 备注

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNameChinese() {
		return nameChinese;
	}

	public void setNameChinese(String nameChinese) {
		this.nameChinese = nameChinese;
	}

	public String getNameEnglish() {
		return nameEnglish;
	}

	public void setNameEnglish(String nameEnglish) {
		this.nameEnglish = nameEnglish;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Country(int countryId, String code, String nameChinese, String nameEnglish, String remark) {
		super();
		this.countryId = countryId;
		this.code = code;
		this.nameChinese = nameChinese;
		this.nameEnglish = nameEnglish;
		this.remark = remark;
	}

	public Country() {
		super();
	}

	@Override
	public String toString() {
		return "Country [countryId=" + countryId + ", code=" + code + ", nameChinese=" + nameChinese + ", nameEnglish="
				+ nameEnglish + ", remark=" + remark + "]";
	}

}

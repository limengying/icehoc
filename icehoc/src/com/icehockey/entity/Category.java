package com.icehockey.entity;

public class Category {
	private int categoryId; // 类别编号
	private String categoryName; // 类别名称
	private String remark; // 备注

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(int categoryId, String categoryName, String remark) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName="
				+ categoryName + ", remark=" + remark + "]";
	}

}

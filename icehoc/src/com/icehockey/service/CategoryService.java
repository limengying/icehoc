package com.icehockey.service;

import java.util.List;

import com.icehockey.dao.CategoryDao;
import com.icehockey.entity.Category;

public class CategoryService {

	CategoryDao dao=new CategoryDao();
	Category category=null;
	public Category queryCategory(String categoryValue) {//通过类别名称查找类别对象并返回
		category=dao.getCategoryByCategoryValue(categoryValue);
		if(category!=null){
			System.out.println(category.toString());
		}
		return category;
	}
	public Category queryCategoryByCategoryId(int categoryId) {//通过类别名称查找类别对象并返回
		category=dao.getCategoryByCategoryId(categoryId);
		if(category!=null){
			System.out.println(category.toString());
		}
		return category;
	}
	public List<Category> getAll() {
		return dao.getCategorys();
	}

}

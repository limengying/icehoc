package com.icehockey.service;

import com.icehockey.dao.ErrorDao;

public class ErrorService {
	ErrorDao dao=new ErrorDao();
	public boolean insertError(String errorName, String errorDesc,String contactInfo){//插入错误信息，并返回是否成功
		boolean t=dao.insertError(errorName, errorDesc, contactInfo);
		return t;
	}
}

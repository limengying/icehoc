package com.icehockey.service;

import com.icehockey.dao.IdInfoDao;
import com.icehockey.entity.IdInfo;

public class IdInfoService {

	IdInfoDao idInfoDao = new IdInfoDao();
	IdInfo idInfo = null;// 声明一个User对象

	/**
	 * 
	 * 通过身份证号码查找记录
	 */
	public IdInfo getRecordByIdInfo(String idNo) {
		return idInfoDao.getIdInfoByIdNo(idNo);
	}

	
}

package com.icehockey.service;

import com.icehockey.dao.CheckDao;
import com.icehockey.entity.Check;

public class CheckService {
	CheckDao checkDao = new CheckDao();

	public Check getCheckRecord(int flag, int flagNo) {
		return checkDao.getCheckRecord(flag, flagNo);
	}

	public boolean addCheckRecord(Check check) {
		return checkDao.addCheckRecord(check);
	}

	public boolean updateCheckRecord(int id, Check check) {
		return checkDao.updateCheckRecord(id, check);
	}

}

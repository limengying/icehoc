package com.icehockey.service;

import com.icehockey.dao.LoginLogDao;
import com.icehockey.entity.LoginLog;

public class LoginLogService {
	LoginLogDao loginLogDao = new LoginLogDao();

	public boolean addLoginLog(int userId, String loginTime, String remark) {
		return loginLogDao.addRecord(userId, loginTime, "1900-01-01 00:00:00", remark);
	}

	public LoginLog getLogNewAdd(int loginUserId, String loginTime) {
		return loginLogDao.getLogNewAddRecord(loginUserId, loginTime);
	}

	public boolean sign(int id) {
		return loginLogDao.updateUserSign(id);
	}

	public int getSignedNum(int userId) {
		return loginLogDao.getSignedNum(userId);
	}

	public LoginLog isSigned(int loginLogId) {
		return loginLogDao.getById(loginLogId);
	}
}

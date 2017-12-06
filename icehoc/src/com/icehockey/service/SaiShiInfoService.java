package com.icehockey.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.icehockey.dao.SaiShiInfoDao;
import com.icehockey.entity.SaiShiInfo;

public class SaiShiInfoService {
	SaiShiInfoDao dao = new SaiShiInfoDao();

	public List<SaiShiInfo> getSaiShiInfosGuanFang() {
		return dao.getSaiShiInfosByType(true);
	}

	public List<SaiShiInfo> getSaiShiInfosLINSHI() {
		return dao.getSaiShiInfosByType(false);
	}

	public SaiShiInfo getSaiShiInfoById(int id) {
		return dao.getSaiShiInfoById(id);
	}

	public List<SaiShiInfo> getSaiShiInfosAll() {
		return dao.getSaiShiInfosAll();
	}

	public List<SaiShiInfo> querySaiShiInfosByNameString(String nameString) {
		return dao.getSaiShiInfosByNameString(nameString);
	}

	public boolean addFollowGuanFang(int competitionId, int userId) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		Date currentDateTime = new Date();
		System.out.println(df.format(currentDateTime));// new Date()为获取当前系统时间
		String dateString = df.format(currentDateTime);
		return dao.addFollowGuanFang(competitionId, userId,dateString);
	}

	public List<SaiShiInfo> getSaiShiInfosUserFollow(int userId) {
		return dao.getSaiShiInfosUserFollow(userId);
	}

}

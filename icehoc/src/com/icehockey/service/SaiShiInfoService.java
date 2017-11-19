package com.icehockey.service;

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

}

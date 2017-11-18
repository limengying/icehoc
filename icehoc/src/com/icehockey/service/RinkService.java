package com.icehockey.service;

import java.util.List;

import com.icehockey.dao.RinkDao;
import com.icehockey.entity.Rink;

public class RinkService {
	RinkDao rinkDao = new RinkDao();

	Rink rink = null;
	List<Rink> rinks = null;

	/**
	 * 通过冰场编号返回冰场信息
	 * 
	 */
	public Rink getRinkByRinkId(int rinkId) {

		rink = rinkDao.getRinkByRinkName(rinkId);
		if (rink != null) {
			System.out.println(rink.toString());
			return rink;
		} else {
			System.out.println(rinkId + "不存在");
			return null;
		}

	}

	/**
	 * 返回数据中的所有冰场信息
	 * 
	 */
	public List<Rink> getRinks() {
		rinks = rinkDao.getRinks();
		if (rinks != null) {
			System.out.println(rinks.toString());
			return rinks;
		} else {
			System.out.println("Rink为空");
			return null;
		}
	}

	/**
	 * 通过冰场名称，查找数据库中所有的冰场对象，并返回集合,这里是模糊查询
	 * 
	 */
	public List<Rink> getRinksByRinkName(String rinkName) {
		rinks = rinkDao.getRinksByString(rinkName);
		if (rinks != null) {
			System.out.println(rinks.toString());
			return rinks;
		} else {
			System.out.println("Rinks为空");
			return null;
		}
	}

	public boolean AddRink(String rinkName, String address, String telephone, boolean indoor, boolean hasLocker,
			boolean hasCarparks, String trainingDegree, int scale, boolean hasLandTrainingRoom, int area, int iceArea,
			String completionDate, String beginUseDate, String openTime, boolean allowedSlip, String iceType) {
		
		return rinkDao.addRink(rinkName,address,telephone,indoor,hasLocker,hasCarparks,trainingDegree,scale,hasLandTrainingRoom,area,iceArea,completionDate,beginUseDate,openTime,allowedSlip,iceType);
		
	}

}

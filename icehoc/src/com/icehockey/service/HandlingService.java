package com.icehockey.service;

import java.util.List;

import com.icehockey.dao.HandlingDao;
import com.icehockey.entity.Handling;

public class HandlingService {

	HandlingDao dao = new HandlingDao();
	Handling handling = null;

	public Handling queryHandling(String handlingName) {// 根据持杆方式名称获得持杆方式对象

		handling = dao.getHandlingByHandlingValue(handlingName);
		if (handling != null) {
			System.out.println(handling);
		} else {
			System.out.println("持杆方式未找到");
		}
		return handling;
	}

	public Handling queryHandling(int HandlingId) {// 根据持杆方式名称获得持杆方式对象

		handling = dao.getHandlingByHandlingId(HandlingId);
		if (handling != null) {
			System.out.println(handling);
		} else {
			System.out.println("持杆方式未找到");
		}
		return handling;
	}

	public List<Handling> getAll() {
		return dao.getHandlings();
	}
}

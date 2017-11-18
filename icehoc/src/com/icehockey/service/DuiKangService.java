package com.icehockey.service;

import java.util.List;

import com.icehockey.dao.DuiKangDao;
import com.icehockey.entity.DuiKang;

public class DuiKangService {
	DuiKangDao dao=new DuiKangDao();
	
	public List<DuiKang> getDuiKangs(int userId) {
		return dao.getDuiKangsByUserId(userId);
	}

	public List<DuiKang> queryDuiKangsByNameString(String nameString) {
		
		return dao.getDuiKangsByNameString(nameString);
	}

	public List<DuiKang> getDuiKangsGuanFang() {
		return dao.getDuiKangsGuanFang();
	}

	public DuiKang getDuiKangById(int id) {
		return dao.getDuiKangById(id);
		}

	public List<DuiKang> getDuiKangsAll() {
		return dao.getDuiKangsAll();
	}

}

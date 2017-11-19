package com.icehockey.service;

import com.icehockey.dao.CompetitionDao;

public class CompetitionService {
	CompetitionDao competitionDao = new CompetitionDao();

	public boolean addCompetition(int teamAId, int teamBId, int rinkId, String time, String remark,boolean competitionType) {

		return competitionDao.insertRe(teamAId, teamBId, rinkId, time, remark, competitionType);
	}

	public boolean addCompetition(String competitionName, String remark) {
		return competitionDao.insertRe(competitionName, remark);
	}

	public boolean addCompetitionGUANGFANG(String competitionName, int teamAId, int teamBId, int rinkId, String time,
			String remark, boolean competitionType) {
		return competitionDao.insertReGUANFANG(competitionName,teamAId, teamBId, rinkId, time, remark, competitionType);
	}

}

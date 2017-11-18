package com.icehockey.service;

import com.icehockey.dao.CompetitionDao;

public class CompetitionService {
	CompetitionDao competitionDao = new CompetitionDao();

	public boolean addCompetition(int teamAId, int teamBId, int rinkId, String time, String remark) {

		return competitionDao.insertRe(teamAId, teamBId, rinkId, time, remark, false);
	}

	public boolean addCompetition(String competitionName, String remark) {
		return competitionDao.insertRe(competitionName, remark);
	}

}

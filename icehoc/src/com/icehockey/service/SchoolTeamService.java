package com.icehockey.service;

import java.util.List;

import com.icehockey.dao.SchoolTeamDao;
import com.icehockey.entity.SchoolTeam;

public class SchoolTeamService {
	SchoolTeamDao dao = new SchoolTeamDao();

	public List<SchoolTeam> querySchoolTeamsByNameString(String nameString) {

		return dao.getSchoolsByNameString(nameString);
	}

	public List<SchoolTeam> querySchoolTeams() {
		return dao.getSchoolTeams();
	}

	public SchoolTeam querySchoolTeamBySchoolTeamId(int schoolTeamId) {
		return dao.getSchoolTeamBySchoolTeamId(schoolTeamId);
	}

	public boolean addschoolTeam(String teamName, String buildTime, String construction) {
		return dao.addschoolTeam(teamName, buildTime, construction);
	}

}

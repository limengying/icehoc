package com.icehockey.service;

import java.util.List;

import com.icehockey.dao.TeamDao;
import com.icehockey.entity.Team;

public class TeamService {
	TeamDao dao = new TeamDao();

	public List<Team> queryTeamsByNameString(String nameString) {

		return dao.getTeamsByNameString(nameString);
	}

	public List<Team> queryTeams() {
		return dao.getTeams();
	}

	public Team queryTeamByTeamId(int schoolTeamId) {
		return dao.getTeamByTeamId(schoolTeamId);
	}

	public boolean addTeam(String teamName, String buildTime, String construction) {
		return dao.addTeam(teamName, buildTime, construction);
	}
	public void resetcheckId(Team team) {
		dao.resetschoolTeamcheckId(team);;
	}
}

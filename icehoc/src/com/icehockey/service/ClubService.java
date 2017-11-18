package com.icehockey.service;

import java.util.List;

import com.icehockey.dao.ClubDao;
import com.icehockey.entity.Club;

public class ClubService {
	ClubDao dao=new ClubDao();
	Club club=null;
	public Club queryClub(int playerId) {//通过角色名称查找角色对象并返回
		club=dao.getClubByPlayerId(playerId);
		if(club!=null){
			System.out.println(club.toString());
		}
		return club;
	}
	public List<Club> getAll() {
		return dao.getClubs();
	}
	public List<Club> queryClubByNameString(String nameString) {
		return dao.queryClubWithNameString(nameString);
	}
	public Club queryClubByClubId(int clubId) {
		return dao.queryClubByClubId(clubId);
	}
	public boolean addClub(String clubName, String buildTime, String remark) {
		
		return dao.addClub(clubName, buildTime, remark);
	}
}

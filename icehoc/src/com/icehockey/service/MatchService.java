package com.icehockey.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.icehockey.dao.MatchDao;
import com.icehockey.entity.Match;
import com.icehockey.util.FileUtil;



public class MatchService {
	
	MatchDao matchDao=new MatchDao();

	
	public List<Match> getAllUserFollowCompetition(int userId) {
		List<Match> matchs = new ArrayList<Match>();
		matchs = matchDao.getAllUserFollowCompetition(userId);
		return matchs;
	}

	
	public List<Match> getAllOfficialCompetitions() {
		List<Match> matchs = new ArrayList<Match>();
		matchs = matchDao.getCompetitionsByType(true);
		return matchs;
	}

	
	public boolean addFollowCompetition(int userId, int competitionId) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		Date currentDateTime = new Date();
		System.out.println(df.format(currentDateTime));// new Date()为获取当前系统时间
		String followdateString = df.format(currentDateTime);
		int i = matchDao.addFollowOfficalCompetitionId(userId, competitionId, followdateString);
		if (i == 1) {
			return true;
		}
		return false;
	}

	
	public int addUnOfficalCompetion(int userId, Match match) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		Date currentDateTime = new Date();
		System.out.println(df.format(currentDateTime));// new Date()为获取当前系统时间
		String onDate = df.format(currentDateTime);
		match.setCompetitionType(false);
		matchDao.addUnOfficalCompetion(match);
		int competitionId = match.getCompetitionId();
		System.out.println(competitionId);
		matchDao.addFollowOfficalCompetitionId(userId, competitionId, onDate);
		return competitionId;
	}

	
	public List<Match> getAllCompetitions() {
		List<Match> matchs = new ArrayList<Match>();
		matchs = matchDao.getAllCompetitions();
		return matchs;
	}

	
	public Match getMatchByCompetitionId(int competitionId) {
		Match match = matchDao.getMatchByCompetitionId(competitionId);
		return match;
	}

	
	public int addOfficalCompetion(Match match) {
		String businessLicense = FileUtil.savePicture(match.getBusinessLicense(), "matchBusinessLicense");
		match.setBusinessLicense(businessLicense);

		String idCardCopyFile = FileUtil.savePicture(match.getIdCardCopyFile(), "matchIdCardCopyFile");
		match.setIdCardCopyFile(idCardCopyFile);
		
		match.setCompetitionType(true);
		matchDao.addOfficalCompetion(match);
		int competitionId = match.getCompetitionId();
		System.out.println(competitionId);
		return competitionId;
	}

	
	public List<Match> getMatchsByStr(String competitionNameStr) {
		List<Match> matchs = new ArrayList<Match>();
		matchs = matchDao.getMatchsByStr(competitionNameStr);
		return matchs;
	}

}

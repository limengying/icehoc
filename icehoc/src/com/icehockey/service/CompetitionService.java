package com.icehockey.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.icehockey.dao.CompetitionDao;
import com.icehockey.entity.Check;

public class CompetitionService {
	CompetitionDao competitionDao = new CompetitionDao();
	Check check=null;
	CheckService checkService=new CheckService();

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
	public boolean clubCheckRefused(int userId, int clubId) {
		check =checkService.getCheckRecord(2,clubId);
		Check checkTemp =new Check();
		String reason=null;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		Date currentDateTime = new Date();
		System.out.println(df.format(currentDateTime));// new Date()为获取当前系统时间
		String followdateString = df.format(currentDateTime);
		checkTemp.setFlag(4);
		checkTemp.setFlagNo(clubId);
		checkTemp.setCheckReslut(false); 
		checkTemp.setCheckDate(followdateString);
		checkTemp.setUserId(userId);
		checkTemp.setRemark("aaa");
		boolean f=false;
		if(check==null){
			reason="驳回";
			checkTemp.setReason(reason);
			 f=checkService.addCheckRecord(checkTemp);
		}else{
			reason=check.getReason()+"资料不全驳回";
			checkTemp.setReason(reason);
			f=checkService.updateCheckRecord(check.getId(),checkTemp);
		}
		if(f){
			System.out.println("驳回成功");
			check =checkService.getCheckRecord(4,clubId);
			competitionDao.competitionCheck(clubId,0);
		}else{
			System.out.println("驳回失败");
		}
		return f;
	}
	public boolean clubCheckOK(int userId, int clubId) {
		check =checkService.getCheckRecord(2,clubId);
		Check checkTemp =new Check();
		String reason=null;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		Date currentDateTime = new Date();
		System.out.println(df.format(currentDateTime));// new Date()为获取当前系统时间
		String followdateString = df.format(currentDateTime);
		checkTemp.setFlag(2);
		checkTemp.setFlagNo(clubId);
		checkTemp.setCheckReslut(true); 
		checkTemp.setCheckDate(followdateString);
		checkTemp.setUserId(userId);
		checkTemp.setRemark("aaa");
		boolean f=false;
		if(check==null){
			reason="通过";
			checkTemp.setReason(reason);
			 f=checkService.addCheckRecord(checkTemp);
		}else{
			reason=check.getReason()+"通过";
			checkTemp.setReason(reason);
			f=checkService.updateCheckRecord(check.getId(),checkTemp);
		}
		if(f){
			System.out.println("审核成功");
			check =checkService.getCheckRecord(4,clubId);
			competitionDao.competitionCheck(clubId,check.getId());
		}else{
			System.out.println("审核失败");
		}
		return f;
	}
}

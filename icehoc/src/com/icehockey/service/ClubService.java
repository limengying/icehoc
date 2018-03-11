package com.icehockey.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.icehockey.dao.ClubDao;
import com.icehockey.entity.Check;
import com.icehockey.entity.Club;

public class ClubService {
	ClubDao dao = new ClubDao();
	Club club = null;
	Check check=null;
	CheckService checkService=new CheckService();

	public Club queryClub(int playerId) {// 通过角色名称查找角色对象并返回
		club = dao.getClubByPlayerId(playerId);
		if (club != null) {
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

	
	public boolean clubCheckRefused(int userId, int clubId) {
		check =checkService.getCheckRecord(2,clubId);
		Check checkTemp =new Check();
		String reason=null;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		Date currentDateTime = new Date();
		System.out.println(df.format(currentDateTime));// new Date()为获取当前系统时间
		String followdateString = df.format(currentDateTime);
		checkTemp.setFlag(2);
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
			System.out.println("审核成功");
			check =checkService.getCheckRecord(1,clubId);
			dao.clubCheck(clubId,0);
		}else{
			System.out.println("审核失败");
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
			check =checkService.getCheckRecord(1,clubId);
			dao.clubCheck(clubId,check.getId());
		}else{
			System.out.println("审核失败");
		}
		return f;
	}
}

package com.icehockey.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.icehockey.dao.TeamDao;
import com.icehockey.entity.Check;
import com.icehockey.entity.Team;

public class TeamService {
	TeamDao dao = new TeamDao();
Check check=null;
CheckService checkService=new CheckService();
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
	public boolean teamCheckRefused(int userId, int teamId) {
		check =checkService.getCheckRecord(2,teamId);
		Check checkTemp =new Check();
		String reason=null;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		Date currentDateTime = new Date();
		System.out.println(df.format(currentDateTime));// new Date()为获取当前系统时间
		String followdateString = df.format(currentDateTime);
		checkTemp.setFlag(2);
		checkTemp.setFlagNo(teamId);
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
			check =checkService.getCheckRecord(2,teamId);
			dao.teamCheck(teamId,0);
		}else{
			System.out.println("审核失败");
		}
		return f;
	}
	public boolean teamCheckOK(int userId, int teamId) {
		check =checkService.getCheckRecord(2,teamId);
		Check checkTemp =new Check();
		String reason=null;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		Date currentDateTime = new Date();
		System.out.println(df.format(currentDateTime));// new Date()为获取当前系统时间
		String followdateString = df.format(currentDateTime);
		checkTemp.setFlag(2);
		checkTemp.setFlagNo(teamId);
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
			check =checkService.getCheckRecord(2,teamId);
			dao.teamCheck(teamId,check.getId());
		}else{
			System.out.println("审核失败");
		}
		return f;
	}
}

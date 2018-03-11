package com.icehockey.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.icehockey.entity.Match;
import com.icehockey.util.DBUtil;

public class MatchDao {

	DBUtil util = new DBUtil();
	private ResultSet rs = null;
	private Connection conn = null;
	private Match match = null;
	private PreparedStatement preparedStatement = null;

	public List<Match> getAllUserFollowCompetition(int userId) {
		List<Match> Matchs = new ArrayList<Match>();
		String sql = "SELECT DISTINCT matchView.* FROM matchView, userFollowPlayer, playerClub, USER, userCompetition WHERE (( USER .userId = userfollowplayer.userId AND userfollowplayer.playerId = playerclub.playerId AND ( playerclub.clubId = matchview.clubAId OR playerclub.clubId = matchview.clubBId ) AND matchView.checkId !=- 1 ) OR ( usercompetition.userId = USER .userId AND usercompetition.competitionId = matchview.competitionId )) AND USER .userId = ?";
		System.out.println(sql);
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, userId);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int competitionId = rs.getInt("competitionId");// 编号
				String competitionName = rs.getString("competitionName");// 赛事名称
				int teamAId = rs.getInt("teamAId");// 主队编号
				int teamBId = rs.getInt("teamBId");// 客队编号
				int rinkId = rs.getInt("rinkId");// 场地编号
				Timestamp timestamp = rs.getTimestamp("competitionTime");// 比赛时间
				String competitionTime = null;
				if (timestamp != null) {
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:MM:SS");// 设置日期格式
					competitionTime = df.format(timestamp.getTime());
				}
				int competitionDegreeId = rs.getInt("competitionDegreeId");// 比赛等级编号
				int round = rs.getInt("round");// 轮次
				boolean competitionType=rs.getBoolean("competitionType");// 比赛类型
				String remark = rs.getString("remark");// 备注
				String businessLicense = rs.getString("businessLicense");// 经营执照
				String idCardCopyFile = rs.getString("idCardCopyFile");// 法人身份证复印件
				int checkId = rs.getInt("checkId");// 是否审核

				String teamAName = rs.getString("checkId");// 主队名称
				String teamBName = rs.getString("teamBName");// 客队名称
				int clubAId = rs.getInt("clubAId");// 主队俱乐部
				String clubAName = rs.getString("clubAName");// 主队俱乐部名称
				String clubALogo = rs.getString("clubALogo");// 主队俱乐部LOGO

				int clubBId = rs.getInt("clubBId");// 客队俱乐部
				String clubBName = rs.getString("clubBName");// 客队俱乐部名称
				String clubBLogo = rs.getString("clubBLogo");// 客队俱乐部LOGO

				 timestamp = rs.getTimestamp("pkDate");// 比赛日期 年月日星期几
				String pkDate = null;
				if (timestamp != null) {
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd EEEE");// 设置日期格式
					pkDate = df.format(timestamp.getTime());
				}
				System.out.println("pkDate:" + pkDate);
				timestamp = rs.getTimestamp("pkTime");// 比赛时间 HH：MM
				String pkTime = null;
				if (timestamp != null) {
					SimpleDateFormat df = new SimpleDateFormat("HH:mm");// 设置日期格式
					pkTime = df.format(timestamp.getTime());
				}
				System.out.println("pkTime:" + pkTime);
				String competitionDegreeName = rs.getString("competitionDegreeName");// 比赛等级名称
				String rinkName = rs.getString("rinkName");// 场地名称
				int environmentalIndex = rs.getInt("environmentalIndex");// 环境指数

				
				match = new Match(competitionId, competitionName, teamAId, teamBId, rinkId, competitionTime, competitionDegreeId, round, competitionType, remark, businessLicense, idCardCopyFile, checkId, teamAName, teamBName, clubAId, clubAName, clubALogo, clubBId, clubBName, clubBLogo, pkDate, pkTime, competitionDegreeName, rinkName, environmentalIndex);
				System.out.println(match);
				Matchs.add(match);
			}
			return Matchs;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return Matchs;
	}

	public List<Match> getCompetitionsByType(boolean b) {
		List<Match> matchs = new ArrayList<Match>();
		String sql ="SELECT matchView.* FROM matchView WHERE checkId !=- 1 AND matchView.competitionType = ?";
		System.out.println(sql);
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setBoolean(1, b);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int competitionId = rs.getInt("competitionId");// 编号
				String competitionName = rs.getString("competitionName");// 赛事名称
				int teamAId = rs.getInt("teamAId");// 主队编号
				int teamBId = rs.getInt("teamBId");// 客队编号
				int rinkId = rs.getInt("rinkId");// 场地编号
				Timestamp timestamp = rs.getTimestamp("competitionTime");// 比赛时间
				String competitionTime = null;
				if (timestamp != null) {
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:MM:SS");// 设置日期格式
					competitionTime = df.format(timestamp.getTime());
				}
				int competitionDegreeId = rs.getInt("competitionDegreeId");// 比赛等级编号
				int round = rs.getInt("round");// 轮次
				boolean competitionType=rs.getBoolean("competitionType");// 比赛类型
				String remark = rs.getString("remark");// 备注
				String businessLicense = rs.getString("businessLicense");// 经营执照
				String idCardCopyFile = rs.getString("idCardCopyFile");// 法人身份证复印件
				int checkId = rs.getInt("checkId");// 是否审核

				String teamAName = rs.getString("checkId");// 主队名称
				String teamBName = rs.getString("teamBName");// 客队名称
				int clubAId = rs.getInt("clubAId");// 主队俱乐部
				String clubAName = rs.getString("clubAName");// 主队俱乐部名称
				String clubALogo = rs.getString("clubALogo");// 主队俱乐部LOGO

				int clubBId = rs.getInt("clubBId");// 客队俱乐部
				String clubBName = rs.getString("clubBName");// 客队俱乐部名称
				String clubBLogo = rs.getString("clubBLogo");// 客队俱乐部LOGO

				 timestamp = rs.getTimestamp("pkDate");// 比赛日期 年月日星期几
				String pkDate = null;
				if (timestamp != null) {
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd EEEE");// 设置日期格式
					pkDate = df.format(timestamp.getTime());
				}
				System.out.println("pkDate:" + pkDate);
				timestamp = rs.getTimestamp("pkTime");// 比赛时间 HH：MM
				String pkTime = null;
				if (timestamp != null) {
					SimpleDateFormat df = new SimpleDateFormat("HH:mm");// 设置日期格式
					pkTime = df.format(timestamp.getTime());
				}
				System.out.println("pkTime:" + pkTime);
				String competitionDegreeName = rs.getString("competitionDegreeName");// 比赛等级名称
				String rinkName = rs.getString("rinkName");// 场地名称
				int environmentalIndex = rs.getInt("environmentalIndex");// 环境指数

				
				match = new Match(competitionId, competitionName, teamAId, teamBId, rinkId, competitionTime, competitionDegreeId, round, competitionType, remark, businessLicense, idCardCopyFile, checkId, teamAName, teamBName, clubAId, clubAName, clubALogo, clubBId, clubBName, clubBLogo, pkDate, pkTime, competitionDegreeName, rinkName, environmentalIndex);
				System.out.println(match);
				matchs.add(match);
			}
			return matchs;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return matchs;
	}

	public int addFollowOfficalCompetitionId(int userId, int competitionId, String followdateString) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void addUnOfficalCompetion(Match match2) {
		// TODO Auto-generated method stub

	}

	public List<Match> getAllCompetitions() {
		List<Match> matchs = new ArrayList<Match>();
		String sql ="SELECT matchView.* FROM matchView";
		System.out.println(sql);
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int competitionId = rs.getInt("competitionId");// 编号
				String competitionName = rs.getString("competitionName");// 赛事名称
				int teamAId = rs.getInt("teamAId");// 主队编号
				int teamBId = rs.getInt("teamBId");// 客队编号
				int rinkId = rs.getInt("rinkId");// 场地编号
				Timestamp timestamp = rs.getTimestamp("competitionTime");// 比赛时间
				String competitionTime = null;
				if (timestamp != null) {
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:MM:SS");// 设置日期格式
					competitionTime = df.format(timestamp.getTime());
				}
				int competitionDegreeId = rs.getInt("competitionDegreeId");// 比赛等级编号
				int round = rs.getInt("round");// 轮次
				boolean competitionType=rs.getBoolean("competitionType");// 比赛类型
				String remark = rs.getString("remark");// 备注
				String businessLicense = rs.getString("businessLicense");// 经营执照
				String idCardCopyFile = rs.getString("idCardCopyFile");// 法人身份证复印件
				int checkId = rs.getInt("checkId");// 是否审核

				String teamAName = rs.getString("checkId");// 主队名称
				String teamBName = rs.getString("teamBName");// 客队名称
				int clubAId = rs.getInt("clubAId");// 主队俱乐部
				String clubAName = rs.getString("clubAName");// 主队俱乐部名称
				String clubALogo = rs.getString("clubALogo");// 主队俱乐部LOGO

				int clubBId = rs.getInt("clubBId");// 客队俱乐部
				String clubBName = rs.getString("clubBName");// 客队俱乐部名称
				String clubBLogo = rs.getString("clubBLogo");// 客队俱乐部LOGO

				 timestamp = rs.getTimestamp("pkDate");// 比赛日期 年月日星期几
				String pkDate = null;
				if (timestamp != null) {
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd EEEE");// 设置日期格式
					pkDate = df.format(timestamp.getTime());
				}
				System.out.println("pkDate:" + pkDate);
				timestamp = rs.getTimestamp("pkTime");// 比赛时间 HH：MM
				String pkTime = null;
				if (timestamp != null) {
					SimpleDateFormat df = new SimpleDateFormat("HH:mm");// 设置日期格式
					pkTime = df.format(timestamp.getTime());
				}
				System.out.println("pkTime:" + pkTime);
				String competitionDegreeName = rs.getString("competitionDegreeName");// 比赛等级名称
				String rinkName = rs.getString("rinkName");// 场地名称
				int environmentalIndex = rs.getInt("environmentalIndex");// 环境指数

				
				match = new Match(competitionId, competitionName, teamAId, teamBId, rinkId, competitionTime, competitionDegreeId, round, competitionType, remark, businessLicense, idCardCopyFile, checkId, teamAName, teamBName, clubAId, clubAName, clubALogo, clubBId, clubBName, clubBLogo, pkDate, pkTime, competitionDegreeName, rinkName, environmentalIndex);
				System.out.println(match);
				matchs.add(match);
			}
			return matchs;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return matchs;
	}

	public Match getMatchByCompetitionId(int competitionId) {
		
		String sql ="SELECT matchView.* FROM matchView WHERE matchView.competitionId = ?";
		System.out.println(sql);
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, competitionId);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				 competitionId = rs.getInt("competitionId");// 编号
				String competitionName = rs.getString("competitionName");// 赛事名称
				int teamAId = rs.getInt("teamAId");// 主队编号
				int teamBId = rs.getInt("teamBId");// 客队编号
				int rinkId = rs.getInt("rinkId");// 场地编号
				Timestamp timestamp = rs.getTimestamp("competitionTime");// 比赛时间
				String competitionTime = null;
				if (timestamp != null) {
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:MM:SS");// 设置日期格式
					competitionTime = df.format(timestamp.getTime());
				}
				int competitionDegreeId = rs.getInt("competitionDegreeId");// 比赛等级编号
				int round = rs.getInt("round");// 轮次
				boolean competitionType=rs.getBoolean("competitionType");// 比赛类型
				String remark = rs.getString("remark");// 备注
				String businessLicense = rs.getString("businessLicense");// 经营执照
				String idCardCopyFile = rs.getString("idCardCopyFile");// 法人身份证复印件
				int checkId = rs.getInt("checkId");// 是否审核

				String teamAName = rs.getString("checkId");// 主队名称
				String teamBName = rs.getString("teamBName");// 客队名称
				int clubAId = rs.getInt("clubAId");// 主队俱乐部
				String clubAName = rs.getString("clubAName");// 主队俱乐部名称
				String clubALogo = rs.getString("clubALogo");// 主队俱乐部LOGO

				int clubBId = rs.getInt("clubBId");// 客队俱乐部
				String clubBName = rs.getString("clubBName");// 客队俱乐部名称
				String clubBLogo = rs.getString("clubBLogo");// 客队俱乐部LOGO

				 timestamp = rs.getTimestamp("pkDate");// 比赛日期 年月日星期几
				String pkDate = null;
				if (timestamp != null) {
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd EEEE");// 设置日期格式
					pkDate = df.format(timestamp.getTime());
				}
				System.out.println("pkDate:" + pkDate);
				timestamp = rs.getTimestamp("pkTime");// 比赛时间 HH：MM
				String pkTime = null;
				if (timestamp != null) {
					SimpleDateFormat df = new SimpleDateFormat("HH:mm");// 设置日期格式
					pkTime = df.format(timestamp.getTime());
				}
				System.out.println("pkTime:" + pkTime);
				String competitionDegreeName = rs.getString("competitionDegreeName");// 比赛等级名称
				String rinkName = rs.getString("rinkName");// 场地名称
				int environmentalIndex = rs.getInt("environmentalIndex");// 环境指数

				
				match = new Match(competitionId, competitionName, teamAId, teamBId, rinkId, competitionTime, competitionDegreeId, round, competitionType, remark, businessLicense, idCardCopyFile, checkId, teamAName, teamBName, clubAId, clubAName, clubALogo, clubBId, clubBName, clubBLogo, pkDate, pkTime, competitionDegreeName, rinkName, environmentalIndex);
				System.out.println(match);
			}
			return match;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return match;
	}

	public void addOfficalCompetion(Match match2) {
		// TODO Auto-generated method stub

	}

	public List<Match> getMatchsByStr(String competitionNameStr) {
		// TODO Auto-generated method stub
		return null;
	}

}

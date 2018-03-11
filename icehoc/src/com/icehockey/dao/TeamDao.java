package com.icehockey.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.icehockey.entity.Team;
import com.icehockey.util.DBUtil;

public class TeamDao {

	DBUtil util = new DBUtil();
	private ResultSet rs = null;
	private Connection conn = null;
	private Team team = null;
	private List<Team> teams = null;
	private PreparedStatement preparedStatement = null;

	/**
	 * @param telephone
	 * @return Team
	 * 
	 *         通过手机号码查找到SchoolTeam对象并返回
	 */
	public List<Team> getTeamsByNameString(String nameString) {
		teams = new ArrayList<Team>();
		String sql = "SELECT * FROM team where teamName like '%" + nameString + "%';";
		System.out.println(sql);
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int teamId = rs.getInt("teamId"); // 校队编号
				String teamName = rs.getString("teamName"); // 校队名称
				String teamLogo = rs.getString("teamLogo");// 校队LOGO
				String teamAddress = rs.getString("teamAddress");// 校队地址
				Timestamp timestamp = rs.getTimestamp("buildTime");// 组建时间
				String buildTime = null;
				if (timestamp != null) {
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
					buildTime = df.format(timestamp.getTime());
				}
				String telephone = rs.getString("telephone"); // 联系方式
				String leaderName = rs.getString("leaderName"); // 领队
				String leaderTelephone = rs.getString("leaderTelephone"); // 领队联系方式
				String construction = rs.getString("construction");// 球队建设
				String email = rs.getString("email");// 电子邮件
				String remark = rs.getString("remark"); // 备注
				String businessLicense = rs.getString("businessLicense");// 经营执照
				String idCardCopyFile = rs.getString("idCardCopyFile");// 法人身份证复印件
				int checkId = rs.getInt("checkId");// 是否审核
				int clubId = rs.getInt("clubId");// 俱乐部编号
				team = new Team(teamId, teamName, teamLogo, teamAddress, buildTime, telephone, leaderName,
						leaderTelephone, construction, email, remark, businessLicense, idCardCopyFile, checkId, clubId);
				teams.add(team);
			}
			return teams;
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
		return null;
	}

	public List<Team> getTeams() {
		teams = new ArrayList<Team>();
		String sql = "SELECT * FROM team;";
		System.out.println(sql);
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int teamId = rs.getInt("teamId"); // 校队编号
				String teamName = rs.getString("teamName"); // 校队名称
				String teamLogo = rs.getString("teamLogo");// 校队LOGO
				String teamAddress = rs.getString("teamAddress");// 校队地址
				Timestamp timestamp = rs.getTimestamp("buildTime");// 组建时间
				String buildTime = null;
				if (timestamp != null) {
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
					buildTime = df.format(timestamp.getTime());
				}
				String telephone = rs.getString("telephone"); // 联系方式
				String leaderName = rs.getString("leaderName"); // 领队
				String leaderTelephone = rs.getString("leaderTelephone"); // 领队联系方式
				String construction = rs.getString("construction");// 球队建设
				String email = rs.getString("email");// 电子邮件
				String remark = rs.getString("remark"); // 备注
				String businessLicense = rs.getString("businessLicense");// 经营执照
				String idCardCopyFile = rs.getString("idCardCopyFile");// 法人身份证复印件
				int checkId = rs.getInt("checkId");// 是否审核
				int clubId = rs.getInt("clubId");// 俱乐部编号
				team = new Team(teamId, teamName, teamLogo, teamAddress, buildTime, telephone, leaderName,
						leaderTelephone, construction, email, remark, businessLicense, idCardCopyFile, checkId, clubId);
				
				teams.add(team);
			}
			return teams;
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
		return null;
	}

	public Team getTeamByTeamId(int TeamId) {
		String sql = "SELECT * FROM team where teamId=?;";

		System.out.println(sql);
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, TeamId);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				int teamId = rs.getInt("teamId"); // 校队编号
				String teamName = rs.getString("teamName"); // 校队名称
				String teamLogo = rs.getString("teamLogo");// 校队LOGO
				String teamAddress = rs.getString("teamAddress");// 校队地址
				Timestamp timestamp = rs.getTimestamp("buildTime");// 组建时间
				String buildTime = null;
				if (timestamp != null) {
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
					buildTime = df.format(timestamp.getTime());
				}
				String telephone = rs.getString("telephone"); // 联系方式
				String leaderName = rs.getString("leaderName"); // 领队
				String leaderTelephone = rs.getString("leaderTelephone"); // 领队联系方式
				String construction = rs.getString("construction");// 球队建设
				String email = rs.getString("email");// 电子邮件
				String remark = rs.getString("remark"); // 备注
				String businessLicense = rs.getString("businessLicense");// 经营执照
				String idCardCopyFile = rs.getString("idCardCopyFile");// 法人身份证复印件
				int checkId = rs.getInt("checkId");// 是否审核
				int clubId = rs.getInt("clubId");// 俱乐部编号
				team = new Team(teamId, teamName, teamLogo, teamAddress, buildTime, telephone, leaderName,
						leaderTelephone, construction, email, remark, businessLicense, idCardCopyFile, checkId, clubId);
				
				return team;
			}
			return null;
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
		return null;
	}

	public void resetschoolTeamcheckId(Team team) {// 重置审核标志
		String sql = "UPDATE team SET checkId=? WHERE teamId=?;";
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			// preparedStatement.setInt(1, Team.getCheckId());
			preparedStatement.setInt(1, team.getTeamId());
			int flag = preparedStatement.executeUpdate(sql);
			if (flag > 0) {
				System.out.println(team.getCheckId());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 关闭Statement
			try {
				System.out.println("statement关闭");
				preparedStatement.close();
			} catch (Exception e) {
				System.out.println("statement关闭失败");
			}
			// 关闭Connection
			try {
				System.out.println("conn关闭");
				conn.close();
			} catch (Exception e) {
				System.out.println("conn关闭失败");
			}
		}
	}

	public boolean addTeam(String teamName, String buildTime, String construction) {
		String sql = "INSERT INTO team ( teamName, buildTime, construction ) " + "VALUES ( '" + teamName + "', '"
				+ buildTime + "', '" + construction + "' )";
		System.out.println(sql);
		try {
			// 获取数据库链接
			conn = util.openConnection();
			// 执行SQL1语句
			preparedStatement = conn.prepareStatement(sql);
			int row = preparedStatement.executeUpdate(sql);
			System.out.println(row);
			if (row == 1) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			// 关闭Statement
			try {
				System.out.println("statement关闭");
				preparedStatement.close();
			} catch (Exception e) {
				System.out.println("statement关闭失败");
			}
			// 关闭Connection
			try {
				System.out.println("conn关闭");
				conn.close();
			} catch (Exception e) {
				System.out.println("conn关闭失败");
			}
		}

		return false;
	}

	public boolean teamCheck(int teamId, int checkId) {
		String sql ="UPDATE club SET checkId="+checkId+" WHERE teamId="+teamId;
		System.out.println(sql);
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			int flag = preparedStatement.executeUpdate(sql);
			if (flag==1) {
				System.out.println(teamId);
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			// 关闭Statement
			try {
				System.out.println("statement关闭");
				preparedStatement.close();
			} catch (Exception e) {
				System.out.println("statement关闭失败");
			}
			// 关闭Connection
			try {
				System.out.println("conn关闭");
				conn.close();
			} catch (Exception e) {
				System.out.println("conn关闭失败");
			}
		}
		return false;
		
	}

}

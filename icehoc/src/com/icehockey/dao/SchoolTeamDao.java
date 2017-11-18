package com.icehockey.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.icehockey.entity.SchoolTeam;
import com.icehockey.util.DBUtil;

public class SchoolTeamDao {

	DBUtil util = new DBUtil();
	private ResultSet rs = null;
	private Connection conn = null;
	private SchoolTeam schoolTeam = null;
	private List<SchoolTeam> schoolTeams = null;
	private PreparedStatement preparedStatement = null;

	/**
	 * @param telephone
	 * @return SchoolTeam
	 * 
	 *         通过手机号码查找到SchoolTeam对象并返回
	 */
	public List<SchoolTeam> getSchoolsByNameString(String nameString) {
		schoolTeams = new ArrayList<SchoolTeam>();
		String sql = "SELECT * FROM schoolteam where teamName like '%" + nameString + "%';";
		System.out.println(sql);
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int teamId = rs.getInt("teamId"); // 校队编号
				String teamName = rs.getString("teamName"); // 校队名称
				String teamLogo = rs.getString("teamLogo"); // 校队LOGO
				String teamAddress = rs.getString("teamAddress"); // 校队地址
				Timestamp timestamp = rs.getTimestamp("buildTime");// 组建时间
				String buildTime = null;
				if (timestamp != null) {
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
					buildTime = df.format(timestamp.getTime());
				}
				String telephone = rs.getString("telephone"); // 联系方式
				String leaderName = rs.getString("leaderName"); // 领队
				String leaderTelephone = rs.getString("leaderTelephone"); // 领队联系方式
				String construction = rs.getString("construction"); // 球队建设
				String email = rs.getString("email"); // 电子邮件
				String remark = rs.getString("remark"); // 备注
				schoolTeam = new SchoolTeam(teamId, teamName, teamLogo, teamAddress, buildTime, telephone, leaderName,
						leaderTelephone, construction, email, remark);
				schoolTeams.add(schoolTeam);
			}
			return schoolTeams;
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

	public List<SchoolTeam> getSchoolTeams() {
		schoolTeams = new ArrayList<SchoolTeam>();
		String sql = "SELECT * FROM schoolteam;";
		System.out.println(sql);
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int teamId = rs.getInt("teamId"); // 校队编号
				String teamName = rs.getString("teamName"); // 校队名称
				String teamLogo = rs.getString("teamLogo"); // 校队LOGO
				String teamAddress = rs.getString("teamAddress"); // 校队地址
				Timestamp timestamp = rs.getTimestamp("buildTime");// 组建时间
				String buildTime = null;
				if (timestamp != null) {
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
					buildTime = df.format(timestamp.getTime());
				}
				String telephone = rs.getString("telephone"); // 联系方式
				String leaderName = rs.getString("leaderName"); // 领队
				String leaderTelephone = rs.getString("leaderTelephone"); // 领队联系方式
				String construction = rs.getString("construction"); // 球队建设
				String email = rs.getString("email"); // 电子邮件
				String remark = rs.getString("remark"); // 备注
				schoolTeam = new SchoolTeam(teamId, teamName, teamLogo, teamAddress, buildTime, telephone, leaderName,
						leaderTelephone, construction, email, remark);
				System.out.println(schoolTeam);
				schoolTeams.add(schoolTeam);
			}
			return schoolTeams;
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

	public SchoolTeam getSchoolTeamBySchoolTeamId(int schoolTeamId) {
		String sql = "SELECT * FROM schoolteam where teamId=?;";
		
		System.out.println(sql);
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, schoolTeamId);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				int teamId = rs.getInt("teamId"); // 校队编号
				String teamName = rs.getString("teamName"); // 校队名称
				String teamLogo = rs.getString("teamLogo"); // 校队LOGO
				String teamAddress = rs.getString("teamAddress"); // 校队地址
				Timestamp timestamp = rs.getTimestamp("buildTime");// 组建时间
				String buildTime = null;
				if (timestamp != null) {
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
					buildTime = df.format(timestamp.getTime());
				}
				String telephone = rs.getString("telephone"); // 联系方式
				String leaderName = rs.getString("leaderName"); // 领队
				String leaderTelephone = rs.getString("leaderTelephone"); // 领队联系方式
				String construction = rs.getString("construction"); // 球队建设
				String email = rs.getString("email"); // 电子邮件
				String remark = rs.getString("remark"); // 备注
				schoolTeam = new SchoolTeam(teamId, teamName, teamLogo, teamAddress, buildTime, telephone, leaderName,
						leaderTelephone, construction, email, remark);
				System.out.println(schoolTeam);
				return schoolTeam;
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

	public boolean addschoolTeam(String teamName, String buildTime, String construction) {
		String sql = "INSERT INTO schoolteam ( teamName, buildTime, construction ) " + "VALUES ( '" + teamName + "', '"
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

}

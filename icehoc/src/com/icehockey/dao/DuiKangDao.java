package com.icehockey.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.icehockey.entity.DuiKang;
import com.icehockey.util.DBUtil;

public class DuiKangDao {

	DBUtil util = new DBUtil();
	private ResultSet rs = null;
	private Connection conn = null;
	private DuiKang duikang = null;
	private PreparedStatement preparedStatement = null;

	/**
	 * @param telephone
	 * @return User
	 * 
	 *         返回用户关注的球员相关的赛事
	 */
	public List<DuiKang> getDuiKangsByUserId(int userId) {
		List<DuiKang> duiKangs = new ArrayList<DuiKang>();
		String sql = "SELECT * FROM duikang WHERE userId=?";
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, userId);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {

				int id = rs.getInt("id");
				String competitionName=rs.getString("competitionName");
				int teamAId = rs.getInt("teamAId");
				String clubAName = rs.getString("clubAName");
				String clubALogo = rs.getString("clubALogo");
				int teamBId = rs.getInt("teamBId");
				String clubBName = rs.getString("clubBName");
				String clubBLogo = rs.getString("clubBLogo");
				boolean competitionType = rs.getBoolean("competitionType");
				String remark = rs.getString("remark");
				int rinkId = rs.getInt("rinkId");
				Timestamp timestamp = rs.getTimestamp("pkDate");// 年月日星期几
				String pkDate = null;
				if (timestamp != null) {
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd EEEE");// 设置日期格式
					pkDate = df.format(timestamp.getTime());
				}
				System.out.println("pkDate:"+pkDate);
				timestamp = rs.getTimestamp("pkTime");// 年月日星期几
				String pkTime = null;
				if (timestamp != null) {
					SimpleDateFormat df = new SimpleDateFormat("HH:mm");// 设置日期格式
					pkTime = df.format(timestamp.getTime());
				}
				System.out.println("pkTime:"+pkTime);
				int competitionDegreeId = rs.getInt("competitionDegreeId");
				int round = rs.getInt("round");
				String rinkName = rs.getString("rinkName");
				String environmentalIndex = rs.getString("environmentalIndex");
				String address = rs.getString("address");
				userId = rs.getInt("userId");
				String competitionDegreeName = rs.getString("competitionDegreeName");
				duikang=new DuiKang(id, competitionName, teamAId, clubAName, clubALogo, teamBId, clubBName, clubBLogo, competitionType, remark, rinkId, pkDate, pkTime, competitionDegreeId, round, rinkName, environmentalIndex, address, userId, competitionDegreeName);
				System.out.println(duikang);
				duiKangs.add(duikang);
			}
			return duiKangs;
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
		return duiKangs;
	}

	public List<DuiKang> getDuiKangsByNameString(String nameString) {
		List<DuiKang> duiKangs = new ArrayList<DuiKang>();
		String sql = "SELECT * FROM duikang WHERE competitionName like '%"+nameString+"%';";
		System.out.println(sql);
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {

				int id = rs.getInt("id");
				String competitionName=rs.getString("competitionName");
				int teamAId = rs.getInt("teamAId");
				String clubAName = rs.getString("clubAName");
				String clubALogo = rs.getString("clubALogo");
				int teamBId = rs.getInt("teamBId");
				String clubBName = rs.getString("clubBName");
				String clubBLogo = rs.getString("clubBLogo");
				boolean competitionType = rs.getBoolean("competitionType");
				String remark = rs.getString("remark");
				int rinkId = rs.getInt("rinkId");
				Timestamp timestamp = rs.getTimestamp("pkDate");// 年月日星期几
				String pkDate = null;
				if (timestamp != null) {
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd EEEE");// 设置日期格式
					pkDate = df.format(timestamp.getTime());
				}
				System.out.println("pkDate:"+pkDate);
				timestamp = rs.getTimestamp("pkTime");// 年月日星期几
				String pkTime = null;
				if (timestamp != null) {
					SimpleDateFormat df = new SimpleDateFormat("HH:mm");// 设置日期格式
					pkTime = df.format(timestamp.getTime());
				}
				System.out.println("pkTime:"+pkTime);
				int competitionDegreeId = rs.getInt("competitionDegreeId");
				int round = rs.getInt("round");
				String rinkName = rs.getString("rinkName");
				String environmentalIndex = rs.getString("environmentalIndex");
				String address = rs.getString("address");
				int userId = rs.getInt("userId");
				String competitionDegreeName = rs.getString("competitionDegreeName");
				duikang=new DuiKang(id, competitionName, teamAId, clubAName, clubALogo, teamBId, clubBName, clubBLogo, competitionType, remark, rinkId, pkDate, pkTime, competitionDegreeId, round, rinkName, environmentalIndex, address, userId, competitionDegreeName);
				System.out.println(duikang);
				duiKangs.add(duikang);
			}
			return duiKangs;
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
		return duiKangs;
	}

	public List<DuiKang> getDuiKangsGuanFang() {
		List<DuiKang> duiKangs = new ArrayList<DuiKang>();
		String sql = "SELECT * FROM duikang WHERE competitionType=?";
		System.out.println(sql);
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setBoolean(1, true);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {

				int id = rs.getInt("id");
				String competitionName=rs.getString("competitionName");
				int teamAId = rs.getInt("teamAId");
				String clubAName = rs.getString("clubAName");
				String clubALogo = rs.getString("clubALogo");
				int teamBId = rs.getInt("teamBId");
				String clubBName = rs.getString("clubBName");
				String clubBLogo = rs.getString("clubBLogo");
				boolean competitionType = rs.getBoolean("competitionType");
				String remark = rs.getString("remark");
				int rinkId = rs.getInt("rinkId");
				Timestamp timestamp = rs.getTimestamp("pkDate");// 年月日星期几
				String pkDate = null;
				if (timestamp != null) {
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd EEEE");// 设置日期格式
					pkDate = df.format(timestamp.getTime());
				}
				System.out.println("pkDate:"+pkDate);
				timestamp = rs.getTimestamp("pkTime");// 年月日星期几
				String pkTime = null;
				if (timestamp != null) {
					SimpleDateFormat df = new SimpleDateFormat("HH:mm");// 设置日期格式
					pkTime = df.format(timestamp.getTime());
				}
				System.out.println("pkTime:"+pkTime);
				int competitionDegreeId = rs.getInt("competitionDegreeId");
				int round = rs.getInt("round");
				String rinkName = rs.getString("rinkName");
				String environmentalIndex = rs.getString("environmentalIndex");
				String address = rs.getString("address");
				int userId = rs.getInt("userId");
				String competitionDegreeName = rs.getString("competitionDegreeName");
				duikang=new DuiKang(id, competitionName, teamAId, clubAName, clubALogo, teamBId, clubBName, clubBLogo, competitionType, remark, rinkId, pkDate, pkTime, competitionDegreeId, round, rinkName, environmentalIndex, address, userId, competitionDegreeName);
				System.out.println(duikang);
				duiKangs.add(duikang);
			}
			return duiKangs;
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
		return duiKangs;
	}

	public DuiKang getDuiKangById(int id) {
		String sql = "SELECT * FROM duikang WHERE id=?";
		System.out.println(sql);
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {

				 id = rs.getInt("id");
				String competitionName=rs.getString("competitionName");
				int teamAId = rs.getInt("teamAId");
				String clubAName = rs.getString("clubAName");
				String clubALogo = rs.getString("clubALogo");
				int teamBId = rs.getInt("teamBId");
				String clubBName = rs.getString("clubBName");
				String clubBLogo = rs.getString("clubBLogo");
				boolean competitionType = rs.getBoolean("competitionType");
				String remark = rs.getString("remark");
				int rinkId = rs.getInt("rinkId");
				Timestamp timestamp = rs.getTimestamp("pkDate");// 年月日星期几
				String pkDate = null;
				if (timestamp != null) {
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd EEEE");// 设置日期格式
					pkDate = df.format(timestamp.getTime());
				}
				System.out.println("pkDate:"+pkDate);
				timestamp = rs.getTimestamp("pkTime");// 年月日星期几
				String pkTime = null;
				if (timestamp != null) {
					SimpleDateFormat df = new SimpleDateFormat("HH:mm");// 设置日期格式
					pkTime = df.format(timestamp.getTime());
				}
				System.out.println("pkTime:"+pkTime);
				int competitionDegreeId = rs.getInt("competitionDegreeId");
				int round = rs.getInt("round");
				String rinkName = rs.getString("rinkName");
				String environmentalIndex = rs.getString("environmentalIndex");
				String address = rs.getString("address");
				int userId = rs.getInt("userId");
				String competitionDegreeName = rs.getString("competitionDegreeName");
				duikang=new DuiKang(id, competitionName, teamAId, clubAName, clubALogo, teamBId, clubBName, clubBLogo, competitionType, remark, rinkId, pkDate, pkTime, competitionDegreeId, round, rinkName, environmentalIndex, address, userId, competitionDegreeName);
				System.out.println(duikang);
				return duikang;
			}
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
		return duikang;
	}

	public List<DuiKang> getDuiKangsAll() {
		List<DuiKang> duiKangs = new ArrayList<DuiKang>();
		String sql = "SELECT * FROM duikang";
		System.out.println(sql);
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String competitionName=rs.getString("competitionName");
				int teamAId = rs.getInt("teamAId");
				String clubAName = rs.getString("clubAName");
				String clubALogo = rs.getString("clubALogo");
				int teamBId = rs.getInt("teamBId");
				String clubBName = rs.getString("clubBName");
				String clubBLogo = rs.getString("clubBLogo");
				boolean competitionType = rs.getBoolean("competitionType");
				String remark = rs.getString("remark");
				int rinkId = rs.getInt("rinkId");
				Timestamp timestamp = rs.getTimestamp("pkDate");// 年月日星期几
				String pkDate = null;
				if (timestamp != null) {
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd EEEE");// 设置日期格式
					pkDate = df.format(timestamp.getTime());
				}
				System.out.println("pkDate:"+pkDate);
				timestamp = rs.getTimestamp("pkTime");// 年月日星期几
				String pkTime = null;
				if (timestamp != null) {
					SimpleDateFormat df = new SimpleDateFormat("HH:mm");// 设置日期格式
					pkTime = df.format(timestamp.getTime());
				}
				System.out.println("pkTime:"+pkTime);
				int competitionDegreeId = rs.getInt("competitionDegreeId");
				int round = rs.getInt("round");
				String rinkName = rs.getString("rinkName");
				String environmentalIndex = rs.getString("environmentalIndex");
				String address = rs.getString("address");
				int userId = rs.getInt("userId");
				String competitionDegreeName = rs.getString("competitionDegreeName");
				duikang=new DuiKang(id, competitionName, teamAId, clubAName, clubALogo, teamBId, clubBName, clubBLogo, competitionType, remark, rinkId, pkDate, pkTime, competitionDegreeId, round, rinkName, environmentalIndex, address, userId, competitionDegreeName);
				System.out.println(duikang);
				duiKangs.add(duikang);
			}
			return duiKangs;
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
		return duiKangs;
	}

}

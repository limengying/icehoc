package com.icehockey.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.icehockey.util.DBUtil;

public class CompetitionDao {

	DBUtil util = new DBUtil();
	private ResultSet rs = null;
	private Connection conn = null;
	private PreparedStatement preparedStatement = null;

	/**
	 * @param rinkId
	 * @param teamBId
	 * @param teamAId
	 * @param telephone
	 * @param remark
	 * @param b
	 * @return Competition
	 * 
	 *         通过手机号码查找到Competition对象并返回
	 */
	public boolean insertRe(int teamAId, int teamBId, int rinkId, String competitionTime, String remark,
			boolean competitionType) {
		String sql = "INSERT INTO competition (teamAId,teamBId,rinkId,competitionTime,competitionType,remark) VALUES (?,?,?,?,?,?)";
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, teamAId);
			preparedStatement.setInt(2, teamBId);
			preparedStatement.setInt(3, rinkId);
			preparedStatement.setString(4, competitionTime);
			preparedStatement.setBoolean(5, competitionType);
			preparedStatement.setString(6, remark);
			int i = preparedStatement.executeUpdate();
			if (i == 1) {
				System.out.println("插入成功");
				return true;
			} else
				return false;
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

		return false;
	}

	public boolean insertRe(String competitionName, String remark) {
		String sql = "INSERT INTO competition ( competitionName, remark) " + "VALUES ( '" + competitionName + "', '"
				+ remark + "' )";
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

	public boolean insertReGUANFANG(String competitionName, int teamAId, int teamBId, int rinkId, String competitionTime,
			String remark, boolean competitionType) {
		String sql = "INSERT INTO competition (competitionName,teamAId,teamBId,rinkId,competitionTime,competitionType,remark) VALUES (?,?,?,?,?,?,?)";
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, competitionName);
			preparedStatement.setInt(2, teamAId);
			preparedStatement.setInt(3, teamBId);
			preparedStatement.setInt(4, rinkId);
			preparedStatement.setString(5, competitionTime);
			preparedStatement.setBoolean(6, competitionType);
			preparedStatement.setString(7, remark);
			int i = preparedStatement.executeUpdate();
			if (i == 1) {
				System.out.println("插入成功");
				return true;
			} else
				return false;
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

		return false;
	}

	public boolean competitionCheck(int id, int checkId) {
		String sql ="UPDATE competition SET checkId="+checkId+" WHERE id="+id;
		System.out.println(sql);
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			int flag = preparedStatement.executeUpdate(sql);
			if (flag==1) {
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

package com.icehockey.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.icehockey.util.DBUtil;

public class StatisticDao {

	DBUtil util = new DBUtil();
	private ResultSet rs = null;
	private Connection conn = null;
	
	private PreparedStatement preparedStatement = null;

	/**
	 * @param dateString 
	 * @param telephone
	 * @return City
	 * 
	 *         通过手机号码查找到City对象并返回
	 */
	public boolean addRecord(int competitionId, int playerId, String attackingPosi, String guardType,
			String skatingType, String attackingType, String ballArmFace, String matchInTime, String isGoal, String dateString) {
		String sql = "INSERT INTO statistic (competitionId,playerId,attackingPosi,guardType,skatingType,attackingType,ballArmFace,matchInTime,isGoal,onDate) VALUES (?,?,?,?,?,?,?,?,?,?)";
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, competitionId);
			preparedStatement.setInt(2, playerId);
			preparedStatement.setString(3, attackingPosi);
			preparedStatement.setString(4, guardType);
			preparedStatement.setString(5, skatingType);
			preparedStatement.setString(6, attackingType);
			preparedStatement.setString(7, ballArmFace);
			preparedStatement.setString(8, matchInTime);
			preparedStatement.setString(9, isGoal);
			preparedStatement.setString(10, dateString);
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

	public boolean addZhuGongRecord(int competitionId, int playerId, String dateString) {
		String sql = "INSERT INTO statistic (competitionId,playerId,zhugong,onDate) VALUES (?,?,?,?)";
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, competitionId);
			preparedStatement.setInt(2, playerId);
			preparedStatement.setString(3, "1");
			preparedStatement.setString(4, dateString);
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

	public boolean addFanGuiRecord(int competitionId, int playerId, String dateString) {
		String sql = "INSERT INTO statistic (competitionId,playerId,fangui,onDate) VALUES (?,?,?,?)";
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, competitionId);
			preparedStatement.setInt(2, playerId);
			preparedStatement.setString(3, "1");
			preparedStatement.setString(4, dateString);
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

}

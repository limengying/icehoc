package com.icehockey.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.icehockey.entity.Handling;
import com.icehockey.util.DBUtil;

public class HandlingDao {
	Handling handling = null;
	DBUtil util = new DBUtil();
	private ResultSet rs = null;
	private Statement statement = null;
	private Connection conn = null;
	private PreparedStatement preparedStatement = null;

	public Handling getHandlingByHandlingValue(String handlingValue) {//通过持杆方式简称获取持杆方式对象
		String sql = "SELECT * FROM handling where handlingValue=?";
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, handlingValue);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				int handlingId = rs.getInt("handlingId");
				String handlingName = rs.getString("handlingName");
				String remark = rs.getString("remark");
				handling = new Handling(handlingId, handlingName, handlingValue, remark);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return handling;
	}

	public Handling getHandlingByHandlingId(int handlingId) {
		String sql = "SELECT * FROM handling where handlingId=?";
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, handlingId);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				String handlingValue = rs.getString("handlingValue");
				String handlingName = rs.getString("handlingName");
				String remark = rs.getString("remark");
				handling = new Handling(handlingId, handlingName, handlingValue, remark);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return handling;
	}

	public List<Handling> getHandlings() {
		List<Handling> handlings=new ArrayList<Handling>();
		String sql = "SELECT * FROM handling";
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int handlingId=rs.getInt("handlingId");
				String handlingValue = rs.getString("handlingValue");
				String handlingName = rs.getString("handlingName");
				String remark = rs.getString("remark");
				handling = new Handling(handlingId, handlingName, handlingValue, remark);
				handlings.add(handling);
			}
			return handlings;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return handlings;
	}
}

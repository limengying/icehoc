package com.icehockey.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.icehockey.entity.Error;
import com.icehockey.util.DBUtil;

public class ErrorDao {
	DBUtil util = new DBUtil();
	private ResultSet rs = null;
	private Statement statement = null;
	private Connection conn = null;
	private PreparedStatement preparedStatement = null;
	Error error=null;
	
	public boolean insertError(String errorName, String errorDesc,String contactInfo ) {//向error表中插入一条新的纪录
		String sql = "INSERT INTO error (errorName, errorDesc, contactInfo)VALUES (?,?,?)";
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, errorName);
			preparedStatement.setString(2, errorDesc);
			preparedStatement.setString(3, contactInfo);
			int i = preparedStatement.executeUpdate();
			if (i == 1) {
				System.out.println("插入成功");
				return true;
			} else
				System.out.println("插入失败");
			return false;

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
		return true;
	}
}

package com.icehockey.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.icehockey.entity.Check;
import com.icehockey.util.DBUtil;

public class CheckDao {

	DBUtil util = new DBUtil();
	private ResultSet rs = null;
	private Connection conn = null;
	private Check check = null;
	private PreparedStatement preparedStatement = null;

	public Check getCheckRecord(int flag, int flagNo) {
		String sql = "SELECT * FROM check WHERE check.flag = ? and check.flagNo = ?";
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, flag);
			preparedStatement.setInt(2, flagNo);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {

				int id = rs.getInt("id");
				// int flag = rs.getInt("flag");
				// int flagNo = rs.getInt("flagNo");
				String reason = rs.getString("reason");
				boolean checkReslut = rs.getBoolean("checkReslut");
				String checkDate = rs.getString("checkDate");
				int userId = rs.getInt("userId");
				String remark = rs.getString("remark");
				check = new Check(id, flag, flagNo, checkReslut, reason, checkDate, userId, remark);

				System.out.println(check);
				return check;
			} else {
				return null;
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
		return check;
	}

	public boolean addCheckRecord(Check check2) {
		try {
			// 获取数据库链接
			conn = util.openConnection();
			String sql1 = "INSERT INTO check (id, flag, flagNo, checkReslut, reason, checkDate, userId, remark)VALUES (" + check2.getId() + "," + check2.getFlag()
					+ "," + check2.getFlagNo()+ "," + check2.getCheckDate()+ "," + check2.getReason()+ "," + check2.getCheckDate()+ "," + check2.getUserId()+ "," + check2.getRemark() + ")";
			System.out.println("sql1:  " + sql1);
			// 执行SQL1语句
			preparedStatement = conn.prepareStatement(sql1);
			int row1 = preparedStatement.executeUpdate(sql1);
			if(row1==1){
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

	public boolean updateCheckRecord(int id, Check check2) {
		try {
			// 获取数据库链接
			conn = util.openConnection();
			String sql1 = "UPDATE check SET checkReslut = " + check2.isCheckReslut() + ", reason = " + check2.getReason()
					+ " ,checkDate =" + check2.getCheckDate()+ " , userId =" + check2.getUserId() + "WHERE id = " + id;
			System.out.println("sql1:  " + sql1);
			// 执行SQL1语句
			preparedStatement = conn.prepareStatement(sql1);
			int row1 = preparedStatement.executeUpdate(sql1);
			if(row1==1){
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

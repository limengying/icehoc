package com.icehockey.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.icehockey.entity.LoginLog;
import com.icehockey.util.DBUtil;

public class LoginLogDao {

	DBUtil util = new DBUtil();
	private ResultSet rs = null;
	private Connection conn = null;
	private LoginLog loginLog = null;
	private PreparedStatement preparedStatement = null;

	/**
	 * @param userId
	 * @return int
	 * 
	 *         返回签到次数
	 */
	public int getSignedNum(int userId) {
		String sql = "SELECT count(*) AS signedNum FROM loginlog WHERE userId = ? AND signed = TRUE";
		int num = -1;
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, userId);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				num = rs.getInt("signedNum"); // 城市编号
				return num;
			} else {
				return num;
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
		return num;
	}

	/**
	 * @param userId
	 * @param loginTime
	 * @param loginOffTime
	 * @param remark
	 * @return boolean
	 * 
	 *         添加一条记录
	 */
	public boolean addRecord(int userId, String loginTime, String loginOffTime, String remark) {
		String sql = "INSERT INTO loginlog (userId,loginTime,loginOffTime,remark) VALUES (?,?,?,?)";
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, userId);
			preparedStatement.setString(2, loginTime);
			preparedStatement.setString(3, loginOffTime);
			preparedStatement.setString(4, remark);
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

	/**
	 * @param id
	 * @return boolean
	 * 
	 *         添加一次签到
	 */
	public boolean updateUserSign(int id) {
		loginLog = getLoginLogById(id);
		if (loginLog != null) {
			try {
				// 获取数据库链接
				conn = util.openConnection();
				String sql = "UPDATE loginlog SET signed =1 WHERE id = " + id + ";";
				System.out.println("sql:  " + sql);
				// 执行SQL1语句
				preparedStatement = conn.prepareStatement(sql);
				int row1 = preparedStatement.executeUpdate(sql);
				System.out.println(row1);
				if (row1 == 1) {
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
		return false;
	}

	/**
	 * @param id
	 * @return LoginLog
	 * 
	 *         查找记录
	 */
	private LoginLog getLoginLogById(int id) {
		String sql = "SELECT * FROM loginlog WHERE id = ?;";
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				// int id=rs.getInt("id"); // 记录编号
				int userId = rs.getInt("userId"); // 用户编号
				String ipAddress = rs.getString("ipAddress"); // 登录IP地址
				boolean signed = rs.getBoolean("signed");// 是否签到
				String loginTime = rs.getString("loginTime"); // 登录时间
				String loginOffTime = rs.getString("loginOffTime"); // 登出时间
				String remark = rs.getString("remark"); // 备注
				loginLog = new LoginLog(id, userId, ipAddress, signed, loginTime, loginOffTime, remark);
				System.out.println(loginLog);
				return loginLog;
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
		return null;
	}

	public LoginLog getLogNewAddRecord(int userId, String loginTime) {
		String sql = "SELECT * FROM loginlog WHERE id = ( SELECT max(id) FROM loginlog WHERE userId = ? AND loginTime = ? );";
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, userId);
			preparedStatement.setString(2, loginTime);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("id"); // 记录编号
				// int userId=rs.getInt("userId"); // 用户编号
				String ipAddress = rs.getString("ipAddress"); // 登录IP地址
				boolean signed = rs.getBoolean("signed");// 是否签到
				// String loginTime=rs.getString("loginTime"); // 登录时间
				String loginOffTime = rs.getString("loginOffTime"); // 登出时间
				String remark = rs.getString("remark"); // 备注
				loginLog = new LoginLog(id, userId, ipAddress, signed, loginTime, loginOffTime, remark);
				return loginLog;
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
		return null;
	}

	public LoginLog getById(int loginLogId) {
		String sql = "SELECT * FROM loginlog WHERE id = ?;";
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, loginLogId);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("id"); // 记录编号
				int userId = rs.getInt("userId"); // 用户编号
				String ipAddress = rs.getString("ipAddress"); // 登录IP地址
				boolean signed = rs.getBoolean("signed");// 是否签到
				String loginTime=rs.getString("loginTime"); // 登录时间
				String loginOffTime = rs.getString("loginOffTime"); // 登出时间
				String remark = rs.getString("remark"); // 备注
				loginLog = new LoginLog(id, userId, ipAddress, signed, loginTime, loginOffTime, remark);
				return loginLog;
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
		return null;
	}

}

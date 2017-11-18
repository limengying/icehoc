package com.icehockey.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import com.icehockey.entity.User;
import com.icehockey.util.DBUtil;

public class UserDao {

	DBUtil util = new DBUtil();
	private ResultSet rs = null;
	private Connection conn = null;
	private User user = null;
	private PreparedStatement preparedStatement = null;

	/**
	 * @param telephone
	 * @return User
	 * 
	 *         通过手机号码查找到user对象并返回
	 */
	public User getUserByTelephone(String telephone) {
		String sql = "SELECT * FROM user WHERE user.telephone=?";
		System.out.println(sql);
		try {
			conn = util.openConnection();
			System.out.println(conn);
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, telephone);
			rs = preparedStatement.executeQuery();
			System.out.println(telephone);
			if (rs.next()) {
				int userId = rs.getInt("userId");// '用户编号',
				String userName = rs.getString("userName");// '用户姓名',
				String weChatId = rs.getString("weChatId");// '微信账号',
				String password = rs.getString("password");// '登录密码',
				String roleId = rs.getString("roleId");// '角色编号',
				boolean sex = rs.getBoolean("sex");// '性别',
				Timestamp timestamp = rs.getTimestamp("birthday");// '用户出生日期',
				String birthday = null;
				if (timestamp != null) {
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
					birthday = df.format(timestamp.getTime());
					System.out.println("birthdayDao" + birthday);
				}
				String idType = rs.getString("idType");// '证件类型',
				String idInfoId = rs.getString("idInfoId");// '证件类型编号',
				int countryId = rs.getInt("countryId");// '国籍编号',
				int cityId = rs.getInt("cityId");// '籍贯编号',
				String address = rs.getString("address");// '住址',
				timestamp = rs.getTimestamp("joinDate");
				String joinDate = null;
				if (timestamp != null) {
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
					joinDate = df.format(timestamp.getTime());
					System.out.println("joinDateDao" + joinDate);
				}
				String remark = rs.getString("remark");// '备注',
				user = new User(userId, userName, weChatId, telephone, password, roleId, sex, birthday, idType,
						idInfoId, countryId, cityId, address, joinDate, remark);
				System.out.println(user + "......DAO");
				return user;
			} else {
				System.out.println("dao层未找到");
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
		return user;
	}

	/**
	 * @param userId
	 * @return User
	 * 
	 *         通过userid查找用户并返回user对象
	 */
	public User getUserByUserId(int userId) {
		String sql = "SELECT * FROM user WHERE user.userId=?";
		System.out.println(sql);
		try {
			conn = util.openConnection();
			System.out.println(conn);
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, userId);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				String telephone = rs.getString("telephone");// '用户编号',
				String userName = rs.getString("userName");// '用户姓名',
				String weChatId = rs.getString("weChatId");// '微信账号',
				String password = rs.getString("password");// '登录密码',
				String roleId = rs.getString("roleId");// '角色编号',
				boolean sex = rs.getBoolean("sex");// '性别',
				Timestamp timestamp = rs.getTimestamp("birthday");// '用户出生日期',
				String birthday = null;
				if (timestamp != null) {
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
					birthday = df.format(timestamp.getTime());
					System.out.println("birthdayDao" + birthday);
				}
				String idType = rs.getString("idType");// '证件类型',
				String idInfoId = rs.getString("idInfoId");// '证件类型编号',
				int countryId = rs.getInt("countryId");// '国籍编号',
				int cityId = rs.getInt("cityId");// '籍贯编号',
				String address = rs.getString("address");// '住址',
				timestamp = rs.getTimestamp("joinDate");
				String joinDate = null;
				if (timestamp != null) {
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
					joinDate = df.format(timestamp.getTime());
					System.out.println("joinDateDao" + joinDate);
				}
				String remark = rs.getString("remark");// '备注',
				user = new User(userId, userName, weChatId, telephone, password, roleId, sex, birthday, idType,
						idInfoId, countryId, cityId, address, joinDate, remark);
				System.out.println(user + "......DAO");
				return user;
			} else {
				System.out.println("dao层未找到");
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
		return user;
	}

	/**
	 * @param telephone
	 * @return User
	 * 
	 *         通过手机号码,密码新建user对象并返回
	 */
	public User addUser(String telephone, String password) {
		String sql = "INSERT INTO user (telephone,password) VALUES (?,?)";
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, telephone);
			preparedStatement.setString(2, password);
			int i = preparedStatement.executeUpdate();
			if (i == 1) {
				System.out.println("插入成功");
				user = getUserByTelephone(telephone);
				return user;
			} else
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

	public boolean updateUser(int userId, String name, String birthday, String address) {
		user = getUserByUserId(userId);
		if (user != null) {
			try {
				// 获取数据库链接
				conn = util.openConnection();
				String sql = "UPDATE user SET userName ='" + name + "',birthday = '" + birthday + "',address = '"
						+ address + "' WHERE userId = " + userId + ";";
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

}

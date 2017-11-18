package com.icehockey.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import com.icehockey.entity.UserFollowPlayer;
import com.icehockey.util.DBUtil;

public class UserFollowPlayerDao {

	DBUtil util = new DBUtil();
	private ResultSet rs = null;
	private Connection conn = null;
	private PreparedStatement preparedStatement = null;

	UserFollowPlayer userFollowPlayer = null;

	/**
	 * @param userId
	 * @param playerId
	 * @return UserFollowPlayer
	 * 
	 *         通过手机号码查找到user对象并返回
	 */
	public UserFollowPlayer queryByUserIdPlayerId(int userId, int playerId) {
		String sql = "SELECT * FROM userfollowplayer WHERE userfollowplayer.userId = ? AND userfollowplayer.playerId = ?;";
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, userId);
			preparedStatement.setInt(2, playerId);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("id"); // 记录编号
				// int userId=rs.getInt("userId"); // 用户编号
				// int playerId=rs.getInt("playerId"); // 运动员编号
				Timestamp timestamp = rs.getTimestamp("followDate");// 关注时间,
				Date followDate = null;
				if (timestamp != null) {
					followDate = new Date(timestamp.getTime());
				}
				timestamp = rs.getTimestamp("cancelDate");// 接触绑定时间,
				Date cancelDate = null;
				if (timestamp != null) {
					cancelDate = new Date(timestamp.getTime());
				}
				String remark = rs.getString("remark"); // 备注
				userFollowPlayer = new UserFollowPlayer(id, userId, playerId, followDate, cancelDate, remark);
				return userFollowPlayer;
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

	/**
	 * @param userId
	 * @param playerId
	 * @return UserFollowPlayer
	 * 
	 *         通过手机号码查找到user对象并返回
	 */
	public UserFollowPlayer queryById(int id) {
		String sql = "SELECT * FROM userfollowplayer WHERE id = ?";
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				id = rs.getInt("id"); // 记录编号
				int userId = rs.getInt("userId"); // 用户编号
				int playerId = rs.getInt("playerId"); // 运动员编号
				Timestamp timestamp = rs.getTimestamp("followDate");// 关注时间,
				Date followDate = null;
				if (timestamp != null) {
					followDate = new Date(timestamp.getTime());
				}
				timestamp = rs.getTimestamp("cancelDate");// 接触绑定时间,
				Date cancelDate = null;
				if (timestamp != null) {
					cancelDate = new Date(timestamp.getTime());
				}
				String remark = rs.getString("remark"); // 备注
				userFollowPlayer = new UserFollowPlayer(id, userId, playerId, followDate, cancelDate, remark);
				return userFollowPlayer;
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

	public boolean updateRe(int id, String dateString) {
		String sql = "UPDATE userfollowplayer SET cancelDate=? WHERE id=?;";
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, dateString);
			preparedStatement.setInt(2, id);
			int i = preparedStatement.executeUpdate();
			if (i == 1) {
				System.out.println("插入成功");
				userFollowPlayer = queryById(id);
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

	public boolean updateRe2(int id, String followDateString, String cancelDateString) {
		String sql = "UPDATE userfollowplayer SET followDate=? and cancelDate=? WHERE id=?;";
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, followDateString);
			preparedStatement.setString(2, cancelDateString);
			preparedStatement.setInt(3, id);
			int i = preparedStatement.executeUpdate();
			if (i == 1) {
				System.out.println("插入成功");
				userFollowPlayer = queryById(id);
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

	public boolean insertRe(int userId, int playerId, String followDateString) {
		String sql = "INSERT INTO userfollowplayer ( userfollowplayer.userId, userfollowplayer.playerId, userfollowplayer.followDate ) VALUES ( "
				+ userId + ", " + playerId + ", '" + followDateString + "' );";
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
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

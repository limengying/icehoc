package com.icehockey.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.icehockey.entity.Player;
import com.icehockey.util.DBUtil;

public class PlayerDao {

	DBUtil util = new DBUtil();
	private ResultSet rs = null;
	private Connection conn = null;
	private Player player = null;
	private List<Player> players = null;
	private PreparedStatement preparedStatement = null;

	/**
	 * @param userId
	 * @return List<Player>
	 * 
	 *         通过用户编号找到用户关注的球员列表
	 */
	public List<Player> getPlayersUserFollowed(int userId) {
		players = new ArrayList<Player>();
		String sql = "SELECT player.* FROM player, userfollowplayer, `user` WHERE player.playerId = userfollowplayer.playerId AND"
				+ " `user`.userId = userfollowplayer.userId AND userfollowplayer.cancelDate = '1900-01-01 00:00:00' AND `user`.userId = ?";
		System.out.println(sql);
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, userId);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {

				int playerId = rs.getInt("playerId"); // 运动员编号
				String name = rs.getString("name"); // 姓名
				boolean sex = rs.getBoolean("sex"); // 性别
				Timestamp timestamp = rs.getTimestamp("birthday");// '出生日期',
				String birthday = null;
				if (timestamp != null) {
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
					birthday = df.format(timestamp.getTime());
				}

				double height = rs.getDouble("height"); // 身高
				double weight = rs.getDouble("weight"); // 体重
				int countryId = rs.getInt("countryId"); // 国籍编号
				int cityId = rs.getInt("cityId"); // 籍贯编号
				double firstLearnAge = rs.getDouble("firstLearnAge"); // 初学年龄
				int roleId = rs.getInt("roleId"); // 角色编号
				int handlingId = rs.getInt("handlingId"); // 持杆方式编号
				String idType = rs.getString("idType"); // 证件类型
				String idInfoId = rs.getString("idInfoId"); // 证件信息编号
				int categoryId = rs.getInt("categoryId"); // 类别编号
				String position = rs.getString("position"); // 位置
				int creatMeld = rs.getInt("creatMeld"); // 谁创建我
				String image = rs.getString("image"); // 头像
				timestamp = rs.getTimestamp("modificateDate");// 修改时间
				String modificateDate = null;
				if (timestamp != null) {
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
					modificateDate = df.format(timestamp.getTime());
				}
				String remark = rs.getString("remark"); // 备注

				player = new Player(playerId, name, sex, birthday, height, weight, countryId, cityId, firstLearnAge,
						roleId, handlingId, idType, idInfoId, categoryId, position, creatMeld, image, modificateDate,
						remark);
				players.add(player);
			}
			return players;
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
		return players;
	}

	/**
	 * @param userId
	 *            用户编号
	 * @param playerNameString
	 *            球员名字字符串
	 * @return List<Player>
	 * 
	 *         通过用户编号和球员名字字符串，模糊查询找到用户关注的球员列表
	 */
	public List<Player> getPlayersUserFollowedByNameString(int userId, String playerNameString) {
		players = new ArrayList<Player>();
		String sql = "SELECT player.* FROM player, userfollowplayer, user WHERE player.playerId = userfollowplayer.playerId AND `user`.userId = userfollowplayer.userId AND `user`.userId = "
				+ userId + " AND player.`name` like '%" + playerNameString + "%';";
		System.out.println(sql);
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {

				int playerId = rs.getInt("playerId"); // 运动员编号
				String name = rs.getString("name"); // 姓名
				boolean sex = rs.getBoolean("sex"); // 性别
				Timestamp timestamp = rs.getTimestamp("birthday");// '出生日期',
				String birthday = null;
				if (timestamp != null) {
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
					birthday = df.format(timestamp.getTime());
				}

				double height = rs.getDouble("height"); // 身高
				double weight = rs.getDouble("weight"); // 体重
				int countryId = rs.getInt("countryId"); // 国籍编号
				int cityId = rs.getInt("cityId"); // 籍贯编号
				double firstLearnAge = rs.getDouble("firstLearnAge"); // 初学年龄
				int roleId = rs.getInt("roleId"); // 角色编号
				int handlingId = rs.getInt("handlingId"); // 持杆方式编号
				String idType = rs.getString("idType"); // 证件类型
				String idInfoId = rs.getString("idInfoId"); // 证件信息编号
				int categoryId = rs.getInt("categoryId"); // 类别编号
				String position = rs.getString("position"); // 位置
				int creatMeld = rs.getInt("creatMeld"); // 谁创建我
				String image = rs.getString("image"); // 头像
				timestamp = rs.getTimestamp("modificateDate");// 修改时间
				String modificateDate = null;
				if (timestamp != null) {
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
					modificateDate = df.format(timestamp.getTime());
				}
				String remark = rs.getString("remark"); // 备注

				player = new Player(playerId, name, sex, birthday, height, weight, countryId, cityId, firstLearnAge,
						roleId, handlingId, idType, idInfoId, categoryId, position, creatMeld, image, modificateDate,
						remark);
				players.add(player);
			}
			return players;
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
		return players;
	}

	/**
	 * @param userId
	 *            用户编号
	 * @param playerName
	 *            球员名字
	 * @return List<Player>
	 * 
	 *         通过用户编号和球员名字字符串，精确查询找到用户关注的球员列表
	 */
	public List<Player> getPlayersByPlayerName(String playerName) {
		players = new ArrayList<Player>();
		String sql = "SELECT * FROM player WHERE player. name = ?;";
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, playerName);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {

				int playerId = rs.getInt("playerId"); // 运动员编号
				String name = rs.getString("name"); // 姓名
				boolean sex = rs.getBoolean("sex"); // 性别
				Timestamp timestamp = rs.getTimestamp("birthday");// '出生日期',
				String birthday = null;
				if (timestamp != null) {
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
					birthday = df.format(timestamp.getTime());
				}

				double height = rs.getDouble("height"); // 身高
				double weight = rs.getDouble("weight"); // 体重
				int countryId = rs.getInt("countryId"); // 国籍编号
				int cityId = rs.getInt("cityId"); // 籍贯编号
				double firstLearnAge = rs.getDouble("firstLearnAge"); // 初学年龄
				int roleId = rs.getInt("roleId"); // 角色编号
				int handlingId = rs.getInt("handlingId"); // 持杆方式编号
				String idType = rs.getString("idType"); // 证件类型
				String idInfoId = rs.getString("idInfoId"); // 证件信息编号
				int categoryId = rs.getInt("categoryId"); // 类别编号
				String position = rs.getString("position"); // 位置
				int creatMeld = rs.getInt("creatMeld"); // 谁创建我
				String image = rs.getString("image"); // 头像
				timestamp = rs.getTimestamp("modificateDate");// 修改时间
				String modificateDate = null;
				if (timestamp != null) {
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
					modificateDate = df.format(timestamp.getTime());
				}
				String remark = rs.getString("remark"); // 备注

				player = new Player(playerId, name, sex, birthday, height, weight, countryId, cityId, firstLearnAge,
						roleId, handlingId, idType, idInfoId, categoryId, position, creatMeld, image, modificateDate,
						remark);
				players.add(player);
			}
			return players;
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
		return players;
	}

	public Player getPlayersByPlayerName1(String playerName) {
		String sql = "SELECT * FROM player WHERE player. name = ?;";
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, playerName);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {

				int playerId = rs.getInt("playerId"); // 运动员编号
				String name = rs.getString("name"); // 姓名
				boolean sex = rs.getBoolean("sex"); // 性别
				Timestamp timestamp = rs.getTimestamp("birthday");// '出生日期',
				String birthday = null;
				if (timestamp != null) {
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
					birthday = df.format(timestamp.getTime());
				}

				double height = rs.getDouble("height"); // 身高
				double weight = rs.getDouble("weight"); // 体重
				int countryId = rs.getInt("countryId"); // 国籍编号
				int cityId = rs.getInt("cityId"); // 籍贯编号
				double firstLearnAge = rs.getDouble("firstLearnAge"); // 初学年龄
				int roleId = rs.getInt("roleId"); // 角色编号
				int handlingId = rs.getInt("handlingId"); // 持杆方式编号
				String idType = rs.getString("idType"); // 证件类型
				String idInfoId = rs.getString("idInfoId"); // 证件信息编号
				int categoryId = rs.getInt("categoryId"); // 类别编号
				String position = rs.getString("position"); // 位置
				int creatMeld = rs.getInt("creatMeld"); // 谁创建我
				String image = rs.getString("image"); // 头像
				timestamp = rs.getTimestamp("modificateDate");// 修改时间
				String modificateDate = null;
				if (timestamp != null) {
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
					modificateDate = df.format(timestamp.getTime());
				}
				String remark = rs.getString("remark"); // 备注

				player = new Player(playerId, name, sex, birthday, height, weight, countryId, cityId, firstLearnAge,
						roleId, handlingId, idType, idInfoId, categoryId, position, creatMeld, image, modificateDate,
						remark);
			}
			return player;
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
		return player;
	}

	/**
	 * 通过userId等参数新建一个player 插入新用户，首先判断前端传入的角色名称，持杆方式名称是否存在，如果都存在，则插入，返回是否插入成功
	 */
	public Player addPlayerCascand(int userId, boolean sex, double height, double weight, int categoryId,
			int handlingId, String playerName, String imageUrl, String dateString, String idNo) {
		int i = addPlayer(userId, sex, height, weight, categoryId, handlingId, playerName, imageUrl, dateString, idNo);
		if (i == 1) {
			try {
				player = getPlayerByIdNo(idNo);
				// 获取数据库链接
				conn = util.openConnection();
				// 开启事务,不把其设置为true之前都是一个当作一个事务来处理
				conn.setAutoCommit(false);

				String sql2 = "INSERT INTO idinfo ( idinfo.flag, idinfo.playerId, idinfo.idNo ) VALUES (0, "
						+ player.getPlayerId() + ", '" + idNo + "');";
				String sql3 = "INSERT INTO userfollowplayer ( userfollowplayer.userId, userfollowplayer.playerId, userfollowplayer.followDate ) VALUES ( "
						+ userId + ", " + player.getPlayerId() + ", '" + dateString + "' );";
				System.out.println("sql2:  " + sql2);

				// 执行SQL2语句
				preparedStatement = conn.prepareStatement(sql2);
				int row2 = preparedStatement.executeUpdate(sql2);
				System.out.println(row2);

				// 执行SQL3语句
				preparedStatement = conn.prepareStatement(sql3);

				int row3 = preparedStatement.executeUpdate(sql3);
				System.out.println(row3);
				// 提交事务
				conn.commit();
				System.out.println(player);
				return player;
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("有错误！");
				try {
					// 回滚事务,撤销上面对事务的所有操作哈！
					conn.rollback();
					System.out.println("事物回滚");
				} catch (Exception e2) {
					System.out.println("事物回滚失败");
				}
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
		}
		return null;
	}

	public int addPlayer(int userId, boolean sex, double height, double weight, int categoryId, int handlingId,
			String playerName, String imageUrl, String dateString, String idNo) {
		try {
			// 获取数据库链接
			conn = util.openConnection();
			String sql1 = "INSERT INTO player (player.name,player.sex,player.height,player.weight,player.categoryId, player.handlingId,player.image,player.modificateDate,player.idInfoId,player.creatMeld) "
					+ "VALUES ('" + playerName + "', " + sex + ", " + height + ", " + weight + ", " + categoryId + ", "
					+ handlingId + ", '" + imageUrl + "',' " + dateString + "', '" + idNo + "', " + userId + ");";
			System.out.println("sql1:  " + sql1);
			// 执行SQL1语句
			preparedStatement = conn.prepareStatement(sql1);
			int row1 = preparedStatement.executeUpdate(sql1);
			System.out.println(row1);
			return row1;
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
		return 0;
	}

	public Player getPlayerByIdNo(String idNo) {
		String sql = "SELECT * FROM player WHERE idInfoId = ?;";
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, idNo);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				int playerId = rs.getInt("playerId"); // 运动员编号
				String name = rs.getString("name"); // 姓名
				boolean sex = rs.getBoolean("sex"); // 性别
				Timestamp timestamp = rs.getTimestamp("birthday");// '出生日期',
				String birthday = null;
				if (timestamp != null) {
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
					birthday = df.format(timestamp.getTime());
				}

				double height = rs.getDouble("height"); // 身高
				double weight = rs.getDouble("weight"); // 体重
				int countryId = rs.getInt("countryId"); // 国籍编号
				int cityId = rs.getInt("cityId"); // 籍贯编号
				double firstLearnAge = rs.getDouble("firstLearnAge"); // 初学年龄
				int roleId = rs.getInt("roleId"); // 角色编号
				int handlingId = rs.getInt("handlingId"); // 持杆方式编号
				String idType = rs.getString("idType"); // 证件类型
				String idInfoId = rs.getString("idInfoId"); // 证件信息编号
				int categoryId = rs.getInt("categoryId"); // 类别编号
				String position = rs.getString("position"); // 位置
				int creatMeld = rs.getInt("creatMeld"); // 谁创建我
				String image = rs.getString("image"); // 头像
				timestamp = rs.getTimestamp("modificateDate");// 修改时间
				String modificateDate = null;
				if (timestamp != null) {
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
					modificateDate = df.format(timestamp.getTime());
				}
				String remark = rs.getString("remark"); // 备注

				player = new Player(playerId, name, sex, birthday, height, weight, countryId, cityId, firstLearnAge,
						roleId, handlingId, idType, idInfoId, categoryId, position, creatMeld, image, modificateDate,
						remark);
			}
			return player;
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

	public Player getPlayerById(int playerId) {
		String sql = "SELECT * FROM player WHERE playerId = ?;";
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, playerId);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				// int playerId = rs.getInt("playerId"); // 运动员编号
				String name = rs.getString("name"); // 姓名
				boolean sex = rs.getBoolean("sex"); // 性别
				Timestamp timestamp = rs.getTimestamp("birthday");// '出生日期',
				String birthday = null;
				if (timestamp != null) {
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
					birthday = df.format(timestamp.getTime());
				}

				double height = rs.getDouble("height"); // 身高
				double weight = rs.getDouble("weight"); // 体重
				int countryId = rs.getInt("countryId"); // 国籍编号
				int cityId = rs.getInt("cityId"); // 籍贯编号
				double firstLearnAge = rs.getDouble("firstLearnAge"); // 初学年龄
				int roleId = rs.getInt("roleId"); // 角色编号
				int handlingId = rs.getInt("handlingId"); // 持杆方式编号
				String idType = rs.getString("idType"); // 证件类型
				String idInfoId = rs.getString("idInfoId"); // 证件信息编号
				int categoryId = rs.getInt("categoryId"); // 类别编号
				String position = rs.getString("position"); // 位置
				int creatMeld = rs.getInt("creatMeld"); // 谁创建我
				String image = rs.getString("image"); // 头像
				timestamp = rs.getTimestamp("modificateDate");// 修改时间
				String modificateDate = null;
				if (timestamp != null) {
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
					modificateDate = df.format(timestamp.getTime());
				}
				String remark = rs.getString("remark"); // 备注

				player = new Player(playerId, name, sex, birthday, height, weight, countryId, cityId, firstLearnAge,
						roleId, handlingId, idType, idInfoId, categoryId, position, creatMeld, image, modificateDate,
						remark);
			}
			return player;
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

	public boolean updatePlayerInfo(int playerId, double weight, double height, String position, int categoryId,
			int handlingId, String birthday, String image, String modificateDate) {
		player = getPlayerById(playerId);
		if (player != null) {
			try {
				// 获取数据库链接
				conn = util.openConnection();
				String sql = "UPDATE player SET weight = " + weight + ",height = " + height + ",position ='" + position
						+ "',categoryId =" + categoryId + ",handlingId = " + handlingId + ",birthday = '" + birthday
						+ "',image = '" + image + "',modificateDate = '" + modificateDate + "' WHERE playerId = "
						+ playerId + ";";
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

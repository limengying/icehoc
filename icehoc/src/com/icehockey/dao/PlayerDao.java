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

	public List<Player> getAllFollowPlayers(int userId) {
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

	public Player getPlayerByPlayerId(int playerId) {
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

	public List<Player> getFollowPlayersByStr(int userId, String nameStr) {
		players = new ArrayList<Player>();
		String sql = "SELECT player.* FROM player, userfollowplayer, user WHERE player.playerId = userfollowplayer.playerId AND `user`.userId = userfollowplayer.userId AND `user`.userId = "
				+ userId + " AND userfollowplayer.cancelDate='1900-01-01 00:00:00' AND player.`name` like '%" + nameStr
				+ "%';";
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

	public Player getFollowPlayerByPlayerId(int userId, int playerId) {
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

	public int updateFollowPlayer(int userId, int playerId, String followdateString, String canceldateString) {
		try {
			// 获取数据库链接
			conn = util.openConnection();
			String sql1 = "UPDATE userFollowPlayer SET userFollowPlayer.followDate = " + followdateString
					+ ",userFollowPlayer.cancelDate = " + canceldateString + "WHERE userFollowPlayer.userId = " + userId
					+ " AND userfollowplayer.playerId = " + playerId;
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

	public int insertFollowPlayer(int userId, int playerId, String followdateString) {
		try {
			// 获取数据库链接
			conn = util.openConnection();
			String sql1 = "INSERT INTO userFollowPlayer (userId,playerId,followDate)VALUES (" + userId + "," + playerId
					+ "," + followdateString + ")";
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

	public int cancelFollowPlayer(int userId, int playerId, String canceldateString) {
		try {
			// 获取数据库链接
			conn = util.openConnection();
			String sql1 = "UPDATE userFollowPlayer SET userFollowPlayer.cancelDate =" + canceldateString
					+ " WHERE userFollowPlayer.userId =" + userId + " AND userfollowplayer.playerId =" + playerId;
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

	public int updatePlayerInfo(Player player2) {
		try {
			// 获取数据库链接
			conn = util.openConnection();
			String sql1 = "UPDATE Player SET NAME = " + player2.getName() + ", sex = " + player2.isSex()
					+ " ,birthday =" + player2.getBirthday() + " , height =" + player2.getHeight() + ",weight ="
					+ player2.getWeight() + ",handlingId = " + player2.getHandlingId() + ", countryId ="
					+ player2.getCountryId() + ",cityId = " + player2.getCityId() + ",firstLearnAge ="
					+ player2.getFirstLearnAge() + ", handlingId= " + player2.getHandlingId() + ",categoryId="
					+ player2.getCategoryId() + ",position=" + player2.getPosition() + ",image=" + player2.getImage()
					+ ",remark=" + player2.getRemark() + ",modificateDate=" + player2.getModificateDate()
					+ "WHERE playerId = " + player2.getPlayerId();
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

	public int addPlayer(Player player2) {
		try {
			// 获取数据库链接
			conn = util.openConnection();
			String sql1 = "INSERT INTO player(name,sex,weight,height,categoryId,handlingId,image,idInfoId,modificateDate) VALUES("
					+ player2.isSex() + "," + player2.getWeight() + "," + player2.getWeight() + ","
					+ player2.getCategoryId() + "," + player2.getHandlingId() + "," + player2.getImage() + ","
					+ player2.getIdInfoId() + "," + player2.getModificateDate() + ")";
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

	public int addPlayerIdNoRecord(int playerId, String idInfoId) {
		try {
			// 获取数据库链接
			conn = util.openConnection();
			String sql1 = "INSERT INTO idInfo(playerId,idNo)VALUES (" + playerId + "," + idInfoId + ")";
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

	public List<Player> getPlayersByPlayerName(String name) {

		players = new ArrayList<Player>();
		String sql = "SELECT * FROM player WHERE name=" + name;
		System.out.println(sql);
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {

				int playerId = rs.getInt("playerId"); // 运动员编号
				name = rs.getString("name"); // 姓名
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

}

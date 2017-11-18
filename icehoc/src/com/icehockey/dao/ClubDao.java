package com.icehockey.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.icehockey.entity.Club;
import com.icehockey.util.DBUtil;

public class ClubDao {

	DBUtil util = new DBUtil();
	private ResultSet rs = null;
	private Connection conn = null;
	private Club club = null;
	private PreparedStatement preparedStatement = null;

	/**
	 * @param telephone
	 * @return Club
	 * 
	 *         通过手机号码查找到Club对象并返回
	 */
	public Club getClubByPlayerId(int playerId) {
		String sql = "SELECT club.* FROM club, playerclub WHERE club.clubId = playerclub.clubId AND club.buildTime = '1900-01-01 00:00:00' AND playerclub.playerId = ?";
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, playerId);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {

				int clubId = rs.getInt("clubId"); // 俱乐部编号
				String clubName = rs.getString("clubName"); // 俱乐部名称
				String clubLogo = rs.getString("clubLogo"); // 俱乐部LOGO
				String organization = rs.getString("organization"); // 俱乐部所属机构
				String address = rs.getString("address"); // 官方地址
				Timestamp timestamp = rs.getTimestamp("buildTime");// 成立时间
				String buildTime = null;
				if (timestamp != null) {
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
					buildTime = df.format(timestamp.getTime());
				}
				int countryId = rs.getInt("countryId"); // 国籍编号
				int cityId = rs.getInt("cityId"); // 城市编号
				String managerContent = rs.getString("managerContent"); // 经营内容
				String email = rs.getString("email"); // 电子邮件
				String construction = rs.getString("construction"); // 球队建设
				String province = rs.getString("province"); // 省份
				String remark = rs.getString("remark"); // 备注

				club = new Club(clubId, clubName, clubLogo, organization, address, buildTime, countryId, cityId,
						managerContent, email, construction, province, remark);
				System.out.println(club);

				return club;
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
		return club;
	}

	public List<Club> getClubs() {
		List<Club> clubs = new ArrayList<Club>();
		String sql = "SELECT * FROM club;";
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int clubId = rs.getInt("clubId"); // 城市编号
				String clubName = rs.getString("clubName"); // 俱乐部名称
				String clubLogo = rs.getString("clubLogo"); // 俱乐部LOGO
				String organization = rs.getString("organization"); // 俱乐部所属机构
				String address = rs.getString("address"); // 官方地址
				Timestamp timestamp = rs.getTimestamp("buildTime");// 成立时间
				String buildTime = null;
				if (timestamp != null) {
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
					buildTime = df.format(timestamp.getTime());
				}
				int countryId = rs.getInt("countryId"); // 国籍编号
				int cityId = rs.getInt("cityId"); // 城市编号
				String managerContent = rs.getString("managerContent"); // 经营内容
				String email = rs.getString("email"); // 电子邮件
				String construction = rs.getString("construction"); // 球队建设
				String province = rs.getString("provinceId"); // 省份
				String remark = rs.getString("remark"); // 备注

				club = new Club(clubId, clubName, clubLogo, organization, address, buildTime, countryId, cityId,
						managerContent, email, construction, province, remark);
				System.out.println(club);
				clubs.add(club);

			}
			return clubs;
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
		return clubs;
	}

	public List<Club> queryClubWithNameString(String nameString) {
		List<Club> clubs = new ArrayList<Club>();
		String sql = "SELECT * FROM club where clubName like '%" + nameString + "%';";
		System.out.println(sql);
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int clubId = rs.getInt("clubId"); // 城市编号
				String clubName = rs.getString("clubName"); // 俱乐部名称
				String clubLogo = rs.getString("clubLogo"); // 俱乐部LOGO
				String organization = rs.getString("organization"); // 俱乐部所属机构
				String address = rs.getString("address"); // 官方地址
				Timestamp timestamp = rs.getTimestamp("buildTime");// 成立时间
				String buildTime = null;
				if (timestamp != null) {
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
					buildTime = df.format(timestamp.getTime());
				}
				int countryId = rs.getInt("countryId"); // 国籍编号
				int cityId = rs.getInt("cityId"); // 城市编号
				String managerContent = rs.getString("managerContent"); // 经营内容
				String email = rs.getString("email"); // 电子邮件
				String construction = rs.getString("construction"); // 球队建设
				String province = rs.getString("provinceId"); // 省份
				String remark = rs.getString("remark"); // 备注

				club = new Club(clubId, clubName, clubLogo, organization, address, buildTime, countryId, cityId,
						managerContent, email, construction, province, remark);
				System.out.println(club);
				clubs.add(club);

			}
			return clubs;
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
		return clubs;
	}

	public Club queryClubByClubId(int clubId) {
		String sql = "SELECT * FROM club where clubId=?;";
		System.out.println(sql);
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, clubId);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				clubId = rs.getInt("clubId"); // 城市编号
				String clubName = rs.getString("clubName"); // 俱乐部名称
				String clubLogo = rs.getString("clubLogo"); // 俱乐部LOGO
				String organization = rs.getString("organization"); // 俱乐部所属机构
				String address = rs.getString("address"); // 官方地址
				Timestamp timestamp = rs.getTimestamp("buildTime");// 成立时间
				String buildTime = null;
				if (timestamp != null) {
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
					buildTime = df.format(timestamp.getTime());
				}
				int countryId = rs.getInt("countryId"); // 国籍编号
				int cityId = rs.getInt("cityId"); // 城市编号
				String managerContent = rs.getString("managerContent"); // 经营内容
				String email = rs.getString("email"); // 电子邮件
				String construction = rs.getString("construction"); // 球队建设
				String province = rs.getString("provinceId"); // 省份
				String remark = rs.getString("remark"); // 备注

				club = new Club(clubId, clubName, clubLogo, organization, address, buildTime, countryId, cityId,
						managerContent, email, construction, province, remark);
				System.out.println(club);
				return club;

			}
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

	public boolean addClub(String clubName, String buildTime, String construction) {
		String sql = "INSERT INTO club ( clubName, buildTime, construction ) " + "VALUES ( '" + clubName + "', '"
				+ buildTime + "', '" + construction + "' )";
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

}

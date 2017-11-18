package com.icehockey.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.icehockey.entity.City;
import com.icehockey.util.DBUtil;

public class CityDao {

	DBUtil util = new DBUtil();
	private ResultSet rs = null;
	private Connection conn = null;
	private City city = null;
	private PreparedStatement preparedStatement = null;

	/**
	 * @param telephone
	 * @return City
	 * 
	 *         通过手机号码查找到City对象并返回
	 */
	public City getCity(int cityId) {
		String sql = "SELECT * FROM city WHERE city.cityId = ?";
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, cityId);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {

				cityId = rs.getInt("cityId"); // 城市编号
				String cityName = rs.getString("cityName");// 城市名称
				int pId = rs.getInt("pId"); // 城市编号
				int cId = rs.getInt("cId"); // 城市编号
				int countryId = rs.getInt("countryId"); // 城市编号
				String remark = rs.getString("remark"); // 备注
				city = new City(cityId, cityName, pId, cId, countryId, remark);
				System.out.println(city);
				return city;
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
		return city;
	}

}

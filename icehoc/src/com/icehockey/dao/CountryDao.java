package com.icehockey.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.icehockey.entity.Country;
import com.icehockey.util.DBUtil;

public class CountryDao {

	DBUtil util = new DBUtil();
	private ResultSet rs = null;
	private Connection conn = null;
	private Country country = null;
	private PreparedStatement preparedStatement = null;

	/**
	 * @param telephone
	 * @return Country
	 * 
	 *         通过手机号码查找到Country对象并返回
	 */
	public Country getCountry(int countryId) {
		String sql = "SELECT * FROM country WHERE country.countryId = ?";
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, countryId);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				 //int countryId=rs.getInt("countryId"); // 国籍编号
				 String code=rs.getString("code"); // 编码
				 String nameChinese=rs.getString("nameChinese"); // 中文
				 String nameEnglish=rs.getString("nameEnglish"); // 英文
				 String remark=rs.getString("remark"); // 备注
				 country=new Country(countryId, code, nameChinese, nameEnglish, remark);
				 System.out.println(country);
				return country;
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
		return country;
	}

	
}

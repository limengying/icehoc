package com.icehockey.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.icehockey.entity.Category;
import com.icehockey.util.DBUtil;

public class CategoryDao {
	Category category = null;
	DBUtil util = new DBUtil();
	private ResultSet rs = null;
	private Statement statement = null;
	private Connection conn = null;
	private PreparedStatement preparedStatement = null;

	public Category getCategoryByCategoryValue(String categoryValue) {// 通过CategoryValue获取角色对象
		String sql = "SELECT * FROM Category where remark=?;";
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, categoryValue);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				int categoryId = rs.getInt("categoryId"); // 类别编号
				String categoryName = rs.getString("categoryName"); // 类别名称
				String remark = rs.getString("remark"); // 备注
				category = new Category(categoryId, categoryName, remark);
				return category;
			} else {
				System.out.println("该角色不存在");
				category = null;
			}

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
		return category;
	}

	public Category getCategoryByCategoryId(int categoryId) {
		String sql = "SELECT * FROM Category where categoryId=?;";
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, categoryId);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				categoryId = rs.getInt("categoryId"); // 类别编号
				String categoryName = rs.getString("categoryName"); // 类别名称
				String remark = rs.getString("remark"); // 备注
				category = new Category(categoryId, categoryName, remark);
				return category;
			} else {
				System.out.println("该类别不存在");
				category = null;
			}

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
		return category;
	}

	public List<Category> getCategorys() {
		List<Category> categories = new ArrayList<Category>();
		String sql = "SELECT * FROM category ;";
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int categoryId = rs.getInt("categoryId"); // 类别编号
				String categoryName = rs.getString("categoryName"); // 类别名称
				String remark = rs.getString("remark"); // 备注
				category = new Category(categoryId, categoryName, remark);
				categories.add(category);

			}
			return categories;

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
		return categories;
	}
}

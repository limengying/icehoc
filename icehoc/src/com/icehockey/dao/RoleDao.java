package com.icehockey.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.icehockey.entity.Role;
import com.icehockey.util.DBUtil;

public class RoleDao {

	DBUtil util = new DBUtil();
	private ResultSet rs = null;
	private Connection conn = null;
	private Role role = null;
	private PreparedStatement preparedStatement = null;

	/**
	 * @param telephone
	 * @return Role
	 * 
	 *         通过手机号码查找到Role对象并返回
	 */
	public Role getRoleByRoleId(int roleId) {
		String sql = "SELECT * FROM role WHERE role.roleId = ?";
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, roleId);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				// int roleId =rs.getInt("roleId"); // 角色编号
				String roleName = rs.getString("roleName"); // 角色名称
				String roleValue = rs.getString("roleValue"); // 简称
				String remark = rs.getString("remark"); // 备注
				role = new Role(roleId, roleName, roleValue, remark);
				return role;

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
		return role;
	}

}

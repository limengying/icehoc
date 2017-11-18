package com.icehockey.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.icehockey.entity.IdInfo;
import com.icehockey.util.DBUtil;

public class IdInfoDao {

	DBUtil util = new DBUtil();
	private ResultSet rs = null;
	private Connection conn = null;
	private PreparedStatement preparedStatement = null;
	private IdInfo idInfo = null;

	/**
	 * @param IdNo
	 * @return User
	 * 
	 *         通过身份证号码查找到记录对象并返回
	 */
	public IdInfo getIdInfoByIdNo(String idNo) {
		String sql = "SELECT * FROM idinfo WHERE idNo=?";
		try {
			conn = util.openConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, idNo);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {

				int idInfoId = rs.getInt("idInfoId"); // 记录编号
				int flag = rs.getInt("flag"); // 标志位
				int playerId = rs.getInt("playerId"); // 运动员编号
				int coachId = rs.getInt("coachId"); // 教练员编号
				int judgerId = rs.getInt("judgerId"); // 裁判员编号
				String frontPhoto = rs.getString("frontPhoto"); // 正面照片
				String reversePhoto = rs.getString("reversePhoto"); // 反面照片
				String remark = rs.getString("remark"); // 备注

				idInfo = new IdInfo(idInfoId, flag, playerId, coachId, judgerId, idNo, frontPhoto, reversePhoto,
						remark);
				return idInfo;
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
		return idInfo;
	}
}

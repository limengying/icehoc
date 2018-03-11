package com.icehockey.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.icehockey.dao.PlayerDao;
import com.icehockey.entity.Player;
import com.icehockey.util.FileUtil;

public class PlayerService {

	PlayerDao playerMapper=new PlayerDao();

	public List<Player> getAllFollowPlayers(int userId) {
		List<Player> players = new ArrayList<Player>();
		players = playerMapper.getAllFollowPlayers(userId);
		return players;
	}

	public Player getPlayerByPlayerId(int playerId) {
		Player player = playerMapper.getPlayerByPlayerId(playerId);
		return player;
	}

	public List<Player> getPlayersByPlayerName(String name) {
		List<Player> players = new ArrayList<Player>();
		players = playerMapper.getPlayersByPlayerName(name);
		return players;
	}

	public List<Player> getFollowPlayersByStr(int userId, String nameStr) {
		List<Player> players = new ArrayList<Player>();
		players = playerMapper.getFollowPlayersByStr(userId, nameStr);
		return players;
	}

	public boolean addFollowPlayer(int userId, int playerId) {
		// 现根据用户编号，员工原编号查询是否之前关注过，
		// 1.若已关注过则能查出一条用户
		// 修改关注时间为当前时间，取消关注时间为1900-01-01 00:00:00
		// 2.否则将此用户和运动员相关联插入一条新信息
		// 修改关注时间为当前时间，取消关注时间为1900-01-01 00:00:00
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		Date currentDateTime = new Date();
		System.out.println(df.format(currentDateTime));// new Date()为获取当前系统时间
		String followdateString = df.format(currentDateTime);
		Player player = playerMapper.getFollowPlayerByPlayerId(userId, playerId);
		if (player != null) {
			String canceldateString = "1900-01-01 00:00:00";
			int i = playerMapper.updateFollowPlayer(userId, playerId, followdateString, canceldateString);
			if (i == 1) {
				return true;
			}
		} else {
			int i = playerMapper.insertFollowPlayer(userId, playerId, followdateString);
			if (i == 1) {
				return true;
			}
		}
		return false;
	}

	public boolean cancelFollowPlayer(int userId, int playerId) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		Date currentDateTime = new Date();
		System.out.println(df.format(currentDateTime));// new Date()为获取当前系统时间
		String canceldateString = df.format(currentDateTime);
		int i = playerMapper.cancelFollowPlayer(userId, playerId, canceldateString);
		if (i == 1) {
			return true;
		}
		return false;
	}

	public boolean updatePlayerInfo(Player player) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		Date currentDateTime = new Date();
		System.out.println(df.format(currentDateTime));// new Date()为获取当前系统时间
		String followDateString = df.format(currentDateTime);
		player.setModificateDate(followDateString);

		String picturePath = FileUtil.savePicture(player.getImage(), "player");
		player.setImage(picturePath);
		int i = playerMapper.updatePlayerInfo(player);
		if (i == 1) {
			return true;
		}
		return false;
	}

	public boolean addPlayer1(int userId, Player player) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		Date currentDateTime = new Date();
		System.out.println(df.format(currentDateTime));// new Date()为获取当前系统时间
		String followDateString = df.format(currentDateTime);

		player.setCreatMeld(userId);
		player.setModificateDate(followDateString);
		// 存储头像到某个文件夹
		String picturePath = FileUtil.savePicture(player.getImage(), "player");
		player.setImage(picturePath);
		// 插入数据库
		int i1 = playerMapper.addPlayer(player);
		int playerId = player.getPlayerId();
		System.out.println(playerId + "aaaaaaaaaaa");
		int i2 = playerMapper.addPlayerIdNoRecord(playerId, player.getIdInfoId());
		System.out.println(playerId);
		int i3 = playerMapper.insertFollowPlayer(userId, playerId, followDateString);

		if (i1 == 1 && i2 == 1 && i3 == 1) {
			return true;
		}
		return false;
	}

	public Player getPlayerByIdNo(String idInfoId) {
		Player player = playerMapper.getPlayerByIdNo(idInfoId);
		System.out.println(player+"getPlayerByIdNo");
		return player;
	}
	/**
	 * 通过userId等参数新建一个player 插入新用户，首先判断前端传入的角色名称，持杆方式名称是否存在，如果都存在，则插入，返回是否插入成功
	 */
	public Player insertNewPlayer(int userId, boolean gender, double height, double weight, int categoryId,
			int handlingId, String userName, String imageUrl, String idNo) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		Date currentDateTime = new Date();
		System.out.println(df.format(currentDateTime));// new Date()为获取当前系统时间
		String dateString = df.format(currentDateTime);
		Player player = playerMapper.addPlayerCascand(userId, gender, height, weight, categoryId, handlingId, userName, imageUrl,
				dateString, idNo);
		return player;
	}
}

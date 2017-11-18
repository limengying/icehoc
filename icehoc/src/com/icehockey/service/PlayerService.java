package com.icehockey.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.icehockey.dao.PlayerDao;
import com.icehockey.dao.UserDao;
import com.icehockey.entity.Player;
import com.icehockey.entity.User;
import com.icehockey.entity.UserFollowPlayer;

public class PlayerService {

	UserFollowPlayerService followPlayerService = new UserFollowPlayerService();

	List<User> users = null;// 声明一个User集合
	List<Player> players = null;// 声明一个Player集合

	UserDao dao = new UserDao();
	PlayerDao playerDao = new PlayerDao();

	Player player = null;// 声明一个Player对象
	UserFollowPlayer userFollowPlayer = null;

	/**
	 * @param userId
	 *            用户编号
	 * 
	 *            返回用户关注的球员
	 */
	public List<Player> getUserFollowedPlayers(int userId) {
		players = playerDao.getPlayersUserFollowed(userId);
		if (players != null) {
			System.out.println(players);
		} else {
			System.out.println("getUserFollowedPlayers.....PlayerService......null");
			players = null;
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
	public List<Player> getUserFollowedPlayersByNameString(int userId, String playerNameString) {
		players = playerDao.getPlayersUserFollowedByNameString(userId, playerNameString);
		if (players != null) {
			System.out.println(players);
		} else {
			System.out.println("getUserFollowedPlayersByNameString.....PlayerService......null");
			players = null;
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
	public Player getUserFollowedPlayersByPlayerName(int userId, String playerName) {
		player = playerDao.getPlayersByPlayerName1(playerName);
		if (player != null) {
			System.out.println(player);
		} else {
			System.out.println("getUserFollowedPlayersByPlayerName.....PlayerService......null");
			player = null;
		}
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
		player = playerDao.addPlayerCascand(userId, gender, height, weight, categoryId, handlingId, userName, imageUrl,
				dateString, idNo);
		return player;
	}

	/**
	 * @param playerId
	 *            远动员编号
	 * 
	 * @return Player
	 * 
	 *         通过远动员编号，查询远动员信息
	 */
	public Player getPlayerByPlayerId(int playerId) {
		return playerDao.getPlayerById(playerId);
	}

	/**
	 * @param userId
	 *            用户编号
	 * @param playerId
	 *            远动员编号
	 * 
	 * @return boolean
	 * 
	 *         通过用户编号，球员编号，取消对某远动员的关注
	 */
	public boolean cancelFollowed(int userId, int playerId) {
		userFollowPlayer = followPlayerService.query(userId, playerId);
		boolean f = false;
		if (userFollowPlayer != null) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
			Date currentDateTime = new Date();
			System.out.println(df.format(currentDateTime));// new
															// Date()为获取当前系统时间
			String dateString = df.format(currentDateTime);
			f = followPlayerService.updateRecord(userFollowPlayer.getId(), dateString);
			return f;
		}
		return false;
	}

	/**
	 * @param userId
	 *            用户编号
	 * @param playerId
	 *            远动员编号
	 * 
	 * @return boolean
	 * 
	 *         通过用户编号，球员编号，对某远动员的关注 先查找该用户是否之前已经关注了远动员，或者关注了之后又取消关注了，
	 *         1.如果之前已经关注了并且没有取消关注，则返回已关注
	 *         2.如果之前曾经关注过，但是已经取消关注，此时我们设置关注时间为当前时间，取消关注时间为1900-01-01 00:00:00
	 *         3.如果该用户从未关注过此运动员，则插入一条新纪录，即用户关注远动员，关注时间为当前时间
	 */
	public UserFollowPlayer userFollowPlayer(int userId, int playerId) {
		userFollowPlayer = followPlayerService.query(userId, playerId);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		Date currentDateTime = new Date();
		System.out.println(df.format(currentDateTime));// 获取当前系统时间
		String followDateString = df.format(currentDateTime);
		boolean f = false;
		if (userFollowPlayer == null) {
			// 插入新纪录
			f = followPlayerService.addFollowRecord(userId, playerId, followDateString);
			if (f == true) {
				userFollowPlayer = followPlayerService.query(userId, playerId);
				userFollowPlayer.setRemark(userFollowPlayer.getFollowDate() + "第一次关注");
				return userFollowPlayer;
			} else {
				return null;
			}
		} else {
			if ("1900-01-01 00:00:00".equals(userFollowPlayer.getCancelDate())) {
				System.out.println("关注时间：" + userFollowPlayer.getFollowDate());
				System.out.println("已关注");
				userFollowPlayer.setRemark(userFollowPlayer.getFollowDate() + "时，已关注！！");
				System.out.println(userFollowPlayer);
				return userFollowPlayer;
			} else {// 曾经关注过，并且已经取消关注,修改记录，注时间为当前时间，取消关注时间为1900-01-01 00:00:00
				f = followPlayerService.reFollow(userFollowPlayer.getId(), followDateString, "1900-01-01 00:00:00");// 重新关注
				if (f == true) {
					userFollowPlayer = followPlayerService.query(userId, playerId);
					userFollowPlayer.setRemark(userFollowPlayer.getFollowDate() + "重新关注");
					return userFollowPlayer;
				} else {
					return null;
				}
			}

		}
	}

	public boolean updateInfo( int playerId, double weight, double height, String position,
			int categoryId, int handlingId, String birthday, String image) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		Date currentDateTime = new Date();
		System.out.println(df.format(currentDateTime));// 获取当前系统时间
		String modificateDate = df.format(currentDateTime);
		boolean f=playerDao.updatePlayerInfo(playerId, weight, height, position, categoryId,
				handlingId, birthday, image,modificateDate);
		return f;
	}

	public Player getPlayerByPlayerIdNo(String idNo) {
		return playerDao.getPlayerByIdNo(idNo);
	}

}

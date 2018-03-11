package com.icehockey.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.icehockey.dao.UserDao;
import com.icehockey.entity.Category;
import com.icehockey.entity.Handling;
import com.icehockey.entity.LoginLog;
import com.icehockey.entity.Player;
import com.icehockey.entity.User;

public class UserService {

	UserDao dao = new UserDao();
	List<User> users = null;// 声明一个User集合
	User user = null;// 声明一个User对象
	Player player = null;
	LoginLog loginLog = null;

	CategoryService categoryService = new CategoryService();
	HandlingService handlingService = new HandlingService();
	PlayerService playerService = new PlayerService();
	LoginLogService loginLogService = new LoginLogService();

	/**
	 * 
	 * // 通过手机号和密码登录
	 */
	public User loginByTelepone(String telephone, String password) {
		user = dao.getUserByTelephone(telephone);// 先通过手机号查找到用户封装成User返回
		if (user != null) {// 判断如果找到该手机号的用户
			if (password.equals(user.getPassword())) {// 如果密码正确
				System.out.println("loginByTelepone.....登录成功");
				return user;
			} else {// 密码错误，则给此用户Id赋值为-1
				System.out.println("loginByTelepone.....密码错误");
				user = new User();
				user.setUserId(-1);
			}
		} else {// 用户不存在，即登录失败
			System.out.println("loginByTelepone.....该用户不存在");
			user = null;
		}
		return user;
	}

	public int addLoginRecord(int loginUserId, String s) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		Date currentDateTime = new Date();
		System.out.println(df.format(currentDateTime));// new Date()为获取当前系统时间
		String dateString = df.format(currentDateTime);
		boolean f = loginLogService.addLoginLog(loginUserId, dateString, s);
		if (f) {
			loginLog = loginLogService.getLogNewAdd(loginUserId, dateString);
		}
		if (loginLog != null) {
			return loginLog.getId();
		}
		return -1;
	}

	/**
	 * 
	 * // 通过手机号和密码注册
	 */
	public User Register(String telephone, String password) {
		user = dao.getUserByTelephone(telephone);
		if (user == null) {
			user = dao.addUser(telephone, password);
			if (user == null) {
				System.out.println("插入失败");

			} else {
				user.setRemark("注册成功");
				System.out.println("注册成功");
			}
		} else {
			user.setRemark("该用户已存在");
			System.out.println("该用户已存在");
		}
		System.out.println(user);
		return user;
	}

	/**
	 * 通过userId等参数新建一个player 插入新用户，首先判断前端传入的角色名称，持杆方式名称是否存在，如果都存在，则插入，返回是否插入成功
	 */
	public String insertNewPlayer(int userId, boolean gender, double height, double weight, String categoryValue,
			String handlingValue, String userName, String imageUrl, String idNo) {
		// 查找身份证号是否已经存在
		String state = "";
		if (playerService.getPlayerByIdNo(idNo) == null) {
			Category category = categoryService.queryCategory(categoryValue);// 查询当前类别名称是否在数据库中有对应的项
			if (category == null) {
				state = categoryValue + "类别未找到";
				System.out.println(categoryValue + "类别未找到");
				return state;
			}
			Handling handling = handlingService.queryHandling(handlingValue);// 根据持杆方式名称查询持杆方式对象
			if (handling == null) {
				state = handlingValue + "持杆方式未找到";
				System.out.println(handlingValue + "持杆方式未找到");
				return state;
			}
			Player player2 = new Player();
			player2.setSex(gender);
			player2.setHeight(height);
			player2.setWeight(weight);
			player2.setCategoryId(category.getCategoryId());
			player2.setHandlingId(handling.getHandlingId());
			player2.setName(userName);
			player2.setImage(imageUrl);
			player2.setIdInfoId(idNo);
			player = playerService.insertNewPlayer(userId, gender, height, weight, category.getCategoryId(),
					handling.getHandlingId(), userName, imageUrl, idNo);// 执行插入动作，并返回是否插入成功
			if (player!=null) {
				state = "创建成功";
				System.out.println("创建成功");
			} else {
				state = "新建球员失败";
				System.out.println("新建球员失败");
			}
			return state;
		} else {
			state = "身份证号码已存在";
			System.out.println("身份证号码已存在");
			return state;
		}
	}

	/**
	 * 通过userId等参数新建一个player 插入新用户，首先判断前端传入的角色名称，持杆方式名称是否存在，如果都存在，则插入，返回是否插入成功
	 */
	public User queryUserById(int userId) {
		user = dao.getUserByUserId(userId);
		return user;
	}

	/**
	 * 通过userId等参数新建一个player 插入新用户，首先判断前端传入的角色名称，持杆方式名称是否存在，如果都存在，则插入，返回是否插入成功
	 */
	public boolean updateUser(int userId, String name, String birthday, String address) {
		return dao.updateUser(userId, name, birthday, address);

	}

	/**
	 * 签到
	 */
	public boolean sign(int loginLogid) {
		return loginLogService.sign(loginLogid);
	}
}

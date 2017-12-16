package com.icehockey.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.icehockey.dao.StatisticDao;

public class StatisticService {
	StatisticDao statisticDao = new StatisticDao();

	public boolean addRecord(int competitionId, int playerId, String attackingPosi, String guardType,
			String skatingType, String attackingType, String ballArmFace, String matchInTime, String isGoal) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		Date currentDateTime = new Date();
		System.out.println(df.format(currentDateTime));// new Date()为获取当前系统时间
		String dateString = df.format(currentDateTime);
		return statisticDao.addRecord(competitionId, playerId, attackingPosi, guardType, skatingType, attackingType,
				ballArmFace, matchInTime, isGoal, dateString);
	}

	public boolean addZhuGongRecord(int competitionId, int playerId, String string) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		Date currentDateTime = new Date();
		System.out.println(df.format(currentDateTime));// new Date()为获取当前系统时间
		String dateString = df.format(currentDateTime);
		return statisticDao.addZhuGongRecord(competitionId, playerId, dateString);
	}

	public boolean addFanGuiRecord(int competitionId, int playerId, String string) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		Date currentDateTime = new Date();
		System.out.println(df.format(currentDateTime));// new Date()为获取当前系统时间
		String dateString = df.format(currentDateTime);
		return statisticDao.addFanGuiRecord(competitionId, playerId, dateString);
	}
}

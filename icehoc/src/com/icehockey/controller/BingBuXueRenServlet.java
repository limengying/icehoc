package com.icehockey.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.icehockey.entity.Match;
import com.icehockey.entity.Player;
import com.icehockey.entity.User;
import com.icehockey.service.MatchService;
import com.icehockey.service.PlayerService;
import com.icehockey.service.StatisticService;

/**
 * Servlet implementation class BingBuXueRenServlet
 */
@WebServlet("/BingBuXueRenServlet")
public class BingBuXueRenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BingBuXueRenServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		PrintWriter writer = response.getWriter();
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("-----------------冰步雪刃后台程序----------");

		MatchService matchService = new MatchService();
		PlayerService playerService = new PlayerService();
		StatisticService statisticService = new StatisticService();

		User user = null;
		Player player = null;
		List<Player> players = null;
		List<Match> matchs = null;
		
		System.out.println("跳转后的sessionId :" + session.getId());
		String operateType = null;
		// session
		if (session.getAttribute("user") == null) {
			map.put("result", "-1");// 没有用户登录
		} else {
			user = (User) session.getAttribute("user");
			if (request.getParameter("operateType") != null) {
				operateType = request.getParameter("operateType");
				if ("zhukongToBingBuXueRen".equals(operateType)) {// 如果操作类型是主控页面到浇冰必拜主页面，则取出场地表中的所有场地信息
					players = playerService.getAllFollowPlayers(user.getUserId());
					System.out.println(players);
					session.setAttribute("players", players);
					map.put("result", "0");
					map.put("ok", "1");

				} else if ("xiayibu".equals(operateType)) {// 如果操作类型是下一步
					int playerId = Integer.parseInt(request.getParameter("playerId"));
					player = playerService.getPlayerByPlayerId(playerId);
					if (player.getCategoryId() == 901) {
						map.put("query", "1");// 球员
					} else if (player.getCategoryId() == 902) {
						map.put("query", "2");// 守门员
					} else {
						map.put("query", "3");// 未查到类别
					}
					session.setAttribute("player", player);
					String competitionType = request.getParameter("competitionType");
					matchs = matchService.getAllUserFollowCompetition(user.getUserId());
					session.setAttribute("playerId", playerId);
					session.setAttribute("matchs", matchs);
					session.setAttribute("competitionType", competitionType);
					map.put("matchs", matchs);
					map.put("result", "0");
					map.put("ok", "2");
				} else if ("shujvcaijixuanzesaishi".equals(operateType)) {// 如果操作类型是数据采集-赛事选择
					int competitionId = Integer.parseInt(request.getParameter("competitionId"));

					if (session.getAttribute("player") != null) {
						player = (Player) session.getAttribute("player");
						if (player.getCategoryId() == -2) {
							map.put("query", "3");// 未查到类别
						}
					} else {
						map.put("query", "4");// 未查到球员
					}
					session.setAttribute("competitionId", competitionId);
					map.put("competitionId", competitionId);
					map.put("result", "0");
					map.put("ok", "3");

				} else if ("bingmianxuandian".equals(operateType)) {// 如果操作类型是数据采集-赛事选择
					String type = request.getParameter("type");
					int competitionId = (int) session.getAttribute("competitionId");// 赛事编号
					int playerId = (int) session.getAttribute("playerId");// 球员编号
					player = playerService.getPlayerByPlayerId(playerId);
					if (player.getCategoryId() == 901) {
						map.put("query", "1");// 球员
					} else if (player.getCategoryId() == 902) {
						map.put("query", "2");// 守门员
					}
					if ("shemen".equals(type)) {// 跳转至射门页面
						map.put("tiaozhuan", "1");
						map.put("result", "0");
						map.put("ok", "4");
					} else if ("zhugong".equals(type)) {// 插入一条助攻记录
						boolean f = statisticService.addZhuGongRecord(competitionId, playerId, "1");
						if (f) {
							map.put("tiaozhuan", "2");
							map.put("result", "0");
							map.put("ok", "4");
						} else {
							map.put("result", "-3");
						}
					} else {// 插入一条犯规记录
						boolean f = statisticService.addFanGuiRecord(competitionId, playerId, "1");
						if (f) {
							map.put("tiaozhuan", "2");
							map.put("result", "0");
							map.put("ok", "4");
						} else {
							map.put("result", "-3");
						}
					}
				} else if ("lurumenjiangshujv".equals(operateType)) {// 如果操作类型是数据采集-赛事选择
					int competitionId = (int) session.getAttribute("competitionId");// 赛事编号
					int playerId = (int) session.getAttribute("playerId");// 球员编号
					String attackingPosi = request.getParameter("bingqiurushefangwei");// 冰球入射方位
					String guardType = request.getParameter("menjiangfangshoufangshi");// 门将防守方式
					String skatingType = request.getParameter("menjiangyidong");// 门将移动方式
					String attackingType = request.getParameter("qiuyuanjingong");// 球员进攻方式
					String ballArmFace = request.getParameter("zhengganfangan");// 正杆反杆
					String matchInTime = request.getParameter("bisaijieduan");// 比赛阶段
					String isGoal = request.getParameter("jinqiushifou");// 是否进球
					boolean f = statisticService.addRecord(competitionId, playerId, attackingPosi, guardType,
							skatingType, attackingType, ballArmFace, matchInTime, isGoal);
					if (f) {
						map.put("result", "0");
						map.put("ok", "5");
					} else {
						map.put("result", "-3");
					}
				}
			} else {
				map.put("result", "-2");// 没有操作类型
			}
		}

		// 根据result值，判断页面如何跳转
		if ("0".equals(map.get("result"))) {// 登录成功，且不是第一次登陆
			System.out.println("页面操作正确");
			if ("1".equals(map.get("ok"))) {
				writer.println(
						"<script language='javascript'>window.location.href='./views/part6/bingbuxuerenzhuyemian.jsp'</script>");
			} else if ("2".equals(map.get("ok"))) {
				if ("3".equals(map.get("query"))) {
					writer.println(
							"<script language='javascript'>alert('该远动员角色不是球员或者守门员，请前往添兵添将修改！');window.location.href='./views/part6/bingbuxuerenzhuyemian.jsp'</script>");
				} else {
					writer.println(
							"<script language='javascript'>window.location.href='./views/part6/saishixuanze.jsp'</script>");
				}
			} else if ("3".equals(map.get("ok"))) {
				writer.println(
						"<script language='javascript'>window.location.href='./views/part6/bingmianxuandian.jsp'</script>");
			} else if ("4".equals(map.get("ok"))) {
				if ("2".equals(map.get("tiaozhuan"))) {
					writer.println(
							"<script language='javascript'>window.location.href='./views/part6/bingmianxuandian.jsp'</script>");
				} else {
					if ("1".equals(map.get("query"))) {
						writer.println(
								"<script language='javascript'>window.location.href='./views/part6/qiuyuanjishutongji.jsp'</script>");
					} else if ("2".equals(map.get("query"))) {
						writer.println(
								"<script language='javascript'>window.location.href='./views/part6/menjiangjishutongji.jsp'</script>");
					}
				}
			} else if ("5".equals(map.get("ok"))) {
				writer.println(
						"<script language='javascript'>alert('射门记录录入成功！');window.location.href='./views/part6/bingmianxuandian.jsp'</script>");
			}
		} else if ("-1".equals(map.get("result"))) {// 登陆失败，用户名不存在
			writer.println(
					"<script language='javascript'>alert('当前没有登录用户');window.location.href='./views/part1/zhucedengluyemian.jsp'</script>");
		} else if ("-2".equals(map.get("result"))) {// 前端错误
			writer.println(
					"<script language='javascript'>alert('前端错误');window.location.href='./views/error/qianduanError.jsp'</script>");
		} else if ("-3".equals(map.get("result"))) {// 插入失败
			writer.println(
					"<script language='javascript'>alert('插入失败');window.location.href='./views/error/insertError.jsp'</script>");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

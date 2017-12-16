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

import com.icehockey.entity.Club;
import com.icehockey.entity.DuiKang;
import com.icehockey.entity.Player;
import com.icehockey.entity.Rink;
import com.icehockey.entity.SaiShiInfo;
import com.icehockey.entity.User;
import com.icehockey.service.ClubService;
import com.icehockey.service.CompetitionService;
import com.icehockey.service.DuiKangService;
import com.icehockey.service.PlayerService;
import com.icehockey.service.RinkService;
import com.icehockey.service.SaiShiInfoService;

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

		DuiKangService duiKangService = new DuiKangService();
		ClubService clubService = new ClubService();
		RinkService rinkService = new RinkService();
		PlayerService playerService = new PlayerService();
		CompetitionService competitionService = new CompetitionService();
		SaiShiInfoService saiShiInfoService = new SaiShiInfoService();

		User user = null;
		Player player = null;
		List<Player> players = null;
		List<SaiShiInfo> saiShiInfos = null;
		List<DuiKang> duiKangs = null;
		List<Club> clubs = null;
		List<Rink> rinks = null;
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
					players = playerService.getUserFollowedPlayers(user.getUserId());
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
					duiKangs = duiKangService.getDuiKangs(user.getUserId());
					session.setAttribute("playerId", playerId);
					session.setAttribute("duiKangs", duiKangs);
					session.setAttribute("competitionType", competitionType);
					map.put("duiKangs", duiKangs);
					map.put("result", "0");
					map.put("ok", "2");

				} else if ("shujvcaijixuanzesaishi".equals(operateType)) {// 如果操作类型是数据采集-赛事选择
					int competitionId = Integer.parseInt(request.getParameter("competitionId"));
					if (session.getAttribute("player") != null) {
						player = (Player) session.getAttribute("player");
						if (player.getCategoryId() == 901) {
							map.put("query", "1");// 球员
						} else if (player.getCategoryId() == 902) {
							map.put("query", "2");// 守门员
						} else {
							map.put("query", "3");// 未查到类别
						}

					} else {
						map.put("query", "4");// 未查到球员
					}
					session.setAttribute("competitionId", competitionId);
					map.put("competitionId", competitionId);
					map.put("result", "0");
					map.put("ok", "3");

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
					writer.println("<script language='javascript'>alert('该远动员角色不是球员或者守门员，请前往添兵添将修改！');</script>");
				}
				writer.println(
						"<script language='javascript'>window.location.href='./views/part6/saishixuanze.jsp'</script>");
			} else if ("3".equals(map.get("ok"))) {
				if ("1".equals(map.get("query"))) {
					writer.println(
							"<script language='javascript'>window.location.href='./views/part6/qiuyuanjishutongji.jsp'</script>");
				} else if ("2".equals(map.get("query"))) {
					writer.println(
							"<script language='javascript'>window.location.href='./views/part6/menjiangjishutongji.jsp'</script>");
				} else if ("3".equals(map.get("query"))) {
					writer.println(
							"<script language='javascript'>alert('该远动员角色不是球员或者守门员，请前往添兵添将修改！');window.location.href='./views/part6/bingbuxuerenzhuyemian.jsp'</script>");
				} else if ("4".equals(map.get("query"))) {
					writer.println(
							"<script language='javascript'>alert('session保存出错！');window.location.href='./views/part6/bingbuxuerenzhuyemian.jsp'</script>");
				}

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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
